package juegoGeekMasters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private int banderaInicio=0, banderaDado=0, poder=0, banderAccion=0;
    private int[] caras;
    private Header header;
    private JPanel[] panelesAUsar;
    private Listener listener;
    private JLabel tablaPuntuacion;




    /**
     * Constructor de la clase GUI
     */
    public GUI(){
        initGUI();
        // configuracion de los JFrame
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
        //configurar contenedores y layouts
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints=new GridBagConstraints();

        //Crear escuchas y objeto a controlar
        listener = new Listener();
        juegoGeek=new juegoGeek();

        //configurar componentes
        dadoImagen=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/puntuacion.jpg")));
        tablaPuntuacion=new JLabel(dadoImagen);
        /*
        * creacion de los paneles
        */
        panelesAUsar=new JPanel[4];

        panelesAUsar[0]=new JPanel();//este es el panel para dados inactivos
        panelesAUsar[1]=new JPanel();//este es el panel para dados usados
        panelesAUsar[2]=new JPanel();//este es el panel para dados activos
        panelesAUsar[3]=new JPanel();//este es el panel para la tabla de puntuacion

        /*
         * interfaz para el header
         */
        header = new Header("Tabla De Juego Geek Out Master", Color.BLACK);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=0;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        this.add(header, constraints);

        /*
         * boton de ayuda
         */
        ayuda=new JButton("¿Como Jugar?");
        ayuda.addActionListener(listener);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_START;
        this.add(ayuda, constraints);

        /*
         * boton de salida
         */
        salida=new JButton("  SALIDA  ");
        salida.addActionListener(listener);
        constraints.gridx=2;
        constraints.gridy=1;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_END;
        this.add(salida, constraints);

        /*
         * creacion de los dados
         * añadir los listener
         */
        dado=new JButton[10];

        dado[0]=new JButton(); dado[0].addActionListener(listener);
        dado[1]=new JButton(); dado[1].addActionListener(listener);
        dado[2]=new JButton(); dado[2].addActionListener(listener);
        dado[3]=new JButton(); dado[3].addActionListener(listener);
        dado[4]=new JButton(); dado[4].addActionListener(listener);
        dado[5]=new JButton(); dado[5].addActionListener(listener);
        dado[6]=new JButton(); dado[6].addActionListener(listener);
        dado[7]=new JButton(); dado[7].addActionListener(listener);
        dado[8]=new JButton(); dado[8].addActionListener(listener);
        dado[9]=new JButton(); dado[9].addActionListener(listener);

        /*
         * imagen inicial del dado
         */
        dadoImagen=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/42.jpg")));
        dado[0].setIcon(dadoImagen);
        dado[1].setIcon(dadoImagen);
        dado[2].setIcon(dadoImagen);
        dado[3].setIcon(dadoImagen);
        dado[4].setIcon(dadoImagen);
        dado[5].setIcon(dadoImagen);
        dado[6].setIcon(dadoImagen);
        dado[7].setIcon(dadoImagen);
        dado[8].setIcon(dadoImagen);
        dado[9].setIcon(dadoImagen);

        /*
         * panel para los dados inactivos
         */
        panelesAUsar[0]=new JPanel();
        panelesAUsar[0].setPreferredSize(new Dimension(600,400));
        panelesAUsar[0].setBorder(BorderFactory.createTitledBorder("Dados Inactivos."));
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelesAUsar[0], constraints);

        /*
         * panel para los dados usados
         */
        panelesAUsar[1]=new JPanel();
        panelesAUsar[1].setPreferredSize(new Dimension(600,400));
        panelesAUsar[1].setBorder(BorderFactory.createTitledBorder("Dados Usados"));
        constraints.gridx=1;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelesAUsar[1], constraints);

        /*
         * panel para los dados activos
         */
        panelesAUsar[2]=new JPanel();
        panelesAUsar[2].setPreferredSize(new Dimension(600,400));
        panelesAUsar[2].setBorder(BorderFactory.createTitledBorder("Dados Activos."));
        panelesAUsar[2].add(dado[0]); dado[0].setEnabled(false);
        panelesAUsar[2].add(dado[1]); dado[1].setEnabled(false);
        panelesAUsar[2].add(dado[2]); dado[2].setEnabled(false);
        panelesAUsar[2].add(dado[3]); dado[3].setEnabled(false);
        panelesAUsar[2].add(dado[4]); dado[4].setEnabled(false);
        panelesAUsar[2].add(dado[5]); dado[5].setEnabled(false);
        panelesAUsar[2].add(dado[6]); dado[6].setEnabled(false);
        panelesAUsar[2].add(dado[7]); dado[7].setEnabled(false);
        panelesAUsar[2].add(dado[8]); dado[8].setEnabled(false);
        panelesAUsar[2].add(dado[9]); dado[9].setEnabled(false);
        constraints.gridx=1;
        constraints.gridy=3;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelesAUsar[2], constraints);

        /*
         * panel para la tabla de puntuacion
         */
        panelesAUsar[3]=new JPanel();
        panelesAUsar[3].setPreferredSize(new Dimension(600,400));
        panelesAUsar[3].setBorder(BorderFactory.createTitledBorder("Tabla De Puntuacion"));
        panelesAUsar[3].add(tablaPuntuacion);
        constraints.gridx=2;
        constraints.gridy=2;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelesAUsar[3], constraints);

        /*
         * boton para iniciar el juego
         */
        iniciar=new JButton("Iniciar");
        iniciar.addActionListener(listener);
        constraints.gridx=1;
        constraints.gridy=4;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        add(iniciar, constraints);




    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() ->
        {
            GUI miProjectGUI = new GUI();
        });
    }




    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}

