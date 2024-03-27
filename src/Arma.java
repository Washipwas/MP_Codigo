/**
 * 
 */
public class Arma extends Equipo {

    /**
     * Default constructor
     */
    private int manos;

    public Arma(String nombre , int manos, int modificadorAtaque, int modificadorDefensa) {

        super(nombre, modificadorAtaque, modificadorDefensa);
        this.manos =  manos;
    }




}