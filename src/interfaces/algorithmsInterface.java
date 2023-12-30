/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author akira
 */
public interface algorithmsInterface {
    
    void countDates(String filePath, int sheetIndex, String start, String end);
    
    void countBoys(String filePath, int sheetIndex, String start, String end, String perDay);
    
    void countGirls(String filePath, int sheetIndex, String start, String end, String perDay);
    
    void countTotalPerDay(String filePath, int sheetIndex, String totalPerDayCells);
    
}
