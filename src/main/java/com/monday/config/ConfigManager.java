package com.monday.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ConfigManager {
   final static Properties properties=new Properties();
   static{loadProperties();}
    public static void loadProperties(){
       try {
           FileInputStream configFIS =new FileInputStream("src/main/resources/config/config.properties");
           properties.load(configFIS);
       }catch (IOException e ){
           e.printStackTrace();

           throw new RuntimeException(" unable to load properties");}
    }
    public static String getProperty(String propertyKey){
       return properties.getProperty(propertyKey);
    }
    public static int getProperty_int(String propertyKey){
       return Integer.parseInt(properties.getProperty(propertyKey)) ;
    }

}
