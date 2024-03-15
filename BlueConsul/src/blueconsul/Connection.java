/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blueconsul;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ricky Salim
 */
public class Connection {

   private static java.sql.Connection mysql() {
        try {
        java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bluekonsul","root","root");
        return cn;
        } catch(SQLException exception) {
            JOptionPane.showMessageDialog(null, exception);
        }
        return null;
   }
   
   public static void Insert(String query) {
       try {
           java.sql.Connection cn = mysql();
           cn.createStatement().executeUpdate(query);
       } catch (SQLException ex) {
           Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
    public static void Update(String query) {
       try {
           java.sql.Connection cn = mysql();
           cn.createStatement().executeUpdate(query);
       } catch (SQLException ex) {
           Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
    
    public static void Delete(String query) {
       try {
           java.sql.Connection cn = mysql();
           cn.createStatement().executeUpdate(query);
       } catch (SQLException ex) {
           Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public static ResultSet Select(String query)  {
      try {
        java.sql.Connection cn = mysql();
        PreparedStatement ps = cn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        return rs;
      } catch(SQLException exception) {
          JOptionPane.showMessageDialog(null, exception);
      }
      return null;
   }
    
     
   public static Boolean isAuthenticated(String username, String password) {
       try {
           java.sql.Connection cn = mysql();
           PreparedStatement ps = cn.prepareStatement("SELECT * FROM users WHERE user_name=? AND user_password=? LIMIT 1");
           ps.setString(1, username);
           ps.setString(2, password);
           ResultSet rs = ps.executeQuery();
           if(rs.next()) {
               return true;
           }   
       } catch (SQLException ex) {
           Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
       }
       return false;
   }
   
   
}
