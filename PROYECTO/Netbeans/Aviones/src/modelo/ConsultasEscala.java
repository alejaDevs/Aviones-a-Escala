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
public class ConsultasEscala extends Conexion{
    
    public boolean Registrar(Escala esc){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "call sp_agregarEscala (?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setString (1, esc.getEscala()); 
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
    
    public boolean Modificar (Escala esc){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "call sp_actualizarEscala (?,?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt (1, esc.getId());
            ps.setString (2, esc.getEscala());
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
    
    public boolean Eliminar (Escala esc){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "call sp_eliminarEscala (?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt (1, esc.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println (e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean Buscar (Escala esc){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "call sp_buscarEscala (?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt (1 , esc.getId());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                esc.setId(Integer.parseInt(rs.getString("id_escala")));
                esc.setEscala(rs.getString("escala"));
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
