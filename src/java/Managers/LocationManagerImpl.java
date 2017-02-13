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
import java.util.List;
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
    
    /**
     * Création d'une location à partir d'une géométrie entrée
     * @param the_geom
     * @return 
     */
    @Override
    public Location insertLocation(String the_geom){
        Location l = new Location();
        l.setLocationThegeom(the_geom);
        return l;
    }
    
    /**
     * Trouver une localisation par son Id
     * @param id Identifiant de la localisation
     * @return 
     */
    @Override
    public Location findLocationById (Integer id){
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT l.LocationId FROM Location l WHERE  l.locationId=:id");
        q.setParameter("id", id);
        List l = q.getResultList();
        return l.isEmpty() ? null : (Location) l.get(0);
    }
    
    /**
     * Trouver une localisation par sa géométrie
     * @param the_geom Géométrie
     * @return 
     */
    @Override
    public Location findLocation (String thegeom){
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT l.LocationId FROM Location l WHERE  l.locationThegeom=:thegeom");
        q.setParameter("thegeom", thegeom);
        List l = q.getResultList();
        return l.isEmpty() ? null : (Location) l.get(0);
    }
    
}
