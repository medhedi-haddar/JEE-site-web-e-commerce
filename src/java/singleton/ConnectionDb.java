/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 *
 * @author toshiba
 */
public class ConnectionDb 
{
    private static Connection con ;

    
    
    
           static String url = "jdbc:mysql://localhost/gstock";
          static  String login = "root";
          static  String password = "";
          static  String driverClassName = "com.mysql.jdbc.Driver";
          
    private ConnectionDb() 
    {
        try 
        {
            
            Class.forName(driverClassName);
            //DriverManager.registerDriver(driver);
            con =  DriverManager.getConnection(url, login, password);
            
        } catch (Exception e) 
        {
            System.out.print("\n" + e.getMessage());
        }

    }
    
    public static Connection getInstance() 
    {
        if(con == null)
        {
            new ConnectionDb();
        }
        
        return con ;
    }
    
    
}
