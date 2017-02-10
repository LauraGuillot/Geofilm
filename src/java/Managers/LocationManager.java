/**
 * ********************************************************************
 * Interface LocationManager
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Managers;

import Objects.Location;
import Objects.Source;
import java.util.ArrayList;

public interface LocationManager {

    public ArrayList<Location> getMarkers();

    /**
     * Pour une liste de sources donnée, renvoyer la liste des positions pour
     * lesquelles il y a des multimédias de cette source
     *
     * @param s Liste de sources
     * @return Liste de liste de position
     */
    public ArrayList<ArrayList<Location>> getLocationForSources(ArrayList<Source> s);
}
