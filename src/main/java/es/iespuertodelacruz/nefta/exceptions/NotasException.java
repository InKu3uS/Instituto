package es.iespuertodelacruz.nefta.exceptions;

public class NotasException extends Exception {

    private static final long serialVersionUID = 5535984676392224768L;

    /**
     * Constructor por defecto
     * 
     * @param mensaje de error
     */
    public NotasException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con causa del error
     * 
     * @param mensaje de error
     * @param causa   del error
     */
    public NotasException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }

}
