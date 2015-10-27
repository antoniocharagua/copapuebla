package com.ficufi.copapuebla.interfaz.dialogos;

import com.ficufi.copapuebla.back.service.CategoriaService;
import com.ficufi.copapuebla.back.service.dto.CategoriaDto;
import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author antonio
 */
@Component
public class CategoriaDialogo extends javax.swing.JPanel {


    @Autowired
    private Frame propietario;
    
    @Autowired
    private CategoriaService categoriaService;
    
    private JDialog dialogo;
    
    public void muestraDialogo(ModoEnum modoEnum, CategoriaDto categoriaDto) {
        if (dialogo == null || dialogo.getOwner() != propietario) {            
            dialogo = new JDialog(propietario, true);
            dialogo.add(this);
            dialogo.setTitle("Nuevo Categoria");
            dialogo.getRootPane().setDefaultButton(botonCerrar);
            dialogo.pack();
            dialogo.setResizable(false);
            dialogo.setLocationRelativeTo(propietario);
            }
        switch (modoEnum) {
            case CREAR:
                dialogo.setTitle("Nueva Categoria");
                botonCrear.setText("Crear");
                break;
            case ACTUALIZAR:
                campoTextoCategoria.setText(categoriaDto.getClave());
                textDescripcion.setText(categoriaDto.getDescripcion() == null ? "" : categoriaDto.getDescripcion());
                dialogo.setTitle("Actualizar Categoria");
                botonCrear.setText("Actualizar");
                break;
        }
        dialogo.setVisible(true);
    }
    
    /**
     * Creates new form NuevaCategoriaDialogo
     */
    public CategoriaDialogo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelBotones = new javax.swing.JPanel();
        botonCrear = new javax.swing.JButton();
        botonCerrar = new javax.swing.JButton();
        panelCentral = new javax.swing.JPanel();
        etiquetaNuevaCategoria = new javax.swing.JLabel();
        campoTextoCategoria = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        textDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTextoDescripcion = new javax.swing.JTextArea();

        setLayout(new java.awt.BorderLayout());

        panelBotones.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 1, 4));
        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        botonCrear.setText("Crear");
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });
        panelBotones.add(botonCrear);

        botonCerrar.setText("Cerrar");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });
        panelBotones.add(botonCerrar);

        add(panelBotones, java.awt.BorderLayout.PAGE_END);

        panelCentral.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        panelCentral.setLayout(new java.awt.GridBagLayout());

        etiquetaNuevaCategoria.setText("Nueva Categoría:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 4, 13);
        panelCentral.add(etiquetaNuevaCategoria, gridBagConstraints);

        campoTextoCategoria.setMinimumSize(new java.awt.Dimension(250, 20));
        campoTextoCategoria.setPreferredSize(new java.awt.Dimension(250, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 14, 7, 4);
        panelCentral.add(campoTextoCategoria, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        panelCentral.add(jSeparator1, gridBagConstraints);

        textDescripcion.setText("Descripción (opcional) :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        panelCentral.add(textDescripcion, gridBagConstraints);

        areaTextoDescripcion.setColumns(27);
        areaTextoDescripcion.setRows(5);
        areaTextoDescripcion.setWrapStyleWord(true);
        jScrollPane1.setViewportView(areaTextoDescripcion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 14, 4, 5);
        panelCentral.add(jScrollPane1, gridBagConstraints);

        add(panelCentral, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        String textArea = campoTextoCategoria.getText().trim();
        if (textArea.isEmpty()) {
            JOptionPane.showMessageDialog(dialogo, "No contiene Ningun nombre", "Error de escritura", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        if (textArea.length() < 3 || textArea.length() > 50) {
            JOptionPane.showMessageDialog(dialogo, "Número de caracteres invalidos\nDebe ser mayor a 3 y menor a 50", "Error de escritura", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        dialogo.setVisible(false);
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setClave(campoTextoCategoria.getText());
        if (!areaTextoDescripcion.getText().isEmpty()) {
            categoriaDto.setDescripcion(areaTextoDescripcion.getText());
        }        
        categoriaService.create(categoriaDto);
        campoTextoCategoria.setText("");
        areaTextoDescripcion.setText("");
    }//GEN-LAST:event_botonCrearActionPerformed

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        dialogo.setVisible(false);
        campoTextoCategoria.setText("");
        areaTextoDescripcion.setText("");
    }//GEN-LAST:event_botonCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTextoDescripcion;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonCrear;
    private javax.swing.JTextField campoTextoCategoria;
    private javax.swing.JLabel etiquetaNuevaCategoria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JLabel textDescripcion;
    // End of variables declaration//GEN-END:variables
}
