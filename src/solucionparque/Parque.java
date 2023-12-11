/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solucionparque;

import java.util.Arrays;

class Parque {

    // atributos
    private int numVisitantes; //sección crítica. Van a acceder varios threads de forma concurrente a este valor para lectura y modificación
    private final int maximo;  // en este caso se ha establecido en 50
    private int[] entran; //indica los visitantes que salen por la puerta 0 hasta 9 - maximo 10 por cada puerta
    private int[] salen; //indica los visitantes que salen por las puertas. No hay un máximo por cada puerta

    /**
     * constructor
     */
    public Parque() {
        numVisitantes = 0; //inicialmente parque está vacío
        maximo = 50;
        entran = new int[10]; //10 puertas, se puede poner como define si se desea
        salen = new int[10];

    }

    public int getNumVisitantes() {
        return this.numVisitantes;
    }

    public void entradas() {
        System.out.println("Las entradas han sido");
        System.out.println(Arrays.toString(entran));
    }

    public void salidas() {
        System.out.println("Las salidas han sido");
        System.out.println(Arrays.toString(salen));
    }

    public synchronized void incrementa(int puerta) {
        while (numVisitantes == maximo) {
            try {
                // System.out.println("------------Parque lleno---------------");
                wait();
            } catch (InterruptedException e) {
                System.out.println("Error:" + e);
            }

        }
        numVisitantes++;
        entran[puerta] = entran[puerta] + 1;
        System.out.println(" + ENTRA" + " + numero de visitantes " + this.getNumVisitantes() + " puerta: " + puerta);

        notifyAll();// Notifica a todos los hilos en espera

    }

    /**
     * Método sincronizado: salida de un visitante del parque.
     */
    public synchronized void decrementa(int puerta) {
        // Espera si el parque está vacío
        while (0 == numVisitantes) { //si el parque está vacío
            try {
                wait(); //espera
            } catch (InterruptedException e) {
                System.out.println("Error:" + e);
            }

        }

        //si hay algún visitante en el parque puede salir.
        // Decrementa el número de visitantes y registra la salida
        numVisitantes--;
        salen[puerta] = salen[puerta] + 1;
        System.out.println(" - SALE " + "- numero de visitantes: " + this.getNumVisitantes() + " puerta: " + puerta);

        // Notifica a todos los hilos en espera
        notifyAll();
    }
}
