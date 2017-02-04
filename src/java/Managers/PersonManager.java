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
    public Person findPerson(String id);

    /**
     * Inscription d'une personne
     *
     * @param email Adresse email
     * @param mdp Mot de passe
     * @param name Nom
     * @param firstname Prénom
     */
    public void insert(String email, String mdp, String name, String firstname);
}
