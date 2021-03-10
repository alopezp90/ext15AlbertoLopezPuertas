package librorecetas;

/**
 * @author Alberto López Puertas 
 * <https://github.com/alopezp90>
 */

public class Receta {

    private String nombre;
    private int tiempoPreparacion;
    private Ingrediente[] ingredientes;
    
    public Receta(String nombre, int tiempoPreparacion, Ingrediente[] ingredientes) {
        this.nombre = nombre;
        this.tiempoPreparacion = Math.abs(tiempoPreparacion); //no tendria sentido tiempo negativo
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ingrediente[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Ingrediente[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }
    
    public boolean contiene(String nombreIngrediente) {
        for(Ingrediente ingrediente : ingredientes) {
            if(ingrediente.getNombre().equals(nombreIngrediente)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String texto = "";
        texto = nombre + "\t" + tiempoPreparacion + " minutos";
        for(Ingrediente ingrediente : ingredientes) {
            texto+="\n" + ingrediente.getNombre() + "\t" + ingrediente.getGramos() + "gr";
        }
        return texto;
    }
    
    
}
