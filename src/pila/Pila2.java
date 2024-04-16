/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pila;
import java.util.Random;
/**
 *
 * @author nn
 */
public class Pila2 {

    private int capasidad;
    private int[] pila;
    private int tope = -1;
    private static Random rand = new Random();
    public Pila2(int n) {
        capasidad = n;
        pila = new int[capasidad];
    }

    public int getTope() {
        return tope;
    }

    public int getCapasidad() {
        return capasidad;
    }

    public void push(int num) {
        if (tope < capasidad - 1) {
            tope = tope + 1;
            pila[tope] = num;

        } else {
            System.out.println("La estructura esta completa, no se puede insertar");
        }
    }

    public int pop() {
        int elemento = -1;
        if (!pilaVacia()) {
            elemento = pila[tope];
            tope = tope - 1;

        } else {
            System.out.println("La estructura esta vacia, no se puede eliminar");

        }
        return elemento;
    }

    public int verElemento() {
        System.out.println("metodo ver elemento->" + pila[tope]);
        return pila[tope];
    }

    public boolean pilaVacia() {
        return tope == -1;
    }

    public boolean pilaLlena() {
        return tope != capasidad - 1;
    }

    public void mostarArrayDePila() {

        for (int i = tope; i > -1; i--) {
            System.out.println("pila:" + pila[i] + " | pos:" + i);
        }

    }

    public void llenarPila() {
        int i = 0;
        System.out.println(pilaLlena());
        while (pilaLlena()) {

               push(aleatorios());
        }
    }
      public void llenarPilaOrdenado() {
        int i = 0;
        System.out.println(pilaLlena());
        while (pilaLlena()) {

               pushOrdenado(aleatorios());
        }
    }
    
    // Método para invertir la pila usando dos pilas auxiliares

    public void invertirSimple() {
        Pila2 pilaAux1 = new Pila2(capasidad);
        Pila2 pilaAux2 = new Pila2(capasidad);
        //pila original a la aux1
        while (!pilaVacia()) {
            pilaAux1.push(pop());
        }

        //pila aux1 a la aux2
        while (!pilaAux1.pilaVacia()) {
            pilaAux2.push(pilaAux1.pop());
        }

        //pila aux2 a la original
        while (!pilaAux2.pilaVacia()) {
            push(pilaAux2.pop());
        }

    }
    
     public void invertirEficiente() {
        Pila2 pilaAux1 = new Pila2(capasidad);
        int valor;
        for (int i = 0; i < this.tope; i++) {
            valor = this.verElemento();
            this.pop();
            while ((this.tope - i) >= 0) {
                pilaAux1.push(this.pop());
            }
            this.push(valor);
            while (!pilaAux1.pilaVacia()) {
                this.push(pilaAux1.pop());
            }
        }

    }
     
     public void pushOrdenado(int num) {
        Pila2 pilaAux = new Pila2(capasidad);

        // Mover elementos mayores al elemento nuevo a la pila auxiliar
        while (!pilaVacia() && pila[tope] > num) {
            pilaAux.push(pop());
        }

        // Insertar el nuevo elemento en su posición correcta
        push(num);

        // Devolver los elementos movidos de vuelta a la pila original
        while (!pilaAux.pilaVacia()) {
            push(pilaAux.pop());
        }
    }
    
     public static  int aleatorios(){
        return rand.nextInt(100);
    }
     public static  int aleatorios2(){
        return rand.nextInt(100);
    }
}
