/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConsultasUsuario;
import modelo.Usuario;
import vista.Login;
import vista.User;


public class ControladorUsuario implements ActionListener {
    private Usuario mod;
    private ConsultasUsuario modC;
    private User frm;
    
    public ControladorUsuario(Usuario mod, ConsultasUsuario modC, User frm){
        this.mod=mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnlistoUsuario.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()== frm.btnlistoUsuario) {
            mod.setUsuario(frm.txtUsuario.getText());
            mod.setContrasenia(frm.txtContrasenia.getText());
            
            if (modC.Registrar(mod)) {
                JOptionPane.showMessageDialog(null,"Registro Exitoso");
                Limpiar();
                Login u = new Login();
                u.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"Registro Fallido");
                Limpiar();
            }
        }
    }
    
    public void Limpiar(){
        frm.txtUsuario.setText(null);
        frm.txtContrasenia.setText(null);
    }
    
}
