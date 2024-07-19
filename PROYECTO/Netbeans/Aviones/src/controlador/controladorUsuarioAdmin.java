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
import vista.modificarUsuarios;
import vista.verPerfil;

/**
 *
 * @author informatica
 */
public class controladorUsuarioAdmin implements ActionListener {

    private Usuario mod;
    private ConsultasUsuario modC;
    private modificarUsuarios frm;
    private verPerfil rmf;

    public controladorUsuarioAdmin(Usuario mod, ConsultasUsuario modC, modificarUsuarios frm,  verPerfil rmf) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.rmf = rmf;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnBuscarUsuario.addActionListener(this);
        this.rmf.btnBuscarPerfil.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("USUARIOS");
        frm.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnGuardar) {
            mod.setUsuario(frm.txtUsuario.getText());
            mod.setContrasenia(frm.txtContraseniaUsuario.getText());
            if (modC.Registrar(mod)) {
                JOptionPane.showMessageDialog(null, "SE HAN CREADOS LOS NUEVOS DATOS CORRECTAMENTE");
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL CREAR DATOS");
                Limpiar();
            }
        }

        if (e.getSource() == frm.btnModificar) {
            mod.setId(Integer.parseInt(frm.txtIdBuscar.getText()));
            mod.setUsuario(frm.txtUsuario.getText());
            mod.setContrasenia(frm.txtContraseniaUsuario.getText());     
            if (modC.Modificar(mod)) {
                JOptionPane.showMessageDialog(null, "SE HAN MODIFICADO LOS DATOS CORRECTAMENTE");
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR DATOS");
                Limpiar();
            }
        }

        if (e.getSource() == frm.btnEliminar) {
            mod.setId(Integer.parseInt(frm.txtIdBuscar.getText()));

            if (modC.Eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "SE HAN ELIMINADO LOS DATOS CORRECTAMENTE");
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR DATOS");
                Limpiar();
            }
        }

        if (e.getSource() == frm.btnBuscarUsuario) {
            mod.setId(Integer.parseInt(frm.txtIdBuscar.getText()));

            if (modC.Buscar(mod)) {

                frm.txtUsuario.setText(mod.getUsuario());
                frm.txtContraseniaUsuario.setText(mod.getContrasenia());   
            } else {
                JOptionPane.showMessageDialog(null, "NO SE HAN ENCONTRADO LOS DATOS");
                Limpiar();
            }
        }
        if (e.getSource() == frm.btnLimpiar) {
            Limpiar();
        }
        
        if (e.getSource() == rmf.btnBuscarPerfil) {
            mod.setUsuario(rmf.txtUsuariob.getText());

            if (modC.VerPerfil(mod)) {

                rmf.txtId.setText(String.valueOf(mod.getId()));
                rmf.txtContrasenia.setText(mod.getContrasenia());   
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
        frm.txtUsuario.setText(null);
        frm.txtContraseniaUsuario.setText(null);
    }

}
