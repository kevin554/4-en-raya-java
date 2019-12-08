package logica;

import grafica.Panel4enRaya;
import grafica.PanelReiniciarPartida;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class EventosMouse extends MouseAdapter {

    private static EventosMouse instancia;
    private Panel4enRaya elPanel;

    public static EventosMouse getOrCreate() {
        if (instancia == null) {
            instancia = new EventosMouse();
        }

        return instancia;
    }

    private EventosMouse() {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() instanceof Panel4enRaya) {
            int x = e.getPoint().x / (elPanel.getWidth() / 4);
            int y = e.getPoint().y / (elPanel.getWidth() / 4);

            for (Cuadricula cuadricula : elPanel.getLaCuadricula()) {
                if (cuadricula.getPosX() == x && cuadricula.getPosY() == y && 
                        !cuadricula.isOcupado()) {
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        if (elPanel.movimientoLegal(elPanel.getFigura())) {
                            cuadricula.setFigura(elPanel.getFigura());
                            cuadricula.setOcupado(true);
                            elPanel.setJugadorActual(elPanel.getLaOtraFigura());
                        } else {
                            break;
                        }
                        
                        // si no juega contra un amigo
                        if (!elPanel.isJuegaContraUnAmigo()) {
                            // siguiente turno de la pc
                            // elPanel.mandarClic aca como clic derecho
                            elPanel.mejorJugada();
                        }
                    } else if (SwingUtilities.isRightMouseButton(e)
                            && elPanel.isJuegaContraUnAmigo()) {
                        if (elPanel.movimientoLegal(elPanel.getLaOtraFigura())) {
                            cuadricula.setFigura(elPanel.getLaOtraFigura());
                            elPanel.setJugadorActual(elPanel.getFigura());
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }

                    cuadricula.setOcupado(true);
                    elPanel.repaint();

                    break;
                }
            }

            if (elPanel.hayUnGanador()) {
                JOptionPane.showMessageDialog(elPanel, "Gana "
                        + elPanel.getLaOtraFigura(elPanel.getJugadorActual()));
            }
        }

        if (e.getSource() instanceof PanelReiniciarPartida) {
            elPanel.nuevoJuego();
            elPanel.repaint();
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
