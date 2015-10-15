package com.ficufi.copapuebla.interfaz;

import java.awt.BorderLayout;
import java.awt.event.WindowListener;
import java.util.prefs.Preferences;
import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author Antonio Francisco Alonso Valerdi
 */
@Component
public class Principal extends JFrame{
    
    private final Preferences preferences;
    private JMenuBar jMenuBar;
    
    @Autowired
    private WindowListener windowListener;
    
    @Autowired
    private VisorArbol visorArbol;
    
    @Autowired
    private VisorGeneral visorGeneral;
    
    @Autowired
    private MenuTorneo menuTorneo;
    
    @Autowired
    private BarraMensaje barraMensaje;    
    
    public Principal() {        
        preferences = Preferences.userNodeForPackage(getClass());
        setLayout(new BorderLayout(5,5));
    }

    public Preferences getPreferences() {
        return preferences;
    }
    
    @PostConstruct
    private void initComponent () {
        addWindowListener(windowListener);
        add(barraMensaje, BorderLayout.PAGE_END);
        add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, visorArbol, visorGeneral));        
        jMenuBar = new JMenuBar();
        jMenuBar.add(menuTorneo);
        setJMenuBar(jMenuBar);
        setTitle(preferences.get("title", "Copa Puebla"));
        int x = preferences.getInt("x", 10);
        int y = preferences.getInt("y", 10);
        int width = preferences.getInt("width", 400);
        int height = preferences.getInt("height", 300);
        setBounds(x, y, width, height);        
    }
    
    public static void main(String[] args) {        
        SwingUtilities.invokeLater(new Runnable() {
            ApplicationContext applicationContext = 
                new ClassPathXmlApplicationContext("spring/applicationContext.xml");
            @Override
            public void run() {
                Principal principal = applicationContext.getBean(Principal.class);
                principal.setVisible(true);
            }
        });
    }

}
