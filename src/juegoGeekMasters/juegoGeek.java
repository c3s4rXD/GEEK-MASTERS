package juegoGeekMasters;

import javax.swing.*;
import java.util.Objects;
import java.util.Random;


/**
 * @autores Cesar Mauricio Hincapie Lopez 2228820-2724 / Carlos Fernando Drada Hincapie
 * @version v.2.0.0
 * fecha: mayo / 5 / 2023
 */

public class juegoGeek {

    //[]= alt + 91

    private Dado[]  dado;
    private int[] caras;

    /*
     *arreglo para asignacion de valores de las caras
     */
    public juegoGeek(){
        dado=new Dado[10];

        dado[0]=new Dado();
        dado[1]=new Dado();
        dado[2]=new Dado();
        dado[3]=new Dado();
        dado[4]=new Dado();
        dado[5]=new Dado();
        dado[6]=new Dado();
        dado[7]=new Dado();
        dado[8]=new Dado();
        dado[9]=new Dado();

        caras=new int[10];


    }
    /*
     * Metodo para asignar la cara visible del dado
     */
    public void caraDeterminada()
    {
        caras[0]=dado[0].getCara();
        caras[1]=dado[1].getCara();
        caras[2]=dado[2].getCara();
        caras[3]=dado[3].getCara();
        caras[4]=dado[4].getCara();
        caras[5]=dado[5].getCara();
        caras[6]=dado[6].getCara();
        caras[7]=dado[7].getCara();
        caras[8]=dado[8].getCara();
        caras[9]=dado[9].getCara();
    }

    /*
     * metodo de perdiste
     */
    public void youLose(JButton playButton, JButton[] ArregloDado, JPanel[] ArregloPanels)
    {
        JOptionPane.showMessageDialog(null, "no obtuviste puntos en esta ronda, mejor suerte para la proxima");
        for(int i=0; i < ArregloDado.length; i++)
        {
            ArregloPanels[0].removeAll();
            ArregloPanels[1].removeAll();
            ArregloPanels[2].add(ArregloDado[i]);
            ArregloDado[i].setEnabled(false);
            ArregloPanels[0].updateUI();
            ArregloPanels[1].updateUI();
            ArregloPanels[2].updateUI();
            ArregloDado[i].updateUI();
        }
        playButton.setEnabled(true);
    }

    /*
     * metodo de ganaste
     */
    public void youWin(JButton playButton, JButton[] ArregloDado, JPanel[] ArregloPanels)
    {
        for(int i=0; i < ArregloDado.length; i++)
        {
            ArregloPanels[0].removeAll();
            ArregloPanels[1].removeAll();
            ArregloPanels[2].add(ArregloDado[i]);
            ArregloDado[i].setEnabled(false);
            ArregloPanels[0].updateUI();
            ArregloPanels[1].updateUI();
            ArregloPanels[2].updateUI();
            ArregloDado[i].updateUI();
        }
        playButton.setEnabled(true);
    }


    /**
     *  42: si te sale esta cara te sumara puntos para ganar
     */
    public void accion42()
    {
        JOptionPane.showMessageDialog(null, "esta cara del dado te dara puntos para ganar");
    }

    /**
     * Dragon: si te sale esta cara quitara los puntos que hayas obtenido en la ronda
     */
    public void accionDragon()
    {
        JOptionPane.showMessageDialog(null, "esta cara del dado te quitara los puntos obtenidos en tu ronda");
    }




