/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sf2_automation_project;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author psyche
 */
public class ConnectionPooling {
    // Connection pooling
    
    private static HikariDataSource dts;
    
    static {
        HikariConfig config = new HikariConfig("src/sf2_automation_project/hikari.properties");
        dts = new HikariDataSource(config);
    }
    
    public static Connection getConnection() throws SQLException {
        return dts.getConnection();
    }
}
