package com.ficufi.copapuebla.interfaz;

import com.ficufi.copapuebla.back.service.dto.TorneoDto;
import com.ficufi.copapuebla.interfaz.popup.TorneoPopUp;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.annotation.PostConstruct;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
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

    private Logger log = LoggerFactory.getLogger(getClass());
    private JTree arbol;
    private TreeModel treeModel;
    private TreeNode nodo;
    private JScrollPane jScrollPane;
    
    @Autowired
    private TorneoPopUp arbolPopUp;
    
    @PostConstruct
    public void init () {
        nodo = new DefaultMutableTreeNode();
        treeModel = new DefaultTreeModel(nodo);
        arbol = new JTree(treeModel);
        arbol.addMouseListener(new PopUpListener());
        arbol.setCellRenderer(new TorneoCellRenderer());
        setLayout(new BorderLayout());
        add(jScrollPane = new JScrollPane(arbol));
        jScrollPane.setMinimumSize(new Dimension(100, 50));
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
                    Object object = ((DefaultMutableTreeNode)selectedPath.getLastPathComponent()).getUserObject();
                    TorneoDto torneoDto = (TorneoDto)object;
                    log.debug("torneo seleccionado:{}", torneoDto);
                    //arbolPopUp.show(e.getComponent(), e.getX(), e.getY());
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
    
    private class TorneoCellRenderer extends JLabel implements TreeCellRenderer {
        
        DefaultTreeCellRenderer defaultTreeCellRenderer;

        public TorneoCellRenderer() {
            defaultTreeCellRenderer = new DefaultTreeCellRenderer();
        }
        
        @Override
        public java.awt.Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            if (selected) {
                setBackground(defaultTreeCellRenderer.getBackgroundSelectionColor());
            } else {
                setBackground(defaultTreeCellRenderer.getBackgroundNonSelectionColor());
            }
            if (value != null && value instanceof DefaultMutableTreeNode) {
                Object object = ((DefaultMutableTreeNode)value).getUserObject();
                if (object != null) {
                    TorneoDto torneoDto = (TorneoDto)object;
                    setText(torneoDto.getNombre());
                } else {
                    setText("Sin Torneo");
                }
            } 
            return this;
        }
        
    }
}
