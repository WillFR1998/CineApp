/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineapp;

import com.sun.istack.internal.logging.Logger;
import java.sql.ResultSet;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

/**
 *
 * @author Will Figueroa
 */
public class Cine_App extends javax.swing.JFrame {

    ResultSet rstControladorEstudiante = null;
    peliculas est = new peliculas();

    JTableHeader tHeadPeliculas;
    JTableHeader tHeadGenero;
    JTableHeader tHeadDirector;
    
    DefaultTableModel modeloPeliculas = new DefaultTableModel();
    DefaultTableModel modeloGenero = new DefaultTableModel();
    DefaultTableModel modeloDirector=new DefaultTableModel();

    public Cine_App() throws Exception {
        initComponents();
        tHeadPeliculas = tbnMuestraPeliculas.getTableHeader();
        modeloPeliculas.addColumn("ID Pelicula");
        modeloPeliculas.addColumn("Nombre");

        modeloPeliculas.addColumn("Año de Filmación");
        modeloPeliculas.addColumn("Estreno");
        modeloPeliculas.addColumn("Presupuesto");
        tbnMuestraPeliculas.setModel(modeloPeliculas);

        tHeadGenero = tbnMuestraGenero.getTableHeader();
        modeloGenero.addColumn("ID Género");
        modeloGenero.addColumn("Nombre del Género");
        tbnMuestraGenero.setModel(modeloGenero);
        
        tHeadDirector=tbnMuestraDirector.getTableHeader();
        modeloDirector.addColumn("ID Director");
        modeloDirector.addColumn("Nombre");
        modeloDirector.addColumn("Apellido");
        modeloDirector.addColumn("Nacimiento");
        modeloDirector.addColumn("Nacionalidad");
        tbnMuestraDirector.setModel(modeloDirector);

    }

