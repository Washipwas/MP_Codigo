import java.util.Set;

/**
 * 
 */
public abstract class Personaje {

    /**
     * Default constructor
     */
    public Personaje() {
    }

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private Set<Habilidad> habilidad;

    /**
     * 
     */
    private Set<Arma> armas;

    /**
     * 
     */
    private Set<Armadura> armadura;

    /**
     * 
     */
    private Set<Esbirro> esbirros;

    /**
     * 
     */
    private int salud;

    /**
     * 
     */
    private int poder;

    /**
     * 
     */
    private Set<Debilidad> debilidades;

    /**
     * 
     */
    private Set<Fortaleza> fortalezas;

    /**
     * @return
     */
    public int sumarPotencialAtaque() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int sumarPotencialDefensa() {
        // TODO implement here
        return 0;
    }

}