/*

echo "# EXAMEN-FINAL" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/JoseSolares644/EXAMEN-FINAL.git
git push -u origin main

*/



import java.util.Scanner;

public class inicio {
    public static Scanner scanner = new Scanner(System.in);
    public static GestorPlaylist gestor = new GestorPlaylist();
    public static Playlist playlistActual = null;

    public static void main(String[] args) {
        limpiarPantalla();
        String opcion = "0";

        do {
            System.out.println("------ M E N Ú ------");
            System.out.println("1. Crear Playlists.");
            System.out.println("2. Usar Playlists.");
            System.out.println("3. Mostrar Playlists.");
            System.out.println("4. Salir Del Programa..");
            System.out.println("Ingrese opción: ");
            opcion = scanner.nextLine();
        
            if (opcion.matches("\\+?\\d+")) {
                switch (opcion) {
                    case "1":
                        limpiarPantalla();
                        crearPlaylist1();
                    break;
                    case "2":
                        limpiarPantalla();
                        buscarPlaylist1();
                    break;
                    case "3":
                        limpiarPantalla();
                        gestor.mostrarPlaylist();
                    break;
                    case "4":
                        limpiarPantalla();
                        System.out.println("------Saliste del programa ------");
                    break;
                    default:
                        limpiarPantalla();
                        System.out.println("ERROR: Ingresa un número entero entre 1 y 4.");
                    break;
                }
            } else {
                limpiarPantalla();
                System.out.println("ERROR: Ingresa número entero.");
            }
        } while (!opcion.equals("4"));
    }



    // MÉTODO PARA CREAR PLAYLIST.
    public static void crearPlaylist1() {
        String nombrePlaylist;

        System.out.println("Nomnbre de nueva Playlist: ");
        nombrePlaylist = scanner.nextLine();
        limpiarPantalla();

        gestor.crearPlaylist(nombrePlaylist);

        System.out.println("Playlist agregada con éxito!");
    }

    // MÉTODO PARA BUSCAR PLAYLIST.
    public static void buscarPlaylist1() {
        String usarPlaylist;

        System.out.println("Nombre Playlist a utilizar: ");
        usarPlaylist = scanner.nextLine();
        limpiarPantalla();

        playlistActual = gestor.buscarPlaylist(usarPlaylist);

        if (playlistActual == null) {
            limpiarPantalla();
            System.out.println("ERROR: Playlist no encontrada.");
            return;
        } else {
            limpiarPantalla();
            System.out.println("Playlist seleccionada: " + playlistActual.nombre);
        }

        // MENÚ 2
        String opcion = "0";

        do {
            System.out.println("------ M E N Ú ------");
            System.out.println("1. Agregar canciones.");
            System.out.println("2. Mostrar todas las canciones.");
            System.out.println("3. Buscar canciones.");
            System.out.println("4. Elimminar canciones.");
            System.out.println("5. Salir a menú principal.");
            System.out.println("Ingrese opción: ");
            opcion = scanner.nextLine();

            if (opcion.matches("\\+?\\d+")) {
                switch (opcion) {
                    case "1":
                        limpiarPantalla();
                        agregarCancion2();
                    break;
                    case "2":
                        limpiarPantalla();
                        playlistActual.cancion.mostrarCanciones();
                    break;
                    case "3":
                        limpiarPantalla();
                        buscarCancion2();
                    break;
                    case "4":
                        limpiarPantalla();
                        eliminarCancion2();
                    break;
                    case "5":
                    break;
                    default:
                        limpiarPantalla();
                        System.out.println("ERROR: Ingrese número entero entre 1 y 5");
                    break;
                }
            } else {
                limpiarPantalla();
                System.out.println("ERROR: Ingresa número entero.");
            }
        } while (!opcion.equals("5"));
    }

    // MÉTODO PARA AGREGAR CANCION.
    public static void agregarCancion2() {
        String titulo, artista;
        int duracion;

        if (playlistActual == null) {
            limpiarPantalla();
            System.out.println("ERROR: Selecciona una playlist.");
            return;
        }

        System.out.println("Título canción: ");
        titulo = scanner.nextLine();
        limpiarPantalla();

        System.out.println("Artísta: ");
        artista = scanner.nextLine();
        limpiarPantalla();

        System.out.println("Duración: ");
        duracion = scanner.nextInt();
        limpiarPantalla();


        playlistActual.cancion.agregarCancion(titulo, artista, duracion);
        System.out.println("Canción agregado con éxito!");
    }

    // MÉTODO PARA BUSCAR CANCION.
    public static void buscarCancion2() {
        String buscarTitulo;

        if (playlistActual == null) {
            limpiarPantalla();
            System.out.println("ERROR: Seleccione una playlist.");
            return;
        }

        System.out.println("Titulo de canción: ");
        buscarTitulo = scanner.nextLine();
        limpiarPantalla();

        Nodo encontrado = playlistActual.cancion.buscarcancion(buscarTitulo);
        if (encontrado != null) {
            System.out.println("Canción encontrada.");
        } else {
            System.out.println("Canción no encontrada.");
        }
    }

    // MÉTODO ELIMINAR CANCION.
    public static void eliminarCancion2() {
        String eliminarTitulo;

        if (playlistActual == null) {
            limpiarPantalla();
            System.out.println("ERROR: Seleccione ina playlist.");
            return;
        }

        System.out.println("Título canción a eliminar: ");
        eliminarTitulo = scanner.nextLine();
        limpiarPantalla();

        boolean eliminado = playlistActual.cancion.eliminarCancion(eliminarTitulo);
        System.out.println(eliminado ? "Canción eliminada con éxito!" : "ERROR: No se encontró la canción.");
    }

    // MÉTODO PARA LIMPIAR PANTALLA.
    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    /*letra.matches("[\\p{L}]+");

    if (scanner.hasNextInt()) {
        paginas = scanner.nextInt();
    }*/
}