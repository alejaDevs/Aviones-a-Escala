/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConsultasEscala;
import modelo.Escala;
import vista.modificarEscala;

/**
 *
 * @author crist
 */
public class ControladorEscalaAdmin implements ActionListener {
    private Escala mod;
    private ConsultasEscala modC;
    private modificarEscala frm;
    
    public ControladorEscalaAdmin (Escala mod, ConsultasEscala modC, modificarEscala frm){
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnAgregar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }
    
    public void Iniciar(){
        frm.setTitle("Escala");
        frm.setLocationRelativeTo(null);
    }
    
    @Override
     public void actionPerformed(ActionEvent e){
        if (e.getSource() == frm.btnAgregar) {
            mod.setEscala(frm.txtEcala.getText());           
            if (modC.Registrar(mod)) {
                JOptionPane.showMessageDialog(null, "LA ESCALA HA SIDO CREADA DE MANERA EXITOSA");
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR AL CREAR LA ESCALA");
                Limpiar();
            }
        }
        
        if (e.getSource() == frm.btnModificar) {
            mod.setId(Integer.parseInt(frm.txtidBuscar.getText()));
            mod.setEscala(frm.txtEcala.getText());       
            if (modC.Modificar(mod)) {
                JOptionPane.showMessageDialog(null, "LA ESCALA HA SIDO MODIFICADA DE MANERA EXITOSA");
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR AL MODIFICAR LA ESCALA");
                Limpiar();
            }
        }
        
        if (e.getSource() == frm.btnEliminar) {
            mod.setId(Integer.parseInt(frm.txtidBuscar.getText()));

            if (modC.Eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "LA ESCALA HA SIDO ELIMINADA DE MANERA EXITOSA");
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR AL ELIMINAR LA ESCALA");
                Limpiar();
            }
        }
        
        if (e.getSource() == frm.btnBuscar) {
            mod.setId(Integer.parseInt(frm.txtidBuscar.getText()));

            if (modC.Buscar(mod)) {
                
                frm.txtEcala.setText(mod.getEscala());
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
        frm.txtidBuscar.setText(null);
        frm.txtEcala.setText(null);
    }
}
