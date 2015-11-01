package com.ficufi.copapuebla.interfaz.popup;

import com.ficufi.copapuebla.back.service.dto.TorneoDto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.annotation.PostConstruct;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import org.springframework.stereotype.Component;

/**
 *
 * @author antonio-lap
 */
@Component
public class TorneoPopUp extends JPopupMenu {
    
    private JMenuItem jMenuItem;
    private Accion accion;
    private TorneoDto torneoDto;
    
    @PostConstruct
    public void init() {
        accion = new Accion();
        jMenuItem = new JMenuItem("Agregar Equipo");
        jMenuItem.addActionListener(accion);
        add(jMenuItem);
    }
    
    public void setTorneoDto(TorneoDto torneoDto) {
        this.torneoDto = torneoDto;
    }
    
    private class Accion implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    
    }

}
