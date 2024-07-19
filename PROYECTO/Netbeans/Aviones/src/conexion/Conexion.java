/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    private final String base = "aviones_Escala";
    private final String user = "root";
    private final String contrasenia = "ADMIN";
    private final String url = "jdbc:mysql://localhost:3306/"+base;
    private Connection con = null;
    
    public Connection getConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user,this.contrasenia);
        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public ResultSet SeleccionarUsuario (String usuario){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = getConexion();
            pst = cn.prepareStatement("call sp_buscarCompra (?);");
            pst.setString(1,usuario);
            rs = pst.executeQuery();
        } catch (Exception e) {
        }
        return rs;
    }
}
