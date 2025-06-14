public class GestorPlaylist {
    Playlist inicio;

    public GestorPlaylist() {
        this.inicio = null;
    }

    // MÉTODO PARA CREAR PLAYLIST.
    public void crearPlaylist(String nombre) {
        Playlist nuevo = new Playlist(nombre);

        if (inicio == null) {
            inicio = nuevo;
        } else {
            Playlist recorrer = inicio;
            while (recorrer.siguiente != null) {
                recorrer = recorrer.siguiente;
            }
            recorrer.siguiente = nuevo;
        }
    }

    // MÉTODO PARA BUSCAR PLAYLIST.
    public Playlist buscarPlaylist(String nombre) {
        Playlist buscar = inicio;
        while (buscar != null) {
            if (buscar.nombre.equalsIgnoreCase(nombre)) return buscar;
            buscar = buscar.siguiente;
        }
        return null;
    }

    // MÉTODO PARA MOSTRAR PLAYLIST.
    public void mostrarPlaylist() {
        if (inicio == null) {
            System.out.println("ERROR: No hay playlists disponibles.");
            return;
        }

        Playlist recorrer = inicio;
        System.out.println("Lista de playlists: ");
        while (recorrer != null) {
            recorrer = recorrer.siguiente;
        }
    }
}