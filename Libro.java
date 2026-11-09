public class Libro {
    private String titulo;
    private String isbn;
    private int ejemplaresDisponibles;

    public Libro(String titulo, String isbn, int ejemplaresDisponibles) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public String getTitulo() { return titulo; }
    public String getIsbn() { return isbn; }
    public int getEjemplaresDisponibles() { return ejemplaresDisponibles; }

    public void prestar() throws EjemplarNoDisponibleException {
        if (this.ejemplaresDisponibles <= 0) {
            throw new EjemplarNoDisponibleException(this.isbn, "No quedan ejemplares disponibles para préstamo del libro: '" + this.titulo + "'");
        }
        this.ejemplaresDisponibles--;
        System.out.println("Préstamo realizado. Ejemplares restantes de '" + this.titulo + "': " + this.ejemplaresDisponibles);
    }

    public static void main(String[] args) {
        Libro libro = new Libro("Rayuela", "978-950-07-0010-0", 0);

        try {
            System.out.println("Solicitando préstamo de '" + libro.getTitulo() + "'...");
            libro.prestar();
        } catch (EjemplarNoDisponibleException e) {
            System.err.println("Excepción capturada: " + e.getMessage());
            System.err.println("ISBN del libro no disponible: " + e.getIsbnLibro());
        }
    }
}