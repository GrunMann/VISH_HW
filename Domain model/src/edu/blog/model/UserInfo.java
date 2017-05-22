package edu.blog.model;

import java.io.Serializable;

public interface UserInfo extends Serializable {
    
    String getName();
    
    String getLastName();
    
    String getEmail();
    
}
