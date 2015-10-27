package com.ficufi.copapuebla.interfaz.tabla;

import com.ficufi.copapuebla.back.service.CategoriaService;
import com.ficufi.copapuebla.back.service.dto.CategoriaDto;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.prefs.Preferences;
import javax.annotation.PostConstruct;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
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
public class CategoriaTabla extends javax.swing.JPanel {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final Preferences preferences = Preferences.userNodeForPackage(getClass());
    private TableModel tableModel;
    
    @Autowired
    private CategoriaService categoriaService;
    
    /**
     * Creates new form CategoriaTabla
     */
    public CategoriaTabla() {
        initComponents();
    }
    
    @PostConstruct
    public void init() {
        tableModel = tablaCategoria.getModel();
        tableModel.addTableModelListener(new CambiosColumnas());
        tablaCategoria.removeColumn(tablaCategoria.getColumnModel().getColumn(2));
        tablaCategoria.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scrollTablacategoria.addComponentListener(new ListenerScroll());
        llenaTabla();
    }
    
    public void llenaTabla() {
        ((DefaultTableModel)tableModel).setRowCount(0);
        for (CategoriaDto categoriaDto : categoriaService.encuentra()) {
            Object[] row = new Object[]{categoriaDto.getClave(), categoriaDto.getDescripcion(), categoriaDto.getId()};
            ((DefaultTableModel)tableModel).addRow(row);
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

        scrollTablacategoria = new javax.swing.JScrollPane();
        tablaCategoria = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        tablaCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Categoría", "Descripción", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaCategoria.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollTablacategoria.setViewportView(tablaCategoria);

        add(scrollTablacategoria, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollTablacategoria;
    private javax.swing.JTable tablaCategoria;
    // End of variables declaration//GEN-END:variables

    private class ListenerScroll implements ComponentListener {

        @Override
        public void componentResized(ComponentEvent e) {
            int anchoTabla = e.getComponent().getWidth();
            TableColumn tableColumn = tablaCategoria.getColumnModel().getColumn(0);
            log.debug("ancho tabla: {} y aun tercio: {}", anchoTabla, anchoTabla/3);
            tableColumn.setPreferredWidth(anchoTabla / 3);
            tableColumn = tablaCategoria.getColumnModel().getColumn(1);
            tableColumn.setPreferredWidth(2 * (anchoTabla / 3));
        }

        @Override
        public void componentMoved(ComponentEvent e) {

        }

        @Override
        public void componentShown(ComponentEvent e) {

        }

        @Override
        public void componentHidden(ComponentEvent e) {

        }
        
    }
    
    private class CambiosColumnas implements TableModelListener {

        @Override
        public void tableChanged(TableModelEvent e) {
            int row = e.getFirstRow();
            int column = e.getColumn();
            if (row >= 0 && column >= 0) {
                log.debug("row:{} y column:{}", row, column);
                CategoriaDto categoriaDto = new CategoriaDto();
                categoriaDto.setClave((String)tableModel.getValueAt(row, 0));
                categoriaDto.setDescripcion((String)tableModel.getValueAt(row, 1));
                categoriaDto.setId((Integer)tableModel.getValueAt(row, 2));
                log.debug("categoria a actualizar:{}", categoriaDto);
                categoriaService.actualizar(categoriaDto);
            }            
        }
        
    }

}
