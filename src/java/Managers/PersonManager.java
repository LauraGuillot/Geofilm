/**
 * ********************************************************************
 * Interface PersonManager
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Managers;

import Objects.Person;

public interface PersonManager {

    /**
     * Retrouver une personne par son email
     *
     * @param email Adresse email
     * @return Personne
     */
    public Person findPersonByEmail(String email);
    
    /**
     * Retrouver une personne par son identifiant de connexion
     *
     * @param id Identifiant de connexion
     * @return Personne
     */
    public Person findPerson(String id) ;

}
