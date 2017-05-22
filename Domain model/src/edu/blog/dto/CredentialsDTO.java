package edu.blog.dto;

import edu.blog.model.Credentials;

public class CredentialsDTO implements Credentials {
    
    private final String login;
    
    private final String password;
    
    public CredentialsDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }
    
}
