package pila;

/**
 *
 * @author nn
 */
public class Pila {
   private int capasidad;
   private char[] pila;
   private int tope=-1;
   
   
    public Pila(int n){
        capasidad=n;
       pila= new char[capasidad];
    }
    
    
    public int getTope() {
        return tope;
    }

    public int getCapasidad() {
        return capasidad;
    }

  
    
   
    public void push(char num){
        if(tope<capasidad-1){
            tope=tope+1;
            pila[tope]=num;
            
        }else{
            System.out.println("La estructura esta completa, no se puede insertar");
        }
    }
    
    public char pop() {
        char elemento ='1';
        if (!pilaVacia()) {
            elemento = pila[tope];
            tope = tope - 1;

        } else {
            System.out.println("La estructura esta vacia, no se puede eliminar");

        }
        return elemento;
    }
    
    public char verElemento(){
        System.out.println("metodo ver elemento->"+pila[tope]);
        return pila[tope];
    }
    
    public boolean pilaVacia(){
        return tope==-1;
    }
    public boolean pilaLlena(){
        return  tope!=capasidad-1;
    }
    
    public void mostarArrayDePila(){
       
        for (int i = tope; i > -1; i--) {
            System.out.println("pila:"+pila[i]+" | pos:"+i);
        }
       
         
    }
    
    public void llenarPila(){
        int i=0; 
        System.out.println(pilaLlena());
        while(pilaLlena()){
           
          //   push(i++);
         }
    }
     // Método para invertir la pila usando dos pilas auxiliares
    public void invertirSimple(){
        Pila pilaAux1=new Pila(capasidad);
        Pila pilaAux2=new Pila(capasidad);
        //pila original a la aux1
        while(!pilaVacia()){
            pilaAux1.push(pop());
        }
        
          //pila aux1 a la aux2
        while(!pilaAux1.pilaVacia()){
          pilaAux2.push(pilaAux1.pop());
        }
        
           //pila aux2 a la original
        while(!pilaAux2.pilaVacia()){
            push(pilaAux2.pop());
        }
        
        
    }
    /*
   
   //para que funcion tiene que ser un 
   public void invertirEficiente() {
        Pila pilaAux1 = new Pila(capasidad);
        int valor;
        for(int i=0;i<this.tope;i++){
            valor=this.verElemento();
            this.pop();
            while((this.tope-i)>=0){
                pilaAux1.push(this.pop());
            }
            this.push(valor);
            while(!pilaAux1.pilaVacia()){
                this.push(pilaAux1.pop());
            }
        }
       
      

    }
    
    /*
      private void invertirRecursivamente(int elemento) {
         if (pilaVacia()) {
            push(elemento); 
        } else {
            int temp = pop();
            invertirRecursivamente(elemento); 
            push(temp);
        }
    }

    
    public void inviertePila() {
        if (!pilaVacia()) {
            int temp = pop(); 
            inviertePila();
            invertirRecursivamente(temp); 
        }
    }*/
    
    
    
    
}
