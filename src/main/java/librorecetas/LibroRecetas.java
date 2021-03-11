package librorecetas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
public class LibroRecetas {

    private String nombre;
    private Map<String, Receta> libroRecetas;

    public LibroRecetas(String nombre) {
        this.nombre = nombre;
        libroRecetas = new TreeMap<>();
    }

    public void guardarReceta(Receta receta) {
        this.libroRecetas.put(receta.getNombre().toUpperCase(), receta);
        //key en mayusculas para evitar errores ordenando mayusculas y minusculas
    }

    public void borrarReceta(Receta receta) {
        this.libroRecetas.remove(receta.getNombre().toUpperCase());
    }

    public Receta buscarRecetaPorNombre(String nombreReceta) {
        return this.libroRecetas.get(nombreReceta.toUpperCase());
    }

    public ArrayList<String> listadoNombres() {
        return new ArrayList<>(this.libroRecetas.keySet());
    }

    public ArrayList<Ingrediente> listadoIngredientes(String nombreReceta) {
        ArrayList<Ingrediente> listado = new ArrayList<>();
        for (Ingrediente ingrediente : this.buscarRecetaPorNombre(nombreReceta.toUpperCase()).getIngredientes()) {
            listado.add(ingrediente);
        }
        ordenaIngredientesPorNombre(listado);
        return listado;
    }

    private void ordenaIngredientesPorNombre(ArrayList<Ingrediente> listado) {
        Collections.sort(listado, (c1, c2) -> c1.getNombre().compareTo(c2.getNombre()));
    }

    public ArrayList<Receta> listadoSegunTiempo() {
        ArrayList<Receta> listado = new ArrayList<>(libroRecetas.values());
        Collections.sort(listado, (c1, c2) -> compararTiempoNombre(c1, c2));
        return listado;
    }

    private static int compararTiempoNombre(Receta receta1, Receta receta2) {
        int resultado = receta1.getTiempoPreparacion() - receta2.getTiempoPreparacion(); //negativo si receta1 es mas rapida
        if (resultado == 0) {
            resultado = receta1.getNombre().compareTo(receta2.getNombre()); //negativo si el nombre de receta1 va primero alfabeticamente
        }
        return resultado;
    }
    
    public ArrayList<Receta> listarSegunIngrediente(String nombreIngrediente){
        ArrayList<Receta> listado = new ArrayList<>();
        for(Receta receta : libroRecetas.values()) {
            if(receta.contiene(nombreIngrediente)) {
                listado.add(receta);
            }
        }
        return listado;
    }

}
