public class EjemplarNoDisponibleException extends Exception {
    private String isbnLibro;

    public EjemplarNoDisponibleException(String isbnLibro, String mensaje) {
        super(mensaje);
        this.isbnLibro = isbnLibro;
    }

    public String getIsbnLibro() {
        return isbnLibro;
    }
}