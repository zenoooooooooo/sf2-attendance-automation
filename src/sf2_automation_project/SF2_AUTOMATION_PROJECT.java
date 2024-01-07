/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sf2_automation_project;

import CPUManagement.*;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author akira
 */
public class SF2_AUTOMATION_PROJECT extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        File file = new File("src/components/SF2GUI/SF2GUI.fxml");
        Parent root = FXMLLoader.load(file.toURI().toURL());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
//        Monitor1 mon1 = new Monitor1();
//        mon1.monitor1();
        
    }

}
