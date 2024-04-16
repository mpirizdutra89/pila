/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pila;



/**
 *
 * @author nn
 */
public class main {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Pila2 pila2=new Pila2(10);
         System.out.println("Pila esta vacia ? -> "+ pila2.pilaVacia());
        System.out.println("Llenado una pila ordenada ");
//pila2.llenarPila();
pila2.llenarPilaOrdenado();
         System.out.println("mostrar Pila");
         pila2.mostarArrayDePila();
         pila2.pushOrdenado(0);
         
        /*Pila pila=new Pila(10);
        System.out.println("Total:"+pila.getCapasidad()+ "\n\n");
        System.out.println("Pila esta vacia ? -> "+ pila.pilaVacia());
        System.out.println("Llenado una pila ");
        pila.llenarPila();
       
        System.out.println("mostrar Pila");
         pila.mostarArrayDePila();
         
        
        System.out.println("\n\n\n");
        
        //System.out.println("Pila ivertir simple");
        //pila.invertirSimple();
        System.out.println("Invertir eficiente");
       // pila.invertirEficiente();
       pila.inviertePila(); 
       
       pila.mostarArrayDePila();*/
        
        
        
        
        
        System.out.println("\n\nPila formula balanciada");
        
      if (balanceada("{2*(4-5)-{3*4}-[4-5]")){
          System.out.println("La formula esta balanciada");
      }else{
           System.out.println("La formula no esta balanciada");
      }
        
    }
    
    
   
    
    public static boolean balanceada(String cadena) {
        
        Pila pila=new Pila(cadena.length());
    	
    	for (int f = 0 ; f < cadena.length() ; f++)
    	{
    	    if (cadena.charAt(f) == '(' || cadena.charAt(f) == '[' || cadena.charAt(f) == '{') {
    	    	pila.push(cadena.charAt(f));
    	    } else {
    	    	if (cadena.charAt(f)==')') {
    	    	    if (pila.pop()!='(') {
    	    	        return false;
    	    	    }
    	     	} else {
    	    	    if (cadena.charAt(f)==']') {
    	    	        if (pila.pop()!='[') {
    	    	            return false;
    	    	        }
    	    	    } else {
    	    	        if (cadena.charAt(f)=='}') {
    	    	            if (pila.pop()!='{') {
    	    	                return false;
    	    	            }
    	    	        }
    	    	    }
    	        }
   	    }   
        }
    	if (pila.pilaVacia()) {
    	    return true;
    	} else {
   	    return false;
    	}
    }	
    
    
    
    
}
