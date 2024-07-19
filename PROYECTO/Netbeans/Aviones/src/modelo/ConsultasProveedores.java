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
public class ConsultasProveedores extends Conexion {

    public boolean Registrar(Proveedor prov) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "call sp_agregarProveedor(?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getProveedor());
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

    public boolean Modificar(Proveedor prov) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "call sp_actualizarProveedor (?,?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, prov.getId());
            ps.setString(2, prov.getProveedor());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean Eliminar(Proveedor prov) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "call sp_eliminarProveedor (?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, prov.getId());
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
    
    public boolean Buscar(Proveedor prov) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "call sp_buscarProveedor (?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, prov.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                prov.setId(Integer.parseInt(rs.getString("id_proveedor")));
                prov.setProveedor(rs.getString("proveedor"));
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
