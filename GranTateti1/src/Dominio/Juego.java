package Dominio;

/**
 *
 * @author Bruno Tolaba (258096), Maximo Gilino (332163)
 */
public class Juego {
    private SuperTateti tablero;
    private String espacioDeJuegoActual;
    private char turno;
    private String aliasJugadorRojo;
    private String aliasJugadorAzul;

    public Juego(String jugadorRojo, String jugadorAzul) {
        tablero = new SuperTateti();
        espacioDeJuegoActual = "SN";
        turno = 'X';
        aliasJugadorRojo = jugadorRojo;
        aliasJugadorAzul = jugadorAzul;
    }
    
    
}
