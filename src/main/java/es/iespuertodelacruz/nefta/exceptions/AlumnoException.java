package es.iespuertodelacruz.nefta.exceptions;

public class AlumnoException extends Exception{

    private static final long serialVersionUID = -7911581919206854978L;

    /**
     * Constructor por defecto
     * @param mensaje de error
     */
    public AlumnoException(String mensaje){
        super(mensaje);
    }

    /**
     * Constructor con causa del error
     * @param mensaje de error
     * @param causa del error
     */
    public AlumnoException(String mensaje, Exception causa){
        super(mensaje, causa);
    }
}
