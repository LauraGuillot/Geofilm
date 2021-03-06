/**
 * ********************************************************************
 * Class MultimediaManagementImpl
 * Gestion des multimédias
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Managers;

import Objects.Badlocation;
import Objects.Favorite;
import Objects.Liked;
import Objects.LikedPK;
import Objects.Location;
import Objects.Multimedia;
import Objects.Person;
import Objects.Source;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MultimediaManagerImpl implements MultimediaManager {

    private EntityManagerFactory emf;
    private static MultimediaManagerImpl theMultimediaManager;

    private MultimediaManagerImpl() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("GeofilmPU");
        }
    }

    public static MultimediaManager getInstance() {
        if (theMultimediaManager == null) {
            theMultimediaManager = new MultimediaManagerImpl();
        }
        return theMultimediaManager;
    }

    /**
     * Obtention d'une liste de listes de multimédias où chaque liste de
     * multimédia correspond à une position donnée
     *
     * @param pos Liste de positions
     * @return Liste de listes de multimédias
     */
    @Override
    public ArrayList<ArrayList<Multimedia>> getMultiByPos(ArrayList<Location> pos) {
        ArrayList<ArrayList<Multimedia>> mult = new ArrayList<>();

        for (Location loc : pos) {
            ArrayList<Multimedia> m = new ArrayList<>();

            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("SELECT m FROM Multimedia m WHERE  m.locationId=:loc");
            q.setParameter("loc", loc);
            List l = q.getResultList();

            for (Object o : l) {
                m.add((Multimedia) o);
            }

            mult.add(m);
        }
        return mult;
    }

    /**
     * Récupérer le nombre de likes d'un multimédia
     *
     * @param m Multimédia
     * @return Nombre de likes
     */
    @Override
    public Integer getLike(Multimedia m) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT l FROM Liked l WHERE  l.multimedia=:m");
        q.setParameter("m", m);
        List l = q.getResultList();

        int cpt = 0;
        for (Object o : l) {
            Liked li = (Liked) o;
            if (li.getLikedType().equals("LIKE")) {
                cpt++;
            }
        }
        return cpt;
    }

    /**
     * Récupérer le nombre de dislikes d'un multimédia
     *
     * @param m Multimédia
     * @return Nombre de dislikes
     */
    @Override
    public Integer getDislike(Multimedia m) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT l FROM Liked l WHERE  l.multimedia=:m");
        q.setParameter("m", m);
        List l = q.getResultList();

        int cpt = 0;
        for (Object o : l) {
            Liked li = (Liked) o;
            if (!li.getLikedType().equals("LIKE")) {
                cpt++;
            }
        }
        return cpt;
    }

    /**
     * Récupérer les likes de chaque multimédias
     *
     * @param multis Matrice de multimédias
     * @return Matrice de nombre de likes
     */
    @Override
    public ArrayList<ArrayList<Integer>> getLikes(ArrayList<ArrayList<Multimedia>> multis) {
        ArrayList<ArrayList<Integer>> li = new ArrayList<>();
        for (ArrayList<Multimedia> mu : multis) {
            ArrayList<Integer> l = new ArrayList<>();
            for (Multimedia m : mu) {
                l.add(this.getLike(m));
            }
            li.add(l);
        }
        return li;
    }

    /**
     * Récupérer les dislikes de chaque multimédias
     *
     * @param multis Matrice de multimédias
     * @return Matrice de nombre de dislikes
     */
    @Override
    public ArrayList<ArrayList<Integer>> getDislikes(ArrayList<ArrayList<Multimedia>> multis) {
        ArrayList<ArrayList<Integer>> li = new ArrayList<>();
        for (ArrayList<Multimedia> mu : multis) {
            ArrayList<Integer> l = new ArrayList<>();
            for (Multimedia m : mu) {
                l.add(this.getDislike(m));
            }
            li.add(l);
        }
        return li;
    }

    /**
     * Récupérer le nombre de signalements de mauvaise géolocalisation pour un
     * multimedia
     *
     * @param m Multimedia
     * @return Nombre de signalements
     */
    @Override
    public int getBadLocMult(Multimedia m) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT b FROM Badlocation b WHERE  b.multimediaId=:m");
        q.setParameter("m", m);
        List l = q.getResultList();
        return l.size();
    }

    /**
     * Récupérer les signalements de mauvais géolocalisation pour tous les
     * multimédias
     *
     * @param multis Matrice de multimédias
     * @return Matrice de nombre de mauvaise géolocalisation
     */
    @Override
    public ArrayList<ArrayList<Integer>> getBadLoc(ArrayList<ArrayList<Multimedia>> multis) {
        ArrayList<ArrayList<Integer>> li = new ArrayList<>();
        for (ArrayList<Multimedia> mu : multis) {
            ArrayList<Integer> l = new ArrayList<>();
            for (Multimedia m : mu) {
                l.add(this.getBadLocMult(m));
            }
            li.add(l);
        }
        return li;
    }

    /**
     * Récupérer un multimédia par son id
     *
     * @param id Identifiant
     * @return Multimédia
     */
    @Override
    public Multimedia getMultById(int id) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Multimedia.findByMultimediaId", Multimedia.class);
        q.setParameter("multimediaId", id);
        List l = q.getResultList();
        return l.isEmpty() ? null : (Multimedia) l.get(0);
    }

    /**
     * Récupérer les actions d'une personne sur un multimédia sous la forme
     * d'une chaîne de caractère de la forme : badloc:[est ce que la personne a
     * signalé le multimédia ]*favoris:[est ce que la personne a ajouté ce
     * multimédia à ses favoris]*like:[est ce que la personne a liké le
     * multimédia]
     *
     * @param m Multimedia
     * @param p Personne
     * @return Chaîne d'informations
     */
    @Override
    public String getInfosMuliPerson(Multimedia m, Person p) {
        EntityManager em = emf.createEntityManager();

        //Est ce que la personne a mal géolocalisé le multimédia?
        String result = "badloc:";
        Query q = em.createQuery("SELECT b FROM Badlocation b WHERE  b.multimediaId=:m AND b.personId=:p");
        q.setParameter("m", m);
        q.setParameter("p", p);
        List l = q.getResultList();
        result += (!l.isEmpty());

        //Est ce que la personne a ajouté ce multimédia dans ses favoris?
        result += "*favoris:";
        Query q1 = em.createQuery("SELECT f FROM Favorite f WHERE  f.multimediaId=:m AND f.personId=:p");
        q1.setParameter("m", m);
        q1.setParameter("p", p);
        List l1 = q1.getResultList();
        result += (!l1.isEmpty());

        //Est ce que la perosnne a liké/disliké ce multimédia?
        result += "*like:";
        Query q2 = em.createQuery("SELECT l FROM Liked l WHERE  l.multimedia=:m AND l.person=:p");
        q2.setParameter("m", m);
        q2.setParameter("p", p);
        List l2 = q2.getResultList();

        if (l2.isEmpty()) {
            result += "no";
        } else {
            result += ((Liked) l2.get(0)).getLikedType();
        }

        return result;
    }

    /**
     * Ajout d'un multimédia dans les favoris d'une personne
     *
     * @param m Multimédia
     * @param p Personne
     */
    @Override
    public void addToFavorite(Multimedia m, Person p) {
        EntityManager em = emf.createEntityManager();

        //Récupération id max des favoris
        Query q = em.createNamedQuery("Favorite.findAll", Favorite.class);
        List l = q.getResultList();

        //Création du favoris
        Favorite f = new Favorite(l.size() + 1);
        f.setMultimediaId(m);
        f.setPersonId(p);
        System.out.println(f.getFavoriteId());

        //Insertion
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
    }

    /**
     * Signalement d'un multimédia comme mal géolocalisé
     *
     * @param m Multimédia
     * @param p Personne
     */
    @Override
    public void signal(Multimedia m, Person p) {
        EntityManager em = emf.createEntityManager();

        //Récupération id max des favoris
        Query q = em.createNamedQuery("Badlocation.findAll", Badlocation.class);
        List l = q.getResultList();

        //Création du favoris
        System.out.println(l.size() + 1);
        Badlocation b = new Badlocation(l.size() + 1);
        b.setMultimediaId(m);
        b.setPersonId(p);

        //Insertion
        em.getTransaction().begin();
        em.persist(b);
        em.getTransaction().commit();
    }

    /**
     * Enregistrement d'un like/dislike d'une personne
     *
     * @param m Multimedia
     * @param p Personne
     * @param type Type : like ou dislike
     */
    @Override
    public void like(Multimedia m, Person p, String type) {
        EntityManager em = emf.createEntityManager();

        //Primary key
        LikedPK pk = new LikedPK();
        pk.setMultimediaId(m.getMultimediaId());
        pk.setPersonId(p.getPersonId());

        //Like
        Liked like = new Liked();
        like.setLikedPK(pk);
        like.setLikedType(type);
        like.setMultimedia(m);
        like.setPerson(p);

        //Insertion
        em.getTransaction().begin();
        em.persist(like);
        em.getTransaction().commit();

    }

    /**
     * Insertion d'un multimédia dans la base de données et création de la
     * localisation associée (à partir d'une géométrie reçue en paramètre)
     *
     * @param title
     * @param description
     * @param path
     * @param date
     * @param format
     * @param language
     * @param type
     * @param l Localisation du média
     * @param p Person p qui upload le multimédia
     * @param sourceId s Source du multimédia
     */
    @Override
    public void insertMultimedia(String title, String description, String path, String date, String format, String language, String type, Location l, Person p, Source sourceId) {
        Multimedia m = new Multimedia();
        m.setMultimediaTitle(title);
        m.setMultimediaDescription(description);
        m.setMultimediaPath(path);
        m.setMultimediaUploadDate(date);
        m.setMultimediaFormat(format);
        m.setMultimediaLanguage(language);
        m.setMultimediaType(type);
        m.setLocationId(l);
        m.setPublisher(p);
        m.setSourceId(sourceId);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
    }

    /**
     * Matrice de multimédias qui correspond à une matrice de positions
     *
     * @param loc Matrice de positions
     * @return Matrice de multimédia
     */
    @Override
    public ArrayList<ArrayList<ArrayList<Multimedia>>> getMultimediaForSource(ArrayList<ArrayList<Location>> loc) {
        ArrayList<ArrayList<ArrayList<Multimedia>>> multi = new ArrayList<>();

        for (ArrayList<Location> pos : loc) {
            multi.add(getMultiByPos(pos));
        }

        return multi;
    }

    /**
     * Récupérer les likes de chaque multimédiasde chaque source
     *
     * @param multis Matrice de multimédias
     * @return Matrice de nombre de likes
     */
    @Override
    public ArrayList<ArrayList<ArrayList<Integer>>> getLikesSource(ArrayList<ArrayList<ArrayList<Multimedia>>> multis) {
        ArrayList<ArrayList< ArrayList< Integer>>> li = new ArrayList<>();
        for (ArrayList<ArrayList<Multimedia>> m : multis) {
            li.add(this.getLikes(m));
        }
        return li;
    }

    /**
     * Récupérer les dislikes de chaque multimédias pour chaque sources
     *
     * @param multis Matrice de multimédias
     * @return Matrice de nombre de dislikes
     */
    @Override
    public ArrayList<ArrayList<ArrayList<Integer>>> getDislikesSource(ArrayList<ArrayList<ArrayList<Multimedia>>> multis) {
        ArrayList<ArrayList< ArrayList< Integer>>> li = new ArrayList<>();
        for (ArrayList<ArrayList<Multimedia>> m : multis) {
            li.add(this.getDislikes(m));
        }
        return li;
    }

    /**
     * Récupérer le nombre de signalements de chaque multimédias pour chaque
     * sources
     *
     * @param multis Matrice de multimédias
     * @return Matrice de nombre de dsignalements
     */
    @Override
    public ArrayList<ArrayList<ArrayList<Integer>>> getBadLocSource(ArrayList<ArrayList<ArrayList<Multimedia>>> multis) {
        ArrayList<ArrayList< ArrayList< Integer>>> li = new ArrayList<>();
        for (ArrayList<ArrayList<Multimedia>> m : multis) {
            li.add(this.getBadLoc(m));
        }
        return li;
    }

    
}
