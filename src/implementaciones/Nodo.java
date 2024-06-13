package implementaciones;

public class Nodo 
{
    int info;
    Nodo izq, der; // izquierdo y derecho

    public Nodo(int dato) 
    {
        info = dato;
        izq = der = null;
    }
}
