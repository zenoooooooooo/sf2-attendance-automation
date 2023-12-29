/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sf2_automation_project;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FXML Controller class
 *
 * @author psyche
 */
public class ChooseFileController implements Initializable {

    private String sf2FilePath = "";
    @FXML
    private TextField filetf = new TextField();
    
    private FileChooser fchooser = new FileChooser();
    
    @FXML
    private TabPane tabp;
    
    private void goToExcel(File excelFile) throws IOException {
        if (excelFile != null) {
            if (excelFile.exists() && excelFile.isFile()) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Excel.fxml"));
                AnchorPane excelp = loader.load();
                ExcelController controller = loader.getController();
                controller.changeProc(tabp, tabp.getSelectionModel().getSelectedItem());
                Tab excelt = new Tab("Excel", excelp);
                tabp.getTabs().add(excelt);
                tabp.getSelectionModel().select(excelt);
                
            }
        }
        
    }
    
    public void setTabPane(TabPane tabPane) {
        tabp = tabPane;
    }

    @FXML
    public void chooseFileBtn() throws IOException {
        File prop = new File("src/sf2_automation_project/sf2.properties");
        File file = fchooser.showOpenDialog(null);
        if (prop.exists() && file != null) {
            SF2Config conf = new SF2Config(prop);
            sf2FilePath = file.getAbsolutePath();
            if (conf.getSF2FilePath().isBlank() || !conf.getSF2FilePath().contentEquals(sf2FilePath)) {
                conf.setSF2FilePath(sf2FilePath);
            }
            goToExcel(file);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ExtensionFilter all = new ExtensionFilter("All", "*");
        ExtensionFilter excelExtensionFilter = new ExtensionFilter("Excel", "*.xlsx");
        fchooser.getExtensionFilters().add(excelExtensionFilter);
        fchooser.getExtensionFilters().add(all);
    }

}
