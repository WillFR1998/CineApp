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
public class peliculas {
    private int id_peliculas;
    private String nombre;
    private String anyo_filmacion;
    private String estreno;
    private double presupuesto;
    public peliculas(int id_peliculas){
        setId_peliculas(id_peliculas);
    }
    
    
    public peliculas(){
        
    }
    public peliculas(int id_peliculas,String nombre,String anyo_filmacion,String estreno, double presupuesto){
     setId_peliculas(id_peliculas);   
     setNombre(nombre);
     setAnyo_filmacion(anyo_filmacion);
     setEstreno(estreno);
     setPresupuesto(presupuesto);
    }
    /**
     * @return the id_peliculas
     */
    public int getId_peliculas() {
        return id_peliculas;
    }

    /**
     * @param id_peliculas the id_peliculas to set
     */
    private void setId_peliculas(int id_peliculas) {
        this.id_peliculas = id_peliculas;
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
     * @return the anyo_filmacion
     */
    public String getAnyo_filmacion() {
        return anyo_filmacion;
    }

    /**
     * @param anyo_filmacion the anyo_filmacion to set
     */
    public void setAnyo_filmacion(String anyo_filmacion) {
        if(anyo_filmacion.length()<=45){
             this.anyo_filmacion = anyo_filmacion;
        }
       
    }

    /**
     * @return the estreno
     */
    public String getEstreno() {
        return estreno;
    }

    /**
     * @param estreno the estreno to set
     */
    public void setEstreno(String estreno) {
        if(estreno.length()<=45){
            this.estreno = estreno;
        }
        
    }

    /**
     * @return the presupuesto
     */
    public double getPresupuesto() {
        return presupuesto;
    }

    /**
     * @param presupuesto the presupuesto to set
     */
    public void setPresupuesto(double presupuesto) {
      if(presupuesto>0){
          this.presupuesto = presupuesto;
      }
        
    }
    conexion cn=new conexion();
    public void Agregar() throws Exception{

         try {
            cn.conectar();
            cn.UID("INSERT into peliculas(nombre,anyo_filmacion,estreno,presupuesto) values(\""+getNombre()+"\",\""+getAnyo_filmacion()+"\",\""+getEstreno()+"\",\""+getPresupuesto()+"\");");
            
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
         cn.UID("UPDATE peliculas set nombre=\""+getNombre()+"\", anyo_filmacion=\""+getAnyo_filmacion()+"\" ,estreno=\""+getEstreno()+"\" ,presupuesto=\""+getPresupuesto()+"\" where id_peliculas="+getId_peliculas()+"; ");
         cn.desconectar();   
         } catch (Exception e) {
             System.out.println("Error: "+e.getMessage());
             
         }finally{
         cn.desconectar();
         }
     }
     
     
     public void Eliminar() throws  Exception{
         System.out.println(getId_peliculas());
         try {
         cn.conectar();
         cn.UID("DELETE FROM peliculas WHERE id_peliculas='"+getId_peliculas()+ "'");
         cn.desconectar();   
         } catch (Exception e) {
             System.out.println("Error: "+e.getMessage());
         }finally{
         cn.desconectar();
         }
     }
     public void BuscarPelicula() throws Exception{
         ResultSet d=null;
         try {
         cn.conectar();
         
         d=cn.getValores("SELECT id_peliculas,nombre,anyo_filmacion,estreno,presupuesto FROM peliculas WHERE id_peliculas='"+getId_peliculas()+"'");  
          if (!d.isBeforeFirst()) {
            System.out.println("No existe");
        } else {
            try {
                while (d.next()) {
                    
                    this.setNombre(d.getString("nombre")); 
                    this.setAnyo_filmacion(d.getString("anyo_filmacion"));
                    this.setEstreno(d.getString("estreno"));
                    this.setPresupuesto(d.getDouble("presupuesto"));
                    System.out.println("Nombre de pelicula: "+this.getNombre());

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
         d=cn.getValores("select id_peliculas,nombre,anyo_filmacion,estreno,presupuesto from peliculas;");    
         } catch (Exception e) {
             cn.desconectar();
             System.out.println("Error: "+e.getMessage());  
         }finally{
         
         }
         return d;
     }
     
}
