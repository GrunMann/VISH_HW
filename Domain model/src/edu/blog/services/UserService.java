package edu.blog.services;

import edu.blog.exceptions.AccessException;
import edu.blog.exceptions.RegistrationException;
import edu.blog.exceptions.ValidationException;
import edu.blog.model.Credentials;
import edu.blog.model.UserInfo;
import javax.ejb.Remote;

@Remote
public interface UserService {
    
    void register(Credentials credentials, UserInfo info) throws RegistrationException, ValidationException;
    
    void authenticate(Credentials credentials) throws AccessException;
    
    boolean isAuthenticated();
    
    UserInfo getInfo() throws AccessException;
    
}
