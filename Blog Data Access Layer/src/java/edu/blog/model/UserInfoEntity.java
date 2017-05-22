package edu.blog.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class UserInfoEntity implements UserInfo, Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private long id;
    
    private String name;
    
    private String lastName;
    
    private String email;
    
    protected UserInfoEntity() {}
    
    public UserInfoEntity(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }
    
    public UserInfoEntity(UserInfo info) {
        name = info.getName();
        lastName = info.getLastName();
        email = info.getEmail();
    }

    public long getId() {
        return id;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
