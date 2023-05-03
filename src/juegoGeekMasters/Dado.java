package juegoGeekMasters;

import java.util.Random;

/**
 * clase dado
 * lanza una cara al azar de las 6 disponibles
 */
public class Dado {
    private int cara;

    public int getCara() {
        Random aleatorio = new Random();
        cara = aleatorio.nextInt(6)+1;
        return cara;
    }
}
