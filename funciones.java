public class funciones {
    Nodo inicio;

    public funciones() {
        this.inicio = null;
    }

    // MÉTODO PARA AGREGAR CANCION.
    public void agregarCancion(String titulo, String artista, int duracion) {
        Nodo nuevo = new Nodo(titulo, artista, duracion);
        nuevo.siguiente = inicio;
        inicio = nuevo;
    }

    // MÉTODO PARA MOSTRAR TODAS LAS CANCIONES.
    public void mostrarCanciones() {
        Nodo recorrer = inicio;
        if (recorrer == null) {
            System.out.println("ERROR: La colección está vacía.");
            return;
        }

        while (recorrer != null) {
            System.out.println("Título canción: " + recorrer.titulo + "Artísta: " + recorrer.artista +"Duracion: " + recorrer.duracions);
            recorrer = recorrer.siguiente;
        }
    }

    // MÉTODO PARA BUSCAR CANCIÓN.
    public Nodo buscarcancion(String titulo) {
        Nodo buscar = inicio;
        while (buscar != null) {
            if (buscar.titulo.equalsIgnoreCase(titulo)) {
                return buscar;
            }
            buscar = buscar.siguiente;
        }
        return null;
    }

    // MÉTODO PARA ELIMINAR CANCION.
    public boolean eliminarCancion(String titulo) {
        if (inicio ==  null) return false;
        if (inicio.titulo.equalsIgnoreCase(titulo)) {
            return true;
        }

        Nodo anterior = inicio;
        Nodo actual = inicio.siguiente;
        while (actual != null) {
            if (actual.titulo.equalsIgnoreCase(titulo)) {
                anterior.siguiente = actual.siguiente;
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return false;
    }
}