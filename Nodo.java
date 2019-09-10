package quicktest;

public class Nodo {
    int info;
    Nodo siguiente;
    
    //constructor que crea un nodo que apunta a null
    public Nodo(int datoRecibido){
        info = datoRecibido;
        siguiente = null;
    }
    
    //constructor que crea un nodo que a su vez apunta a otro nodo    
    public Nodo(int datoRecibido, Nodo nodoRecibido){
        info = datoRecibido;
        siguiente = nodoRecibido;
    }
}
