package edu.blog.web;

import edu.blog.core.AbstractServlet;
import edu.blog.dto.CredentialsDTO;
import edu.blog.exceptions.AccessException;
import edu.blog.model.Credentials;
import edu.blog.services.UserService;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet({"/auth/*"})
public class Login extends AbstractServlet {

    @EJB UserService userService;
    
    public void logOut() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void logIn() throws ServletException, IOException {
        System.out.println("login~!");
        forward("login");
    }

    public void logIn(String login, String password) throws ServletException, IOException {
        System.out.println("login~!??");
        try {
            Credentials credentials = new CredentialsDTO(login, password);
            userService.authenticate(credentials);
            redirect("/blog/");
        } catch (AccessException e) {
            getRequest().setAttribute("error", "Wrong login or password!");
        } 
        forward("login");
    }
    
}
