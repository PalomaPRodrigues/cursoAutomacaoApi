package utils;

import java.io.IOException;
import java.util.Properties;

//Classe que irá fazer a leitura dos arquivos(dev/hom)
public class PropertiesUtils {

    Properties properties = new Properties();
    //Recupera arquibvos de propriedades e  seta as configurações do projeto ( usuario, senha e etc)
    // String é o retorno do valor e key é o valor.
    public String getProp(String key) {
        try {
            if (System.getProperty("env") == null) {
                //getResoourceAsStream irá ler meu arquivo (dev/hom)
                properties.load(getClass().getClassLoader().getResourceAsStream("hom.properties"));
            } else {
                properties.load(getClass().getClassLoader().getResourceAsStream(System.getProperty("env")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}
