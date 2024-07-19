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
public class ConsultasAviones extends Conexion {

    public boolean Registrar(Aviones av) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "call sp_agregarAvion (?,?,?,?,?,?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, av.getNombre());
            ps.setString(2, av.getModelo());
            ps.setString(3, av.getMarca());
            ps.setInt(4, av.getId_escala());
            ps.setInt(5, av.getId_proveedor());
            ps.setFloat(6, av.getPrecio());
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

    public boolean Modificar(Aviones av) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "call sp_actualizarAvion (?,?,?,?,?,?,?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, av.getId());
            ps.setString(2, av.getNombre());
            ps.setString(3, av.getModelo());
            ps.setString(4, av.getMarca());
            ps.setInt(5, av.getId_escala());
            ps.setInt(6, av.getId_proveedor());
            ps.setFloat(7, av.getPrecio());
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

    public boolean Eliminar(Aviones av) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "call sp_eliminarAvion (?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, av.getId());
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

    public boolean Buscar(Aviones av) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "call sp_buscarAvion (?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, av.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                av.setId(Integer.parseInt(rs.getString("id_aviones")));
                av.setNombre(rs.getString("nombre"));
                av.setModelo(rs.getString("modelo"));
                av.setMarca(rs.getString("marca"));
                av.setId_escala(Integer.parseInt(rs.getString("id_escala")));
                av.setId_proveedor(Integer.parseInt(rs.getString("id_proveedor")));
                av.setPrecio(Float.valueOf(rs.getString("precio")));
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
