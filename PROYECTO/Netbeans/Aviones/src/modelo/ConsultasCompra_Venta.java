/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author crist
 */
public class ConsultasCompra_Venta extends Conexion{
     
    public boolean Registrar(Compra_Venta cv) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "call sp_agregarCompra_Venta (?,?,now());";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cv.getId_usuario());
            ps.setInt(2, cv.getId_aviones());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean Eliminar(Compra_Venta cv) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "call sp_eliminarCompra_Venta (?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cv.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean Buscar(Compra_Venta cv) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "call sp_buscarCompra_Venta (?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cv.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                cv.setId(Integer.parseInt(rs.getString("id_compra_venta")));
                cv.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
                cv.setId_aviones(Integer.parseInt(rs.getString("id_aviones")));
                cv.setFecha(rs.getString("fecha"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
