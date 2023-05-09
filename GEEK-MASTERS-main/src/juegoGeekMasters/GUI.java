package juegoGeekMasters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;



/**
 * @autors Cesar Mauricio Hincapie Lopez 2228820-2724 / Carlos Fernando Drada Hincapie 2040171-2724
 * @version v.1.0.0
 * fecha: mayo / 5 / 2023
 */
public class GUI extends JFrame {

    public static final String BEGINNING_MESSAGE="bienvenido a nuestra version de Geek Out Masters\n"

            +"Presiona el boton  'Jugar' para iniciar (Una vez presionado lo podras re-usar en la siguiente ronda).\n"
            +"\nTendras 10 dados a tu disponibilidad, tu objetivo sera conseguir tantos '42' como te sea posible "
            +"usando los poderes que has conseguido "
            +"\nCada cara del dado tendra poderes, poderes los cuales son:\n"
            +"\n42: Esta cara te dara puntos."
            +"\nDragon: El dragon tomara todos los puntos obtenidos y los eliminara."
            +"\nCorazon: El corazon te permitira tomar un dado de la seccion de inactivos, girarlo y convertirlo en un dado activo."
            +"\nHeroe: El heroe permite que cualquier dado que no haya sido usado de los dados activos cambie su cara al opuesto."
            +"\nNave espacial: La nave envia un dado de la seccion de dados activos a la seccion de inactivos."
            +"\nMeeple: te permitira re lanzar un dado que este en juego , de la seccion de dados activos \n";

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
    private listener listener;
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
     * Este método se utiliza para establecer la configuración predeterminada de JComponent
     * se crean los objetos de escucha y control utilizados para la clase GUI
     */
    private void initGUI() {
        //configurar contenedores y layouts
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints=new GridBagConstraints();

        //Crear escuchas y objeto a controlar
        listener = new listener();
        juegoGeek =new juegoGeek();

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
        dadoImagen=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/1.jpg")));
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
     * Proceso principal del programa Java
     * @param args Objeto utilizado para enviar datos de entrada desde la línea de comando cuando
     * el programa se ejecuta por consola.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() ->
        {
            GUI miProjectGUI = new GUI();
        });
    }




    /**
     * clase interna que extiende una clase de un adaptador o implementa escuchas utilizados por la clase GUI
     */
    private class listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            /*
             * Determine the state of the game
             */
            if(panelesAUsar[2].getComponentCount()==0)
            {
                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                banderaInicio=0;
                banderaDado=0;
            }

            /*
             * Contador de caras con el numero 42
             */
            int numero42 = 0, numeroDragones=0, carasDiferentes=0;
            for(int i=0; i < dado.length; i++)
            {
                if(dado[i].isEnabled() && caras[i]==1)
                {
                    numero42++;
                }
                if(dado[i].isEnabled() && caras[i]==2)
                {
                    numeroDragones++;
                }
                if(dado[i].isEnabled() && caras[i]>=3)
                {
                    carasDiferentes++;
                }
            }
            if(numero42 > 0 && numeroDragones==0 && carasDiferentes==0 && banderaDado==1)
            {
                JOptionPane.showMessageDialog(null, "Felicitaciones, alguien al parecer obtuvo un 42 , comparalo con la tabal de puntaje "
                        +"\n \n(no cierres la ventana si nates haber guardado el puntaje).");
                juegoGeek.youWin(iniciar, dado, panelesAUsar);
                banderaInicio=0;
                banderaDado=0;
            }

            if(numero42 > 0 && numeroDragones > 0 && carasDiferentes==0)
            {
                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                banderaInicio=0;
                banderaDado=0;
            }
            /*
             * boton para comenzar a jugar
             */
            if(e.getSource()==iniciar)
            {

                /*
                 * bandera para determinar una accion
                 */
                banderaDado++;

                /*
                 * Obtiene las distintas caras del dado
                 */
                juegoGeek.caraDeterminada();
                caras=juegoGeek.getCaras();

                /*
                 * boton para activar
                 */
                for(int i=0; i < dado.length; i++)
                {
                    dado[i].setEnabled(true);
                }
                /*
                 * esto es para mandar los dados a los paneles inactivos
                 */
                for(int i=0; i < dado.length; i++)
                {
                    panelesAUsar[2].remove(dado[i]);//Remover del panel de dados
                    panelesAUsar[0].add(dado[i]);//Introducir el dado en el panel de inactivos
                    dado[i].setEnabled(false);
                    if(i == 2)
                    {
                        break;
                    }
                }
                /*
                 * Esto se usa para añadir las imagenes al panel
                 */
                banderaInicio++;
                dadoImagen=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + caras[0] + ".jpg")));
                dado[0].setIcon(dadoImagen);
                dadoImagen=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + caras[1] + ".jpg")));
                dado[1].setIcon(dadoImagen);
                dadoImagen=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + caras[2] + ".jpg")));
                dado[2].setIcon(dadoImagen);
                dadoImagen=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + caras[3] + ".jpg")));
                dado[3].setIcon(dadoImagen);
                dadoImagen=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + caras[4] + ".jpg")));
                dado[4].setIcon(dadoImagen);
                dadoImagen=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + caras[5] + ".jpg")));
                dado[5].setIcon(dadoImagen);
                dadoImagen=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + caras[6] + ".jpg")));
                dado[6].setIcon(dadoImagen);
                dadoImagen=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + caras[7] + ".jpg")));
                dado[7].setIcon(dadoImagen);
                dadoImagen=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + caras[8] + ".jpg")));
                dado[8].setIcon(dadoImagen);
                dadoImagen=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + caras[9] + ".jpg")));
                dado[9].setIcon(dadoImagen);
                /*
                 * Una vez que el usuario presiona el botón de iniciar, se desactivará
                 */
                if(banderaInicio==1)
                {
                    iniciar.setEnabled(false);
                }
            }
            /*
             * obtiene la accion
             */
            if(banderaDado==1)
            {
                /*
                 * boton para el dado 1
                 */
                if (e.getSource() == dado[0])
                {
                    boolean state = false;
                    while (state == false)
                    {
                        /*
                         * Condiciones para las caras de cada dado
                         */
                        //1: 42
                        if (caras[0] == 1)
                        {
                            juegoGeek.accion42();
                            break;
                        }
                        //2: Dragon
                        if (caras[0] == 2)
                        {
                            if(panelesAUsar[2].getComponentCount()==1)
                            {
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                juegoGeek.accionDragon();
                                break;
                            }
                        }
                        if (caras[0] == 3)//3: Corazon
                        {
                            if (panelesAUsar[0].getComponentCount() == 0) {
                                JOptionPane.showMessageDialog(null, "No hay dados en la seccion de dados inactivos.");
                                break;
                            } else {
                                dado[0].setEnabled(false);
                                panelesAUsar[2].remove(dado[0]);
                                panelesAUsar[1].add(dado[0]);
                                dado[0].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                juegoGeek.heartAction(panelesAUsar, dado, dadoImagen, caras);
                                break;
                            }
                        } if (caras[0] == 4)//4: Heroe
                    {
                        if(panelesAUsar[2].getComponentCount()==1 || panelesAUsar[2].getComponentCount() == 0)
                        {
                            JOptionPane.showMessageDialog(null, "No hay dado alguno en la seccion de dados.");
                            juegoGeek.youLose(iniciar, dado, panelesAUsar);
                            banderaInicio=0;
                            banderaDado=0;
                            break;
                        }
                        else
                        {
                            panelesAUsar[2].remove(dado[0]);
                            panelesAUsar[1].add(dado[0]);
                            dado[0].setEnabled(false);
                            dado[0].updateUI();
                            panelesAUsar[2].updateUI();
                            panelesAUsar[1].updateUI();
                            JOptionPane.showMessageDialog(null, "Escoge el dado por el que quieres cambiar su cara.");
                            banderAccion=1;
                            poder=4;
                            banderaDado=2;
                            break;
                        }
                    }
                        //5:meeple
                        if (caras[0] == 5)
                        {
                            if(panelesAUsar[2].getComponentCount()==1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay dados aun en la seccion de los dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[0]);
                                panelesAUsar[1].add(dado[0]);
                                dado[0].setEnabled(false);
                                dado[0].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Escoge el dado que deseas girar de nuevo.");
                                banderAccion=1;
                                poder=5;
                                banderaDado=2;
                                break;
                            }
                        }
                        //6:Nave espacial
                        if (caras[0] == 6)
                        {
                            if(panelesAUsar[2].getComponentCount()==1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[0]);
                                panelesAUsar[1].add(dado[0]);
                                dado[0].setEnabled(false);
                                dado[0].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Selecciona el dado que deseas mandar a la seccion de inactivos");
                                banderAccion=1;
                                poder=6;
                                banderaDado=2;
                                break;
                            }
                        }
                    }
                }
                /*
                 * boton para el segundo dado
                 */
                if (e.getSource() == dado[1]) {
                    boolean state = false;
                    while (state == false) {
                        /**
                         * Condiciones para las caras de los dados
                         * */
                        if (caras[1] == 1)//1: Cara con el 42
                        {
                            juegoGeek.accion42();
                            break;
                        }
                        if (caras[1] == 2)//2: Cara del dragon
                        {
                            if(panelesAUsar[2].getComponentCount()==1)
                            {
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                juegoGeek.accionDragon();
                                break;
                            }
                        }
                        if (caras[1] == 3)//3: cara del corazon
                        {
                            if (panelesAUsar[0].getComponentCount() == 0) {
                                JOptionPane.showMessageDialog(null, "No hay dados en la seccion de dados inactivos.");
                                break;
                            } else {
                                dado[1].setEnabled(false);
                                panelesAUsar[2].remove(dado[1]);
                                panelesAUsar[1].add(dado[1]);
                                dado[1].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                juegoGeek.heartAction(panelesAUsar, dado, dadoImagen, caras);
                                break;
                            }
                        }
                        if (caras[1] == 4)//4: face of hero
                        {
                            if(panelesAUsar[2].getComponentCount()==1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[1]);
                                panelesAUsar[1].add(dado[1]);
                                dado[1].setEnabled(false);
                                dado[1].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Escoge que dado deseas intercambiar su cara.");
                                banderaInicio=1;
                                poder=4;
                                banderaDado=2;
                                break;
                            }
                        }
                        if (caras[1] == 5)//5: cara meeple
                        {
                            if(panelesAUsar[2].getComponentCount()==1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[1]);
                                panelesAUsar[1].add(dado[1]);
                                dado[1].setEnabled(false);
                                dado[1].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Escoge el dado que deseas volver a lanzar.");
                                banderAccion=1;
                                poder=5;
                                banderaDado=2;
                                break;
                            }
                        }
                        if (caras[1] == 6)//6: face of ship
                        {
                            if(panelesAUsar[2].getComponentCount()==1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[1]);
                                panelesAUsar[1].add(dado[1]);
                                dado[1].setEnabled(false);
                                dado[1].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Escoge que dado deseas enviar a la seccion de inactivos.");
                                banderAccion=1;
                                poder=6;
                                banderaDado=2;
                                break;
                            }
                        }
                    }
                }
                /*
                 * boton para el tercer dado
                 */
                if (e.getSource() == dado[2]) {
                    boolean state = false;
                    while (state == false) {
                        /**
                         * Condiciones para las caras de los dados
                         */
                        if (caras[2] == 1)//1: face of 42
                        {
                            juegoGeek.accion42();
                            break;
                        }
                        if (caras[2] == 2)//2: face of dragon
                        {
                            if(panelesAUsar[2].getComponentCount()==1)
                            {
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                juegoGeek.accionDragon();
                                break;
                            }
                        }
                        if (caras[2] == 3)//3: face of heart
                        {
                            if (panelesAUsar[0].getComponentCount() == 0) {
                                JOptionPane.showMessageDialog(null, "No hay dados en la seccion de dados inactivos.");
                                break;
                            } else {
                                panelesAUsar[2].remove(dado[2]);
                                panelesAUsar[1].add(dado[2]);
                                dado[2].setEnabled(false);
                                dado[2].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                juegoGeek.heartAction(panelesAUsar, dado, dadoImagen, caras);
                                break;
                            }
                        }
                        if (caras[2] == 4)//4: face of hero
                        {
                            if (panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[2]);
                                panelesAUsar[1].add(dado[2]);
                                dado[2].setEnabled(false);
                                dado[2].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Escoge a que dado quieres voltear su cara");
                                banderAccion=1;
                                poder=4;
                                banderaDado=2;
                                break;
                            }
                        }
                        if (caras[2] == 5)//5: face of meeple
                        {
                            if(panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[2]);
                                panelesAUsar[1].add(dado[2]);
                                dado[2].setEnabled(false);
                                dado[2].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Escoge el dado que deseas volver a lanzar ");
                                banderAccion=1;
                                poder=5;
                                banderaDado=2;
                                break;
                            }
                        }
                        if (caras[2] == 6)//6: face of ship
                        {
                            if (panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[2]);
                                panelesAUsar[1].add(dado[2]);
                                dado[2].setEnabled(false);
                                dado[2].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Selecciona que dado deseas mandar a la seccion de inactivos");
                                banderAccion=1;
                                poder=6;
                                banderaDado=2;
                                break;
                            }
                        }
                    }
                }
                /*
                 * boton del cuarto dado
                 */
                if (e.getSource() == dado[3]) {
                    boolean state = false;
                    while (state == false) {
                        /**
                         * condicionales para las caras de los dados
                         */
                        if (caras[3] == 1)//1: face of 42
                        {
                            juegoGeek.accion42();
                            break;
                        }
                        if (caras[3] == 2)//2: face of dragon
                        {
                            if(panelesAUsar[2].getComponentCount()==1)
                            {
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                juegoGeek.accionDragon();
                                break;
                            }
                        }
                        if (caras[3] == 3)//3: face of heart
                        {
                            if (panelesAUsar[0].getComponentCount() == 0) {
                                JOptionPane.showMessageDialog(null, "No hay dado en la seccion de dados.");
                                break;
                            } else {
                                panelesAUsar[2].remove(dado[3]);
                                panelesAUsar[1].add(dado[3]);
                                dado[3].setEnabled(false);
                                dado[3].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                juegoGeek.heartAction(panelesAUsar, dado, dadoImagen, caras);
                                break;
                            }
                        }
                        if (caras[3] == 4)//4: face of hero
                        {
                            if(panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[3]);
                                panelesAUsar[1].add(dado[3]);
                                dado[3].setEnabled(false);
                                dado[3].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Escoge a que dado deseas cambiar su cara");
                                banderAccion=1;
                                poder=4;
                                banderaDado=2;
                                break;
                            }
                        }
                        if (caras[3] == 5)//5: face of meeple
                        {
                            if(panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[3]);
                                panelesAUsar[1].add(dado[3]);
                                dado[3].setEnabled(false);
                                dado[3].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Escoge el dado que deseas volver a lanzar");
                                banderAccion=1;
                                poder=5;
                                banderaDado=2;
                                break;
                            }
                        }
                        if (caras[3] == 6)//6: face of ship
                        {
                            if(panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[3]);
                                panelesAUsar[1].add(dado[3]);
                                dado[3].setEnabled(false);
                                dado[3].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Selecciona el dado que quieres enviar a la seccion de inactivos");
                                banderAccion=1;
                                poder=6;
                                banderaDado=2;
                                break;
                            }
                        }
                    }
                }
                /*
                 * boton del quinto dado
                 */
                if (e.getSource() == dado[4]) {
                    boolean state = false;
                    while (state == false) {
                        /**
                         * condiciones para las caras del dado
                         */
                        if (caras[4] == 1)//1: face of 42
                        {
                            juegoGeek.accion42();
                            break;
                        }
                        if (caras[4] == 2)//2: face of dragon
                        {
                            if(panelesAUsar[2].getComponentCount()==1)
                            {
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                juegoGeek.accionDragon();
                                break;
                            }
                        }
                        if (caras[4] == 3)//3: face of heart
                        {
                            if (panelesAUsar[0].getComponentCount() == 0) {
                                JOptionPane.showMessageDialog(null, "No hay dados en la seccion de dados inactivos.");
                                break;
                            } else {
                                panelesAUsar[2].remove(dado[4]);
                                panelesAUsar[1].add(dado[4]);
                                dado[4].setEnabled(false);
                                dado[4].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                juegoGeek.heartAction(panelesAUsar, dado, dadoImagen, caras);
                                break;
                            }
                        }
                        if (caras[4] == 4)//4: face of hero
                        {
                            if(panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[4]);
                                panelesAUsar[1].add(dado[4]);
                                dado[4].setEnabled(false);
                                dado[4].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Selecciona el dado que deseas girar su cara.");
                                banderaDado=1;
                                poder=4;
                                banderaDado=2;
                            }
                            break;
                        }
                        if (caras[4] == 5)//5: face of meeple
                        {
                            if(panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[4]);
                                panelesAUsar[1].add(dado[4]);
                                dado[4].setEnabled(false);
                                dado[4].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Selecciona el dado que deseas volver a lanzar");
                                banderAccion=1;
                                poder=5;
                                banderaDado=2;
                                break;
                            }
                        }
                        if (caras[4] == 6)//6: face of ship
                        {
                            if(panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[4]);
                                panelesAUsar[1].add(dado[4]);
                                dado[4].setEnabled(false);
                                dado[4].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Selecciona el dado que deseas mandar a la seccion de inactivos.");
                                banderAccion=1;
                                poder=6;
                                banderaDado=2;
                                break;
                            }
                        }
                    }
                }
                /*
                 * boton para el sexto dado
                 */
                if (e.getSource() == dado[5]) {
                    boolean state = false;
                    while (state == false) {
                        /**
                         * condiciones para las caras del dado
                         */
                        if (caras[5] == 1)//1: cara del 42
                        {
                            juegoGeek.accion42();
                            break;
                        }
                        if (caras[5] == 2)//2: face of dragon
                        {
                            if(panelesAUsar[2].getComponentCount()==1)
                            {
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                juegoGeek.accionDragon();
                                break;
                            }
                        }
                        if (caras[5] == 3)//3: face of heart
                        {
                            if (panelesAUsar[0].getComponentCount() == 0) {
                                JOptionPane.showMessageDialog(null, "No hay dados en la seccion de dados inactivos .");
                                break;
                            } else {
                                panelesAUsar[2].remove(dado[5]);
                                panelesAUsar[1].add(dado[5]);
                                dado[5].setEnabled(false);
                                dado[5].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                juegoGeek.heartAction(panelesAUsar, dado, dadoImagen, caras);
                                break;
                            }
                        }
                        if (caras[5] == 4)//4: face of hero
                        {
                            if(panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[5]);
                                panelesAUsar[1].add(dado[5]);
                                dado[5].setEnabled(false);
                                dado[5].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Selecciona a que dado deseas girarle su cara.");
                                banderAccion=1;
                                poder=4;
                                banderaDado=2;
                                break;
                            }
                        }
                        if (caras[5] == 5)//5: face of meeple
                        {
                            if(panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[5]);
                                panelesAUsar[1].add(dado[5]);
                                dado[5].setEnabled(false);
                                dado[5].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Elige el dado que deseas volver a lanzar");
                                banderAccion=1;
                                poder=5;
                                banderaDado=2;
                                break;
                            }
                        }
                        if (caras[5] == 6)//6: face of ship
                        {
                            if(panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[5]);
                                panelesAUsar[1].add(dado[5]);
                                dado[5].setEnabled(false);
                                dado[5].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Selecciona el dado que deseas mandar a la seccion de inactivos.");
                                banderAccion=1;
                                poder=6;
                                banderaDado=2;
                                break;
                            }
                        }
                    }
                }
                /*
                 * boton del septimo dado
                 *
                 */
                if (e.getSource() == dado[6]) {
                    boolean state = false;
                    while (state == false) {
                        /**
                         * condiciones para las caras del dado
                         */
                        if (caras[6] == 1)//1: face of 42
                        {
                            juegoGeek.accion42();
                            break;
                        }
                        if (caras[6] == 2)//2: face of dragon
                        {
                            if(panelesAUsar[2].getComponentCount()==1)
                            {
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                juegoGeek.accionDragon();
                                break;
                            }
                        }
                        if (caras[6] == 3)//3: face of heart
                        {
                            if (panelesAUsar[0].getComponentCount() == 0) {
                                JOptionPane.showMessageDialog(null, "No hay dados en la seccion de dados inactivos ");
                                break;
                            } else {
                                panelesAUsar[2].remove(dado[6]);
                                panelesAUsar[1].add(dado[6]);
                                dado[6].setEnabled(false);
                                dado[6].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                juegoGeek.heartAction(panelesAUsar, dado, dadoImagen, caras);
                                break;
                            }
                        }
                        if (caras[6] == 4)//4: face of hero
                        {
                            if(panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[6]);
                                panelesAUsar[1].add(dado[6]);
                                dado[6].setEnabled(false);
                                dado[6].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Selecciona a que dado deseas girarle su cara.");
                                banderAccion=1;
                                poder=4;
                                banderaDado=2;
                                break;
                            }
                        }
                        if (caras[6] == 5)//5: face of meeple
                        {
                            if(panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[6]);
                                panelesAUsar[1].add(dado[6]);
                                dado[6].setEnabled(false);
                                dado[6].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Selecciona el dado que deseas volver a lanzar");
                                banderAccion=1;
                                poder=5;
                                banderaDado=2;
                                break;
                            }
                        }
                        if (caras[6] == 6)//6: face of ship
                        {
                            if(panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[6]);
                                panelesAUsar[1].add(dado[6]);
                                dado[6].setEnabled(false);
                                dado[6].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Selecciona el dado que deseas enviar a la seccion de inactivos");
                                banderAccion=1;
                                poder=6;
                                banderaDado=2;
                                break;
                            }
                        }
                    }
                }
                /*
                 * boton del octavo dado
                 */
                if (e.getSource() == dado[7]) {
                    boolean state = false;
                    while (state == false) {
                        /**
                         * condiciones de las caras de los dados
                         */
                        if (caras[7] == 1)//1: face of 42
                        {
                            juegoGeek.accion42();
                            break;
                        }
                        if (caras[7] == 2)//2: face of dragon
                        {
                            if(panelesAUsar[2].getComponentCount()==1)
                            {
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                juegoGeek.accionDragon();
                                break;
                            }
                        }
                        if (caras[7] == 3)//3: face of heart
                        {
                            if (panelesAUsar[0].getComponentCount() == 0) {
                                JOptionPane.showMessageDialog(null, "Choose the die you want to flip its face on.");
                                break;
                            } else {
                                panelesAUsar[2].remove(dado[7]);
                                panelesAUsar[1].add(dado[7]);
                                dado[7].setEnabled(false);
                                dado[7].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                juegoGeek.heartAction(panelesAUsar, dado, dadoImagen, caras);
                                break;
                            }
                        }
                        if (caras[7] == 4)//4: face of hero
                        {
                            if(panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[7]);
                                panelesAUsar[1].add(dado[7]);
                                dado[7].setEnabled(false);
                                dado[7].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Selecciona el dado al cual deseas cambiar su cara");
                                banderAccion=1;
                                poder=4;
                                banderaDado=2;
                                break;
                            }
                        }
                        if (caras[7] == 5)//5: face of meeple
                        {
                            if(panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[7]);
                                panelesAUsar[1].add(dado[7]);
                                dado[7].setEnabled(false);
                                dado[7].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Selecciona el dado que deseas volver a lanzar");
                                banderAccion=1;
                                poder=5;
                                banderaDado=2;
                                break;
                            }
                        }
                        if (caras[7] == 6)//6: face of ship
                        {
                            if(panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[7]);
                                panelesAUsar[1].add(dado[7]);
                                dado[7].setEnabled(false);
                                dado[7].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Selecciona el dado que deseas enviar a la seccion de inactivos");
                                banderAccion=1;
                                poder=6;
                                banderaDado=2;
                                break;
                            }
                        }
                    }
                }
                /*
                 * boton del noveno dado
                 */
                if (e.getSource() == dado[8]) {
                    boolean state = false;
                    while (state == false) {
                        /**
                         * condiciones para las caras del dado
                         */
                        if (caras[8] == 1)//1: face of 42
                        {
                            juegoGeek.accion42();
                            break;
                        }
                        if (caras[8] == 2)//2: face of dragon
                        {
                            if(panelesAUsar[2].getComponentCount()==1)
                            {
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                juegoGeek.accionDragon();
                                break;
                            }
                        }
                        if (caras[8] == 3)//3: face of heart
                        {
                            if (panelesAUsar[0].getComponentCount() == 0) {
                                JOptionPane.showMessageDialog(null, "No hay dados en la seccion de dados inactivos");
                                break;
                            } else {
                                panelesAUsar[2].remove(dado[8]);
                                panelesAUsar[1].add(dado[8]);
                                dado[8].setEnabled(false);
                                dado[8].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                juegoGeek.heartAction(panelesAUsar, dado, dadoImagen, caras);
                                break;
                            }
                        }
                        if (caras[8] == 4)//4: face of hero
                        {
                            if(panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[8]);
                                panelesAUsar[1].add(dado[8]);
                                dado[8].setEnabled(false);
                                dado[8].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Selecciona el dado que deseas girar su cara");
                                banderAccion=1;
                                poder=4;
                                banderaDado=2;
                                break;
                            }
                        }
                        if (caras[8] == 5)//5: face of meeple
                        {
                            if(panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[8]);
                                panelesAUsar[1].add(dado[8]);
                                dado[8].setEnabled(false);
                                dado[8].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Selecciona el dado que deseas volver a lanzar.");
                                banderAccion=1;
                                poder=5;
                                banderaDado=2;
                                break;
                            }

                        }
                        if (caras[8] == 6)//6: face of ship
                        {
                            if(panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[8]);
                                panelesAUsar[1].add(dado[8]);
                                dado[8].setEnabled(false);
                                dado[8].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Seleccioan el dado que deseas mandar a la seccion de inactivos. ");
                                banderAccion=1;
                                poder=6;
                                banderaDado=2;
                                break;
                            }
                        }
                    }
                }
                /*
                 * boton del decimo dado
                 */
                if (e.getSource() == dado[9]) {
                    boolean state = false;
                    while (state == false) {
                        /*
                         * condiciones para las caras del dado
                         */
                        if (caras[9] == 1)//1: face of 42
                        {
                            juegoGeek.accion42();
                            break;
                        }
                        if (caras[9] == 2)//2: face of dragon
                        {
                            if(panelesAUsar[2].getComponentCount()==1)
                            {
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                juegoGeek.accionDragon();
                                break;
                            }
                        }
                        if (caras[9] == 3)//3: face of heart
                        {
                            if (panelesAUsar[0].getComponentCount() == 0) {
                                JOptionPane.showMessageDialog(null, "No hay dados en la seccion de dados inactivos");
                                break;
                            } else {
                                panelesAUsar[2].remove(dado[9]);
                                panelesAUsar[1].add(dado[9]);
                                dado[9].setEnabled(false);
                                dado[9].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                juegoGeek.heartAction(panelesAUsar, dado, dadoImagen, caras);
                                break;
                            }
                        }
                        if (caras[9] == 4)//4: face of hero
                        {
                            if (panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[9]);
                                panelesAUsar[1].add(dado[9]);
                                dado[9].setEnabled(false);
                                dado[9].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Seleeciona el dado que deseas girar su cara");
                                banderAccion=1;
                                poder=4;
                                banderaDado=2;
                                break;
                            }
                        }
                        if (caras[9] == 5)//5: face of meeple
                        {
                            if(panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[9]);
                                panelesAUsar[1].add(dado[9]);
                                dado[9].setEnabled(false);
                                dado[9].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Selecciona el dado que deseas volver a lanzar.");
                                banderAccion=1;
                                poder=5;
                                banderaDado=2;
                                break;
                            }

                        }
                        if (caras[9] == 6)//6: face of ship
                        {
                            if(panelesAUsar[2].getComponentCount() == 1 || panelesAUsar[2].getComponentCount() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "No hay Dados en la seccion de dados.");
                                juegoGeek.youLose(iniciar, dado, panelesAUsar);
                                banderaInicio=0;
                                banderaDado=0;
                                break;
                            }
                            else
                            {
                                panelesAUsar[2].remove(dado[9]);
                                panelesAUsar[1].add(dado[9]);
                                dado[9].setEnabled(false);
                                dado[9].updateUI();
                                panelesAUsar[2].updateUI();
                                panelesAUsar[1].updateUI();
                                JOptionPane.showMessageDialog(null, "Selecciona el dado que deseas enviar a la seccion de inactivos");
                                banderAccion=1;
                                poder=6;
                                banderaDado=2;
                                break;
                            }
                        }
                    }
                }
            }

            /*
             * Do action
             */
            if(banderaDado==2)
            {
                /*
                 * poder del heroe
                 */
                if (poder == 4)
                {
                    /*
                     * dado 1
                     */
                    if (e.getSource() == dado[0] && banderAccion == 0)
                    {
                        juegoGeek.accionHeroe(panelesAUsar, dado, dadoImagen, caras, banderaDado,0);
                        poder = 0;
                        banderaDado = 1;
                    }
                    /*
                     *dado 2
                     */
                    if (e.getSource() == dado[1] && banderAccion == 0) {
                        juegoGeek.accionHeroe(panelesAUsar, dado, dadoImagen, caras, banderaDado,1);
                        poder = 0;
                        banderaDado = 1;
                    }
                    /*
                     * dado 3
                     */
                    if (e.getSource() == dado[2] && banderAccion == 0) {
                        juegoGeek.accionHeroe(panelesAUsar, dado, dadoImagen, caras, banderaDado,2);
                        poder = 0;
                        banderaDado = 1;
                    }
                    /*
                     * dado 4
                     */
                    if (e.getSource() == dado[3] && banderAccion == 0) {
                        juegoGeek.accionHeroe(panelesAUsar, dado, dadoImagen, caras, banderaDado,3);
                        poder = 0;
                        banderaDado = 1;
                    }

                    /*
                     * dado 5
                     */
                    if (e.getSource() == dado[4] && banderAccion == 0) {
                        juegoGeek.accionHeroe(panelesAUsar, dado, dadoImagen, caras, banderaDado,4);
                        poder = 0;
                        banderaDado = 1;
                    }

                    /*
                     * dado 6
                     */
                    if (e.getSource() == dado[5] && banderAccion == 0) {
                        juegoGeek.accionHeroe(panelesAUsar, dado, dadoImagen, caras, banderaDado,5);
                        poder = 0;
                        banderaDado = 1;
                    }

                    /*
                     * dado 7
                     */
                    if (e.getSource() == dado[6] && banderAccion == 0) {
                        juegoGeek.accionHeroe(panelesAUsar, dado, dadoImagen, caras, banderaDado,6);
                        poder = 0;
                        banderaDado = 1;
                    }

                    /*
                     * dado 8
                     */
                    if (e.getSource() == dado[7] && banderAccion == 0) {
                        juegoGeek.accionHeroe(panelesAUsar, dado, dadoImagen, caras, banderaDado,7);
                        poder = 0;
                        banderaDado = 1;
                    }

                    /*
                     * dado 9
                     */
                    if (e.getSource() == dado[8] && banderAccion == 0) {
                        juegoGeek.accionHeroe(panelesAUsar, dado, dadoImagen, caras, banderaDado,8);
                        poder = 0;
                        banderaDado = 1;
                    }

                    /*
                     * dado 10
                     */
                    if (e.getSource() == dado[9] && banderAccion == 0) {
                        juegoGeek.accionHeroe(panelesAUsar, dado, dadoImagen, caras, banderaDado,9);
                        poder = 0;
                        banderaDado = 1;
                    }
                    banderAccion=0;
                }

                /*
                 * poder del meeple
                 */
                if (poder == 5)
                {
                    /*
                     * dado 1
                     */
                    if (e.getSource() == dado[0] && banderAccion == 0)
                    {
                        juegoGeek.accionMeeple(panelesAUsar, dado, dadoImagen, caras, 0);
                        poder = 0;
                        banderaDado = 1;
                    }
                    /*
                     * dado 2
                     */
                    if (e.getSource() == dado[1] && banderAccion == 0) {
                        juegoGeek.accionMeeple(panelesAUsar, dado, dadoImagen, caras, 1);
                        poder = 0;
                        banderaDado = 1;
                    }
                    /*
                     * dado 3
                     */
                    if (e.getSource() == dado[2] && banderAccion == 0) {
                        juegoGeek.accionMeeple(panelesAUsar, dado, dadoImagen, caras, 2);
                        poder = 0;
                        banderaDado = 1;
                    }
                    /*
                     * dado 4
                     */
                    if (e.getSource() == dado[3] && banderAccion == 0) {
                        juegoGeek.accionMeeple(panelesAUsar, dado, dadoImagen, caras, 3);
                        poder = 0;
                        banderaDado = 1;
                    }

                    /*
                     * dado 5
                     */
                    if (e.getSource() == dado[4] && banderAccion == 0) {
                        juegoGeek.accionMeeple(panelesAUsar, dado, dadoImagen, caras, 4);
                        poder = 0;
                        banderaDado = 1;
                    }

                    /*
                     * dado 6
                     */
                    if (e.getSource() == dado[5] && banderAccion == 0) {
                        juegoGeek.accionMeeple(panelesAUsar, dado, dadoImagen, caras, 5);
                        poder = 0;
                        banderaDado = 1;
                    }
                    /*
                     * dado 7
                     */
                    if (e.getSource() == dado[6] && banderAccion == 0) {
                        juegoGeek.accionMeeple(panelesAUsar, dado, dadoImagen, caras, 6);
                        poder = 0;
                        banderaDado = 1;
                    }
                    /*
                     * dado 8
                     */
                    if (e.getSource() == dado[7] && banderAccion == 0) {
                        juegoGeek.accionMeeple(panelesAUsar, dado, dadoImagen, caras, 7);
                        poder = 0;
                        banderaDado = 1;
                    }
                    /*
                     * dado 9
                     */
                    if (e.getSource() == dado[8] && banderAccion == 0) {
                        juegoGeek.accionMeeple(panelesAUsar, dado, dadoImagen, caras, 8);
                        poder = 0;
                        banderaDado = 1;
                    }
                    /*
                     * dado 10
                     */
                    if (e.getSource() == dado[9] && banderAccion == 0) {
                        juegoGeek.accionMeeple(panelesAUsar, dado, dadoImagen, caras, 9);
                        poder = 0;
                        banderaDado = 1;
                    }
                    banderAccion=0;
                }
                /*
                 * poder de la nave espacial
                 */
                if(poder==6)
                {
                    /*
                     * dado 1
                     */
                    if (e.getSource() == dado[0] && banderAccion == 0)
                    {
                        juegoGeek.accionNave(panelesAUsar, dado, 0);
                        poder = 0;
                        banderaDado = 1;
                    }
                    /*
                     * dado 2
                     */
                    if (e.getSource() == dado[1] && banderAccion == 0) {
                        juegoGeek.accionNave(panelesAUsar, dado, 1);
                        poder = 0;
                        banderaDado = 1;
                    }
                    /*
                     * dado 3
                     */
                    if (e.getSource() == dado[2] && banderAccion == 0) {
                        juegoGeek.accionNave(panelesAUsar, dado, 2);
                        poder = 0;
                        banderaDado = 1;
                    }
                    /*
                     * dado 4
                     */
                    if (e.getSource() == dado[3] && banderAccion == 0) {
                        juegoGeek.accionNave(panelesAUsar, dado, 3);
                        poder = 0;
                        banderaDado = 1;
                    }

                    /*
                     * dado 5
                     */
                    if (e.getSource() == dado[4] && banderAccion == 0) {
                        juegoGeek.accionNave(panelesAUsar, dado, 4);
                        poder = 0;
                        banderaDado = 1;
                    }

                    /*
                     * dado 6
                     */
                    if (e.getSource() == dado[5] && banderAccion == 0) {
                        juegoGeek.accionNave(panelesAUsar, dado, 5);
                        poder = 0;
                        banderaDado = 1;
                    }

                    /*
                     * dado 7
                     */
                    if (e.getSource() == dado[6] && banderAccion == 0) {
                        juegoGeek.accionNave(panelesAUsar, dado, 6);
                        poder = 0;
                        banderaDado = 1;
                    }

                    /*
                     * dado 8
                     */
                    if (e.getSource() == dado[7] && banderAccion == 0) {
                        juegoGeek.accionNave(panelesAUsar, dado, 7);
                        poder = 0;
                        banderaDado = 1;
                    }

                    /*
                     * dado 9
                     */
                    if (e.getSource() == dado[8] && banderAccion == 0) {
                        juegoGeek.accionNave(panelesAUsar, dado, 8);
                        poder = 0;
                        banderaDado = 1;
                    }

                    /*
                     * dado 10
                     */
                    if (e.getSource() == dado[9] && banderAccion == 0) {
                        juegoGeek.accionNave(panelesAUsar, dado, 9);
                        poder = 0;
                        banderaDado = 1;
                    }
                    banderAccion=0;
                }
            }

            /*
             * Boton de ayuda
             */
            if(e.getSource()==ayuda)
            {
                JOptionPane.showMessageDialog(null, BEGINNING_MESSAGE);
            }

            /*
             * boton de salida
             */
            if(e.getSource()==salida)
            {
                System.exit(0);
            }
            /*
             * Actualizar cada componente del gestor de interface de usuario GUI
             */
            //Para todos los paneles
            for (JPanel jPanel : panelesAUsar) {
                jPanel.updateUI();
            }
            //para todos los dados
            for (JButton die : dado) {
                die.updateUI();
            }
        }
    }
}




