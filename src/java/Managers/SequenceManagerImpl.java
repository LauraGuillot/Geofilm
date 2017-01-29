/**
 * ********************************************************************
 * Class SequenceManagementImpl
 * Gestion des multimédias de type vidéo
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Managers;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SequenceManagerImpl implements SequenceManager {

    private EntityManagerFactory emf;
    private static SequenceManagerImpl theSequenceManager;

    private SequenceManagerImpl() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("GeofilmPU");
        }
    }

    public static SequenceManager getInstance() {
        if (theSequenceManager == null) {
            theSequenceManager = new SequenceManagerImpl();
        }
        return theSequenceManager;
    }
}
