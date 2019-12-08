package grafica;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logica.EventosMouse;

public class Ventana extends JFrame {

    private Panel4enRaya elPanel;
    private PanelReiniciarPartida panelReiniciarPartida;
    
    public Ventana() {
        init();
    }

    private void init() {
        elPanel = new Panel4enRaya();
        MouseAdapter listener = EventosMouse.getOrCreate();
        
        this.setLayout(new BorderLayout());
        this.add(elPanel, BorderLayout.CENTER);
        
        panelReiniciarPartida = new PanelReiniciarPartida();
        panelReiniciarPartida.addMouseListener(listener);
        this.add(panelReiniciarPartida, BorderLayout.SOUTH);
        
        PanelModoDeJuego panelModoDeJuego = new PanelModoDeJuego(elPanel);
        this.add(panelModoDeJuego, BorderLayout.NORTH);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        comenzarPartida();
    }
    
    private void comenzarPartida() {
        String figura = JOptionPane.showInputDialog("Tu figura:");
        if (figura == null) {
            System.exit(0);
        }
        
        switch (figura.toUpperCase()) {
            case "O":
                elPanel.setFigura(Panel4enRaya.CIRCULO);
                break;
                
            default:
                elPanel.setFigura(Panel4enRaya.EQUIS);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="getters y setters">
    public Panel4enRaya getElPanel() {
        return elPanel;
    }

    public void setElPanel(Panel4enRaya elPanel) {
        this.elPanel = elPanel;
    }
    // </editor-fold>
}