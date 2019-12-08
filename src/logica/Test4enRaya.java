package logica;

import java.awt.EventQueue;

public class Test4enRaya {

    /*
     * Abstraer Figuras, con sus metodos para dibujar
     * colocar fondo de papel, de mesa
     * reemplazar arraylist con matriz
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(grafica.Ventana::new);
    }
}