package juegoGeekMasters;
import javax.swing.*;
import java.awt.*;

/**
 * @autors Cesar Mauricio Hincapie Lopez 2228820-2724 / Carlos Fernando Drada Hincapie
 * @version v.2.0.0
 * fecha: mayo / 1 / 2023
 */
public class Header extends JLabel {
    /**
     * Constructor de la clase header
     * @parametro title Cadena que contiene el texto del encabezado
     * @parametro colorBackground Objeto de color que se asignará para el fondo del encabezado
     */
    public Header(String title, Color colorBackground){
        this.setText(title);
        this.setBackground(colorBackground);
        this.setForeground(new Color(255,255,255));
        this.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setOpaque(true);
    }
}
