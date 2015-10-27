package com.ficufi.copapuebla.interfaz.menu;

import com.ficufi.copapuebla.interfaz.Principal;
import com.ficufi.copapuebla.interfaz.VisorEstatusEnum;
import com.ficufi.copapuebla.interfaz.dialogos.EquipoDialogo;
import com.ficufi.copapuebla.interfaz.tabla.EquipoTabla;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.annotation.PostConstruct;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Antonio Francisco Alonso Valerdi
 */
@Component
public class MenuEquipo extends JMenu implements ActionListener{
    
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private JMenuItem jMenuItem;
    
    @Autowired
    private EquipoDialogo equipoDialogo;
    
    @Autowired
    private Principal principal;
    
    @Autowired
    private EquipoTabla equipoTabla;

    public MenuEquipo() {
        super("Equipo");
    }
    
    @PostConstruct
    public void crearMenus() {
        jMenuItem = new JMenuItem("Crear equipo");
        jMenuItem.addActionListener(this);
        add(jMenuItem);
        jMenuItem = new JMenuItem("Muestra equipo");
        jMenuItem.addActionListener(this);
        add(jMenuItem);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Crear equipo":
                equipoDialogo.muestraDialogo();
                break;
            case "Muestra equipo":
                if (principal.getVisorEstatusEnum() != VisorEstatusEnum.TABLA) {
                    principal.remplazaCentral();
                }
                principal.getjTabbedPane().setSelectedComponent(equipoTabla);
                break;
            default:
                logger.error("opcion aun no programada:{}", e.getActionCommand());
                throw new AssertionError();
        }
    }

}
