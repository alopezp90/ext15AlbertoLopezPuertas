package sopadeletras;

/**
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
public class SopaLetras {

    private char[][] sopaLetras;

    //crea SopaLetras NxN y la rellena con *
    public SopaLetras(int n) {
        this.sopaLetras = new char[n][n];
        for (int i = 0; i < sopaLetras.length; i++) {
            for (int j = 0; j < sopaLetras.length; j++) {
                sopaLetras[i][j] = '*';
            }
        }
    }

    public boolean colocarPalabraHorizontal(String palabra, Coordenada coordenada, boolean tieneSentidoNatural) {
        if(!esValido(coordenada)){
            return false; //si la coordenada no es valida (no esta en la matriz
        }

        if (palabra.length() > sopaLetras.length - coordenada.getColumna()) { //es decir, no cabe en la matriz
            return false; //si no cabe la palabra

        } else if (!compruebaVacioHorizontal(coordenada, palabra.length())) {
            return false; //si alguna casilla esta ocupada

        } else {
            if (!tieneSentidoNatural) {
                palabra = cambiaSentido(palabra);
            }
            for (int k = 0; k < palabra.length(); k++) {
                sopaLetras[coordenada.getFila()][coordenada.getColumna() + k] = palabra.charAt(k);
            }
        }
        return true; //si ha podido poner la palabra
    }

    public boolean colocarPalabraVertical(String palabra, Coordenada coordenada, boolean tieneSentidoNatural) {
                if(!esValido(coordenada)){
            return false; //si la coordenada no es valida (no esta en la matriz
        }

        if (palabra.length() > sopaLetras.length - coordenada.getFila()) { //es decir, no cabe en la matriz
            return false; //si no cabe la palabra

        } else if (!compruebaVacioVertical(coordenada, palabra.length())) {
            return false; //si alguna casilla esta ocupada

        } else {
            if (!tieneSentidoNatural) {
                palabra = cambiaSentido(palabra);
            }
            for (int k = 0; k < palabra.length(); k++) {
                sopaLetras[coordenada.getFila() + k][coordenada.getColumna()] = palabra.charAt(k);
            }
        }
        return true; //si ha podido poner la palabra
    }

    private String cambiaSentido(String palabra) {
        String aux = "";
        for (int i = palabra.length() - 1; i >= 0; i--) {
            aux += palabra.charAt(i);
        }
        return aux;
    }

    //comprueba que no haya casillas ocupadas desde coordenada y en direccion horizontal
    private boolean compruebaVacioHorizontal(Coordenada coordenada, int longitud) {
        for (int k = 0; k < longitud; k++) {
            if (sopaLetras[coordenada.getFila()][coordenada.getColumna() + k] != '*') {
                return false; //si alguna casilla esta ocupada
            }
        }
        return true; //si estan vacias las casillas
    }

    //comprueba que no haya casillas ocupadas desde coordenada y en direccion vertical
    private boolean compruebaVacioVertical(Coordenada coordenada, int longitud) {
        for (int k = 0; k < longitud; k++) {
            if (sopaLetras[coordenada.getFila() + k][coordenada.getColumna()] != '*') {
                return false; //si alguna casilla esta ocupada
            }
        }
        return true; //si estan vacias las casillas
    }
    
    private boolean esValido(Coordenada coordenada) {
        if (coordenada.getFila()<0 || coordenada.getFila() >= sopaLetras.length
                || coordenada.getColumna()<0 || coordenada.getColumna()>=sopaLetras.length) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String texto = "";
        for (int i = 0; i < sopaLetras.length; i++) {
            for (int j = 0; j < sopaLetras.length; j++) {
                texto+=sopaLetras[i][j] + " ";
            }
            texto += "\n";
        }
        return texto;
    }
}
