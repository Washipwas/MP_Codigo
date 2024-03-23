/**
 * 
 */
public class Ghoul extends Esbirro {

    /**
     * Default constructor
     */

    public Ghoul(String nombre, int vida, int dependencia) {
        super(nombre,vida);
        this.dependencia = dependencia;
    }

    /**
     *
     * 
     */
    private int dependencia;

}