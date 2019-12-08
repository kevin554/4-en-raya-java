package grafica;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import logica.Cuadricula;
import logica.EventosMouse;

public class Panel4enRaya extends JPanel {

    private ArrayList<Cuadricula> laCuadricula;
    private String figura;
    private String jugadorActual;
    private java.awt.Image imagen;
    private boolean juegaContraUnAmigo;
    public static final String EQUIS = "X";
    public static final String CIRCULO = "O";

    public Panel4enRaya() {
        init();
    }

    private void init() {
        MouseAdapter listener = EventosMouse.getOrCreate();
        ((EventosMouse) listener).setElPanel(this);
        this.addMouseListener(listener);

        try {
            String direccion = "/imagenes/mesa rustica.jpg";
            this.imagen = ImageIO.read(getClass().getResource(direccion));
        } catch (IOException ex) {
            System.out.println(ex);
        }

        laCuadricula = new ArrayList<>();
        nuevoJuego();
    }

    public void nuevoJuego() {
        laCuadricula.clear();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                laCuadricula.add(new Cuadricula(j, i));
            }
        }

        this.repaint();
    }

    public boolean hayUnGanador() {
        if (laCuadricula.get(0).isOcupado()) {
            if (laCuadricula.get(1).isOcupado()
                    && laCuadricula.get(2).isOcupado()
                    && laCuadricula.get(3).isOcupado()) {
                if (laCuadricula.get(0).getFigura().equals(laCuadricula.get(1).getFigura())
                        && laCuadricula.get(0).getFigura().equals(laCuadricula.get(2).getFigura())
                        && laCuadricula.get(0).getFigura().equals(laCuadricula.get(3).getFigura())) {
                    return true;
                }
            }

            if (laCuadricula.get(4).isOcupado()
                    && laCuadricula.get(8).isOcupado()
                    && laCuadricula.get(12).isOcupado()) {
                if (laCuadricula.get(0).getFigura().equals(laCuadricula.get(4).getFigura())
                        && laCuadricula.get(0).getFigura().equals(laCuadricula.get(8).getFigura())
                        && laCuadricula.get(0).getFigura().equals(laCuadricula.get(12).getFigura())) {
                    return true;
                }
            }

            if (laCuadricula.get(5).isOcupado()
                    && laCuadricula.get(10).isOcupado()
                    && laCuadricula.get(15).isOcupado()) {
                if (laCuadricula.get(0).getFigura().equals(laCuadricula.get(5).getFigura())
                        && laCuadricula.get(0).getFigura().equals(laCuadricula.get(10).getFigura())
                        && laCuadricula.get(0).getFigura().equals(laCuadricula.get(15).getFigura())) {
                    return true;
                }
            }
        }

        if (laCuadricula.get(1).isOcupado()) {
            if (laCuadricula.get(5).isOcupado()
                    && laCuadricula.get(9).isOcupado()
                    && laCuadricula.get(13).isOcupado()) {
                if (laCuadricula.get(1).getFigura().equals(laCuadricula.get(5).getFigura())
                        && laCuadricula.get(1).getFigura().equals(laCuadricula.get(9).getFigura())
                        && laCuadricula.get(1).getFigura().equals(laCuadricula.get(13).getFigura())) {
                    return true;
                }
            }
        }

        if (laCuadricula.get(2).isOcupado()) {
            if (laCuadricula.get(6).isOcupado()
                    && laCuadricula.get(10).isOcupado()
                    && laCuadricula.get(14).isOcupado()) {
                if (laCuadricula.get(2).getFigura().equals(laCuadricula.get(6).getFigura())
                        && laCuadricula.get(2).getFigura().equals(laCuadricula.get(10).getFigura())
                        && laCuadricula.get(2).getFigura().equals(laCuadricula.get(14).getFigura())) {
                    return true;
                }
            }
        }

        if (laCuadricula.get(3).isOcupado()) {
            if (laCuadricula.get(7).isOcupado()
                    && laCuadricula.get(11).isOcupado()
                    && laCuadricula.get(15).isOcupado()) {
                if (laCuadricula.get(3).getFigura().equals(laCuadricula.get(7).getFigura())
                        && laCuadricula.get(3).getFigura().equals(laCuadricula.get(11).getFigura())
                        && laCuadricula.get(3).getFigura().equals(laCuadricula.get(15).getFigura())) {
                    return true;
                }
            }

            if (laCuadricula.get(6).isOcupado()
                    && laCuadricula.get(9).isOcupado()
                    && laCuadricula.get(12).isOcupado()) {
                if (laCuadricula.get(3).getFigura().equals(laCuadricula.get(6).getFigura())
                        && laCuadricula.get(3).getFigura().equals(laCuadricula.get(9).getFigura())
                        && laCuadricula.get(3).getFigura().equals(laCuadricula.get(12).getFigura())) {
                    return true;
                }
            }
        }

        if (laCuadricula.get(4).isOcupado()) {
            if (laCuadricula.get(5).isOcupado()
                    && laCuadricula.get(6).isOcupado()
                    && laCuadricula.get(7).isOcupado()) {
                if (laCuadricula.get(4).getFigura().equals(laCuadricula.get(5).getFigura())
                        && laCuadricula.get(4).getFigura().equals(laCuadricula.get(6).getFigura())
                        && laCuadricula.get(4).getFigura().equals(laCuadricula.get(7).getFigura())) {
                    return true;
                }
            }
        }

        if (laCuadricula.get(8).isOcupado()) {
            if (laCuadricula.get(9).isOcupado()
                    && laCuadricula.get(10).isOcupado()
                    && laCuadricula.get(11).isOcupado()) {
                if (laCuadricula.get(8).getFigura().equals(laCuadricula.get(9).getFigura())
                        && laCuadricula.get(8).getFigura().equals(laCuadricula.get(10).getFigura())
                        && laCuadricula.get(8).getFigura().equals(laCuadricula.get(11).getFigura())) {
                    return true;
                }
            }
        }

        if (laCuadricula.get(12).isOcupado()) {
            if (laCuadricula.get(13).isOcupado()
                    && laCuadricula.get(14).isOcupado()
                    && laCuadricula.get(15).isOcupado()) {
                if (laCuadricula.get(12).getFigura().equals(laCuadricula.get(13).getFigura())
                        && laCuadricula.get(12).getFigura().equals(laCuadricula.get(14).getFigura())
                        && laCuadricula.get(12).getFigura().equals(laCuadricula.get(15).getFigura())) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean movimientoLegal(String figura) {
        return jugadorActual.equals(figura);
    }

    public void mejorJugada() {
        for (Cuadricula cuadricula : laCuadricula) {
            if (cuadricula.isOcupado()) {
                int x = cuadricula.getPosX();
                int y = cuadricula.getPosY();

                System.out.println(x);
                System.out.println(y);

                int aleatorio = (int) (Math.random() * 4);
                int indice = 0;
                while (aleatorio != 0) {
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            if (i == x) {
                                continue;
                            }

                            if (j == y) {
                                continue;
                            }

                            
                            aleatorio--;
                        }
                    }
                    
                    
                }
                
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

//        g.drawImage(imagen, 0, 0, null);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1.51f));

        int margenX = getWidth() / 4;
        int margenY = getHeight() / 4;

        for (int i = margenX, j = margenY; i < getWidth() && j < getHeight();
                i += margenX, j += margenY) {
            g2d.drawLine(i, 0, i, getHeight()); // lineas horizontales
            g2d.drawLine(0, j, getWidth(), j); // lineas verticales
        }

        for (Cuadricula cuadro : laCuadricula) {
            if (cuadro.isOcupado()) {
                cuadro.dibujar(g2d, this);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(480, 480);
    }

    // <editor-fold defaultstate="collapsed" desc="getters y setters">
    public ArrayList<Cuadricula> getLaCuadricula() {
        return laCuadricula;
    }

    public void setLaCuadricula(ArrayList<Cuadricula> laCuadricula) {
        this.laCuadricula = laCuadricula;
    }

    public String getFigura() {
        return figura;
    }

    public String getLaOtraFigura() {
        if (figura.equals(CIRCULO)) {
            return EQUIS;
        } else {
            return CIRCULO;
        }
    }

    public String getLaOtraFigura(String figuraActual) {
        if (figuraActual.equals(EQUIS)) {
            return CIRCULO;
        } else {
            return EQUIS;
        }
    }

    public String getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(String jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public boolean isJuegaContraUnAmigo() {
        return juegaContraUnAmigo;
    }

    public void setJuegaContraUnAmigo(boolean juegaContraUnAmigo) {
        this.juegaContraUnAmigo = juegaContraUnAmigo;
    }

    public void setFigura(String figura) {
        this.figura = figura;
        jugadorActual = figura;
    }
    // </editor-fold>

}
