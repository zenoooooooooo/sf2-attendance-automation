/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package components.chooseFile;

import components.excel.ExcelController;
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
import sf2_automation_project.Excel;
import sf2_automation_project.SF2Config;

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

    private File chosenFile;

    private TabPane tabp;

    public void setTabPane(TabPane tabPane) {
        tabp = tabPane;
    }

    @FXML
    private void goToExcel() throws IOException {
        if (chosenFile != null) {
            if (chosenFile.exists() && chosenFile.isFile() && new Excel().isExcel(chosenFile)) {
                File file = new File("src/components/excel/Excel.fxml");
                FXMLLoader loader = new FXMLLoader(file.toURI().toURL());
                AnchorPane excel = loader.load();
                ExcelController controller = loader.getController();
                controller.setFile(chosenFile);
                controller.setPath(chosenFile.getAbsolutePath());
                controller.setTabPane(tabp);
                Tab excelTab = new Tab("Excel", excel);
                tabp.getTabs().add(excelTab);
            }
        }
    }

    @FXML
    public void chooseFileBtn() throws IOException {
        File prop = new File("src/sf2_automation_project/sf2.properties");
        chosenFile = fchooser.showOpenDialog(null);
        if (prop.exists() && chosenFile != null) {
            SF2Config conf = new SF2Config(prop);
            sf2FilePath = chosenFile.getAbsolutePath();
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
