/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.io.File;

/**
 *
 * @author akira
 */
public interface algorithmsInterface {
    
    void countDates(File filePath, int sheetIndex, String start, String end);
    
    void countBoys(File filePath, int sheetIndex, String start, String end, String perDay);
    
    void countGirls(File filePath, int sheetIndex, String start, String end, String perDay);
    
    void countTotalPerDay(File filePath, int sheetIndex, String totalPerDayCells);
    
}
