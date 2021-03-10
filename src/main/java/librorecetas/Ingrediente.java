package librorecetas;

/**
 * @author Alberto López Puertas 
 * <https://github.com/alopezp90>
 */

public class Ingrediente {
    
    private String nombre;
    private int gramos;
    
    public Ingrediente(String nombre, int gramos) {
        this.nombre = nombre;
        this.gramos = gramos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGramos() {
        return gramos;
    }

    public void setGramos(int gramos) {
        this.gramos = gramos;
    }
}
