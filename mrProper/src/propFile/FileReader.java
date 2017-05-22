

package propFile;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import Exceptions.ParseException;



public class FileReader implements Closeable{
    
    private BufferedReader reader;
    public FileReader(InputStream stream){
        reader = new BufferedReader(new InputStreamReader(stream));
    }
    public FileReader(File file) throws FileNotFoundException{
        this ( new FileInputStream(file));
    }
    
    public ParamParser read() throws IOException{
        String line = reader.readLine();
        try
        {return line != null ? ParamParser.values(line) : null;} 
        catch (ParseException ignore)
        {}
        return read();
    }
    
    
    @Override
    public void close() throws IOException{
        reader.close();
        reader=null;
    }
}
