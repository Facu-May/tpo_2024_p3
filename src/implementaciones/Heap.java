package implementaciones;

// heap -> estructura de datos de tipo árbol
// cada nodo padre es mayor (max-heap) o menor (min-heap) que sus hijos
public class Heap 
{
    Nodo raiz; // nodo raíz del árbol

    // inicialización
    public Heap() 
    {
        raiz = null;
    }

    public void insertar(int dato)
    {
        raiz = insertarRec(raiz, dato);
    }

    private Nodo insertarRec(Nodo nodo, int dato)
    {
        if (nodo == null)
        {
            // si el árbol está vacío, creamos un nuevo nodo y lo retornamos
            nodo = new Nodo(dato);
            return nodo;
        }
        // Si el nodo no es nulo, insertamos recursivamente en el subárbol izquierdo o derecho, dependiendo si el dato es mayor (subárbol izquierdo) o menor (subárbol derecho) que la raíz (nodo actual)
        if(dato > raiz.info)
        {
            raiz.izq = insertarRec(raiz.izq, dato);
        }
        else
        {
            raiz.der = insertarRec(raiz.der, dato);
        }
        // luego de la inserción recursiva, verificamos si la propiedad de heap se mantiene ()
        if(raiz.izq != null && raiz.izq.info > raiz.info)
        {
            // si no se cumple, hacemos un intercambio
            int temp = raiz.info;
            raiz.info = raiz.izq.info;
            raiz.izq.info = temp;
        }
        if(raiz.der != null && raiz.der.info > raiz.info)
        {
            // si no se cumple, hacemos un intercambio
            int temp = raiz.info;
            raiz.info = raiz.der.info;
            raiz.der.info = temp;
        }
        // retornamos el nodo actual
        return nodo;
    }
    public void eliminar() // eli
    {
        
    }
}