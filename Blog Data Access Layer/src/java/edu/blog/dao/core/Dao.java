package edu.blog.dao.core;

import edu.blog.exceptions.DaoException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Data Access Object base class definition
 * @author Daniel
 */
public abstract class Dao<T, E> {
    
    private final Class<E> cls;

    public Dao(Class<E> cls) {
        this.cls = cls;
    }
    
    protected abstract EntityManager getEntityManager();
    
    public void create(E entity) throws DaoException {
        try {
            getEntityManager().persist(entity);
        } catch (PersistenceException e) {
            throw new DaoException(e.getCause());
        }
    }
    
    public void delete(E entity) {
        getEntityManager().detach(entity);
    }
    
    public void update(E entity) {
        getEntityManager().merge(entity);
    }
    
    public List<E> all() {
        EntityManager em = getEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<E> query = builder.createQuery(cls);
        Root<E> from = query.from(cls);
        query = query.select(from);
        return em.createQuery(query).getResultList();
    }
    
    public E find(T id) {
        return getEntityManager().find(cls, id);
    }
    
}
