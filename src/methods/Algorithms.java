/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package methods;

import interfaces.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author espla
 */
public class Algorithms implements algorithmsInterface {

    public List<Integer> getBoysPerDay() {
        return boysPerDay;
    }

    public List<Integer> getGirlsPerDay() {
        return girlsPerDay;
    }

    public List<Integer> getTotalPerDay() {
        return totalPerDay;
    }

    public int getTotalSum() {
        return totalSum;
    }

    public int getNumberOfDates() {
        return numberOfDates;
    }

    public int getAbsentTotalBoys() {
        return absentTotalBoys;
    }

    public int getAbsentTotalGirls() {
        return absentTotalGirls;
    }

    public int getBlanks() {
        return blanks;
    }

    private FileInputStream inputStream;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private int numberOfDates = 0;
    private int absentTotalBoys = 0;
    private int absentTotalGirls = 0;
    private int blanks = 0;

    private final List<Integer> boysPerDay = new ArrayList<>();
    private final List<Integer> girlsPerDay = new ArrayList<>();
    private final List<Integer> totalPerDay = new ArrayList<>();
    private int totalSum = 0;

    @Override
    public void countDates(String filePath, int sheetIndex, String start, String end) {
        try {
            inputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheetAt(sheetIndex);

            CellReference sd = new CellReference(start);
            CellReference ed = new CellReference(end);

            boolean countingBlanks = true;

            for (int col = sd.getCol(); col <= ed.getCol(); col++) {
                Row currentRow = sheet.getRow(sd.getRow());
                Cell currentCell = currentRow.getCell(col);

                if (currentCell == null || currentCell.getCellType() == CellType.BLANK) {

                    if (countingBlanks) {
                        blanks++;
                    }
                } else if (currentCell.getCellType() == CellType.NUMERIC) {

                    countingBlanks = false;
                    numberOfDates++;
                }
            }

            System.out.println("Number of blanks: " + getBlanks());

            System.out.println("Number of Dates: " + getNumberOfDates());

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Override
    public void countBoys(String filePath, int sheetIndex, String start, String end, String perDay) {
        try {
            inputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheetAt(sheetIndex);

            CellReference startBoys = new CellReference(start);
            CellReference endBoys = new CellReference(end);
            CellReference perDayCells = new CellReference(perDay);

            for (int row1 = startBoys.getRow(); row1 <= endBoys.getRow(); row1++) {
                Row currentRow1 = sheet.getRow(row1);
                Row totalPerDayRow = sheet.getRow(perDayCells.getRow());

                int absences = 0;

                for (int col = startBoys.getCol() + getBlanks(); col <= startBoys.getCol() + getBlanks() + getNumberOfDates() - 1; col++) {
                    Cell currentCell1 = currentRow1.getCell(col);
                    int presences = 0;

                    for (int row2 = startBoys.getRow(); row2 <= endBoys.getRow(); row2++) {
                        Row currentRow2 = sheet.getRow(row2);
                        Cell currentCell2 = currentRow2.getCell(col);

                        if (currentCell2.getCellType().equals(CellType.BLANK)) {
                            presences++;
                        }

                        Cell boysPerDayCell = totalPerDayRow.getCell(col);
                        boysPerDayCell.setCellValue(presences);
                    }

                    if (currentCell1 != null && currentCell1.toString().equalsIgnoreCase("x")) {
                        absences++;

                    }
                    Cell absentCell = currentRow1.getCell(startBoys.getCol() + 25);
                    absentCell.setCellValue(absences);

                }

                absentTotalBoys += absences;
                Cell absentTotalCell = totalPerDayRow.getCell(startBoys.getCol() + 25);
                absentTotalCell.setCellValue(getAbsentTotalBoys());

                System.out.println(absences);
                System.out.println(getAbsentTotalBoys());
            }

            for (int col = perDayCells.getCol() + getBlanks(); col <= perDayCells.getCol() + getBlanks() + getNumberOfDates() - 1; col++) {
                Row currentRow = sheet.getRow(perDayCells.getRow());
                Cell currentCell = currentRow.getCell(col);

                getBoysPerDay().add((int) currentCell.getNumericCellValue());
            }

            try (FileOutputStream fileout = new FileOutputStream(filePath)) {
                workbook.write(fileout);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Override
    public void countGirls(String filePath, int sheetIndex, String start, String end, String perDay) {
        try {
            inputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheetAt(sheetIndex);

            CellReference startGirls = new CellReference(start);
            CellReference endGirls = new CellReference(end);
            CellReference perDayCells = new CellReference(perDay);
            for (int row1 = startGirls.getRow(); row1 <= endGirls.getRow(); row1++) {
                Row currentRow1 = sheet.getRow(row1);
                Row totalPerDayRow = sheet.getRow(perDayCells.getRow());

                int absences = 0;

                for (int col = startGirls.getCol() + getBlanks(); col <= startGirls.getCol() + getBlanks() + getNumberOfDates() - 1; col++) {
                    Cell currentCell1 = currentRow1.getCell(col);
                    int presences = 0;

                    for (int row2 = startGirls.getRow(); row2 <= endGirls.getRow(); row2++) {
                        Row currentRow2 = sheet.getRow(row2);
                        Cell currentCell2 = currentRow2.getCell(col);

                        if (currentCell2.getCellType().equals(CellType.BLANK)) {
                            presences++;
                        }

                        Cell girlsPerDayCell = totalPerDayRow.getCell(col);
                        girlsPerDayCell.setCellValue(presences);

                    }

                    if (currentCell1 != null && currentCell1.toString().equalsIgnoreCase("x")) {
                        absences++;
                    }

                    Cell absentCell = currentRow1.getCell(startGirls.getCol() + 25);
                    absentCell.setCellValue(absences);
                }

                absentTotalGirls += absences;
                Cell absentTotalCell = totalPerDayRow.getCell(startGirls.getCol() + 25);
                absentTotalCell.setCellValue(getAbsentTotalGirls());

                System.out.println(absences);
                System.out.println(getAbsentTotalGirls());
            }
            for (int col = perDayCells.getCol() + getBlanks(); col <= perDayCells.getCol() + getBlanks() + getNumberOfDates() - 1; col++) {
                Row currentRow = sheet.getRow(perDayCells.getRow());
                Cell currentCell = currentRow.getCell(col);

                getGirlsPerDay().add((int) currentCell.getNumericCellValue());
            }
            try (FileOutputStream fileout = new FileOutputStream(filePath)) {
                workbook.write(fileout);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Override
    public void countTotalPerDay(String filePath, int sheetIndex, String totalPerDayCells) {
        try {
            inputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheetAt(sheetIndex);

            CellReference cells = new CellReference(totalPerDayCells);

            for (int i = 0; i < getBoysPerDay().size(); i++) {
                int sum = getBoysPerDay().get(i) + getGirlsPerDay().get(i);
                getTotalPerDay().add(sum);
                Row currentRow = sheet.getRow(cells.getRow());
                Cell currentCell = currentRow.getCell(cells.getCol() + getBlanks() + i);

                currentCell.setCellValue(getTotalPerDay().get(i));

                Cell totalAbsentCell = currentRow.getCell(cells.getCol() + 25);
                totalSum += totalPerDay.get(i);
                int overallTotal = getAbsentTotalBoys() + getAbsentTotalGirls();
                totalAbsentCell.setCellValue(overallTotal);

            }
            try (FileOutputStream fileout = new FileOutputStream(filePath)) {
                workbook.write(fileout);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    /* 
    Code Explanation:
   
    The first argument is the path of the file, so if the user chooses a file, 
    the filepath will be set to a String variable called "PATH" and will automatically be set as the first argument of all the methods.

    The second argument on the other hand is the sheet index. When the user clicked the valid sf2 sheet in the workbook or file they have chosen,
    the index of that sheet will be set to an int variable called "Sheet" and will automatically be set as the second argument of all the methods.
    
    The cell references such as "D11", are the user input.
    
    The first and second inputs are where the program will start and end reading respectively.
    
    The third is where the computer will start outputting the results.
    
    Default Arguments:
    
        countDates(PATH, 0, "D11", "AB11");
        countBoys(PATH, 0, "G14", "G34", "G35");
        countGirls(PATH, 0, "G36", "G54", "G61");
        countTotalPerDay(PATH, 0, "G62");
     */
}
