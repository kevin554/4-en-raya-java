package logica;

import grafica.Panel4enRaya;
import java.awt.Graphics;

public class Cuadricula {

    private int posX;
    private int posY;
    private boolean ocupado;
    private String figura;

    public Cuadricula(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.ocupado = false;
    }

    public void dibujar(Graphics g2d, Panel4enRaya elPanel) {
        if (figura.equals(Panel4enRaya.CIRCULO)) {
            dibujarCirculo(g2d, elPanel);
        } else {
            dibujarEquis(g2d, elPanel);
        }
    }
    
    private void dibujarCirculo(Graphics g2d, Panel4enRaya elPanel) {
        int margenX = elPanel.getWidth() / 4;
        int margenY = elPanel.getHeight() / 4;
        
        g2d.drawOval(margenX * this.getPosX(), margenY * this.getPosY(), 
                elPanel.getWidth() / 4, elPanel.getHeight() / 4);        
    }
    
    private void dibujarEquis(Graphics g2d, Panel4enRaya elPanel) {
        int margenX = elPanel.getWidth() / 4;
        int margenY = elPanel.getHeight() / 4;
        
        // /
        g2d.drawLine(margenX * this.getPosX(), margenY * this.getPosY(), 
                margenX * (this.getPosX() + 1), 
                margenY * (this.getPosY() + 1));
        // \
        g2d.drawLine(margenX * (this.getPosX() + 1), margenY * this.getPosY(),
                margenX * this.getPosX(), 
                margenY * (this.getPosY() + 1));
    }
    
    // <editor-fold defaultstate="collapsed" desc="getters y setters">
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public String getFigura() {
        return figura;
    }

    public void setFigura(String figura) {
        this.figura = figura;
    }
    // </editor-fold>
}