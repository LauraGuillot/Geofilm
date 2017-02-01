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
     * Retrouver une personne par son email
     *
     * @param email Adresse email
     * @return Personne
     */
    @Override
    public Person findPerson(String email) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT p FROM Person p WHERE  p.personEmail=:email");
        q.setParameter("email", email);
        List l = q.getResultList();
        return l.isEmpty() ? null : (Person) l.get(0);
    }

}
