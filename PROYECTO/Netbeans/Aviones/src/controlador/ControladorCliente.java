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
import vista.Vista_Cliente;
import vista.User;

public class ControladorCliente implements ActionListener{
    private Cliente mod;
    private ConsultasCliente modC;
    private Vista_Cliente frm;
    
    public ControladorCliente(Cliente mod, ConsultasCliente modC, Vista_Cliente frm){
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnAgregarCliente.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()== frm.btnAgregarCliente) {
            mod.setNombre(frm.txtNombreCliente.getText());
            mod.setApellido(frm.txtApellidoCliente.getText());
            mod.setDireccion(frm.txtDireccionCliente.getText());
            mod.setTelefono(frm.txtTelefonoCliente.getText());
            mod.setEmail(frm.txtEmailCliente.getText());
            
            if (modC.Registrar(mod)) {
                JOptionPane.showMessageDialog(null,"Registro Exitoso");
                Limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"Registro Fallido");
                Limpiar();
            }
        }
    }
    
    
    public void Limpiar(){
        frm.txtNombreCliente.setText(null);
        frm.txtApellidoCliente.setText(null);
        frm.txtDireccionCliente.setText(null);
        frm.txtTelefonoCliente.setText(null);
        frm.txtEmailCliente.setText(null);
    }
}
