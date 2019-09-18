package Group;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProps {
    static Properties pros;
    static FileInputStream inputStream;
    //method for
    public  String getProperty(String key) {
        pros=new Properties();
        try {
            inputStream=new FileInputStream("src\\main\\Resources\\BrowserDriver\\testdataconfig.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            pros.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pros.getProperty(key);
    }

}


