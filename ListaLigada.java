package quicktest;
import javax.swing.JOptionPane;

public class ListaLigada {
    Nodo cabeza;
    Nodo cola;
    String datos;
    
    //Constructor que crea una lista vacía
    public ListaLigada(){
        cabeza = cola = null;
    }
    
    //Método que verifica si la lista está vacía    
    public boolean listaVacia(){
        return (cabeza == null);
    }
    
    
    public void insertarCabeza(int datoRecibido){
        //Si la lista está vacía, cabeza y cola serán el nuevo nodo
        if(listaVacia())
            cabeza = cola = new Nodo(datoRecibido);
        //Si al menos un elemento, el nuevo nodo a crear apunta a cabeza y
        //la etiqueta de cabeza se actuliza
        else
            cabeza = new Nodo(datoRecibido, cabeza);
    }
        
    
    public void insertarCola(int datoRecibido){
        //Si la lista está vacía, cabeza y cola serán el nuevo nodo
        if(listaVacia())
            cabeza = cola = new Nodo(datoRecibido);
        //Se crea un nuevo nodo que apunta a null, el nodo cola apunta a este nuevo
        //nodo y la variable de cola se actualiza
        else
            cola = cola.siguiente = new Nodo(datoRecibido);
    }
    
    public void insertarOrdenado(int datoRecibido){
        //Si la lista está vacía, cabeza y cola serán el nuevo nodo
        if(listaVacia())
            cabeza = cola = new Nodo(datoRecibido);
        else{
            //Si el dato recibido es el menor de todos, agregarlo al inicio de la lista
            if(datoRecibido < cabeza.info)
                cabeza = new Nodo(datoRecibido, cabeza);
            else{
                Nodo actual = cabeza;
                Nodo anterior = null;
                //Se crean dos nodos auxiliares para ir recorriendo la lista ligada para determinar
                //entre cuales nodos ingresae el nuevo elemento
                while((actual.siguiente != null)  && (datoRecibido > actual.info)){
                    anterior = actual;
                    actual = actual.siguiente;
                }
                //Si el dato a ingresar es el mayor de todos en la lista, se crea un nuevo nodo que apunta
                //a null, la variable de actual apunta a este nuevo nodo que será la nueva cola
                if(datoRecibido > actual.info)
                    cola = actual.siguiente = new Nodo(datoRecibido);
                //De no ser así, el nuevo elemento se crea apuntando a actual y el nodoo anterior apunta 
                //a este nuevo nodo
                else 
                    anterior.siguiente = new Nodo(datoRecibido, actual);
            }
        }
    }
    
    
    public void eliminarCabeza(){
        //Mostrar un mensaje de advertencia si la lista está vacía
        if(listaVacia())
            JOptionPane.showMessageDialog(null,"¡LA LISTA ESTÁ VACÍA!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        else{
            //Si hay un solo elemento, poner la lista vacía
            if(cabeza == cola)
                cabeza = cola = null;
            //Si más de un elemento, modificar la variable de cabeza
            else
                cabeza = cabeza.siguiente;            
        }            
    }
    
    
    public void eliminarCola(){
        //Mostrar un mensaje de advertencia si la lista está vacía
        if(listaVacia())
            JOptionPane.showMessageDialog(null,"¡LA LISTA ESTÁ VACÍA!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        else{
            //Si hay un solo elemento, poner la lista vacía
            if(cabeza == cola)
                cabeza = cola = null;
            else{
                //Si hay más de un elmento, crear un nodo auxiliar que recorra la lista hasta posicionarse
                //justo antes del nodo cola
                Nodo aux = cabeza;
                while(aux.siguiente != cola)
                    aux = aux.siguiente;
                //El nodo auxiliar será la nueva cola, que apunta a null
                aux.siguiente = null;
                cola = aux;
            }
            
        }
    }
    
    
    public void eliminaSeleccionado(int datoRecibido){
        //Crear dos nodos auxiliares para recorrer la lista en busca del nodo a elimiar
        Nodo actual = cabeza;
        Nodo anterior = null;
        while((actual != null)  && (datoRecibido != actual.info)){
            anterior = actual;
            actual = actual.siguiente;
        }
        //Si la lista está vacía o si el nodo con el dato a elimiar no fue encontrado,
        //mostrar un mensaje de error
        if(actual == null)
            JOptionPane.showMessageDialog(null,"EL DATO NO HA SIDO ENCONTRADO", "ERROR", JOptionPane.ERROR_MESSAGE);
        else{
            //Si el nodo a eliminar resulta ser el primero, modificar la cabeza
            if(actual == cabeza)
                cabeza = cabeza.siguiente;
            else{
                //Ignorar (eliminar) el nodo actual, pero si resulta ser la cola, entonsces
                //anteriror será la nueva cola
                anterior.siguiente = actual.siguiente;
                if(actual == cola)
                    cola = anterior;
            }
        }
    }
    
    
    public String imprimir(){
        datos = "";
        //Si la lista está vacía, regresar dicho mensaje
        if(listaVacia())
            datos = "LISTA VACIA";
        else{
            //Recorre todos los elementos de la lista, tomando su parte de info y almacenandola
            //en el String
            Nodo aux = cabeza;
            while(aux != null){
                datos += aux.info + " - ";
                aux = aux.siguiente;
            }
        }
        return datos;
    }
}
