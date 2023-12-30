/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sf2_automation_project;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author psyche
 */
public class SF2GUIController implements Initializable {
    
    @FXML
    private TabPane tabPane = new TabPane();
    
    @FXML
    private void excelBtn() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChooseFile.fxml"));
        AnchorPane chooseFile = loader.load();
        ChooseFileController controller = loader.getController();
        controller.setTabPane(tabPane);
        Tab chooseFileTab = new Tab("Choose File", chooseFile);
        tabPane.getTabs().add(chooseFileTab);
        tabPane.getSelectionModel().select(chooseFileTab);
    }
    
    
    @FXML
    private void databaseBtn() throws IOException {
        AnchorPane dbpane = FXMLLoader.load(getClass().getResource("Database.fxml"));
        Tab dbtab = new Tab("Database", dbpane);
        tabPane.getTabs().add(dbtab);
    }

    @FXML
    private void closeMenuItem() {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
