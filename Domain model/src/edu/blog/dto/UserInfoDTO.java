package edu.blog.dto;

import edu.blog.model.UserInfo;

public class UserInfoDTO implements UserInfo {
    
    private final String name;
    
    private final String lastName;
    
    private final String email;

    public UserInfoDTO(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }
    
    public UserInfoDTO(UserInfo info) {
        name = info.getName();
        lastName = info.getLastName();
        email = info.getEmail();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }
    
}
