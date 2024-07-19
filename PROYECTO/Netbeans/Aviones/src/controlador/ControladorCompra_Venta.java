/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Compra_Venta;
import modelo.ConsultasCompra_Venta;
import vista.RealizarC_V;
import vista.modificarCompra_Venta;
import vista.verCompras;

/**
 *
 * @author crist
 */
public class ControladorCompra_Venta implements ActionListener {

    private Compra_Venta mod;
    private ConsultasCompra_Venta modC;
    private modificarCompra_Venta frm;
    private RealizarC_V mrf;

    public ControladorCompra_Venta(Compra_Venta mod, ConsultasCompra_Venta modC, modificarCompra_Venta frm, RealizarC_V mrf) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.mrf = mrf;
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.mrf.btnRealizarCompra.addActionListener(this);

    }
    
    public void iniciar(){
        frm.setTitle("Compra Venta");
        frm.setLocationRelativeTo(null); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource() == mrf.btnRealizarCompra) {
            mod.setId_usuario(Integer.parseInt(mrf.txtIdUsuario.getText()));
            mod.setId_aviones(Integer.parseInt(mrf.txtIdAvion.getText()));
            
            if (modC.Registrar(mod)) {
                JOptionPane.showMessageDialog(null, "COMPRA REALIZADA DE MANERA EXITOSA");
            } else{
                JOptionPane.showMessageDialog(null, "NO SE PUDO REALIZAR LA COMPRA");
                Limpiar();
            }
        }
        
        if (e.getSource() == frm.btnEliminar) {
                mod.setId(Integer.parseInt(frm.txtIdAbuscar.getText()));

                if (modC.Eliminar(mod)) {
                    JOptionPane.showMessageDialog(null, "SE HA ELIMINADO LA COMPRA/VENTA CORRECTAMENTE");
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR LA COMPRA/VENTA");
                    Limpiar();
                }
            } 
        
        if (e.getSource() == frm.btnBuscar) {
            mod.setId(Integer.parseInt(frm.txtIdAbuscar.getText()));

            if (modC.Buscar(mod)) {
                
                frm.txtIdUsuario.setText(String.valueOf(mod.getId_usuario()));
                frm.txtIdAvion.setText(String.valueOf(mod.getId_aviones()));
                frm.txtFecha.setText(mod.getFecha());
            } else {
                JOptionPane.showMessageDialog(null, "NO SE HAN ENCONTRADO LOS DATOS");
                Limpiar();
            }
        }
        if (e.getSource() == frm.btnEliminar) {
            Limpiar();
        }
   }   
    
        
            
    
    public void Limpiar(){
        frm.txtIdAbuscar.setText(null);
        frm.txtIdUsuario.setText(null);
        frm.txtIdAvion.setText(null);
        frm.txtFecha.setText(null);
        mrf.txtIdUsuario.setText(null);
        mrf.txtIdAvion.setText(null);
    }
    
}
