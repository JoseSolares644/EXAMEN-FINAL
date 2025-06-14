public class Nodo {
    String titulo, artista;
    int duracion;
    Nodo siguiente;

    public Nodo(String titulo, String artista, int duracion){
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.siguiente = null;
    }
}