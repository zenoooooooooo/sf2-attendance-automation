/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package components.SF2GUI;

import components.chooseFile.ChooseFileController;
import components.configure.ConfigureController;
import components.instructions.InstructionsController;
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
    private void toChooseFile() throws IOException {
        File file = new File("src/components/chooseFile/ChooseFile.fxml");
        FXMLLoader loader = new FXMLLoader(file.toURI().toURL());
        AnchorPane chooseFile = loader.load();
        ChooseFileController controller = loader.getController();
        controller.setTabPane(tabPane);
        Tab cfTab = new Tab("Choose File", chooseFile);
        tabPane.getTabs().add(cfTab);
    }

    @FXML
    private void toDatabase() throws IOException {
        File file = new File("src/components/database/Database.fxml");
        AnchorPane dbPane = FXMLLoader.load(file.toURI().toURL());
        Tab dbtab = new Tab("Database", dbPane);
        tabPane.getTabs().add(dbtab);
    }

    @FXML
    private void toReport() throws IOException {
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
        File file = new File("src/components/configure/Configure.fxml");
        FXMLLoader loader = new FXMLLoader(file.toURI().toURL());
        AnchorPane configure = loader.load();
        ConfigureController controller = loader.getController();
        controller.setTabPane(tabPane);
        Tab configureTab = new Tab("Configuration", configure);
        tabPane.getTabs().add(configureTab);
        tabPane.getSelectionModel().select(configureTab);

    }

    @FXML
    private void instructionBtn() throws IOException {
        File file = new File("src/components/instructions/Instructions.fxml");
        FXMLLoader loader = new FXMLLoader(file.toURI().toURL());
        AnchorPane instruction = loader.load();
        InstructionsController controller = loader.getController();
        controller.setTabPane(tabPane);
        Tab instructionsTab = new Tab("Instructions", instruction);
        tabPane.getTabs().add(instructionsTab);
        tabPane.getSelectionModel().select(instructionsTab);
    }

    @FXML
    private void closeMenuItem() {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
