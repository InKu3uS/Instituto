package es.iespuertodelacruz.nefta.exceptions;

public class ProfesorException extends Exception {

    private static final long serialVersionUID = 7193322447846658887L;

    /**
     * Constructor por defecto
     * 
     * @param mensaje de error
     */
    public ProfesorException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con causa del error
     * 
     * @param mensaje de error
     * @param causa   del error
     */
    public ProfesorException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }
}
