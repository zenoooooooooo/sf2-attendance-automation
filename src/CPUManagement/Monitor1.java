/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CPUManagement;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

/**
 *
 * @author akira
 */
public class Monitor1 {
        public void monitor1() {
            
            System.gc();
            OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
            
            System.out.println("Available processors: " + osBean.getAvailableProcessors());
            
            if (osBean instanceof com.sun.management.OperatingSystemMXBean) {
                com.sun.management.OperatingSystemMXBean sunOsBean = (com.sun.management.OperatingSystemMXBean) osBean;
                
                while (true) {
                    double cpuUsage = sunOsBean.getProcessCpuLoad() * 100.0;
                    System.out.println("CPU Usage: " + cpuUsage + "%");
                    
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            } else {
                System.out.println("OperatingSystemManagementSystemMXBean does not suuport CPU usage monitoring");
            }
    }
}
