package com.ficufi.copapuebla.interfaz.menu;

import com.ficufi.copapuebla.interfaz.dialogos.JugadorDialogo;
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
public class JugadorMenu extends JMenu {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private JMenuItem jMenuItem;
    private final Acciones acciones;
    
    @Autowired
    private JugadorDialogo jugadorDialogo;

    public JugadorMenu() {
        super("Jugador");
        acciones = new Acciones();        
    }
    
    @PostConstruct
    public void crearMenus() {
        jMenuItem = new JMenuItem("Crear Jugador");
        jMenuItem.addActionListener(acciones);
        add(jMenuItem);
        jMenuItem = new JMenuItem("Muestra Jugador");
        jMenuItem.addActionListener(acciones);
        add(jMenuItem);
    }
    
    private class Acciones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Crear Jugador":
                    jugadorDialogo.muestraDialogo();
                    break;
                default:
                    throw new AssertionError();
            }
        }
        
    }
}
