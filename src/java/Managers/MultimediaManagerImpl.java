/**
 * ********************************************************************
 * Class MultimediaManagementImpl
 * Gestion des multimédias
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Managers;

import Objects.Location;
import Objects.Multimedia;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MultimediaManagerImpl implements MultimediaManager {

    private EntityManagerFactory emf;
    private static MultimediaManagerImpl theMultimediaManager;

    private MultimediaManagerImpl() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("GeofilmPU");
        }
    }

    public static MultimediaManager getInstance() {
        if (theMultimediaManager == null) {
            theMultimediaManager = new MultimediaManagerImpl();
        }
        return theMultimediaManager;
    }

    /**
     * Obtention d'une liste de listes de multimédias où chaque liste de
     * multimédia correspond à une position donnée
     *
     * @param pos Liste de positions
     * @return Liste de listes de multimédias
     */
    @Override
    public ArrayList<ArrayList<Multimedia>> getMultiByPos(ArrayList<Location> pos) {
        ArrayList<ArrayList<Multimedia>> mult = new ArrayList<>();

        for (Location loc : pos) {
            ArrayList<Multimedia> m = new ArrayList<>();

            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("SELECT m FROM Multimedia m WHERE  m.locationId=:loc");
            q.setParameter("loc", loc);
            List l = q.getResultList();

            for (Object o : l) {
                m.add((Multimedia) o);
            }

            mult.add(m);
        }
        return mult;
    }
}
