/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineapp;

import java.sql.ResultSet;

/**
 *
 * @author Will Figueroa
 */
public class usuarios {
private int id_usuarios;
private String nombre_usuarios;
private String password;

    /**
     * @return the id_usuarios
     */
    public int getId_usuarios() {
        return id_usuarios;
    }

    /**
     * @param id_usuarios the id_usuarios to set
     */
    private void setId_usuarios(int id_usuarios) {
        
        this.id_usuarios = id_usuarios;
    }

    /**
     * @return the nombre_usuarios
     */
    public String getNombre_usuarios() {
       
        return nombre_usuarios;
    }

    /**
     * @param nombre_usuarios the nombre_usuarios to set
     */
    public void setNombre_usuarios(String nombre_usuarios) {
        if(nombre_usuarios.length()<=45){
            this.nombre_usuarios = nombre_usuarios;
        }
       
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        if(password.length()<=45){
             this.password = password;
        }
       
    }
    conexion cn=new conexion();
    public void agregar() throws Exception{
        try {
            cn.conectar();
            cn.UID("INSERT into usuarios(nombre_usuarios,password) values(\""+getNombre_usuarios()+"\",\""+getPassword()+"\")");
            
            cn.desconectar();   
         } catch (Exception e) {
             System.out.println("no logra ingresar");
             
         }finally{
         cn.desconectar();
         } 
    }
     public ResultSet BuscarUsuario(int id_usuarios) throws Exception{
         ResultSet d=null;
         try {
         cn.conectar();
         d=cn.getValores("SELECT nombre_usuario,password FROM usuarios WHERE id_usuarios='"+id_usuarios+"'");    
         } catch (Exception e) {
             System.out.println("No logra obtener");
         }finally{
         cn.desconectar();
         }
         return d;
     }
     
     public ResultSet Obtener() throws Exception{
     ResultSet d=null;
         try {
         cn.conectar();
         d=cn.getValores("select nombre_usuario,password from usuarios;");    
         } catch (Exception e) {
             cn.desconectar();
             System.out.println("no logra obtener datos ");  
         }finally{
         
         }
         return d;
}
}
