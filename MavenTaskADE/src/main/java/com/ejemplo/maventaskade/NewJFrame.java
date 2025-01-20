package com.ejemplo.maventaskade;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class NewJFrame extends javax.swing.JFrame {

    private List<Contenido> contenidos;
    private List<Contenido> listaFiltrada;

    public NewJFrame(List<Contenido> contenidos) {

        initComponents();
        this.setTitle("Plataforma de Streaming");
        Image img = new ImageIcon(this.getClass().getResource("/images/logo.jpg")).getImage();
        this.setIconImage(img);
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int row = jTable1.getSelectedRow();
                    if (row != -1) {
                        String titulo = jTable1.getValueAt(row, 0).toString();
                        String descripcion = jTable1.getValueAt(row, 1).toString();
                        String categoria = jTable1.getValueAt(row, 2).toString();
                        String creador = jTable1.getValueAt(row, 3).toString();
                        int añoPublicacion = Integer.parseInt(jTable1.getValueAt(row, 4).toString());
                        int clasificacionPEGI = Integer.parseInt(jTable1.getValueAt(row, 5).toString());

                        jTextField1.setText(titulo);
                        jTextField2.setText(descripcion);
                        jTextField3.setText(categoria);
                        jTextField4.setText(creador);
                        jTextField5.setText(String.valueOf(añoPublicacion));
                        jTextField6.setText(String.valueOf(clasificacionPEGI));
                    }
                }
            }
        });

        this.contenidos = contenidos;
        this.listaFiltrada = new ArrayList<>(contenidos);

        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (Contenido e : contenidos) {
            listModel.addElement(e.getTitulo() + "-" + e.getCategoria());
        }

        jTable1.setRowSelectionAllowed(true);
        jTable1.setColumnSelectionAllowed(false);

        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jTextField7.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarLista();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarLista();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarLista();
            }
        });

        for (Contenido e : contenidos) {
            listModel.addElement(e.getTitulo() + "-" + e.getCategoria());
        }
       
        cargarTablaCompleta();
       
        jTextField7.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {                
                filtrarLista();                
                filtrarTabla();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarLista();
                filtrarTabla();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarLista();
                filtrarTabla();
            }
        });

    }

    private void filtrarLista() {       
        String query = jTextField7.getText().toLowerCase();
      
        DefaultListModel<String> filteredModel = new DefaultListModel<>();
        
        for (Contenido c : contenidos) {            
            if (c.getTitulo().toLowerCase().contains(query)) {
                filteredModel.addElement(c.getTitulo() + " - " + c.getCategoria());
            }
        }
    }

    private void cargarTablaCompleta() {
       
        String[] columnas = {
            "Título",
            "Descripción",
            "Categoría",
            "Creador",
            "Año Publicación",
            "Clasificación PEGI"
        };
    
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        
        for (Contenido c : contenidos) {
            Object[] fila = {
                c.getTitulo(),
                c.getDescripcion(),
                c.getCategoria(),
                c.getCreador(),
                c.getAño_publicacion(),
                c.getClasificacion_edad()
            };
            modeloTabla.addRow(fila);
        }
      
        jTable1.setModel(modeloTabla);
    }

    private void filtrarTabla() {
        String query = jTextField7.getText().toLowerCase();
       
        listaFiltrada = new ArrayList<>();
        for (Contenido c : contenidos) {
            if (c.getTitulo().toLowerCase().contains(query)) {
                listaFiltrada.add(c);
            }
        }
       
        cargarTabla(listaFiltrada);
    }

    private void cargarTabla(List<Contenido> lista) {
        String[] columnas = {
            "Título",
            "Descripción",
            "Categoría",
            "Creador",
            "Año Publicación",
            "Clasificación PEGI"
        };

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Contenido c : lista) {
            Object[] fila = {
                c.getTitulo(),
                c.getDescripcion(),
                c.getCategoria(),
                c.getCreador(),
                c.getAño_publicacion(),
                c.getClasificacion_edad()
            };
            modelo.addRow(fila);
        }

        jTable1.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel1.setText("CONTENIDOS DE LA PLATAFORMA");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });

        jButton1.setText("Añadir contenido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Importar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Modificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setText("Exportar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel3.setText("BUSCADOR:");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel4.setText("DATOS");

        jLabel5.setText("Título:");

        jLabel6.setText("Creador:");

        jLabel7.setText("Descripción:");

        jLabel8.setText("Categoría:");

        jLabel9.setText("Año:");

        jLabel10.setText("Clasificación PEGI:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2)
                                .addComponent(jSeparator1)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                    .addGap(95, 95, 95)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(29, 29, 29)
                                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jTextField3)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel9))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel10)
                                                    .addGap(0, 0, Short.MAX_VALUE))
                                                .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)))))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jButton4)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(4, 4, 4)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String titulo = jTextField1.getText();
        String descripcion = jTextField2.getText();
        String categoria = jTextField3.getText();
        String creador = jTextField4.getText();
        int año_publicacion = Integer.parseInt(jTextField5.getText());
        int clasificacion_edad = Integer.parseInt(jTextField6.getText());

        Contenido nuevoContenido = new Contenido(titulo, descripcion, categoria, creador, año_publicacion, clasificacion_edad);
        contenidos.add(nuevoContenido);

        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        cargarTablaCompleta();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFileChooser selectFichero = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichero permitidos", "xml");
        selectFichero.setFileFilter(filter);
        selectFichero.setCurrentDirectory(new File("."));
        int result = selectFichero.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = selectFichero.getSelectedFile();
            String nombreFichero = selectedFile.getName();
            String[] formato = nombreFichero.split("\\.");
            if (formato[(formato.length - 1)].equals("xml")) {
                try {
                    JAXBContext context = JAXBContext.newInstance(ContenidoWrapper.class);

                    Unmarshaller unmarshaller = context.createUnmarshaller();

                    ContenidoWrapper contenidoWrapper = (ContenidoWrapper) unmarshaller.unmarshal(selectedFile);

                    List<Contenido> contenidosImportados = contenidoWrapper.getContenidos();
                    if (contenidosImportados == null) {
                        System.out.println("El archivo XML no contiene elementos válidos.");
                        return;
                    }

                    contenidos.addAll(contenidosImportados);

                    cargarTablaCompleta();

                    System.out.println("Contenidos importados correctamente desde el archivo " + nombreFichero);
                } catch (JAXBException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, "Error al importar el archivo XML.", ex);
                    System.out.println("Error al importar el archivo XML.");
                }
            } else {
                System.out.println("Formato de archivo no soportado. Solo se permiten archivos XML.");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int selectedIndex = jTable1.getSelectedRow();
        if (listaFiltrada.isEmpty()) {
            if (selectedIndex != -1) {

                try {
                    Contenido seleccionado = contenidos.get(selectedIndex);

                    seleccionado.setTitulo(jTextField1.getText());
                    seleccionado.setDescripcion(jTextField2.getText());
                    seleccionado.setCategoria(jTextField3.getText());
                    seleccionado.setCreador(jTextField4.getText());
                    seleccionado.setAño_publicacion(Integer.parseInt(jTextField5.getText()));
                    seleccionado.setClasificacion_edad(Integer.parseInt(jTextField6.getText()));

                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField4.setText("");
                    jTextField5.setText("");
                    jTextField6.setText("");
                    cargarTabla(contenidos);

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Por favor, introduce valores numéricos válidos.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un contenido para modificar.");
            }
        } else {
            if (selectedIndex != -1) {

                try {

                    Contenido seleccionado = listaFiltrada.get(selectedIndex);

                    seleccionado.setTitulo(jTextField1.getText());
                    seleccionado.setDescripcion(jTextField2.getText());
                    seleccionado.setCategoria(jTextField3.getText());
                    seleccionado.setCreador(jTextField4.getText());
                    seleccionado.setAño_publicacion(Integer.parseInt(jTextField5.getText()));
                    seleccionado.setClasificacion_edad(Integer.parseInt(jTextField6.getText()));

                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField4.setText("");
                    jTextField5.setText("");
                    jTextField6.setText("");
                    cargarTabla(listaFiltrada);

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Por favor, introduce valores numéricos válidos.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un contenido para modificar.");
            }
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int selectedIndex = jTable1.getSelectedRow();
        if (listaFiltrada.isEmpty()) {
            if (selectedIndex != -1) {
                Contenido seleccionado = contenidos.get(selectedIndex);

                contenidos.remove(seleccionado);

                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
                jTextField6.setText("");
                cargarTabla(contenidos);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un contenido para eliminar.");
            }
        } else {
            if (selectedIndex != -1) {
                Contenido seleccionado = listaFiltrada.get(selectedIndex);

                contenidos.remove(seleccionado);
                listaFiltrada.remove(seleccionado);

                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
                jTextField6.setText("");
                cargarTabla(listaFiltrada);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un contenido para eliminar.");
            }
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String nombreFichero = JOptionPane.showInputDialog("Nombre del fichero");

            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(ContenidoWrapper.class);

                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                ContenidoWrapper contenidoWrapper = new ContenidoWrapper(contenidos);

                File file = new File(nombreFichero + ".xml");

                marshaller.marshal(contenidoWrapper, file);

                System.out.println("Contenidos exportados correctamente a XML en " + file.getAbsolutePath());

            } catch (JAXBException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error al exportar a XML");
            }
        } catch (Exception ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, "Error durante la exportación", ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField6KeyTyped

    public static void main(String args[]) throws IOException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        List<Contenido> empleados = new ArrayList<>();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame(empleados).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
