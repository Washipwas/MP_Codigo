import java.io.Serializable;

/**
 * 
 */
public class Arma extends Equipo implements Serializable {

    public int getManos() {
        return this.manos;
    }

    /**
     * Default constructor
     */
    private int manos;

    public Arma(String nombre,int equipoClase,int manos, int modificadorAtaque, int modificadorDefensa) {
        super(nombre,equipoClase,modificadorAtaque, modificadorDefensa);
        this.manos =  manos;
    }




}