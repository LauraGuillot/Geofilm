/**
 * ********************************************************************
 * Class SourcesManagementImpl
 * Gestion des sources (film, série ou jeu)
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Managers;

import Objects.Source;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SourceManagerImpl implements SourceManager {

    private EntityManagerFactory emf;
    private static SourceManagerImpl theSourceManager;

    private SourceManagerImpl() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("GeofilmPU");
        }
    }

    public static SourceManager getInstance() {
        if (theSourceManager == null) {
            theSourceManager = new SourceManagerImpl();
        }
        return theSourceManager;
    }

    /**
     * Trouver une Source à partir de son nom
     *
     * @param name
     * @return
     */
    @Override
    public Source findSource(String name) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT * FROM Source s WHERE  s.sourceTitle=:name");
        q.setParameter("name", name);
        List l = q.getResultList();
        return l.isEmpty() ? null : (Source) l.get(0);
    }

    /**
     * Récupérer toutes les sources de la base
     *
     * @return Liste de sources
     */
    @Override
    public ArrayList<Source> getSources() {
        ArrayList<Source> s = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Source.findAll", Source.class);
        List l = q.getResultList();

        for (Object o : l) {
            if (((Source) o).getSourceId() > 0) {
                s.add((Source) o);
            }
        }
        return s;
    }

}
