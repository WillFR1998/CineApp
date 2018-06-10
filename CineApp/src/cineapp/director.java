/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineapp;

import java.sql.ResultSet;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Will Figueroa
 */
public class director {
    private int id_director;
    private String nombre;
    private String apellido;
    private Date nacimiento;
    private String nacionalidad;

    /**
     * @return the id_director
     */
    public int getId_director() {
        return id_director;
    }

    /**
     * @param id_director the id_director to set
     */
    private void setId_director(int id_director) {
        this.id_director = id_director;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        if(nombre.length()<=45){
            this.nombre = nombre;
        }
        
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        if(apellido.length()<=45){
        this.apellido = apellido;    
        }
        
    }

    /**
     * @return the nacimiento
     */
    public Date getNacimiento() {
        return nacimiento;
    }

    /**
     * @param nacimiento the nacimiento to set
     */
    public void setNacimiento(String nacimiento) {
        SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
        try{
            this.nacimiento = formato.parse(nacimiento);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
       
    }

    /**
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public void setNacionalidad(String nacionalidad) {
        if(nacionalidad.length()<=45){
             this.nacionalidad = nacionalidad;
        }
       
    }
    conexion cn=new conexion();
    public void Agregar() throws Exception{

         try {
            cn.conectar();
            cn.UID("INSERT into director(nombre,apellido,nacimiento,nacionalidad) values(\""+getNombre()+"\",\""+getApellido()+"\",\""+getNacimiento()+"\",\""+getNacionalidad()+"\");");
            
            cn.desconectar();   
         } catch (Exception e) {
             System.out.println("Error: "+e.getMessage());
             
         }finally{
         cn.desconectar();
         } 
         
     
     }
    public void Modificar() throws Exception{
         try {
         cn.conectar();
         cn.UID("UPDATE director set nombre=\""+getNombre()+"\", apellido=\""+getApellido()+"\" ,nacimiento=\""+getNacimiento()+"\" ,nacionalidad=\""+getNacionalidad()+"\" where id_director="+getId_director()+"; ");
         cn.desconectar();   
         } catch (Exception e) {
             System.out.println("Error: "+e.getMessage());
             
         }finally{
         cn.desconectar();
         }
     }
     
     
     public void Eliminar() throws  Exception{
         try {
         cn.conectar();
         cn.UID("DELETE FROM director WHERE id_director='" +getId_director() + "'");
         cn.desconectar();   
         } catch (Exception e) {
             System.out.println("Error: "+e.getMessage());
         }finally{
         cn.desconectar();
         }
     }
     
     
     public ResultSet BuscarDirector(int id_director) throws Exception{
         ResultSet d=null;
         try {
         cn.conectar();
         d=cn.getValores("SELECT id_director,nombre,apellido,nacimiento,nacionalidad FROM director WHERE id_director='"+getId_director()+"'");    
         } catch (Exception e) {
             System.out.println("Error: "+e.getMessage());
         }finally{
         cn.desconectar();
         }
         return d;
     }
     
     public ResultSet Obtener() throws Exception{
     ResultSet d=null;
         try {
         cn.conectar();
         d=cn.getValores("select id_director,nombre,apellido,nacimiento,nacionalidad from director;");    
         } catch (Exception e) {
             cn.desconectar();
             System.out.println("Error: "+e.getMessage());  
         }finally{
         
         }
         return d;
     }
     
}
