/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConsultasProveedores;
import modelo.Proveedor;
import vista.modificarProveedor;

/**
 *
 * @author crist
 */
public class ControladorProveedorAdmin implements ActionListener {
    private Proveedor mod;
    private ConsultasProveedores modC;
    private modificarProveedor frm;
    
    public ControladorProveedorAdmin (Proveedor mod, ConsultasProveedores modC, modificarProveedor frm){
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnAgregar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }
    
    public void Iniciar(){
        frm.setTitle("Proveedor");
        frm.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == frm.btnAgregar) {
            mod.setProveedor(frm.txtProveedor.getText());           
            if (modC.Registrar(mod)) {
                JOptionPane.showMessageDialog(null, "EL PROVEEDOR HA SIDO CREADO DE MANERA EXITOSA");
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR AL CREAR EL PROVEEDOR");
                Limpiar();
            }
        }
        
        if (e.getSource() == frm.btnModificar) {
            mod.setId(Integer.parseInt(frm.txtIdBuscar.getText()));
            mod.setProveedor(frm.txtProveedor.getText());       
            if (modC.Modificar(mod)) {
                JOptionPane.showMessageDialog(null, "EL PROVEEDOR HA SIDO MODIFICADO DE MANERA EXITOSA");
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR AL MODIFICAR EL PROVEEDOR");
                Limpiar();
            }
        }
        
        if (e.getSource() == frm.btnEliminar) {
            mod.setId(Integer.parseInt(frm.txtIdBuscar.getText()));

            if (modC.Eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "EL PROVEEDOR HA SIDO ELIMINADO DE MANERA EXITOSA");
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR AL ELIMINAR EL PROVEEDOR");
                Limpiar();
            }
        }
        
        if (e.getSource() == frm.btnBuscar) {
            mod.setId(Integer.parseInt(frm.txtIdBuscar.getText()));

            if (modC.Buscar(mod)) {
                
                frm.txtProveedor.setText(mod.getProveedor());
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
        frm.txtIdBuscar.setText(null);
        frm.txtProveedor.setText(null);
    }
}
