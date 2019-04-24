/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author LAKE
 */
public class MySQLConnection {
    public static Connection getConnection() {
      Connection con = null;
      try {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://localhost:3030/eshopping", "root", "Legolas15081212");
      } catch(Exception ex) {
          ex.printStackTrace();
      }
      return con;
    }
    
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
