/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connect;// chinh thuc

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Douers
 */
public class SQLServerProvider {
    Connection connection = null;
    Statement  statement =  null;
    ResultSet result_text = null;
    
    public Connection open () throws SQLException {
        String strServer="LAPTOP-K3GJ0VHV\\SQLEXPRESS";
        String sqlDatabase="DB_VPP3";
        String uid="sa";
        String pwd="123456789";
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String connectionString="";
        try {
            Class.forName(driver);
            String connectionURL = "jdbc:sqlserver://" + strServer 
                    + ":1433; databaseName= " + sqlDatabase
                    + "; user = " + uid
                    + "; password = " + pwd
                    + "; encrypt = true; trustServerCertificate = true";   
            try {   
                connection =(Connection) DriverManager.getConnection(connectionURL);
                if(connection!=null){  
                        connectionString = connectionURL;
                        return DriverManager.getConnection(connectionURL);
                }else{
                        System.out.println("Ket noi ko thanh cong");   
                }
            } catch (SQLException ex) {
                Logger.getLogger(SQLServerProvider.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLServerProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return DriverManager.getConnection(connectionString);
        
    }
    
    public void close() {
        try{
            this.connection.close();
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        
        try{
            Statement sm = connection.createStatement();
            rs = sm.executeQuery(sql);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;
    }
    
    public int executeUpdate (String sql) {
        int n = -1;
        try{
            Statement sm = connection.createStatement();
            n = sm.executeUpdate (sql);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return n;
    
    }

 
//======================TEST======================    
    
//    public static void main(String[] args) throws SQLException {
//        SQLServerProvider sql = new SQLServerProvider();
//        Connection con = sql.open();
//        System.out.println(con);
//    }

    public Object getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int executeUpdate(String sql, int soLuong, int ncc, String maDonDatHang, int maHangHoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int executeUpdate(String sql, int soLuong, int ncc, int maHangHoa, String maDonDatHang, int maHangHoa0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
