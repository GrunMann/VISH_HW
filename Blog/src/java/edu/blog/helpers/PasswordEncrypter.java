package edu.blog.helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.ejb.Singleton;

@Singleton
public class PasswordEncrypter {

    private final MessageDigest digest;

    public PasswordEncrypter() throws NoSuchAlgorithmException {
        this.digest = MessageDigest.getInstance("MD5");
    }
    
    public String encrypt(String source) {
        byte[] bytes = source.getBytes();
        bytes = digest.digest(bytes);
        return new String(bytes);
    }
    
}
