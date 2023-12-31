/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package components.SF2GUI;

import components.chooseFile.ChooseFileController;
import components.report.ReportController;
import java.io.File;
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
        File file = new File("src/components/chooseFile/ChooseFile.fxml");
        FXMLLoader loader = new FXMLLoader(file.toURI().toURL());
        AnchorPane chooseFile = loader.load();
        ChooseFileController controller = loader.getController();
        controller.setTabPane(tabPane);
        Tab chooseFileTab = new Tab("Choose File", chooseFile);
        tabPane.getTabs().add(chooseFileTab);
        tabPane.getSelectionModel().select(chooseFileTab);
    }

    @FXML
    private void databaseBtn() throws IOException {
        File file = new File("src/components/database/Database.fxml");
        AnchorPane dbpane = FXMLLoader.load(file.toURI().toURL());
        Tab dbtab = new Tab("Database", dbpane);
        tabPane.getTabs().add(dbtab);
    }

    @FXML
    private void reportBtn() throws IOException {
        File file = new File("src/components/report/Report.fxml");
        FXMLLoader loader = new FXMLLoader(file.toURI().toURL());
        AnchorPane report = loader.load();
        ReportController controller = loader.getController();
        controller.setTabPane(tabPane);
        Tab reportTab = new Tab("Reports", report);
        tabPane.getTabs().add(reportTab);
        tabPane.getSelectionModel().select(reportTab);
    }

    @FXML
    private void configureBtn() throws IOException {
        //Some code
    }

    @FXML
    private void instructionBtn() throws IOException {
        //Some code
    }

    @FXML
    private void closeMenuItem() {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
