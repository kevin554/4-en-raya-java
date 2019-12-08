package grafica;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class PanelModoDeJuego extends JPanel implements ItemListener {

    private Panel4enRaya elPanel;
    
    public PanelModoDeJuego() {
        init();
    }

    public PanelModoDeJuego(Panel4enRaya elPanel) {
        this.elPanel = elPanel;
        init();
    }
    
    private void init() {
        String[] items = new String[]{"Medio", "Partida contra un amigo"};
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(items);
        JComboBox comboBox = new JComboBox(modelo);
        comboBox.addItemListener(this);
        
        this.add(comboBox);
        this.setBackground(Color.WHITE);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if (e.getItem().equals("Partida contra un amigo")) {
                elPanel.setJuegaContraUnAmigo(true);
            }
            
            if (e.getItem().equals("Medio")) {
                elPanel.setJuegaContraUnAmigo(false);
            }
            
            elPanel.nuevoJuego();
        }
    }

    public Panel4enRaya getElPanel() {
        return elPanel;
    }

    public void setElPanel(Panel4enRaya elPanel) {
        this.elPanel = elPanel;
    }

}