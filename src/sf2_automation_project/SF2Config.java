/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sf2_automation_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author psyche
 */
public class SF2Config {

    private Properties properties = new Properties();
    private String propertiesFilePath = "";
    
    public SF2Config(File configurationFile) {
        try (InputStream is = new FileInputStream(configurationFile)) {
            this.properties.load(is);
            this.propertiesFilePath = configurationFile.getAbsolutePath();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SF2Config.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SF2Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Object getObject(Object key) {
        return this.properties.get(key);
    }
    
    public String getStringProperty(String key) {
        return this.properties.getProperty(key);
    }
    
    public String getSF2FilePath() {
        return this.properties.getProperty("sf2FilePath");
    }
    
    public void setSF2FilePath(String value) {
        String key = "sf2FilePath";
        String comments = "This is where the path of your sf2 file stored";
        this.properties.setProperty(key, value);
        try (OutputStream out = new FileOutputStream(propertiesFilePath)) {
            this.properties.store(out, comments);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SF2Config.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SF2Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setSF2FilePath(String value, String comments) {
        String key = "sf2FilePath";
        this.properties.setProperty(key, value);
        try (OutputStream out = new FileOutputStream(propertiesFilePath)) {
            this.properties.store(out, comments);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SF2Config.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SF2Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Properties getProperties() {
        return this.properties;
    }
    
    
    
}