    public final void llenarTabla() throws Exception {
        peliculas es = new peliculas();
        limpiarTabla();
        ResultSet rs = null;
        rs = es.Obtener();
        if (!rs.isBeforeFirst()) {
            System.out.println("No existe");
        } else {
            try {
                while (rs.next()) {
                    int id_pelicula = rs.getInt("id_peliculas");
                    String Nombre = rs.getString("nombre");
                    String Anyo_Filmacion = rs.getString("anyo_filmacion");
                    String estreno = rs.getString("estreno");
                    double presupuesto = rs.getDouble("presupuesto");
                    modeloPeliculas.addRow(new String[]{Integer.toString(id_pelicula), Nombre, Anyo_Filmacion, estreno, Double.toString(presupuesto)});

                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            tbnMuestraPeliculas.setModel(modeloPeliculas);
        }
    }

    public final void llenarTablaGenero() throws Exception {
        genero gen = new genero();
        limpiarTabla2();
        ResultSet rs = null;
        rs = gen.Obtener();
        if (!rs.isBeforeFirst()) {
            System.out.println("No existe");
        } else {
            try {
                while (rs.next()) {
                    int id_genero = rs.getInt("id_genero");
                    String Nombre = rs.getString("nombre");

                    modeloGenero.addRow(new String[]{Integer.toString(id_genero), Nombre});

                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            tbnMuestraGenero.setModel(modeloGenero);
        }
    }
    public final void llenarTablaDirector() throws Exception {
        director es = new director();
        limpiarTabla3();
        ResultSet rs = null;
        rs = es.Obtener();
        if (!rs.isBeforeFirst()) {
            System.out.println("No existe");
        } else {
            try {
                while (rs.next()) {
                    int id_director = rs.getInt("id_director");
                    String Nombre = rs.getString("nombre");
                    String Apellido = rs.getString("apellido");
                    String Nacimiento = rs.getString("nacimiento");
                     String Nacionalidad = rs.getString("nacionalidad");
                   
                    modeloDirector.addRow(new String[]{Integer.toString(id_director), Nombre, Apellido, Nacimiento, Nacionalidad});

                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            tbnMuestraDirector.setModel(modeloDirector);
        }
    }

    public void limpiarTabla() {
        for (int i = 0; i < tbnMuestraPeliculas.getRowCount(); i++) {
            modeloPeliculas.removeRow(i);
            i -= 1;
        }
    }

    public void limpiarTabla2() {
        for (int a = 0; a < tbnMuestraGenero.getRowCount(); a++) {
            modeloGenero.removeRow(a);
            a -= 1;
        }
    }
     public void limpiarTabla3() {
        for (int b = 0; b < tbnMuestraDirector.getRowCount(); b++) {
            modeloDirector.removeRow(b);
            b -= 1;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFilmacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEstreno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPresupuesto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbnMuestraPeliculas = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNombreGenero = new javax.swing.JTextField();
        btnAgregar2 = new javax.swing.JButton();
        btnEliminar2 = new javax.swing.JButton();
        btnModificar2 = new javax.swing.JButton();
        btnBuscar2 = new javax.swing.JButton();
        btnMostrar2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbnMuestraGenero = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtDirector = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNombreDirector = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtApellidoDirector = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNacimiento = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtNacionalidad = new javax.swing.JTextField();
        btnAgregar3 = new javax.swing.JButton();
        btnEliminar3 = new javax.swing.JButton();
        btnModificar3 = new javax.swing.JButton();
        btnBuscar3 = new javax.swing.JButton();
        btnMostrar3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbnMuestraDirector = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Registro de Peliculas");

        jLabel2.setText("ID: ");

        jLabel3.setText("Nombre: ");

        jLabel4.setText("Año de Filmación: ");

        jLabel5.setText("Estreno: ");

        jLabel6.setText("Presupuesto: ");

        jLabel7.setText("$");

        tbnMuestraPeliculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbnMuestraPeliculas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbnMuestraPeliculasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbnMuestraPeliculas);

        btnAgregar.setText("Agregar");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        btnMostrar.setText("Mostrar");
        btnMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMostrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFilmacion)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtEstreno, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEliminar)
                                    .addComponent(btnBuscar))
                                .addGap(70, 70, 70))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnMostrar)
                                .addGap(113, 113, 113))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAgregar)
                                    .addComponent(btnEliminar))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnModificar)
                                    .addComponent(btnBuscar))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtFilmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtEstreno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnMostrar)
                        .addGap(43, 43, 43)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Peliculas", jPanel1);

        jLabel8.setText("ID Genero: ");

        jLabel9.setText("Nombre del Genero: ");

        btnAgregar2.setText("Agregar");
        btnAgregar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregar2MouseClicked(evt);
            }
        });

        btnEliminar2.setText("Eliminar");
        btnEliminar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminar2MouseClicked(evt);
            }
        });

        btnModificar2.setText("Modificar");
        btnModificar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificar2MouseClicked(evt);
            }
        });

        btnBuscar2.setText("Buscar");
        btnBuscar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscar2MouseClicked(evt);
            }
        });

        btnMostrar2.setText("Mostrar");
        btnMostrar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMostrar2MouseClicked(evt);
            }
        });

        tbnMuestraGenero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbnMuestraGenero);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMostrar2)
                .addGap(151, 151, 151))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnModificar2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel8)
                                        .addGap(32, 32, 32)
                                        .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNombreGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(155, 155, 155)
                                .addComponent(btnAgregar2)))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar2)
                            .addComponent(btnBuscar2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar2)
                            .addComponent(btnEliminar2))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar2)
                    .addComponent(btnBuscar2))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNombreGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(btnMostrar2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Generos", jPanel2);

        jLabel10.setText("ID de Director: ");

        jLabel11.setText("Nombre del Director : ");

        jLabel12.setText("Apellido del Director: ");

        jLabel13.setText("Nacimiento: ");

        jLabel14.setText("Nacionalidad: ");

        btnAgregar3.setText("Agregar");
        btnAgregar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregar3MouseClicked(evt);
            }
        });

        btnEliminar3.setText("Eliminar");

        btnModificar3.setText("Modificar");

        btnBuscar3.setText("Buscar");

        btnMostrar3.setText("Mostrar");
        btnMostrar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMostrar3MouseClicked(evt);
            }
        });

        tbnMuestraDirector.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tbnMuestraDirector);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreDirector)
                    .addComponent(txtApellidoDirector, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(txtNacimiento)
                    .addComponent(txtNacionalidad))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAgregar3)
                            .addComponent(btnModificar3))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar3)
                            .addComponent(btnBuscar3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMostrar3)
                        .addGap(137, 137, 137))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar3)
                    .addComponent(btnEliminar3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtNombreDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar3)
                    .addComponent(btnBuscar3))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtApellidoDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrar3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Directores", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        int id_peliculas = 0;
        String nombre = txtNombre.getText().toUpperCase();
        String anyo_filmacion = txtFilmacion.getText().toUpperCase();
        String estreno = txtEstreno.getText().toUpperCase();
        double presupuesto = Double.parseDouble(txtPresupuesto.getText().toUpperCase());

        peliculas ctp = new peliculas(id_peliculas, nombre, anyo_filmacion, estreno, presupuesto);
        try {
            ctp.Agregar();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNombre.setText("");
        txtFilmacion.setText("");
        txtEstreno.setText("");
        txtPresupuesto.setText("");
        JOptionPane.showMessageDialog(null, "Agregado con exito");
        try {
            llenarTabla();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "no logra agregar");
        }


    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        TableModel tablemodel1 = tbnMuestraPeliculas.getModel();
        peliculas ctp = new peliculas(Integer.parseInt(modeloPeliculas.getValueAt(tbnMuestraPeliculas.getSelectedRow(), 0).toString()));
        ctp.setAnyo_filmacion(txtFilmacion.getText());
        ctp.setEstreno(txtEstreno.getText());
        ctp.setNombre(txtNombre.getText());
        ctp.setPresupuesto(Integer.parseInt(txtPresupuesto.getText()));

        try {
            ctp.Modificar();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNombre.setText("");
        txtFilmacion.setText("");
        txtEstreno.setText("");
        txtPresupuesto.setText("");
        JOptionPane.showMessageDialog(null, "Modificado con exito");
        try {
            llenarTabla();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "no logra modificar");
        }


    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked

        TableModel tablemodel1 = tbnMuestraPeliculas.getModel();
        try {
            peliculas ctp = new peliculas(Integer.parseInt(modeloPeliculas.getValueAt(tbnMuestraPeliculas.getSelectedRow(), 0).toString()));
            System.out.println("lo hizo1");

            ResultSet rs;
            int decide = JOptionPane.showConfirmDialog(null, "Desea borrar la pelicula:");// +modeloEstudiante.getValueAt(tblMuestraMaterias.getSelectedRow(), 1));
            System.out.println("lo hizo2");
            if (decide == 0) {
                try {
                    ctp.Eliminar();
                    System.out.println("Elimino la pelicula");
                    limpiarTabla();
                    llenarTabla();
                } catch (Exception ex) {
                    java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("No pudo eliminar la pelicula");
                }

            }

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No pudo eliminar el estudiante parte 1");
        }


    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked

        int id_peliculas = Integer.parseInt(txtId.getText());
        peliculas ctp = new peliculas(id_peliculas);

        try {
            ctp.BuscarPelicula();
            JOptionPane.showMessageDialog(null, "Nombre de pelicula: " + ctp.getNombre());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnMostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarMouseClicked
        try {
            llenarTabla();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No logra llenar la tabla");
        }


    }//GEN-LAST:event_btnMostrarMouseClicked

    private void tbnMuestraPeliculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbnMuestraPeliculasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbnMuestraPeliculasMouseClicked

    private void btnMostrar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrar2MouseClicked
        try {
            llenarTablaGenero();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No logra llenar la tabla");
        }


    }//GEN-LAST:event_btnMostrar2MouseClicked

    private void btnAgregar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregar2MouseClicked
        int id_genero = 0;
        String nombre = txtNombreGenero.getText().toUpperCase();

        genero gn = new genero();
        gn.setNombre(nombre);
        try {
            gn.Agregar();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNombreGenero.setText("");
        txtId.setText("");

        JOptionPane.showMessageDialog(null, "Agregado con exito");
        try {
            llenarTablaGenero();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "no logra agregar");
        }
    }//GEN-LAST:event_btnAgregar2MouseClicked

    private void btnEliminar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminar2MouseClicked
        TableModel tablemodel1 = tbnMuestraPeliculas.getModel();
        try {
            genero ctp = new genero(Integer.parseInt(modeloGenero.getValueAt(tbnMuestraGenero.getSelectedRow(), 0).toString()));
            System.out.println("lo hizo1");

            ResultSet rs;
            int decide = JOptionPane.showConfirmDialog(null, "Desea borrar la pelicula:");// +modeloEstudiante.getValueAt(tblMuestraMaterias.getSelectedRow(), 1));
            System.out.println("lo hizo2");
            if (decide == 0) {
                try {
                    ctp.EliminarGenero();
                    System.out.println("Elimino la pelicula");
                    limpiarTabla();
                    llenarTabla();
                } catch (Exception ex) {
                    java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("No pudo eliminar la pelicula");
                }

            }

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No pudo eliminar el estudiante parte 1");
        }
    }//GEN-LAST:event_btnEliminar2MouseClicked

    private void btnBuscar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscar2MouseClicked
        int id_genero = Integer.parseInt(txtGenero.getText());
        genero ctp = new genero(id_genero);

        try {
            ctp.BuscarGenero();
            JOptionPane.showMessageDialog(null, "Nombre de pelicula: " + ctp.getNombre());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }


    }//GEN-LAST:event_btnBuscar2MouseClicked

    private void btnModificar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificar2MouseClicked
        TableModel tablemodel2 = tbnMuestraGenero.getModel();
        genero ctp = new genero(Integer.parseInt(modeloGenero.getValueAt(tbnMuestraGenero.getSelectedRow(), 0).toString()));
        ctp.setNombre(txtNombreGenero.getText());
        try {
            ctp.ModificarGenero();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtGenero.setText("");
        txtNombreGenero.setText("");

        JOptionPane.showMessageDialog(null, "Modificado con exito");
        try {
            llenarTablaGenero();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "no logra modificar");
        }
    }//GEN-LAST:event_btnModificar2MouseClicked

    private void btnMostrar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrar3MouseClicked
        try {
            llenarTablaDirector();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No logra llenar la tabla");
        }
    }//GEN-LAST:event_btnMostrar3MouseClicked

    private void btnAgregar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregar3MouseClicked
         int id_director = 0;
        String nombre = txtNombreDirector.getText().toUpperCase();
        String apellido=txtApellidoDirector.getText().toUpperCase();
        String nacimiento=txtNacimiento.getText().toUpperCase();
        String nacionalidad=txtNacionalidad.getText().toUpperCase();

        director dr = new director();
        dr.setNombre(nombre);
        try {
            dr.AgregarDirector();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNombreDirector.setText("");
        txtApellidoDirector.setText("");
        txtDirector.setText("");
        txtNacimiento.setText("");
        txtNacionalidad.setText("");

        JOptionPane.showMessageDialog(null, "Agregado con exito");
        try {
            llenarTablaDirector();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "no logra agregar");
        }
    }//GEN-LAST:event_btnAgregar3MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Cine_App().setVisible(true);
                } catch (Exception ex) {
                    java.util.logging.Logger.getLogger(Cine_App.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnAgregar3;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar2;
    private javax.swing.JButton btnBuscar3;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar2;
    private javax.swing.JButton btnEliminar3;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificar2;
    private javax.swing.JButton btnModificar3;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnMostrar2;
    private javax.swing.JButton btnMostrar3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbnMuestraDirector;
    private javax.swing.JTable tbnMuestraGenero;
    private javax.swing.JTable tbnMuestraPeliculas;
    private javax.swing.JTextField txtApellidoDirector;
    private javax.swing.JTextField txtDirector;
    private javax.swing.JTextField txtEstreno;
    private javax.swing.JTextField txtFilmacion;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNacimiento;
    private javax.swing.JTextField txtNacionalidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreDirector;
    private javax.swing.JTextField txtNombreGenero;
    private javax.swing.JTextField txtPresupuesto;
    // End of variables declaration//GEN-END:variables
}
