/**
 * ********************************************************************
 * Class LocationManagementImpl
 * Gestion des localisations
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Managers;

import Objects.Location;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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

    /**
     * Récupérer toutes les positions de la base de données
     * @return  Liste de positions
     */
    public ArrayList<Location> getMarkers() {
        ArrayList<Location> l = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query queryProductsByName = em.createNamedQuery("Location.findAll", Location.class);
        Collection c = queryProductsByName.getResultList();

        for (Object loc : c) {
            l.add((Location) loc);
        }
        return l;
    }
}
