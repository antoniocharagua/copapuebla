package com.ficufi.copapuebla.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.annotation.PostConstruct;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import org.springframework.stereotype.Component;

/**
 *
 * @author Antonio Francisco Alonso Valerdi
 */
@Component
public class VisorArbol extends JPanel{

    JTree arbol;
    TreeModel treeModel;
    MutableTreeNode nodo;
    JScrollPane jScrollPane;    
    
    @PostConstruct
    public void init () {
        nodo = new DefaultMutableTreeNode("Sin torneo");
        treeModel = new DefaultTreeModel(nodo);
        arbol = new JTree(treeModel);
        setLayout(new BorderLayout());
        add(jScrollPane = new JScrollPane(arbol));
        jScrollPane.setMinimumSize(new Dimension(100, 50));
    }

    public JTree getArbol() {
        return arbol;
    }

}
