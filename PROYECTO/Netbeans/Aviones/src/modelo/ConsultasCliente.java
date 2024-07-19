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
public class ConsultasCliente extends Conexion {

    public boolean Registrar(Cliente client) {  
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "call sp_agregarCliente (?,?,?,?,?,now());";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, client.getNombre());
            ps.setString(2, client.getApellido());
            ps.setString(3, client.getDireccion());
            ps.setString(4, client.getTelefono());
            ps.setString(5, client.getEmail());
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

    public boolean Modificar(Cliente client) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "call sp_actualizarClientes (?,?,?,?,?,?,now());";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, client.getId());
            ps.setString(2, client.getNombre());
            ps.setString(3, client.getApellido());
            ps.setString(4, client.getDireccion());
            ps.setString(5, client.getTelefono());
            ps.setString(6, client.getEmail());
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

    public boolean Eliminar(Cliente client) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "call sp_eliminarClientes (?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, client.getId());
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

    public boolean Buscar(Cliente client) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "call sp_buscarCliente (?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, client.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                client.setId(Integer.parseInt(rs.getString("id_cliente")));
                client.setNombre(rs.getString("nombre"));
                client.setApellido(rs.getString("apellido"));
                client.setDireccion(rs.getString("direccion"));
                client.setTelefono(rs.getString("telefono"));
                client.setEmail(rs.getString("email"));
                client.setFecha(rs.getString("fecha"));
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
