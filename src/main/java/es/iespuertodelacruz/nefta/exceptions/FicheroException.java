package es.iespuertodelacruz.nefta.exceptions;

public class FicheroException extends Exception {

    private static final long serialVersionUID = -2639083039813268831L;

    /**
     * Constructor por defecto
     * 
     * @param mensaje de error
     */
    public FicheroException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con causa del error
     * 
     * @param mensaje de error
     * @param causa   del error
     */
    public FicheroException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }

}
