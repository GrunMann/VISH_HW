package search.helpers;

import java.util.Locale;
import java.util.ResourceBundle;

public final class Resources {
    private static final ResourceBundle bundle;
    static {
        //Locale.setDefault(new Locale("en"));
        bundle = ResourceBundle.getBundle("resources.labels");
    }
    private Resources(){
        
    }
    
    public static String getString (String name){
        return bundle.getString(name);
    }
}
