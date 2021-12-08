package utils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    Properties properties = new Properties();
// String é o retorno do valor e key é o valor.
    public String getProp(String key){
        try{
            if(System.getProperty("env") == null){
                //getResoourceAsStream irá ler meu arquivo da feature
                properties.load(getClass().getClassLoader().getResourceAsStream("hom.properties"));
            }else {
                properties.load(getClass().getClassLoader().getResourceAsStream(System.getProperty("env")));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}
