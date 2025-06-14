public class Playlist {
    String nombre;
    funciones cancion;
    Playlist siguiente;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.cancion = new funciones();
        this.siguiente = null;
    }
}