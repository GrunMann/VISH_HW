package edu.blog.exceptions;
public class ValidationException extends Exception{

    public ValidationException() {
    }

    public ValidationException(String string) {
        super(string);
    }

    public ValidationException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ValidationException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
