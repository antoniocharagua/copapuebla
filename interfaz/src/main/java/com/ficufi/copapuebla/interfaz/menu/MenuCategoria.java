package com.ficufi.copapuebla.interfaz.menu;

import com.ficufi.copapuebla.interfaz.Principal;
import com.ficufi.copapuebla.interfaz.VisorEstatusEnum;
import com.ficufi.copapuebla.interfaz.dialogos.CategoriaDialogo;
import com.ficufi.copapuebla.interfaz.dialogos.ModoEnum;
import com.ficufi.copapuebla.interfaz.tabla.CategoriaTabla;
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
public class MenuCategoria extends JMenu implements ActionListener{
    
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private JMenuItem jMenuItem;
    
    @Autowired
    private CategoriaDialogo nuevaCategoriaDialogo;
    
    @Autowired
    private Principal principal;
    
    @Autowired
    private CategoriaTabla categoriaTabla;

    public MenuCategoria() {
        super("Categoria");
    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Nueva Categoria":
                nuevaCategoriaDialogo.muestraDialogo(ModoEnum.CREAR, null);
                categoriaTabla.llenaTabla();
                break;
            case "Muestra Categorias":
                if (principal.getVisorEstatusEnum() != VisorEstatusEnum.TABLA) {
                    principal.remplazaCentral();
                }
                principal.getjTabbedPane().setSelectedComponent(categoriaTabla);
                break;
            default:
                logger.error("opcion aun no programada:{}", e.getActionCommand());
                throw new AssertionError();
        }
    }
    
    @PostConstruct
    public void init() {
        jMenuItem = new JMenuItem("Nueva Categoria");
        jMenuItem.addActionListener(this);
        add(jMenuItem);
        jMenuItem = new JMenuItem("Muestra Categorias");
        jMenuItem.addActionListener(this);
        add(jMenuItem);
    }

}
