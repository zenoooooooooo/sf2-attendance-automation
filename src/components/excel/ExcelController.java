/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package components.excel;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import methods.Algorithms;
import methods.SF2;

/**
 * FXML Controller class
 *
 * @author psyche
 */
public class ExcelController implements Initializable {

    
    Alert alert = new Alert(AlertType.INFORMATION);
    
    private File file;

    @FXML
    private TextField textfield;

    private SF2 sf2 = new SF2();
    private Algorithms algorithms = new Algorithms();

    public void setPath(String path) {
        textfield.setText(path);
    }

    public void setFile(File file) {
        this.file = file;
    }

    @FXML
    private void calculate() {
        algorithms.countDates(file, 0, "D11", "AB11");
        algorithms.countBoys(file, 0, "D14", "D34", "D35");
        algorithms.countGirls(file, 0, "D36", "D60", "D61");
        algorithms.countTotalPerDay(file, 0, "D62");
        
        
        alert.setHeaderText("PROCESS COMPLETED");
        alert.setContentText("ALL ABSENCES AND PRESENCES HAVE BEEN CALCULATED");
        alert.showAndWait();
    }

    @FXML
    private void automate() {

    
        //boys
        sf2.totalPerDay(file, 0, "D14:AB14", "D34:AB34", "D35:AB35", 21, "AC35", "D35:AB35");
        //girls
        sf2.totalPerDay(file, 0, "D36:AB36", "D60:AB60", "D61:AB61", 19, "AC61", "D61:AB61");

        // Total for the month - absent
        //boys
        sf2.countAbsences(file, 0, "D14:D34", "AB14:AB34", "AC14:AC34");
        //girls
        sf2.countAbsences(file, 0, "D36:D60", "AB36:AB60", "AC36:AC60");

        alert.setHeaderText("PROCESS COMPLETED");
        alert.setHeaderText("FORMULAS HAVE BEEN SET UP");
        alert.showAndWait();
    }

    private TabPane tabp;

    public void setTabPane(TabPane tabPane) {
        tabp = tabPane;
    }

    public void changeProc(TabPane tabPane, Tab tab) {
        this.tabp = tabPane;
        tabp.getTabs().remove(tab);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
