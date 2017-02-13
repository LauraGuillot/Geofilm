/**
 * ********************************************************************
 * Interface LocationManager
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Managers;

import Objects.Location;
import java.util.ArrayList;

public interface LocationManager {
     public ArrayList<Location> getMarkers();
     
     
     /**
     * Création d'une location à partir d'une géométrie entrée
     * @param the_geom
     * @return 
     */
    public Location insertLocation(String the_geom);
    
    /**
     * Trouver une Location à partir d'une géométrie entrée
     * @param the_geom
     * @return 
     */
    public Location findLocation(String the_geom);
    
    /**
     * Trouver une Lcoation à partir de son ID
     * @param id
     * @return 
     */
    public Location findLocationById(Integer id);
}
