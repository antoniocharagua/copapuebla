package com.ficufi.copapuebla.interfaz;

import com.ficufi.copapuebla.back.service.dto.TorneoDto;
import com.ficufi.copapuebla.interfaz.popup.TorneoPopUp;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.prefs.Preferences;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Antonio Francisco Alonso Valerdi
 */
@Component
public class VisorArbol extends JPanel{

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final Preferences preferences = Preferences.userNodeForPackage(getClass());
    private JTree arbol;
    private TreeModel treeModel;
    private TreeNode nodo;
    private JScrollPane jScrollPane;
    
    @Autowired
    private TorneoPopUp torneoPopUp;
    
    @PostConstruct
    public void init () {
        String name = preferences.get("name", null);
        int id = preferences.getInt("id", 0);
        nodo = new DefaultMutableTreeNode((name != null && id != 0) ? new TorneoDto(id, name) : null);
        treeModel = new DefaultTreeModel(nodo);
        arbol = new JTree(treeModel);
        arbol.addMouseListener(new PopUpListener());
        arbol.setCellRenderer(new TorneoCellRenderer());
        setLayout(new BorderLayout());
        add(jScrollPane = new JScrollPane(arbol));
        jScrollPane.setMinimumSize(new Dimension(100, 50));
    }

    @PreDestroy
    public void destroy() {
        log.debug("salvado las preferencias de:{}", getClass());
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)treeModel.getRoot();
        TorneoDto torneoDto = (TorneoDto)node.getUserObject();
        if (torneoDto != null) {
            preferences.put("name", torneoDto.getNombre());
            preferences.putInt("id", torneoDto.getId());
        }
    }
    
    public TreeModel getTreeModel() {
        return treeModel;
    }

    private class PopUpListener implements MouseListener {        

        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            switch (e.getButton()) {
                case MouseEvent.BUTTON1:
                    
                    break;
                case MouseEvent.BUTTON2:
                    
                    break;
                case MouseEvent.BUTTON3:                    
                    TreePath selectedPath = arbol.getPathForLocation(e.getX(), e.getY());
                    if (selectedPath != null) {
                        Object object = ((DefaultMutableTreeNode)selectedPath.getLastPathComponent()).getUserObject();
                        TorneoDto torneoDto = (TorneoDto)object;
                        log.debug("torneo seleccionado:{}", torneoDto);
                        torneoPopUp.setTorneoDto(torneoDto);
                        torneoPopUp.show(e.getComponent(), e.getX(), e.getY());
                    }
                    break;
                default:
                    log.warn("click del mouse aun no programado:", e.getButton());
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
        
    }
    
    private class TorneoCellRenderer extends DefaultTreeCellRenderer {        
        
        @Override
        public java.awt.Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            super.getTreeCellRendererComponent(tree, getNombreTorneo(value), leaf, expanded, leaf, row, hasFocus);
            return this;
        }
        
        private String getNombreTorneo(Object object) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) object;
            TorneoDto torneoDto = (TorneoDto) node.getUserObject();
            return torneoDto == null ? "Sin torneo" : torneoDto.getNombre();
        }
    }
}
