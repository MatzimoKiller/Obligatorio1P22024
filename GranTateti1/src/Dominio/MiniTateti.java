package Dominio;

/**
 *
 * @author Bruno Tolaba (258096), Maximo Gilino (332163)
 */
public class MiniTateti {
    private char[][] tablero = new char[3][3];
    private char ganador;
    
    public MiniTateti(){
        tablero = new char[3][3];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = ' ';
            }
        }
        
        ganador = ' ';
    }

    public char getGanador() {
        return ganador;
    }
    
    //Retorna true y setea la variable ganador si encuentra un ganador 
    public boolean hayUnGanador(){
        boolean retorno = false;
        
        //Verifico diagonales
        if(tablero[0][0] == 'X' && tablero[1][1] == 'X' && tablero[2][2] == 'X'){
            retorno = true;
            ganador = 'X';            
        }
        else if(tablero[0][0] == 'O' && tablero[1][1] == 'O' && tablero[2][2] == 'O'){
            retorno = true;
            ganador = 'X';            
        }
        else if(tablero[0][2] == 'O' && tablero[1][1] == 'O' && tablero[2][0] == 'O'){
            retorno = true;
            ganador = 'O';            
        }
        else if(tablero[0][2] == 'X' && tablero[1][1] == 'X' && tablero[2][0] == 'X'){
            retorno = true;
            ganador = 'X';            
        }
       
        
        //Verifico filas
        for (int i = 0; i < 3 && !retorno; i++) {
            if(tablero[i][0] == 'X' && tablero[i][1] == 'X' && tablero[i][2] == 'X'){

            }
            else if(tablero[i][0] == 'O' && tablero[i][1] == 'O' && tablero[i][2] == 'O'){
                retorno = true;
                ganador = 'O';                
            }
        }
        
        //Verifico columnas
        for (int j = 0; j < 3 && !retorno; j++) {
            if(tablero[0][j] == 'X' && tablero[1][j] == 'X' && tablero[2][j] == 'X'){
                retorno = true;
                ganador = 'X';
            }
            else if(tablero[0][j] == 'O' && tablero[1][j] == 'O' && tablero[2][j] == 'O'){
                retorno = true;
                ganador = 'O';                
            }
        }
        
        return retorno;
    }
    
    //Recibe un string de jugada, si no cumple el formato correcto de las jugadas (el primer caracter es A,B o C y el segundo 1, 2 o 3) o la casilla esta ocupada retorna false
    public boolean esUnaJugadaValida(String jugada){
        boolean retorno = true;
        
        char vertical = jugada.toUpperCase().charAt(0);
        char horizontal = jugada.charAt(1);
        
        //Verifico que lo que hayan escrito cumpla el formato
        boolean sirve = (vertical != 'A' && vertical != 'B' && vertical != 'C') || (horizontal != '1' && horizontal != '2' && horizontal != '3');
        if((vertical != 'A' && vertical != 'B' && vertical != 'C') || (horizontal != '1' && horizontal != '2' && horizontal != '3')){
            retorno = false;
        }
        
        //Si cumple lo traduzco para poder ver en la matriz si no esta ocupada esa coordenada
        if(retorno){
            int coordVertical;
            int coordHorizontal;
            
            switch (vertical) {
                case 'A':
                    coordVertical = 0;
                    break;
               case 'B':
                    coordVertical = 1;
                    break;
               case 'C':
                    coordVertical = 2;
                    break;
                default:
                    throw new Error();
            }
            
            coordHorizontal = Integer.parseInt(String.valueOf(horizontal)) -1;
            
            if(tablero [coordVertical][coordHorizontal] == 'X' || tablero [coordVertical][coordHorizontal] == 'O' ){
                retorno = false;
            }
        }
        
        
        
        return retorno;
    }
    
    //Pone una ficha en una jugada
    public void ponerUnaFicha(String jugada, char ficha){
        int[] coordenadas = traducirJugadasACoordenadas(jugada.charAt(0), jugada.charAt(1));
        tablero[coordenadas[0]][coordenadas[1]] = ficha;
    }
    
    //Le pasas los caracteres correspondientes a una jugada y devuelve las coordenadas correspondientes en la matriz
    private int[] traducirJugadasACoordenadas(char vertical, char horizontal){
        int coordVertical;
        int coordHorizontal;
        int [] retorno = new int[2];
            
        switch (vertical) {
                case 'A':
                    coordVertical = 0;
                    break;
                case 'B':
                    coordVertical = 1;
                    break;
                case 'C':
                    coordVertical = 2;
                    break;
                default:
                    throw new Error();
            }
            
            coordHorizontal = Integer.parseInt(String.valueOf(horizontal)) -1;
            retorno[0] = coordVertical;
            retorno[1] = coordHorizontal;
            return retorno;
    }
    
    @Override
    public String toString(){
        String retorno="";
        String rojo = "\033[31m";
        String azul = "\033[34m";
        String reset = "\u001B[0m";
        
        if(ganador == ' '){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    String color = "";
                    if(j>0){
                        retorno += "|";
                    }
                
                    if(tablero[i][j] == 'X'){
                        color = rojo;
                    }
                    else if(tablero[i][j] == 'O'){
                        color = azul;
                    }
                
                    retorno += (color+ tablero[i][j]+reset); 
                
                }
                if(i<2){
                    retorno +=("\n-+-+-\n");
                }
            }
        }
        else{
            String color;
            if(ganador == 'X'){
                color = rojo;
            }
            else{
                color = azul;
            }
            
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    retorno += color;
                    if(j>0){
                        retorno += "|";
                    }

                    retorno += tablero[i][j]; 
                
                }
                if(i<2){
                    retorno +=("\n"+color+"-+-+-\n");
                }
            }
            
        }

        return retorno;
    }
}
