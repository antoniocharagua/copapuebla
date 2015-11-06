/*
 * Copyright (C) 2015 Antonio Francisco Alonso Valerdi
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ficufi.copapuebla.interfaz.dialogos;

import com.ficufi.copapuebla.back.service.EquipoService;
import com.ficufi.copapuebla.back.service.dto.EquipoDto;
import com.ficufi.copapuebla.back.service.dto.TorneoDto;
import com.ficufi.copapuebla.interfaz.Principal;
import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.PostConstruct;
import javax.swing.AbstractListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *
 * @author Antonio Francisco Alonso Valerdi
 */
@Component
@Lazy
public class JugadorEquipoDialogo extends javax.swing.JPanel {
    
    private final Logger log = LoggerFactory.getLogger(getClass());
    private TorneoDto torneoDto;
    private JDialog dialogo;
    private Principal propietario;
    private ModeloListaEquipo modeloListaEquipo;
    
    @Autowired
    private EquipoService equipoService;

    /**
     * Creates new form JuadorEquipoDialogo
     */
    public JugadorEquipoDialogo() {
        modeloListaEquipo = new ModeloListaEquipo();
        initComponents();        
    }
    
    @PostConstruct
    public void init() {
        listaEquipo.setCellRenderer(new RenderListaEquipo());        
        URL resource = getClass().getResource("/mensajes/relaciona_equipo.html");
        try {
            panelEditorPasos.setPage(resource);
        } catch (IOException ex) {
            log.error("No se pudo cargar la vista:{}", "/mensajes/relaciona_equipo.html");
        }
    }
    
    public void muestraDialogo() {        
        if (dialogo == null || dialogo.getOwner() != propietario) {            
            dialogo = new JDialog(propietario, true);
            dialogo.add(this);
            dialogo.setTitle("Nuevo Torneo");
            dialogo.getRootPane().setDefaultButton(botonCancelar);
            dialogo.setPreferredSize(new Dimension(600, 500));
            dialogo.pack();
            dialogo.setLocationRelativeTo(propietario);
            llenaListaEquipo();
            }
        dialogo.setVisible(true);
    }
    
