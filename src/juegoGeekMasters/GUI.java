package juegoGeekMasters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.http.WebSocket;
import java.awt.GridBagLayout.*;
import java.awt.event.*;
import java.net.http.WebSocket;
import java.util.Objects;
//import java.net.http.WebSocket;


/**
 * @autors Cesar Mauricio Hincapie Lopez 2228820-2724 / Carlos Fernando Drada Hincapie
 * @version v.1.0.0
 * fecha: mayo / 5 / 2023
 */
public class GUI extends JFrame {

    /**
     * Attributos
     */
    private JButton[] dado;
    private JButton iniciar, ayuda, salida;
    private ImageIcon dadoImagen;
    private juegoGeek juegoGeek;
    private int banderaInicio=0, banderaDado=0, poder=0, banderaAccion=0;
    private int[] caras;
    private Header header;
    private JPanel[] panelesAUsar;
    private Listener listener;
    private JLabel scoreTable;




    /**
     * Constructor de la clase GUI
     */
    public GUI(){
        initGUI();
        //Default JFrame configuration
        this.setTitle("Geek Out Masters");
        //this.setUndecorated(true);
        this.setBackground(new Color(255,255,255,255));
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints=new GridBagConstraints();

        //Create Listener Object and Control Object
        listener=new Listener();
        juegoGeek =new juegoGeek();

        //Set up JComponents
        dadoImagen=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/scoreTable.jpg")));
        scoreTable=new JLabel(dadoImagen);
        /*
         * Panel creation
         */
        panelesAUsar=new JPanel[4];

        panelesAUsar[0]=new JPanel();//This is the inactive dice panel.
        panelesAUsar[1]=new JPanel();//This is the dice used panel.
        panelesAUsar[2]=new JPanel();//This is your dice panel.
        panelesAUsar[3]=new JPanel();//This is score dice panel




    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }




    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class listener implements ActionListener, MouseListener {


        @Override
        public void actionPerformed(ActionEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}

