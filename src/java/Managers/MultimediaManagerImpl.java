/**
 * ********************************************************************
 * Class MultimediaManagementImpl
 * Gestion des multimédias
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Managers;

import Objects.Liked;
import Objects.Location;
import Objects.Multimedia;
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

}
