/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package solucionparque;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class SolucionParque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Parque parque = new Parque();
        IncrementaHilo[] incrementaHilos = new IncrementaHilo[10];
        DecrementaHilo[] decrementaHilos = new DecrementaHilo[10];

        // 10 hilos para incrementar y 10 para decrementar corresponden con las puertas del parque
        for (int i = 0; i < 10; i++) {
            incrementaHilos[i] = new IncrementaHilo(parque);
            decrementaHilos[i] = new DecrementaHilo(parque);

            incrementaHilos[i].start(); //ejecuta el metodo run del thread
            decrementaHilos[i].start();//ejecuta el metodo run del thread

            try {
                incrementaHilos[i].join();
                decrementaHilos[i].join();
            } catch (InterruptedException e) {
                System.out.println("Error:" + e);
            }
        }
        parque.entradas();
        parque.salidas();
        // System.out.println("Visitantes en el parque:"+parque.getNumVisitantes());
        System.out.println("FIN DE LA EJECUCIÓN");

    }
}
