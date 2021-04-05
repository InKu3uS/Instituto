package es.iespuertodelacruz.nefta.validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validar extends Exception {

    private static final long serialVersionUID = 2602990398222134828L;

    private String patron = "^[0-9]{8}[A-Z-a-z]";

    Pattern pattern;
    Matcher matcher;

    /**
     * Funcion que evalua si un dni tiene el formato correcto
     * 
     * @param valor a evaluar
     * @return true/false en funcion de si es correcto o no
     */
    public void Dni(String valor) throws Exception {
        boolean resultado = false;
        this.pattern = Pattern.compile(patron);
        this.matcher = pattern.matcher(valor);
        resultado = matcher.find();
        if (!resultado) {
            throw new Exception("El dni:" + valor + ", no tiene un formato correcto");
        }
    }
}
