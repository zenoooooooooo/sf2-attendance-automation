/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/module-info.java to edit this template
 */

module SF2_AUTOMATION_PROJECT {
    
    requires java.sql;
    
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
    requires mysql.connector.j;
    requires org.slf4j;
    requires com.zaxxer.hikari;
    requires com.h2database;
}
