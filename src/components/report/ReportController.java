/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package components.report;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;

/**
 * FXML Controller class
 *
 * @author akira
 */
public class ReportController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private TabPane tabp;
    
    public void setTabPane(TabPane tabPane) {
        tabp = tabPane;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