    /**
     * Corazón: te permite tomar un dado de la sección de dados inactivos y tirarlo para convertirlo en un nuevo dado activo.
     */
    public void heartAction(JPanel[] ArregloPanel, JButton[] ArregloDado, ImageIcon AImageIcon,  int[] ArregloCaras)
    {
        Random aleatorio = new Random();
        JOptionPane.showMessageDialog(null,"Se volverá a lanzar un dado desde la sección de dados inactivos.");
        for(int i=0; i < ArregloPanel.length; i++)
        {
            if(!ArregloPanel[i].isEnabled())
            {
                ArregloDado[i].setIcon(null);
                ArregloCaras[i] = aleatorio.nextInt(6) + 1;
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + ArregloCaras[i] + ".jpg")));
                ArregloDado[i].setIcon(AImageIcon);
                ArregloPanel[0].remove(ArregloPanel[i]);
                ArregloPanel[2].add(ArregloPanel[i]);
                ArregloDado[i].setEnabled(true);
                ArregloDado[i].updateUI();
                ArregloPanel[0].updateUI();
                ArregloPanel[1].updateUI();
                ArregloPanel[2].updateUI();
                break;
            }
        }
    }



    /**
     * Héroe: Permite dar la vuelta a cualquier dado no utilizado (sección de dados activa) y colocarlo en su lado opuesto.
     */
    public void accionHeroe(JPanel[] ArregloPanel, JButton[] ArregloDado, ImageIcon AImageIcon, int[] ArregloCaras, int bandera, int numeroDado)
    {
        boolean estado=false;
        while (estado==false){
            if (ArregloCaras[numeroDado] == 1) {
                ArregloCaras[numeroDado] = 3;
                ArregloDado[numeroDado].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + ArregloCaras[numeroDado] + ".jpg")));
                ArregloDado[numeroDado].setIcon(AImageIcon);
                ArregloDado[numeroDado].updateUI();
                ArregloPanel[2].updateUI();
                break;
            }
            if (ArregloCaras[numeroDado] == 2) {
                ArregloCaras[numeroDado] = 4;
                ArregloDado[numeroDado].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + ArregloCaras[numeroDado] + ".jpg")));
                ArregloDado[numeroDado].setIcon(AImageIcon);
                ArregloDado[numeroDado].updateUI();
                ArregloPanel[2].updateUI();
                break;
            }
            if (ArregloCaras[numeroDado] == 3) {
                ArregloCaras[numeroDado] = 1;
                ArregloDado[numeroDado].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + ArregloCaras[numeroDado] + ".jpg")));
                ArregloDado[numeroDado].setIcon(AImageIcon);
                ArregloDado[numeroDado].updateUI();
                ArregloPanel[2].updateUI();
                break;
            }
            if (ArregloCaras[numeroDado] == 4) {
                ArregloCaras[numeroDado] = 2;
                ArregloDado[numeroDado].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + ArregloCaras[numeroDado] + ".jpg")));
                ArregloDado[numeroDado].setIcon(AImageIcon);
                ArregloDado[numeroDado].updateUI();
                ArregloPanel[2].updateUI();
                break;
            }
            if (ArregloCaras[numeroDado] == 5) {
                ArregloCaras[numeroDado] = 6;
                ArregloDado[numeroDado].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + ArregloCaras[numeroDado] + ".jpg")));
                ArregloDado[numeroDado].setIcon(AImageIcon);
                ArregloDado[numeroDado].updateUI();
                ArregloPanel[2].updateUI();
                break;
            }
            if (ArregloCaras[numeroDado] == 6) {
                ArregloCaras[numeroDado] = 5;
                ArregloDado[numeroDado].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + ArregloCaras[numeroDado] + ".jpg")));
                ArregloDado[numeroDado].setIcon(AImageIcon);
                ArregloDado[numeroDado].updateUI();
                ArregloPanel[2].updateUI();
                break;
            }
        }
    }



    /**
     * Meeple: Te permite volver a tirar otro dado en juego, es decir, desde la sección de dados activos.
     */
    public void accionMeeple(JPanel[] ArregloPanel,JButton[] ArregloDado, ImageIcon AImageIcon, int[] ArregloCaras, int numeroDado)
    {
        Random aleatorio=new Random();
        ArregloCaras[numeroDado]= aleatorio.nextInt(6)+1;
        ArregloDado[numeroDado].setIcon(null);
        AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + ArregloCaras[numeroDado] + ".jpg")));
        ArregloDado[numeroDado].setIcon(AImageIcon);
        ArregloDado[numeroDado].updateUI();
        ArregloPanel[2].updateUI();
    }



    /**
     * Nave: Este dado envía un dado sin usar (de la sección de dados activos) a la sección de dados inactivos.
     */
    public void accionNave(JPanel[] ArregloPanel, JButton[] ArregloDado, int numeroDado)
    {
        ArregloPanel[2].remove(ArregloDado[numeroDado]);
        ArregloPanel[0].add(ArregloDado[numeroDado]);
        ArregloDado[numeroDado].setEnabled(false);
        ArregloPanel[2].updateUI();
        ArregloPanel[0].updateUI();
        ArregloDado[numeroDado].updateUI();
    }

    /**
     * @return valor de las caras
     */
    public int[] getCaras()
    {
        return caras;
    }




}
