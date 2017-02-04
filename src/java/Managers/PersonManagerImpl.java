/**
 * ********************************************************************
 * Class PersonManagementImpl
 * Gestion des personnes
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Managers;

import Objects.Person;
import Util.PasswordHash;
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
     * @param email Adresse email
     * @param mdp Mot de passe
     * @param name Nom
     * @param firstname Prénom 
     */
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
}
