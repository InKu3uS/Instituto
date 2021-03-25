package es.iespuertodelacruz.nefta.exceptions;

public class AulaException extends Exception {

    private static final long serialVersionUID = -5078251138754674953L;

    /**
     * Constructor por defecto
     * 
     * @param mensaje de error
     */
    public AulaException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con causa del error
     * 
     * @param mensaje de error
     * @param causa   del error
     */
    public AulaException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }
}
