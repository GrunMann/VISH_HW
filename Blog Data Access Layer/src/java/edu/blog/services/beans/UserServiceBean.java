package edu.blog.services.beans;

import edu.blog.dao.UserDao;
import edu.blog.dto.UserInfoDTO;
import edu.blog.exceptions.AccessException;
import edu.blog.exceptions.DaoException;
import edu.blog.exceptions.NotFoundException;
import edu.blog.exceptions.RegistrationException;
import edu.blog.exceptions.ValidationException;
import edu.blog.model.Credentials;
import edu.blog.model.UserEntity;
import edu.blog.model.UserInfo;
import edu.blog.services.UserService;
import javax.ejb.Stateful;
import javax.inject.Inject;

@Stateful
public class UserServiceBean implements UserService {

    UserEntity user;
    
    @Inject UserDao userDao;
    
    public boolean exists(String login) {
        try {
            userDao.find(login);
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }
    
    private void validate(Credentials credentials, UserInfo info) throws ValidationException{
        if (credentials.getLogin().isEmpty() ||
            info.getEmail().isEmpty() ||
            info.getName().isEmpty() ||
            info.getLastName().isEmpty()) {
            throw new ValidationException("All fields are required!");
        }
        if (exists(credentials.getLogin())) {
            throw new ValidationException("Such user login already exist!");
        }
    }

    @Override
    public void register(Credentials credentials, UserInfo info) throws RegistrationException, ValidationException {
        validate(credentials, info);
        UserEntity entity = new UserEntity(credentials, info);
        try {
            userDao.create(entity);
        } catch (DaoException e) {
            throw new RegistrationException();
        }
    }

    @Override
    public void authenticate(Credentials credentials) throws AccessException {
        try {
            user = userDao.find(credentials.getLogin());
            if (user.equals(credentials)) {
                user = null;
                return;
            }
        } catch (NotFoundException ignore) {}
        throw new AccessException();
    }

    @Override
    public boolean isAuthenticated() {
        return user != null;
    }

    @Override
    public UserInfo getInfo() throws AccessException {
        if (isAuthenticated()) {
            return new UserInfoDTO(user.getInfo());
        }
        throw new UnsupportedOperationException();
    }
    
}
