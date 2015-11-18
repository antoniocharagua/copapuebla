package com.ficufi.copapuebla.interfaz.popup;

import com.ficufi.copapuebla.back.dto.TorneoDto;
import com.ficufi.copapuebla.interfaz.dialogos.JugadorEquipoDialogo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.annotation.PostConstruct;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private JugadorEquipoDialogo jugadorEquipoDialogo;
    
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
            switch (e.getActionCommand()) {
                case "Agregar Equipo":
                    jugadorEquipoDialogo.setTorneoDto(torneoDto);
                    jugadorEquipoDialogo.muestraDialogo();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    
    }

}
