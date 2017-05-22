package edu.blog.web;

import edu.blog.core.AbstractServlet;
import edu.blog.dto.CredentialsDTO;
import edu.blog.dto.UserInfoDTO;
import edu.blog.exceptions.RegistrationException;
import edu.blog.exceptions.ValidationException;
import edu.blog.helpers.PasswordEncrypter;
import edu.blog.model.Credentials;
import edu.blog.model.UserInfo;
import edu.blog.services.UserService;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet({"/registration", "/registration/"})
public class Registration extends AbstractServlet {
    @EJB UserService userService;
    @EJB PasswordEncrypter encrypter;
    public void index() throws ServletException, IOException {
        forward("registration");
    }
    
    public void index(String login,String name, String lastname, String email, String password, String confirmation) throws ServletException, IOException {
        try{
            if (!password.equals(confirmation)) {
                throw new ValidationException("Passwords are different!");
            }
            Credentials credentials = new CredentialsDTO(login, password);
            UserInfo info = new UserInfoDTO(name, lastname, email);
            userService.register(credentials, info);
        }catch(RegistrationException | ValidationException e){
            getRequest().setAttribute("error", e.getMessage());
            index();
        }
    }
    
    
}
