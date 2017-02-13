/**
 * ********************************************************************
 * Interface SourceManager
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Managers;

import Objects.Source;

public interface SourceManager {
    /**
     * Trouver une Source à partir de son nom
     * @param name
     * @return 
     */
    public Source findSource(String name);
}
