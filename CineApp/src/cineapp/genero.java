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
public class genero {
    private int id_genero;
    private String nombre;

    /**
     * @return the id_genero
     */
    public int getId_genero() {
        return id_genero;
    }

    /**
     * @param id_genero the id_genero to set
     */
    private void setId_genero(int id_genero) {
        this.id_genero = id_genero;
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
    conexion cn=new conexion();
    public void Agregar() throws Exception{

         try {
            cn.conectar();
            cn.UID("INSERT into genero(nombre) values(\""+getNombre()+"\");");
            
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
         cn.UID("UPDATE genero set nombre=\""+getNombre()+"; ");
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
         cn.UID("DELETE FROM genero WHERE id_genero='" +getId_genero()+ "'");
         cn.desconectar();   
         } catch (Exception e) {
             System.out.println("Error: "+e.getMessage());
         }finally{
         cn.desconectar();
         }
     }
     
     
     public ResultSet BuscarGenero(int id_genero) throws Exception{
         ResultSet d=null;
         try {
         cn.conectar();
         d=cn.getValores("SELECT id_genero,nombre FROM genero WHERE id_genero='"+getId_genero()+"'");    
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
         d=cn.getValores("select id_genero,nombre from genero;");    
         } catch (Exception e) {
             cn.desconectar();
             System.out.println("Error: "+e.getMessage());  
         }finally{
         
         }
         return d;
     }
}
