package com.ficufi.copapuebla.interfaz.listener;

import com.ficufi.copapuebla.interfaz.Principal;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.prefs.Preferences;
import javax.swing.JFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Antonio Francisco Alonso Valerdi
 */
@Component
public class VentanaListener implements WindowListener{
    
    @Autowired
    private JFrame frame;
    
    private Preferences preferences;    

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {        
        frame.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        preferences = ((Principal)frame).getPreferences();
        preferences.putInt("x", frame.getX());
        preferences.putInt("y", frame.getY());
        preferences.putInt("width", frame.getWidth());
        preferences.putInt("height", frame.getHeight());
        preferences.put("titulo", frame.getTitle());
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }

}
