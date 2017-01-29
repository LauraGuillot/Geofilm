/**
 * ********************************************************************
 * Class PictureManagementImpl
 * Gestion des multimédia de type image
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Managers;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PictureManagerImpl implements PictureManager {

    private EntityManagerFactory emf;
    private static PictureManagerImpl thePictureManager;

    private PictureManagerImpl() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("GeofilmPU");
        }
    }

    public static PictureManager getInstance() {
        if (thePictureManager == null) {
            thePictureManager = new PictureManagerImpl();
        }
        return thePictureManager;
    }

}
