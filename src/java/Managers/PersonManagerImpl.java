/**
 * ********************************************************************
 * Class PersonManagementImpl
 * Gestion des personnes
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Managers;

import Objects.Liked;
import Objects.Multimedia;
import Objects.Person;
import Util.PasswordHash;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PersonManagerImpl implements PersonManager {

    private EntityManagerFactory emf;
    private static PersonManagerImpl thePersonManager;

    private PersonManagerImpl() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("GeofilmPU");
        }
    }

    public static PersonManager getInstance() {
        if (thePersonManager == null) {
            thePersonManager = new PersonManagerImpl();
        }
        return thePersonManager;
    }

    /**
     * Retrouver une personne par son identifiant de connexion
     *
     * @param id Identifiant de connexion
     * @return Personne
     */
    @Override
    public Person findPerson(String id) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT c.personId FROM Connect c WHERE  c.connectId=:id");
        q.setParameter("id", id);
        List l = q.getResultList();
        return l.isEmpty() ? null : (Person) l.get(0);
    }

    /**
     * Retrouver une personne par son email
     *
     * @param email Adresse email
     * @return Personne
     */
    @Override
    public Person findPersonByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT p FROM Person p WHERE  p.personEmail=:email");
        q.setParameter("email", email);
        List l = q.getResultList();
        return l.isEmpty() ? null : (Person) l.get(0);
    }

    /**
     * Inscription d'une personne
     *
     * @param email Adresse email
     * @param mdp Mot de passe
     * @param name Nom
     * @param firstname Prénom
     */
    @Override
    public void insert(String email, String mdp, String name, String firstname) {
        Person p = new Person();
        p.setPersonEmail(email);
        p.setPersonFirstname(firstname);
        p.setPersonName(name);
        p.setPersonPassword(PasswordHash.hash(mdp));
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    /**
     * Mise à jour des informations d'une personne
     *
     * @param p Personne
     * @param name Nom
     * @param firstname Prénom
     * @param email Adresse Email
     */
    @Override
    public void updateInfos(Person p, String name, String firstname, String email) {
        p.setPersonEmail(email);
        p.setPersonFirstname(firstname);
        p.setPersonName(firstname);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }

    /**
     * Renvoi des favoris d'une personne
     *
     * @param p Personne p
     * @return Liste de multimédias favoris
     */
    @Override
    public ArrayList<Multimedia> getFavorite(Person p) {
        Collection<Multimedia> collect = p.getMultimediaCollection();
        ArrayList<Multimedia> mult = new ArrayList<>();
        for (Multimedia m : collect) {
            mult.add(m);
        }
        return mult;
    }

    /**
     * Renvoi de tous les likes faits par une personne
     *
     * @param p Persone
     * @return Liste de likes
     */
    @Override
    public ArrayList<Liked> getLike(Person p) {
        ArrayList<Liked> like = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT l FROM Liked l WHERE  l.likedPK.person=:p");
        q.setParameter("p", p);
        List l = q.getResultList();

        for (Object o : l) {
            like.add((Liked) o);
        }
        return like;
    }

    /**
     * Renvoi de la liste des multimédias signalés comme mal gélolocalisés par
     * une personne
     *
     * @param p Personne
     * @return Liste de multimédias
     */
    public ArrayList<Multimedia> getBadLoc(Person p) {
        ArrayList<Multimedia> mult = new ArrayList<>();

        //Sélection de tous les multimédias
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT m FROM Multimedia m ");
        List l = q.getResultList();

        //Pour chaque multimédia
        for (Object o : l) {
            Multimedia m = (Multimedia) o;

            // On récupère la liste des personnes qui ont signalé une mauvaise géolocalisation
            Collection<Person> badloc = m.getPersonCollection();

            boolean add = false;

            // On regarde si notre utilisateur est la cette liste
            for (Person p1 : badloc) {
                if (p1.getPersonId() == p.getPersonId()) {
                    add = true;
                }
            }

            //Si il l'est, on ajoute le multimédia à la liste à renvoyer
            if (add) {
                mult.add(m);
            }
        }

        return mult;
    }

}
