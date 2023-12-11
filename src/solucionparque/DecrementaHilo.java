/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solucionparque;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
/**
 *
 * @author angela PSP 2023-2024
 */
class DecrementaHilo extends Thread {

    private Parque parque;

    /**
     * Constructor
     *
     * @param parque
     */
    public DecrementaHilo(Parque parque) {
        this.parque = parque;

    }

    /**
     * Método run del hilo.
     */
    @Override
    public void run() {         //el parque no está vacío
        for (int i = 0; i < 10; i++) {                  //saca 10 visitantes del parque
            int puerta = (int) (Math.random() * 10); //salida por puerta aleatoria
            parque.decrementa(puerta);
        }
    }
}
