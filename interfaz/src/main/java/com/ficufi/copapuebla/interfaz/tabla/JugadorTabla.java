package com.ficufi.copapuebla.interfaz.tabla;

import com.ficufi.copapuebla.back.service.JugadorService;
import com.ficufi.copapuebla.back.dto.JugadorDto;
import javax.annotation.PostConstruct;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *
 * @author antonio
 */
@Component
@Lazy
public class JugadorTabla extends javax.swing.JPanel {
    
    private TableModel tableModel;
    
    @Autowired
    private JugadorService jugadorService;

    /**
     * Creates new form JugadorTabla
     */
    public JugadorTabla() {
        initComponents();
    }
    
    @PostConstruct
    public void init() {
        tableModel = tablaJugador.getModel();
        llenaDatos();
    }
    
    public void llenaDatos() {
        ((DefaultTableModel)tableModel).setRowCount(0);
        for (JugadorDto jugadorDto : jugadorService.encuentra(null)) {
            ((DefaultTableModel)tableModel).addRow(new Object[]{jugadorDto.getId(), jugadorDto.getNombre(),
            jugadorDto.getApellidoPaterno(), jugadorDto.getApellidoMaterno(), jugadorDto.getCurp(),
            jugadorDto.getGenero()});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJugador = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        tablaJugador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido Paterno", "Apellido Materno", "CURP", "Genero"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaJugador);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaJugador;
    // End of variables declaration//GEN-END:variables
}
