/**
 * 
 */
public abstract class Esbirro {

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

}