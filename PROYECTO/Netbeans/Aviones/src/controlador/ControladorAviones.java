/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConsultasAviones;
import modelo.Aviones;
import vista.modificarAviones;

/**
 *
 * @author crist
 */
public class ControladorAviones implements ActionListener {

    private Aviones mod;
    private ConsultasAviones modC;
    private modificarAviones frm;

    public ControladorAviones(Aviones mod, ConsultasAviones modC, modificarAviones frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("DRONES");
        frm.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnGuardar) {
            mod.setNombre(frm.txtNombreDron.getText());
            mod.setModelo(frm.txtModeloDron.getText());
            mod.setMarca(frm.txtMarcaDron.getText());
            mod.setId_escala(Integer.parseInt(frm.txtEscalaAvion.getText()));
            mod.setId_proveedor(Integer.parseInt(frm.txtProveedorDron.getText()));
            mod.setPrecio(Float.parseFloat(frm.txtPrecioDron.getText()));

            if (modC.Registrar(mod)) {
                JOptionPane.showMessageDialog(null, "SE HAN CREADOS LOS NUEVOS DATOS CORRECTAMENTE");
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL CREAR DATOS");
                Limpiar();
            }
        }

        if (e.getSource() == frm.btnModificar) {
            mod.setId(Integer.parseInt(frm.txtBuscarDron.getText()));
            mod.setNombre(frm.txtNombreDron.getText());
            mod.setModelo(frm.txtModeloDron.getText());
            mod.setMarca(frm.txtMarcaDron.getText());
            mod.setId_escala(Integer.parseInt(frm.txtEscalaAvion.getText()));
            mod.setId_proveedor(Integer.parseInt(frm.txtProveedorDron.getText()));
            mod.setPrecio(Float.parseFloat(frm.txtPrecioDron.getText()));

            if (modC.Modificar(mod)) {
                JOptionPane.showMessageDialog(null, "SE HAN MODIFICADO LOS DATOS CORRECTAMENTE");
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR DATOS");
                Limpiar();
            }
        }

        if (e.getSource() == frm.btnEliminar) {
            mod.setId(Integer.parseInt(frm.txtBuscarDron.getText()));

            if (modC.Eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "SE HAN ELIMINADO LOS DATOS CORRECTAMENTE");
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR DATOS");
                Limpiar();
            }
        }
        
        if (e.getSource() == frm.btnBuscar) {
            mod.setId(Integer.parseInt(frm.txtBuscarDron.getText()));

            if (modC.Buscar(mod)) {
                
                frm.txtNombreDron.setText(mod.getNombre());
                frm.txtModeloDron.setText(mod.getModelo());
                frm.txtMarcaDron.setText(mod.getMarca());
                frm.txtEscalaAvion.setText(String.valueOf(mod.getId_escala()));
                frm.txtProveedorDron.setText(String.valueOf(mod.getId_proveedor()));
                frm.txtPrecioDron.setText(String.valueOf(mod.getPrecio()));
            } else {
                JOptionPane.showMessageDialog(null, "NO SE HAN ENCONTRADO LOS DATOS");
                Limpiar();
            }
        }
        if (e.getSource() == frm.btnLimpiar) {
            Limpiar();
        }
    }

    public void Limpiar() {
        frm.txtNombreDron.setText(null);
        frm.txtModeloDron.setText(null);
        frm.txtMarcaDron.setText(null);
        frm.txtEscalaAvion.setText(null);
        frm.txtProveedorDron.setText(null);
        frm.txtPrecioDron.setText(null);
    }
}
