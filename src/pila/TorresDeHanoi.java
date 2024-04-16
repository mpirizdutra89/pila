/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pila;

/**
 *
 * @author nn
 */
public class TorresDeHanoi {
     private Pila2 pilarInicial;
    private Pila2 pilarAuxiliar;
    private Pila2 pilarFinal;
    private int numMovimientos = 0;

    public TorresDeHanoi(int numDiscos) {
        pilarInicial = new Pila2(numDiscos);
        pilarAuxiliar = new Pila2(numDiscos);
        pilarFinal = new Pila2(numDiscos);

        // Llenar el pilar inicial con los discos en orden descendente
        for (int i = numDiscos; i >= 1; i--) {
            pilarInicial.push(Pila2.aleatorios2());
        }
    }

    public void resolver() {
        moverDiscos(pilarInicial.getCapasidad(), pilarInicial, pilarAuxiliar, pilarFinal);
    }

    private void moverDiscos(int numDiscos, Pila2 origen, Pila2 auxiliar, Pila2 destino) {
        if (numDiscos == 1) {
            moverDisco(origen, destino);
        } else {
            moverDiscos(numDiscos - 1, origen, destino, auxiliar);
            moverDisco(origen, destino);
            moverDiscos(numDiscos - 1, auxiliar, origen, destino);
        }
    }

    private void moverDisco(Pila2 origen, Pila2 destino) {
        int disco = origen.pop();
        destino.push(disco);
        numMovimientos++;
        System.out.println("Movimiento " + numMovimientos + ": Mover disco " + disco + " de " + obtenerNombrePilar(origen) + " a " + obtenerNombrePilar(destino));
    }

    private String obtenerNombrePilar(Pila2 pilar) {
        if (pilar.equals(pilarInicial)) {
            return "Pilar Inicial";
        } else if (pilar.equals(pilarAuxiliar)) {
            return "Pilar Auxiliar";
        } else {
            return "Pilar Final";
        }
    }

    public static void main(String[] args) {
        int numDiscos = 3; // Número de discos
        TorresDeHanoi juego = new TorresDeHanoi(numDiscos);
        System.out.println("Estado inicial:");
        juego.mostrarPilares();
        juego.resolver();
        System.out.println("Numero total de movimientos: " + juego.numMovimientos);
        juego.mostrarPilares();
    }

    private void mostrarPilares() {
        System.out.println("Pilar Inicial:");
        pilarInicial.mostarArrayDePila();
        System.out.println("Pilar Auxiliar:");
        pilarAuxiliar.mostarArrayDePila();
        System.out.println("Pilar Final:");
        pilarFinal.mostarArrayDePila();
    }
}
