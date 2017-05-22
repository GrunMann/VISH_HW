

package propFile;

import Exceptions.ParseException;

public class ParamParser {
    
    private final String key;
    private final String value;
    private static String buffer = null;
    
    
    public ParamParser(String key, String value) {
        this.key = key;
        this.value = value;
    }
    
    @Override
    public String toString() {
        return key+"="+value;
    }
    
    public static ParamParser values (String stringFromFileReader) throws ParseException{
        if (buffer != null ){
            stringFromFileReader=buffer+stringFromFileReader;
        }
        //stringFromFileReader=stringFromFileReader.replace("/ "," ");
            String[] parts = stringFromFileReader.split("=", 2);
            try{
                if (parts.length==2){
                    String key=String.valueOf(parts[0]);
                    key.trim();
                    //System.out.println(key.replace("/",""));
                    String value=String.valueOf(parts[1]);
                    value.trim();
                    //System.out.println(value);
                    if (value.charAt(value.length()-1) == '/' ){
                        buffer=stringFromFileReader;
                    }else{
                        buffer=null;
                    }
                    return new ParamParser(key, value);
                }
            }catch (NumberFormatException ignore){}
            throw new ParseException();
        
        
    }
    

}