    private void llenaListaEquipo() {
        campoTextoTorneo.setText(torneoDto.getNombre());
        for (EquipoDto equipoDto : equipoService.enuentra(null)) {
            modeloListaEquipo.add(equipoDto);
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
        java.awt.GridBagConstraints gridBagConstraints;

        panelCentral = new javax.swing.JPanel();
        panelAgredaEquipo = new javax.swing.JPanel();
        etiquetaTorneo = new javax.swing.JLabel();
        campoTextoTorneo = new javax.swing.JTextField();
        etiquetaEquipo = new javax.swing.JLabel();
        scrollPaneListaEquipo = new javax.swing.JScrollPane();
        listaEquipo = new javax.swing.JList();
        panelAgregarJugador = new javax.swing.JPanel();
        etiquetaSeleccionarJugador = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        panelBotonesSeleccion = new javax.swing.JPanel();
        botonDescartar = new javax.swing.JButton();
        botonAgregar = new javax.swing.JButton();
        panelBotones = new javax.swing.JPanel();
        botonAtras = new javax.swing.JButton();
        botonSiguiente = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        botonAyuda = new javax.swing.JButton();
        panelPasos = new javax.swing.JPanel();
        panelEditorScroll = new javax.swing.JScrollPane();
        panelEditorPasos = new javax.swing.JEditorPane();

        setLayout(new java.awt.BorderLayout());

        panelCentral.setPreferredSize(new java.awt.Dimension(420, 320));
        panelCentral.setLayout(new java.awt.CardLayout());

        panelAgredaEquipo.setLayout(new java.awt.GridBagLayout());

        etiquetaTorneo.setText("Torneo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        panelAgredaEquipo.add(etiquetaTorneo, gridBagConstraints);

        campoTextoTorneo.setEditable(false);
        campoTextoTorneo.setColumns(30);
        campoTextoTorneo.setToolTipText("Torneo al cual se le agregará el equipo");
        campoTextoTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoTorneoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 330;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 24, 0, 0);
        panelAgredaEquipo.add(campoTextoTorneo, gridBagConstraints);

        etiquetaEquipo.setText("Equipo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        panelAgredaEquipo.add(etiquetaEquipo, gridBagConstraints);

        listaEquipo.setModel(modeloListaEquipo);
        listaEquipo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaEquipo.setToolTipText("Seleccione un equipo al cual agregar al torneo");
        listaEquipo.setPreferredSize(new java.awt.Dimension(200, 100));
        scrollPaneListaEquipo.setViewportView(listaEquipo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 450;
        gridBagConstraints.ipady = 151;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 24, 20, 12);
        panelAgredaEquipo.add(scrollPaneListaEquipo, gridBagConstraints);

        panelCentral.add(panelAgredaEquipo, "cardEquipo");

        panelAgregarJugador.setLayout(new java.awt.GridBagLayout());

        etiquetaSeleccionarJugador.setText("Seleccionar Jugador:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 4, 0);
        panelAgregarJugador.add(etiquetaSeleccionarJugador, gridBagConstraints);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.1;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 4);
        panelAgregarJugador.add(jScrollPane2, gridBagConstraints);

        jLabel2.setText("Juadores Seleccionados:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        panelAgregarJugador.add(jLabel2, gridBagConstraints);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 8, 4);
        panelAgregarJugador.add(jScrollPane4, gridBagConstraints);

        panelBotonesSeleccion.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        botonDescartar.setText("Descartar");
        botonDescartar.setEnabled(false);
        panelBotonesSeleccion.add(botonDescartar);

        botonAgregar.setText("Agregar");
        panelBotonesSeleccion.add(botonAgregar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelAgregarJugador.add(panelBotonesSeleccion, gridBagConstraints);

        panelCentral.add(panelAgregarJugador, "card3");

        add(panelCentral, java.awt.BorderLayout.CENTER);

        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 7, 7));

        botonAtras.setText("Atras");
        botonAtras.setEnabled(false);
        panelBotones.add(botonAtras);

        botonSiguiente.setText("Siguiente");
        panelBotones.add(botonSiguiente);

        botonAceptar.setText("Aceptar");
        botonAceptar.setEnabled(false);
        panelBotones.add(botonAceptar);

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        panelBotones.add(botonCancelar);

        botonAyuda.setText("Ayuda");
        panelBotones.add(botonAyuda);

        add(panelBotones, java.awt.BorderLayout.PAGE_END);

        panelPasos.setLayout(new java.awt.BorderLayout());

        panelEditorPasos.setEditable(false);
        panelEditorScroll.setViewportView(panelEditorPasos);

        panelPasos.add(panelEditorScroll, java.awt.BorderLayout.CENTER);

        add(panelPasos, java.awt.BorderLayout.LINE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dialogo.setVisible(false);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void campoTextoTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoTorneoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoTorneoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonAyuda;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonDescartar;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JTextField campoTextoTorneo;
    private javax.swing.JLabel etiquetaEquipo;
    private javax.swing.JLabel etiquetaSeleccionarJugador;
    private javax.swing.JLabel etiquetaTorneo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JList listaEquipo;
    private javax.swing.JPanel panelAgredaEquipo;
    private javax.swing.JPanel panelAgregarJugador;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelBotonesSeleccion;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JEditorPane panelEditorPasos;
    private javax.swing.JScrollPane panelEditorScroll;
    private javax.swing.JPanel panelPasos;
    private javax.swing.JScrollPane scrollPaneListaEquipo;
    // End of variables declaration//GEN-END:variables

    private class RenderListaEquipo extends JLabel implements ListCellRenderer<EquipoDto> {

        public RenderListaEquipo() {
            setOpaque(true);
        }

        @Override
        public java.awt.Component getListCellRendererComponent(JList<? extends EquipoDto> list, EquipoDto value, int index, boolean isSelected, boolean cellHasFocus) {
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            setText(value.getNombre());
            return this;
        }
        
    }

    private class ModeloListaEquipo extends AbstractListModel<EquipoDto> {
        
        private final Set<EquipoDto> equipos;

        public ModeloListaEquipo() {
            equipos = new TreeSet<>();
        }

        @Override
        public int getSize() {
            return equipos.size();
        }

        @Override
        public EquipoDto getElementAt(int index) {
            List<EquipoDto> list = new LinkedList<>(equipos);
            return list.get(index);
        }
        
        public void add (EquipoDto equipoDto) {
            equipos.add(equipoDto);
        }
    }

    public void setTorneoDto(TorneoDto torneoDto) {
        this.torneoDto = torneoDto;
    }
       
}
