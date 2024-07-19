  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Alejandro
 */
public class Compra_Venta {
    private int id;
    private int id_usuario;
    private int id_aviones;
    private String nombre;
    private String usuario;
    private String fecha;

    public Compra_Venta (){}
    
    public Compra_Venta (int id, int id_usuario, int id_aviones,String nombre,String usuario, String fecha){
        this.id = id;
        this.id_usuario = id_usuario;
        this.id_aviones = id_aviones;
        this.nombre = nombre;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_aviones() {
        return id_aviones;
    }

    public void setId_aviones(int id_aviones) {
        this.id_aviones = id_aviones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
