package Dominio;

/**
 *
 * @author Bruno Tolaba (258096), Maximo Gilino (332163)
 */
public class Jugador {
    private String alias;
    private int edad;
    private int cantidadDeVictorias;

    public Jugador(String unAlias, int unaEdad){
        alias = unAlias;
        edad = unaEdad;
        cantidadDeVictorias = 0;
    }
    
    public String getAlias() {
        return alias;
    }

    public int getCantidadDeVictorias() {
        return cantidadDeVictorias;
    }

    public void aumentasCantidadDeVictorias() {
        this.cantidadDeVictorias++;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
