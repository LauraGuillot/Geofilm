/**
 * ********************************************************************
 * Interface ConnectManager
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Managers;

import Objects.Connect;
import Objects.Person;

public interface ConnectManager {

    /**
     * Récupérer une connexion par son id
     *
     * @param id Identifiant de la connexion
     * @return Connexion
     */
    public Connect getByConnectId(String id);

    /**
     * Déconnexion d'un utilisateur
     *
     * @param p Personne à connecter
     */
    public void deconnect(Person p);

    /**
     * Création d'une connexion pour un utilisateur
     *
     * @param p Personne à connecter
     * @return Identifiant de connexion
     */
    public String createConnection(Person p);

    /**
     * Mise à jour d'une connexion : mise à jour de la date de la dernière
     * action sur le site
     *
     * @param c Connexion
     */
    public void updateConnection(Connect c);

    /**
     * Connexion d'une personne : mise à jour de sa connexion si celle-ci existe
     * ou création de la connexion sinon
     *
     * @param p Personne
     * @return Identifiant de connexion
     */
    public String connect(Person p);

    /**
     * Déconnexion des utilisateurs qui n'ont pas été actifs sur le site depuis
     * plus de 1h
     */
    public void checkConnection();

}
