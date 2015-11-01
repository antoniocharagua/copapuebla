package com.ficufi.copapuebla.interfaz;

import com.ficufi.copapuebla.interfaz.menu.JugadorMenu;
import com.ficufi.copapuebla.interfaz.menu.MenuCategoria;
import com.ficufi.copapuebla.interfaz.menu.MenuTorneo;
import com.ficufi.copapuebla.interfaz.menu.MenuEquipo;
import com.ficufi.copapuebla.interfaz.popup.TorneoPopUp;
import com.ficufi.copapuebla.interfaz.tabla.CategoriaTabla;
import com.ficufi.copapuebla.interfaz.tabla.EquipoTabla;
import com.ficufi.copapuebla.interfaz.tabla.JugadorTabla;
import java.awt.BorderLayout;
import java.awt.event.WindowListener;
import java.util.prefs.Preferences;
import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
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
    private JSplitPane jSplitPane;
    private JTabbedPane jTabbedPane;
    private VisorEstatusEnum visorEstatusEnum;
    
    @Autowired
    private WindowListener windowListener;
    
    @Autowired
    private VisorArbol visorArbol;
    
    @Autowired
    private VisorGeneral visorGeneral;
    
    @Autowired
    private MenuTorneo menuTorneo;
    
    @Autowired
    private MenuCategoria menuCategoria;
    
    @Autowired
    private MenuEquipo menuEquipo;
    
    @Autowired
    private JugadorMenu jugadorMenu;
    
    @Autowired
    private BarraMensaje barraMensaje;    
    
    @Autowired
    private CategoriaTabla categoriaTabla;
    
    @Autowired
    private JugadorTabla jugadorTabla;
    
    @Autowired
    private EquipoTabla equipoTabla;
    
    @Autowired
    private TorneoPopUp arbolPopUp;
    
    public Principal() {        
        preferences = Preferences.userNodeForPackage(getClass());
        setLayout(new BorderLayout(5,5));
        jTabbedPane = new JTabbedPane();
        visorEstatusEnum = VisorEstatusEnum.INTRO;
    }    
    
    @PostConstruct
    private void initComponent () {
        addWindowListener(windowListener);
        add(barraMensaje, BorderLayout.PAGE_END);        
        add(jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, visorArbol, visorGeneral));
        jMenuBar = new JMenuBar();
        jMenuBar.add(menuTorneo);
        jMenuBar.add(menuEquipo);
        jMenuBar.add(menuCategoria);
        jMenuBar.add(jugadorMenu);
        setJMenuBar(jMenuBar);
        jTabbedPane.addTab("Categorías", categoriaTabla);
        jTabbedPane.addTab("Equipos", equipoTabla);
        jTabbedPane.addTab("Jugadores", jugadorTabla);
        setTitle(preferences.get("title", "Copa Puebla"));
        int x = preferences.getInt("x", 10);
        int y = preferences.getInt("y", 10);
        int width = preferences.getInt("width", 400);
        int height = preferences.getInt("height", 300);
        setBounds(x, y, width, height);        
    }
    
    public void remplazaCentral() {
        visorEstatusEnum = VisorEstatusEnum.TABLA;
        jSplitPane.remove(jSplitPane.getRightComponent());
        jSplitPane.setRightComponent(jTabbedPane);
        jSplitPane.revalidate();
        jSplitPane.repaint();
        revalidate();
        repaint();
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
    
    public Preferences getPreferences() {
        return preferences;
    }

    public JTabbedPane getjTabbedPane() {
        return jTabbedPane;
    }
    
    public VisorEstatusEnum getVisorEstatusEnum() {
        return visorEstatusEnum;
    }
}
