package edu.blog.model;

import java.io.Serializable;

public interface Credentials extends Serializable {
    
    String getLogin();
    
    String getPassword();
    
    default boolean equals(Credentials credentials) {
        return  credentials.getLogin().equalsIgnoreCase(getLogin()) &&
                credentials.getPassword().equals(getPassword());
    }
    
}
