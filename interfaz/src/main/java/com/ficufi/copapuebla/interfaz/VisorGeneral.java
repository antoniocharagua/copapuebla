package com.ficufi.copapuebla.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import javax.annotation.PostConstruct;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.springframework.stereotype.Component;

/**
 *
 * @author Antonio Francisco Alonso Valerdi
 */
@Component
public class VisorGeneral extends JPanel{

    public VisorGeneral() {
        setBackground(Color.white);
    }
    
    @PostConstruct
    public void setBackground() {
        JLabel picture = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/logo_copapuebla.jpg"));
        Image image = icon.getImage().getScaledInstance(425, 528, Image.SCALE_SMOOTH);
        picture.setIcon(new ImageIcon(image));
        add(picture, BorderLayout.CENTER);
    }

}
