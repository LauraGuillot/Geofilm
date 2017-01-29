/**
 * ********************************************************************
 * Class LocationManagementImpl
 * Gestion des localisations
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Managers;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LocationManagerImpl implements LocationManager {

    private EntityManagerFactory emf;
    private static LocationManagerImpl theLocationManager;

    private LocationManagerImpl() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("GeofilmPU");
        }
    }

    public static LocationManager getInstance() {
        if (theLocationManager == null) {
            theLocationManager = new LocationManagerImpl();
        }
        return theLocationManager;
    }
}
