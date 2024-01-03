/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/module-info.java to edit this template
 */

module SF2_AUTOMATION_PROJECT {
    
    requires java.sql;
    
    opens components.SF2GUI;
    opens components.chooseFile;
    opens components.excel;
    opens components.report;
    opens components.database;
    opens components.configure;
    
    exports components.excel to javafx.graphics, javafx.fxml;
    exports components.SF2GUI to javafx.graphics, javafx.fxml;
    exports components.chooseFile to javafx.graphics, javafx.fxml;
    exports components.report to javafx.graphics, javafx.fxml;
    exports components.database to javafx.graphics, javafx.fxml;
    exports components.configure to javafx.graphics, javafx.fxml;
    
    exports sf2_automation_project to javafx.graphics;
    
    requires javafx.swt;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;
    requires javafx.swing;
    requires javafx.web;
    requires java.base;
    requires mysql.connector.j;
    requires org.slf4j;
    requires com.zaxxer.hikari;
    requires com.h2database;
    requires org.apache.poi.poi;
    requires org.apache.poi.examples;
    requires org.apache.poi.excelant;
    requires org.apache.poi.ooxml;
    requires org.apache.poi.ooxml.schemas;
    requires org.apache.poi.scratchpad;
    requires org.apache.commons.compress;
    requires org.apache.xmlbeans;
    requires ant;
    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;
    requires org.apache.commons.io;
    requires org.apache.commons.collections4;
    requires org.apache.commons.codec;
    requires commons.math3;
    requires SparseBitSet;
    requires poi.javadoc;
    requires commons.logging;

}
