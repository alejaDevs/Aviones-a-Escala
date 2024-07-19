/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.ConsultasCliente;
import vista.modificarClientes;

/**
 *
 * @author crist
 */
public class controladorClienteADmin implements ActionListener{
    private Cliente mod;
    private ConsultasCliente modC;
    private modificarClientes frm;
    
    public controladorClienteADmin(Cliente mod, ConsultasCliente modC, modificarClientes frm){
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }
    
    public void inciar(){
        frm.setTitle("CLIENTE");
        frm.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == frm.btnGuardar) {
            mod.setNombre(frm.txtNombreCliente.getText());
            mod.setApellido(frm.txtApellidoCliente.getText());
            mod.setDireccion(frm.txtDireccionCliente.getText());
            mod.setTelefono(frm.txtTelefonoCliente.getText());
            mod.setEmail(frm.txtEmailCliente.getText());
            

            if (modC.Registrar(mod)) {
                JOptionPane.showMessageDialog(null, "SE HAN CREADOS LOS NUEVOS DATOS CORRECTAMENTE");
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL CREAR DATOS");
                Limpiar();
            }
        }
        
        if (e.getSource() == frm.btnModificar) {
            mod.setId(Integer.parseInt(frm.txtBuscarCliente.getText()));
            mod.setNombre(frm.txtNombreCliente.getText());
            mod.setApellido(frm.txtApellidoCliente.getText());
            mod.setDireccion(frm.txtDireccionCliente.getText());
            mod.setTelefono(frm.txtTelefonoCliente.getText());
            mod.setEmail(frm.txtEmailCliente.getText());
            

            if (modC.Modificar(mod)) {
                JOptionPane.showMessageDialog(null, "SE HAN MODIFICADO LOS DATOS CORRECTAMENTE");
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR DATOS");
                Limpiar();
            }
        }
        
        if (e.getSource() == frm.btnEliminar) {
            mod.setId(Integer.parseInt(frm.txtBuscarCliente.getText()));

            if (modC.Eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "SE HAN ELIMINADO LOS DATOS CORRECTAMENTE");
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR DATOS");
                Limpiar();
            }
        }
        
        if (e.getSource() == frm.btnBuscar) {
            mod.setId(Integer.parseInt(frm.txtBuscarCliente.getText()));

            if (modC.Buscar(mod)) {
                
                frm.txtNombreCliente.setText(mod.getNombre());
                frm.txtApellidoCliente.setText(mod.getApellido());
                frm.txtDireccionCliente.setText(mod.getDireccion());
                frm.txtTelefonoCliente.setText(mod.getTelefono());
                frm.txtEmailCliente.setText(mod.getEmail());
                frm.txtFechaCliente.setText(mod.getFecha());
            } else {
                JOptionPane.showMessageDialog(null, "NO SE HAN ENCONTRADO LOS DATOS");
                Limpiar();
            }
        }
        if (e.getSource() == frm.btnLimpiar) {
            Limpiar();
        }
    }
    
    public void Limpiar(){
        frm.txtNombreCliente.setText(null);
        frm.txtApellidoCliente.setText(null);
        frm.txtDireccionCliente.setText(null);
        frm.txtTelefonoCliente.setText(null);
        frm.txtEmailCliente.setText(null);
        frm.txtFechaCliente.setText(null);
    }
    
    
    
    
}
