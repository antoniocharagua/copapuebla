package com.ficufi.copapuebla.interfaz.menu;

import com.ficufi.copapuebla.back.service.TorneoService;
import com.ficufi.copapuebla.back.dto.TorneoDto;
import com.ficufi.copapuebla.interfaz.VisorArbol;
import com.ficufi.copapuebla.interfaz.dialogos.NuevoTorneoDialogo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.PostConstruct;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Antonio Francisco Alonso Valerdi
 */
@Component
public class MenuTorneo extends JMenu implements ActionListener {

    private JMenu submenu;
    private Set<String> set;

    @Autowired
    private VisorArbol visorArbol;

    @Autowired
    private TorneoService torneoService;

    @Autowired
    private NuevoTorneoDialogo nuevoTorneoDialogo;

    public MenuTorneo() {
        super("Torneo");
        set = new TreeSet<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (set.contains(e.getActionCommand())) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) visorArbol.getTreeModel().getRoot();
            node.setUserObject(torneoService.find(e.getActionCommand()));
            ((DefaultTreeModel) visorArbol.getTreeModel()).nodeChanged(node);
        } else {
            switch (e.getActionCommand()) {
                case "Crear torneo":
                    nuevoTorneoDialogo.muestraDialogo();
                    break;
                default:
                    break;
            }
        }
    }

    @PostConstruct
    public void crearMenus() {
        JMenuItem jMenuItem = new JMenuItem("Crear torneo");
        jMenuItem.addActionListener(this);
        add(jMenuItem);
        submenu = new JMenu("Selección Torneo");
        updateTorneo();
        add(submenu);
    }

    public void updateTorneo() {
        JMenuItem jMenuItem = null;
        set.clear();
        submenu.removeAll();
        List<TorneoDto> list = torneoService.find();
        if (list.isEmpty()) {
            jMenuItem = new JMenuItem("Sin Torneos");
            jMenuItem.setEnabled(false);
            submenu.add(jMenuItem);
        } else {
            for (TorneoDto torneoDto : list) {
                jMenuItem = new JMenuItem(torneoDto.getNombre());
                set.add(torneoDto.getNombre());
                jMenuItem.addActionListener(this);
                submenu.add(jMenuItem);
            }
        }
    }

}
