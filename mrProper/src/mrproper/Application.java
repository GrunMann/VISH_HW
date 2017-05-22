package mrproper;

import java.io.File;
import java.io.IOException;
import propFile.FileReader;

public class Application {
    
    static final File file;
    static{
        file = new File("./test.property");
    }
    
    public static void main(String[] args) {
        try (propFile.FileReader fileReader = new FileReader(file)){
            propFile.ParamParser param;
            while ((param =fileReader.read()) != null){
                System.out.println(param);
            }
        }catch (IOException e ){
                System.err.println(e.getMessage());
        }
    }    
}

