package sopadeletras;

/**
 * @author Alberto López Puertas 
 * <https://github.com/alopezp90>
 */

public class Prueba {

    public static void main(String[] args) {
        
        SopaLetras prueba = new SopaLetras(12);

        System.out.println(prueba.toString());
        
        prueba.colocarPalabraHorizontal("hola", new Coordenada(3, 3), true);
        prueba.colocarPalabraHorizontal("coche", new Coordenada(8, 2), false);
        prueba.colocarPalabraHorizontal("estaseguroquenocabe", new Coordenada(10, 7), true);
        prueba.colocarPalabraHorizontal("vecino", new Coordenada(6,0), true);
        
        System.out.println(prueba.toString());
        
        prueba.colocarPalabraVertical("gato", new Coordenada(2,10), false);
        prueba.colocarPalabraVertical("perro", new Coordenada(2,3), true);
        prueba.colocarPalabraVertical("estatampococabe", new Coordenada(5,6), false);
        prueba.colocarPalabraVertical("lagarto", new Coordenada(3,11), true);
        prueba.colocarPalabraVertical("estafuera", new Coordenada(-1, 20), true);
        
        System.out.println(prueba.toString());
    }
}
