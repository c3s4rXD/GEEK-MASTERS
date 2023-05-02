package juegoGeekMasters;

import javax.swing.*;
import java.awt.*;
import java.awt.GridBagLayout.*;
import java.awt.event.*;
import java.net.http.WebSocket;
//import java.net.http.WebSocket;


/**
 * This class is used for ...
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {

    private Header headerProject;

    private  JLabel dados;

    private JButton lanzarDados;

    private JPanel panelDadosActivos, panelDadosInactivos, panelDadosUsados, panelTarjetaPuntuacion, panelAyuda;

    private ImageIcon imagenDados;

    private JTextArea resultados;

    //private Listener listener;

    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("GEEK OUT MASTERS");
        //this.setSize(600,500);
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
        GridBagConstraints constraints = new GridBagConstraints();
        //Create Listener Object and Control Object
        //Set up JComponents
        headerProject = new Header("MESA DE JUEGO", Color.BLACK);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        this.add(headerProject, constraints);


        //se cargan las imagen del dado por defecto
        imagenDados = new ImageIcon(getClass().getResource("/recursos/dados.jpg"));
        dados = new JLabel(imagenDados);
        //se crea el boton para lanzar los dados
        //lanzarDados = new JButton("lanzarDados");
        //creamos los JPanel
        //paneles
        panelDadosActivos = new JPanel();
        panelDadosActivos.setPreferredSize(new Dimension(300, 180));
        panelDadosActivos.setBorder(BorderFactory.createTitledBorder("dados activos"));
        panelDadosActivos.add(dados);
        //panelDadosActivos.add(lanzarDados);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;

        this.add(panelDadosActivos, constraints);



        //se cargan las imagen del dado por defecto
        imagenDados = new ImageIcon(getClass().getResource("/recursos/dados.jpg"));
        dados = new JLabel(imagenDados);
        //se crea el boton para lanzar los dados
        //lanzarDados = new JButton("lanzarDados");
        //creamos los JPanel
        //paneles
        panelDadosInactivos = new JPanel();
        panelDadosInactivos.setPreferredSize(new Dimension(300, 180));
        panelDadosInactivos.setBorder(BorderFactory.createTitledBorder("dados inactivos"));
        panelDadosInactivos.add(dados);
        //panelDadosActivos.add(lanzarDados);
        constraints.gridx=1;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;

        this.add(panelDadosInactivos, constraints);






        //se cargan las imagen del dado por defecto
        imagenDados = new ImageIcon(getClass().getResource("/recursos/dados.jpg"));
        dados = new JLabel(imagenDados);
        //se crea el boton para lanzar los dados
        //lanzarDados = new JButton("lanzarDados");
        //creamos los JPanel
        //paneles
        panelDadosUsados = new JPanel();
        panelDadosUsados.setPreferredSize(new Dimension(300, 180));
        panelDadosUsados.setBorder(BorderFactory.createTitledBorder("dados usados"));
        panelDadosUsados.add(dados);
        //panelDadosActivos.add(lanzarDados);
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;

        this.add(panelDadosUsados, constraints);





        //se cargan las imagen del dado por defecto
        imagenDados = new ImageIcon(getClass().getResource("/recursos/puntuacion.jpg"));
        dados = new JLabel(imagenDados);
        //se crea el boton para lanzar los dados
        //lanzarDados = new JButton("lanzarDados");
        //creamos los JPanel
        //paneles
        panelTarjetaPuntuacion = new JPanel();
        panelTarjetaPuntuacion.setPreferredSize(new Dimension(300, 180));
        panelTarjetaPuntuacion.setBorder(BorderFactory.createTitledBorder("tarjeta de puntuacion"));
        panelTarjetaPuntuacion.add(dados);
        //panelDadosActivos.add(lanzarDados);
        constraints.gridx=1;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;

        this.add(panelTarjetaPuntuacion, constraints);





        //se cargan las imagen del dado por defecto
        imagenDados = new ImageIcon(getClass().getResource("/recursos/ayuda.jpg"));
        dados = new JLabel(imagenDados);
        //se crea el boton para lanzar los dados
        //lanzarDados = new JButton("lanzarDados");
        //creamos los JPanel
        //paneles
        panelAyuda = new JPanel();
        panelAyuda.setPreferredSize(new Dimension(300, 180));
        panelAyuda.setBorder(BorderFactory.createTitledBorder("tarjeta de puntuacion"));
        panelAyuda.add(dados);
        //panelDadosActivos.add(lanzarDados);
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;

        this.add(panelAyuda, constraints);





        //listener = new Listener();
        lanzarDados = new JButton("lanzarDados");
        constraints.gridx=0;
        constraints.gridy=3;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(lanzarDados, constraints);











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

