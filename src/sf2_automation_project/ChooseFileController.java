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
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FXML Controller class
 *
 * @author psyche
 */
public class ChooseFileController implements Initializable {
    
    @FXML
    private Text errtext = new Text();

    private String sf2FilePath = "";
    @FXML
    private TextField filetf = new TextField();
    
    private FileChooser fchooser = new FileChooser();
    
    private File choosedFile;
    
    @FXML
    private TabPane tabp;
    
    public void setTabPane(TabPane tabPane) {
        tabp = tabPane;
    }
    
    @FXML
    private void goToExcel() throws IOException {
        if (choosedFile != null) {
            if (choosedFile.exists() && choosedFile.isFile() && new Excel().isExcel(choosedFile)) {
                AnchorPane excelPane = FXMLLoader.load(getClass().getResource("Excel.fxml"));
                Tab excelTab = new Tab("Excel", excelPane);
                tabp.getTabs().add(excelTab);
                tabp.getSelectionModel().select(excelTab);
            }
        }
    }

    @FXML
    public void chooseFileBtn() throws IOException {
        File prop = new File("src/sf2_automation_project/sf2.properties");
        choosedFile = fchooser.showOpenDialog(null);
        if (prop.exists() && choosedFile != null) {
            SF2Config conf = new SF2Config(prop);
            sf2FilePath = choosedFile.getAbsolutePath();
            if (conf.getSF2FilePath() != null) {
                if (conf.getSF2FilePath().isBlank() || !conf.getSF2FilePath().contentEquals(sf2FilePath)) {
                    conf.setSF2FilePath(sf2FilePath);
                }
            }
            
        }
        filetf.setText(sf2FilePath);
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
