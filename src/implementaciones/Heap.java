package implementaciones;

// heap -> estructura de datos de tipo árbol
// cada nodo padre es mayor (max-heap) o menor (min-heap) que sus hijos
public class Heap 
{
    Nodo raiz; // nodo raíz del árbol
    Nodo ultimoNodo; // nodo hoja más a la derecha

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
            ultimoNodo = nodo; // el último nodo es el nodo recién creado
            return nodo;
        }
        // Si el nodo no es nulo, insertamos recursivamente en el subárbol izquierdo o derecho, dependiendo si el dato es mayor (subárbol izquierdo) o menor (subárbol derecho) que la raíz (nodo actual)
        if(dato > nodo.info)
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
     // eliminacion de elemento máximo (max-heap) o mínimo (min-heap)
    public void eliminar() 
    {
        if (raiz == null) 
        {
            System.out.println("El heap está vacío.");
            return;
        }
    
        // Paso 1: Reemplazar la raíz con el último nodo
        raiz.info = ultimoNodo.info;
    
        // Paso 2: Eliminar el último nodo
        Nodo penultimo = obtenerPenultimoNodo(); // Encuentra el penúltimo nodo
        if (penultimo.der == ultimoNodo) 
        {
            penultimo.der = null;
        } 
        else 
        {
            penultimo.izq = null;
        }
        ultimoNodo = penultimo;
    
        // Paso 3: Restaurar la propiedad del heap (hundir la raíz)
        hundir(raiz);
    }
    
    // Método auxiliar para encontrar el penúltimo nodo
    private Nodo obtenerPenultimoNodo() {
        Nodo actual = raiz;
        while (actual.izq != ultimoNodo && actual.der != ultimoNodo) 
        {
            if (ultimoNodo.info > actual.info) 
            {
                actual = actual.izq;
            } 
            else 
            {
                actual = actual.der;
            }
        }
        return actual;
    }
    
    // Método auxiliar para restaurar la propiedad del heap (hundir un nodo)
    private void hundir(Nodo nodo) {
        Nodo hijoMayor = nodo;
        if (nodo.izq != null && nodo.izq.info > nodo.info) 
        {
            hijoMayor = nodo.izq;
        }
        if (nodo.der != null && nodo.der.info > hijoMayor.info) 
        {
            hijoMayor = nodo.der;
        }
    
        if (hijoMayor != nodo) 
        {
            // Intercambiar el nodo con su hijo mayor
            int temp = nodo.info;
            nodo.info = hijoMayor.info;
            hijoMayor.info = temp;
    
            // Recursivamente hundir el hijo mayor
            hundir(hijoMayor);
        }
    }
    

    public Nodo getUltimoNodo()
    {
        return ultimoNodo;
    }
}