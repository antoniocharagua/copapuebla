package com.ficufi.copapuebla.interfaz;

import com.ficufi.copapuebla.back.service.TorneoService;
import com.ficufi.copapuebla.back.service.dto.TorneoDto;
import com.ficufi.copapuebla.interfaz.dialogos.NuevoTorneoDialogo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.PostConstruct;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Antonio Francisco Alonso Valerdi
 */
@Component
public class MenuTorneo extends JMenu implements ActionListener{
        
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
            
        }
        switch (e.getActionCommand()) {
            case "Crear torneo" :
                nuevoTorneoDialogo.muestraDialogo();
                break;
            default:
                break;
        }
        
    }
    
    @PostConstruct
    public void crearMenus() {
        JMenuItem jMenuItem = new  JMenuItem("Crear torneo");
        jMenuItem.addActionListener(this);
        add(jMenuItem);
        submenu = new JMenu("Selección Torneo");
        for (TorneoDto torneoDto : torneoService.find()) {
            jMenuItem = new JMenuItem(torneoDto.getNombre());
            set.add(torneoDto.getNombre());
            jMenuItem.addActionListener(this);
            submenu.add(jMenuItem);
        }
        add(submenu);
    }
    
}
