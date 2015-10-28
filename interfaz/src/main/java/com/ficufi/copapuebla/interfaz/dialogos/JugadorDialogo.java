package com.ficufi.copapuebla.interfaz.dialogos;

import com.ficufi.copapuebla.back.service.GeneroService;
import com.ficufi.copapuebla.back.service.JugadorService;
import com.ficufi.copapuebla.back.service.dto.GeneroDto;
import com.ficufi.copapuebla.back.service.dto.JugadorDto;
import com.ficufi.copapuebla.interfaz.Principal;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author antonio
 */
@Component
public class JugadorDialogo extends javax.swing.JPanel {
    
    private JDialog dialogo;
    
    @Autowired
    private Principal propietario;
    
    @Autowired
    private JugadorService jugadorService;
    
    @Autowired
    private GeneroService generoService;

    /**
     * Creates new form JugadorDialogo
     */
    public JugadorDialogo() {
        initComponents();        
    }
    
    public void muestraDialogo() {
        if (dialogo == null || dialogo.getOwner() != propietario) {            
            dialogo = new JDialog(propietario, true);
            dialogo.add(this);
            dialogo.setTitle("Nuevo Categoria");
            dialogo.getRootPane().setDefaultButton(botonCerrar);
            dialogo.pack();
            dialogo.setResizable(false);
            dialogo.setLocationRelativeTo(propietario);
            llenaCombo();
            }
        dialogo.setVisible(true);
    }
    
    public void llenaCombo() {
        for (GeneroDto generoDto : generoService.encuentra(true)) {
            comboGenero.addItem(generoDto);
        }
        comboGenero.setRenderer(new ComboBoxRenderer());
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
        etiquetaNombre = new javax.swing.JLabel();
        campoTextoNombre = new javax.swing.JTextField();
        etiquetaApellido = new javax.swing.JLabel();
        campoTextoAP = new javax.swing.JTextField();
        etiquetaApellidoM = new javax.swing.JLabel();
        campoTextoAM = new javax.swing.JTextField();
        etiquetaCurp = new javax.swing.JLabel();
        campoTextoCurp = new javax.swing.JTextField();
        etiquetaGenero = new javax.swing.JLabel();
        comboGenero = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();

        setLayout(new java.awt.BorderLayout());

        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 8, 8));

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

        panelCentral.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 1, 2));
        panelCentral.setLayout(new java.awt.GridBagLayout());

        etiquetaNombre.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panelCentral.add(etiquetaNombre, gridBagConstraints);

        campoTextoNombre.setColumns(15);
        campoTextoNombre.setPreferredSize(new java.awt.Dimension(169, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        panelCentral.add(campoTextoNombre, gridBagConstraints);

        etiquetaApellido.setText("Apellido Paterno:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panelCentral.add(etiquetaApellido, gridBagConstraints);

        campoTextoAP.setColumns(20);
        campoTextoAP.setPreferredSize(new java.awt.Dimension(224, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        panelCentral.add(campoTextoAP, gridBagConstraints);

        etiquetaApellidoM.setText("Apellido Materno:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panelCentral.add(etiquetaApellidoM, gridBagConstraints);

        campoTextoAM.setColumns(20);
        campoTextoAM.setPreferredSize(new java.awt.Dimension(224, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 7);
        panelCentral.add(campoTextoAM, gridBagConstraints);

        etiquetaCurp.setText("Curp:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panelCentral.add(etiquetaCurp, gridBagConstraints);

        campoTextoCurp.setColumns(15);
        campoTextoCurp.setPreferredSize(new java.awt.Dimension(169, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        panelCentral.add(campoTextoCurp, gridBagConstraints);

        etiquetaGenero.setText("Genero:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panelCentral.add(etiquetaGenero, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        panelCentral.add(comboGenero, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 2, 0, 2);
        panelCentral.add(jSeparator1, gridBagConstraints);

        add(panelCentral, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        dialogo.setVisible(false);
        campoTextoNombre.setText("");
        campoTextoAP.setText("");
        campoTextoAM.setText("");
        campoTextoCurp.setText("");
    }//GEN-LAST:event_botonCerrarActionPerformed

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        JugadorDto jugadorDto = new JugadorDto();
        String cadena = campoTextoNombre.getText().trim();
        if (cadena.length() <= 3 || cadena.length() >= 50) {
            JOptionPane.showMessageDialog(dialogo, "Número de caracteres invalidos\nNombre debe ser mayor a 3 y menor a 50", 
                "Error de escritura", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        jugadorDto.setNombre(cadena);
        cadena = campoTextoAP.getText().trim();
        if (cadena.length() <= 3 || cadena.length() >= 40) {
            JOptionPane.showMessageDialog(dialogo, "Número de caracteres invalidos\nApellido Paterno debe ser mayor a 3 y menor a 40", 
                "Error de escritura", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        jugadorDto.setApellidoPaterno(cadena);
        cadena = campoTextoAM.getText().trim();
        if (cadena.length() <= 3 || cadena.length() >= 40) {
            JOptionPane.showMessageDialog(dialogo, "Número de caracteres invalidos\nApellido Materno debe ser mayor a 3 y menor a 40", 
                "Error de escritura", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        jugadorDto.setApellidoMaterno(cadena);
        cadena = campoTextoCurp.getText().trim();
        if (cadena.length() != 18) {
            JOptionPane.showMessageDialog(dialogo, "Número de caracteres invalidos\nCURP debe ser exactamente de 18 caracteres", 
                "Error de escritura", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        jugadorDto.setCurp(cadena);
        GeneroDto generoDto = (GeneroDto)comboGenero.getSelectedItem();
        jugadorService.crear(jugadorDto, generoDto);
        dialogo.setVisible(false);
        campoTextoNombre.setText("");
        campoTextoAP.setText("");
        campoTextoAM.setText("");
        campoTextoCurp.setText("");
    }//GEN-LAST:event_botonCrearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonCrear;
    private javax.swing.JTextField campoTextoAM;
    private javax.swing.JTextField campoTextoAP;
    private javax.swing.JTextField campoTextoCurp;
    private javax.swing.JTextField campoTextoNombre;
    private javax.swing.JComboBox comboGenero;
    private javax.swing.JLabel etiquetaApellido;
    private javax.swing.JLabel etiquetaApellidoM;
    private javax.swing.JLabel etiquetaCurp;
    private javax.swing.JLabel etiquetaGenero;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCentral;
    // End of variables declaration//GEN-END:variables

    
    private class ComboBoxRenderer extends JLabel implements ListCellRenderer<GeneroDto> {

        public ComboBoxRenderer() {
            setOpaque(true);
            setHorizontalAlignment(RIGHT);
            setVerticalAlignment(CENTER);
        }
        
        @Override
        public java.awt.Component getListCellRendererComponent(JList<? extends GeneroDto> list, GeneroDto value, int index, boolean isSelected, boolean cellHasFocus) {
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            setText(value.getDescripcion());
            return this;
        }
        
    }
}
