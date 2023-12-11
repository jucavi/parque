/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solucionparque;

class IncrementaHilo extends Thread {

    private Parque parque;

    /**
     * Constructor
     *
     * @param parque Objeto Parque
     */
    public IncrementaHilo(Parque parque) {
        this.parque = parque;

    }

    /**
     * Método run del hilo.
     */
    @Override
    public void run() {   //el parque no está vacío
        for (int i = 0; i < 10; i++) {
            parque.incrementa(i);
        }
    }
}
