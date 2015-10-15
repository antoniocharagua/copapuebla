package com.ficufi.copapuebla.interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import javax.swing.JPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Antonio Francisco Alonso Valerdi
 */
@Component
public class BarraMensaje extends JPanel{

    @Autowired
    private Frame frame;
    
    public BarraMensaje() throws HeadlessException {
        setLayout(new FlowLayout());
        setBackground(Color.yellow);
    }
    
}
