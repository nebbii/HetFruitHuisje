/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hetfruithuisje;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.*;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class db {
    private static final String USERNAME="root";
    private static final String PASSWORD="";
    private static final String CON_STRING="jdbc:mysql://localhost:3306/hetfruithuisje";
    
    Connection conn = null;
    public static Connection java_db(){
        
        
        try {
            Connection conn = (Connection) DriverManager.getConnection(CON_STRING, USERNAME, PASSWORD);
            System.out.println("Conntected");
            return conn;

        } catch(Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
    
}
