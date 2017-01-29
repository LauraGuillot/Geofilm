/**
 * ********************************************************************
 * Class SourcesManagementImpl
 * Gestion des sources (film, série ou jeu) 
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Managers;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SourceManagerImpl implements SourceManager {

    private EntityManagerFactory emf;
    private static SourceManagerImpl theSourceManager;

    private SourceManagerImpl() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("GeofilmPU");
        }
    }

    public static SourceManager getInstance() {
        if (theSourceManager == null) {
            theSourceManager = new SourceManagerImpl();
        }
        return theSourceManager;
    }

}
