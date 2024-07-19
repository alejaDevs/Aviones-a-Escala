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
 * @author Alejandro
 */
public class ConsultasUsuario extends Conexion {
    
    public boolean Registrar(Usuario user) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "call sp_crearUsuario (?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsuario());
            ps.setString(2, user.getContrasenia());
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
    
    public boolean Modificar(Usuario user) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "call sp_actualizarUsuario (?,?,?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getUsuario());
            ps.setString(3, user.getContrasenia());
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
    
    public boolean Eliminar(Usuario user) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "call sp_eliminarUsuario (?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId());
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
    
    public boolean Buscar(Usuario user) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "call sp_buscarUsuario (?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                user.setUsuario(rs.getString("usuario"));
                user.setContrasenia(rs.getString("contrasenia"));
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
    
    public boolean VerPerfil(Usuario user) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "call sp_buscarUsuarioU (?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsuario());
            rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(Integer.parseInt(rs.getString("id_usuario")));
                user.setContrasenia(rs.getString("contrasenia"));
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
