import java.io.Serializable;

/**
 * 
 */
public abstract class Esbirro implements Serializable {

    /**
     * Default constructor
     */
    public Esbirro(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
    }

    private String nombre;
    private int vida;

    public int getVida() {  // este metodo servira para sumar la vida de todos los esbirros de un personaje
       return this.vida;
    }

    public int generarPotencialAtaque() {
        // TODO implement here
        return 0;
    }
    public int generarPotencialDefensa() {
        // TODO implement here
        return 0;
    }

    public void Operation1() {
        // TODO implement here
    }

    public void mostrar() {
        if (this instanceof Humano){
            System.out.print("Clase: Humano     ");
        } else if (this instanceof Ghoul){
            System.out.print("Clase: Ghoul     ");
        } else if (this instanceof Demonio){
            System.out.print("Clase: Demonio     ");
        }
        System.out.print("Nombre: " + this.nombre + "    ");
        System.out.print("Salud: " + this.vida + "     ");
        mostrarExtra();
    }

    protected abstract void mostrarExtra();
}