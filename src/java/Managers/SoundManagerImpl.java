/**
 * ********************************************************************
 * Class SoundManagementImpl
 * Gestion des multimédias de type son
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Managers;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SoundManagerImpl implements SoundManager{
     private EntityManagerFactory emf;
    private static SoundManagerImpl theSoundManager;

    private SoundManagerImpl() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("GeofilmPU");
        }
    }

    public static SoundManager getInstance() {
        if (theSoundManager == null) {
            theSoundManager = new SoundManagerImpl();
        }
        return theSoundManager;
    }
}
