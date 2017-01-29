/**
 * ********************************************************************
 * Class MultimediaManagementImpl
 * Gestion des multimédias 
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Managers;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

}
