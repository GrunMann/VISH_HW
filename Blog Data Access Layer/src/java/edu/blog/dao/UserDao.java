package edu.blog.dao;

import edu.blog.dao.core.Dao;
import edu.blog.exceptions.NotFoundException;
import edu.blog.model.UserEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
public class UserDao extends Dao<Long, UserEntity> {

    @PersistenceContext(unitName = "Blog")
    private EntityManager em;
    
    public UserDao() {
        super(UserEntity.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public UserEntity find(String login) throws NotFoundException {
        try {
            return (UserEntity) em.createNamedQuery("user.find.by-login")
                .setParameter("login", login)
                .getSingleResult();
        } catch (PersistenceException e) {
            throw new NotFoundException(e.getCause());
        }
    }
    
}
