/**
 * ********************************************************************
 * Interface MultimediaManager
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Managers;

import Objects.Location;
import Objects.Multimedia;
import java.util.ArrayList;

public interface MultimediaManager {

    /**
     * Obtention d'une liste de listes de multimédias où chaque liste de
     * multimédia correspond à une position donnée
     *
     * @param pos Liste de positions
     * @return Liste de listes de multimédias
     */
    public ArrayList<ArrayList<Multimedia>> getMultiByPos(ArrayList<Location> pos);
}
