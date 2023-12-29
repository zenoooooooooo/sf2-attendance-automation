/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/module-info.java to edit this template
 */

module SF2_AUTOMATION_PROJECT {
    
    opens sf2_automation_project;
    
    exports sf2_automation_project to javafx.graphics, javafx.fxml;
    
    requires javafx.swt;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;
    requires javafx.swing;
    requires javafx.web;
    requires java.base;
    requires org.apache.poi.poi;
    requires org.apache.poi.examples;
    requires org.apache.poi.excelant;
    requires poi.javadoc;
    requires org.apache.poi.ooxml;
    requires org.apache.poi.ooxml.schemas;
    requires org.apache.poi.scratchpad;
    requires org.apache.commons.compress;
    requires commons.logging;
    requires org.apache.xmlbeans;
    requires ant;
    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;
}
