package edu.blog.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(
        name = "user.find.by-login",
        query = "SELECT u FROM UserEntity u WHERE u.login = :login"
    )
})
public class UserEntity implements Credentials {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String login;
    
    private String password;
   
    @OneToOne(cascade=CascadeType.ALL)
    private UserInfoEntity info;
    
    protected UserEntity() {}

    public UserEntity(Credentials credentials, UserInfo info) {
        this.login = credentials.getLogin();
        this.password = credentials.getPassword();
        this.info = new UserInfoEntity(info);
    }

    public UserInfoEntity getInfo() {
        return info;
    }
    
    public Long getId() {
        return id;
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
