import java.io.Serializable;

/**
 *
 */
public abstract class Modificador implements Serializable {


    public Modificador(String nombre, int valor) {

        this.nombre = nombre;
        this.valor = valor;
    }


    public String getNombre() {
        return this.nombre;
    }

    public int getValor() {
        return this.valor;
    }


    private final String nombre;

    /**
     *
     */
    private final int valor;

}


// generar potencial ataque y defensa no deberian de ir aquí
/**
 * public int generarPotencialAtaque() {
 * // TODO implement here
 * return 0;
 * }
 * <p>
 * <p>
 * <p>
 * <p>
 * public int generarPotencialDefensa() {
 * // TODO implement here
 * return 0;
 * }
 */


