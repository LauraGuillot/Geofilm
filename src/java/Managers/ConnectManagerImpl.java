/**
 * ********************************************************************
 * Class ConnectManagementImpl
 * Gestion des connexions
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Managers;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectManagerImpl implements ConnectManager {

    private EntityManagerFactory emf;
    private static ConnectManagerImpl theConnectManager;

    private ConnectManagerImpl() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("GeofilmPU");
        }
    }

    public static ConnectManager getInstance() {
        if (theConnectManager == null) {
            theConnectManager = new ConnectManagerImpl();
        }
        return theConnectManager;
    }
}
