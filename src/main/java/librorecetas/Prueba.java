package librorecetas;

/**
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
public class Prueba {

    public static void main(String[] args) {

        //instancia libro
        LibroRecetas libroPrueba = new LibroRecetas();

        //aniade recetas
        libroPrueba.guardarReceta(new Receta("Macarrones", 40,
                new Ingrediente[]{new Ingrediente("Pasta", 250), new Ingrediente("Tomate", 120), new Ingrediente("Agua", 500), new Ingrediente("Agua", 500)}
        ));
        libroPrueba.guardarReceta(new Receta("Pizza", 35,
                new Ingrediente[]{new Ingrediente("BasePizza", 300), new Ingrediente("Tomate", 120), new Ingrediente("Queso", 30), new Ingrediente("Bacon", 500)}
        ));
        libroPrueba.guardarReceta(new Receta("Burger", 40,
                new Ingrediente[]{new Ingrediente("Pan", 130), new Ingrediente("Carne", 100), new Ingrediente("Queso", 30), new Ingrediente("Bacon", 500)}
        ));
        libroPrueba.guardarReceta(new Receta("Fish&Chips", 50, 
                new Ingrediente[]{new Ingrediente("Pescado", 250), new Ingrediente("Harina", 200), new Ingrediente("Aceite", 330), new Ingrediente("Patatas", 500) }
        ));
        
        //lista recetas con Tomate
        for(Receta recetaConTomate : libroPrueba.listarSegunIngrediente("Tomate")){
            System.out.println(recetaConTomate);
            System.out.println("---");
        }
        
        System.out.println("------------------------");
        
        //Muestra recetas ordenadas por tiempo y nombre
        for(Receta recetaOrdenada : libroPrueba.listadoSegunTiempo()) {
            System.out.println(recetaOrdenada);
            System.out.println("---");
        }
    }
}
