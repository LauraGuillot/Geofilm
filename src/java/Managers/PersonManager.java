/**
 * ********************************************************************
 * Interface PersonManager
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Managers;

import Objects.Liked;
import Objects.Multimedia;
import Objects.Person;
import java.util.ArrayList;

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

    /**
     * Mise à jour des informations d'une personne
     *
     * @param p Personne
     * @param name Nom
     * @param firstname Prénom
     * @param email Adresse Email
     */
    public void updateInfos(Person p, String name, String firstname, String email);

    /**
     * Renvoi des favoris d'une personne
     *
     * @param p Personne p
     * @return Liste de multimédias favoris
     */
    public ArrayList<Multimedia> getFavorite(Person p);

    /**
     * Renvoi de tous les likes faits par une personne
     *
     * @param p Persone
     * @return Liste de likes
     */
    public ArrayList<Liked> getLike(Person p);

    /**
     * Renvoi de la liste des multimédias signalés comme mal gélolocalisés par
     * une personne
     *
     * @param p Personne
     * @return Liste de multimédias
     */
    public ArrayList<Multimedia> getBadLoc(Person p);
}
