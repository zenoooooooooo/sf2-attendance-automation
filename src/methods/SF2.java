/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author psyhi
 */
public class SF2 {

    private static File file = new File("src/tests/sf2.xlsx");
    
    public void combine(File SF2File, int sheetNumber, String perDayBoys, String perDayGirls, String resultRangeAddress, String totalCellAddress) {
        try (InputStream istream = new FileInputStream(SF2File)) {
            try (Workbook wbook = new XSSFWorkbook(istream)) {
                Sheet sheet = wbook.getSheetAt(sheetNumber);
                
                CellRangeAddress perDayBoysRange = CellRangeAddress.valueOf(perDayBoys);
                CellRangeAddress perDayGirlsRange = CellRangeAddress.valueOf(perDayGirls);
                
                Iterator<CellAddress> pdBoysRangeIter = perDayBoysRange.iterator();
                Iterator<CellAddress> pdGirlsRangeIter = perDayGirlsRange.iterator();
                
                List<String> cellPairs = new ArrayList<>();
                
                while (pdBoysRangeIter.hasNext() && pdGirlsRangeIter.hasNext()) {
                    cellPairs.add(pdBoysRangeIter.next() + "," + pdGirlsRangeIter.next());
                }
                
                CellRangeAddress resultRange = CellRangeAddress.valueOf(resultRangeAddress);
                FormulaEvaluator eval = wbook.getCreationHelper().createFormulaEvaluator();
                
                int i = 0;
                
                for (int rowIndex = resultRange.getFirstRow(); rowIndex <= resultRange.getLastRow(); rowIndex++) {
                    Row row = sheet.getRow(rowIndex);
                    for (int colIndex = resultRange.getFirstColumn(); colIndex <= resultRange.getLastColumn(); colIndex++) {
                        Cell cell = row.getCell(colIndex);
                        String formula = "SUM(" + cellPairs.get(i) + ")";
                        cell.setCellFormula(formula);
                        eval.evaluateFormulaCell(cell);
                        i++;
                    }
                    
                }
                
                CellAddress overall = new CellAddress(totalCellAddress);
                Row row = sheet.getRow(overall.getRow());
                Cell cell = row.getCell(overall.getColumn());
                cell.setCellFormula("SUM(AC34, AC60)");
                eval.evaluateFormulaCell(cell);
                
                try (OutputStream ostream = new FileOutputStream(SF2File)) {
                    wbook.write(ostream);
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SF2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SF2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void countAbsences(File SF2File, int sheetNumber, String startCellRangeAddress, String endCellRangeAddress, String resultCellRangeAddress) {
        try (InputStream istream = new FileInputStream(SF2File)) {
            try (Workbook wbook = new XSSFWorkbook(istream)) {
                Sheet sheet = wbook.getSheetAt(sheetNumber);

                CellRangeAddress startCells = CellRangeAddress.valueOf(startCellRangeAddress);
                CellRangeAddress endCells = CellRangeAddress.valueOf(endCellRangeAddress);

                Iterator<CellAddress> startCellsIter = startCells.iterator();
                Iterator<CellAddress> endCellsIter = endCells.iterator();

                CellRangeAddress range = CellRangeAddress.valueOf(resultCellRangeAddress);
                FormulaEvaluator eval = wbook.getCreationHelper().createFormulaEvaluator();

                List<String> cellRanges = new ArrayList<>();

                while (startCellsIter.hasNext() && endCellsIter.hasNext()) {
                    cellRanges.add(startCellsIter.next() + ":" + endCellsIter.next());
                }

                int i = 0;

                for (int ri = range.getFirstRow(); ri <= range.getLastRow(); ri++) {
                    Row row = sheet.getRow(ri);
                    for (int ci = range.getFirstColumn(); ci <= range.getLastColumn(); ci++) {
                        Cell cell = row.getCell(ci);
                        String formula = "COUNTIF(" + cellRanges.get(i) + ",\"X\")";
                        cell.setCellFormula(formula);
                        eval.evaluateFormulaCell(cell);
                        i++;
                    }
                }

                try (OutputStream ostream = new FileOutputStream(SF2File)) {
                    wbook.write(ostream);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SF2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SF2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void totalPerDay(File SF2File, int sheetNumber, String startCellRangeAddress, String endCellRangeAddress, String resultCellRangeAddress, int total, String totalCellAddress, String totalCells) {
        try (InputStream istream = new FileInputStream(SF2File)) {
            try (Workbook wbook = new XSSFWorkbook(istream)) {
                Sheet sheet = wbook.getSheetAt(sheetNumber);

                CellRangeAddress startCells = CellRangeAddress.valueOf(startCellRangeAddress);
                CellRangeAddress endCells = CellRangeAddress.valueOf(endCellRangeAddress);

                Iterator<CellAddress> startCellsIter = startCells.iterator();
                Iterator<CellAddress> endCellsIter = endCells.iterator();

                CellRangeAddress range = CellRangeAddress.valueOf(resultCellRangeAddress);
                FormulaEvaluator eval = wbook.getCreationHelper().createFormulaEvaluator();

                List<String> cellRanges = new ArrayList<>();

                while (startCellsIter.hasNext() && endCellsIter.hasNext()) {
                    cellRanges.add(startCellsIter.next() + ":" + endCellsIter.next());
                }

                int i = 0;

                for (int ri = range.getFirstRow(); ri <= range.getLastRow(); ri++) {
                    Row row = sheet.getRow(ri);
                    for (int ci = range.getFirstColumn(); ci <= range.getLastColumn(); ci++) {
                        Cell cell = row.getCell(ci);
                        String formula = total + "-COUNTIF(" + cellRanges.get(i) + ",\"X\")";
                        cell.setCellFormula(formula);
                        eval.evaluateFormulaCell(cell);
                        i++;
                    }
                }

                CellAddress totalForMonthCell = new CellAddress(totalCellAddress);
                Row row = sheet.getRow(totalForMonthCell.getRow());
                Cell totalCell = row.getCell(totalForMonthCell.getColumn());
                totalCell.setCellFormula("SUM(" + totalCells + ")");
                eval.evaluateFormulaCell(totalCell);

                try (OutputStream ostream = new FileOutputStream(SF2File)) {
                    wbook.write(ostream);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SF2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SF2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public void main(String[] args) {
        // TODO code application logic here
        int sheetIndex = 1;
        // Default configuration
        // Total per day
        //boys
        totalPerDay(file, sheetIndex, "D13:AB13", "D33:AB33", "D35:AB35", 21, "AC34", "D34:AB34");
        //girls
        totalPerDay(file, sheetIndex, "D35:AB35", "D59:AB59", "D61:AB61", 19, "AC60", "D60:AB60");

        // Total for the month - absent
        //boys
        countAbsences(file, sheetIndex, "D13:D33", "AB13:AB33", "AC13:AC33");
        //girls
        countAbsences(file, sheetIndex, "D35:D59", "AB35:AB59", "AC35:AC59");
        
        //combine(file, sheetIndex, "D34:AB34", "D60:AB60", "D61:AB61", "AC61");
        
        
        // Default configuration
        // Total per day
        //boys
        //totalPerDay(FILE, sheetIndex, "K18:BH18", "K56:BH56", "K57:BH57", 39, "BI57", "K57:BH57");
        //girls
        //totalPerDay(FILE, sheetIndex, "K58:BH58", "K76:BH76", "K77:BH77", 19, "BI77", "K77:BH77");

        // Total for the month - absent
        //boys
        //countAbsences(FILE, sheetIndex, "K18:K56", "BH18:BH56", "BI18:BI56");
        //girls
        //countAbsences(FILE, sheetIndex, "K58:K76", "BH58:BH76", "BI58:BI76");
    }

}
