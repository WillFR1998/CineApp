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
    
  
    public genero(int id_genero){
        setId_genero(id_genero);
    }
    public genero(){
        
    }
    public genero(int id_genero,String nombre){
        setId_genero(id_genero);
        setNombre(nombre);
    }
    public genero(String nombre){
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        
    }
   

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
     
     
   
     public void ModificarGenero() throws Exception{
         try {
         cn.conectar();
         cn.UID("UPDATE genero set nombre=\""+getNombre()+"\" where id_genero="+getId_genero()+"; ");
         cn.desconectar();   
         } catch (Exception e) {
             System.out.println("Error: "+e.getMessage());
             
         }finally{
         cn.desconectar();
         }
     }
     
     
     public void EliminarGenero() throws  Exception{ 
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
     
     
     public void BuscarGenero() throws Exception{
         ResultSet d=null;
         try {
         cn.conectar();
         
         d=cn.getValores("SELECT id_genero,nombre FROM genero WHERE id_genero='"+getId_genero()+"'");  
          if (!d.isBeforeFirst()) {
            System.out.println("No existe");
        } else {
            try {
                while (d.next()) {
                    
                    this.setNombre(d.getString("nombre"));   
                    System.out.println("Nombre de Genero: "+this.getNombre());

                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            
        }
         } catch (Exception e) {
             System.out.println("Error: "+e.getMessage());
         }finally{
         cn.desconectar();
         }
         
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
