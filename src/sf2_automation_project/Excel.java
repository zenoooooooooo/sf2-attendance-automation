/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sf2_automation_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author psyche
 */
public class Excel {

    public boolean isExcel(File file) {
        Alert alert = new Alert(AlertType.ERROR);
        boolean isExcelFile = false;
        try (FileInputStream fis = new FileInputStream(file)) {
            Workbook workbook = WorkbookFactory.create(fis);
            isExcelFile = true;
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
            alert.setHeaderText("File Not Found!");
            alert.setContentText(ex.getLocalizedMessage());
            alert.showAndWait();
        } catch (IOException ex) {
            alert.setHeaderText("An error occured!");
            alert.setContentText(ex.getLocalizedMessage());
            alert.showAndWait();
            //Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return isExcelFile;
        }
    }
}
