import java.util.ArrayList;

public class CatalogoBiblioteca {
    private ArrayList<Libro> listaLibros = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
    }

    public Libro buscarPorIsbn(String isbn) throws LibroNoEncontradoException {
        for (Libro l : listaLibros) {
            if (l.getIsbn().equalsIgnoreCase(isbn)) {
                return l;
            }
        }
        throw new LibroNoEncontradoException("No se encontró ningún libro registrado con el ISBN: " + isbn);
    }

    public static void main(String[] args) {
        CatalogoBiblioteca catalogo = new CatalogoBiblioteca();

        catalogo.agregarLibro(new Libro("Ficciones", "9789500400011", 3));
        catalogo.agregarLibro(new Libro("El Aleph", "9789500400022", 2));
        catalogo.agregarLibro(new Libro("Bestiario", "9789500400033", 5));

        // Búsqueda exitosa
        try {
            Libro hallado = catalogo.buscarPorIsbn("9789500400022");
            System.out.println("Libro encontrado: " + hallado.getTitulo());
        } catch (LibroNoEncontradoException e) {
            System.err.println(e.getMessage());
        }

        // Búsqueda fallida
        try {
            System.out.println("\nBuscando ISBN inexistente...");
            Libro inexistente = catalogo.buscarPorIsbn("0000000000000");
        } catch (LibroNoEncontradoException e) {
            System.err.println("Búsqueda fallida: " + e.getMessage());
        }
    }
}