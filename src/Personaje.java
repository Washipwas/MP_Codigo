import java.io.Serializable;
import java.util.Set;

public class Personaje implements Serializable {

    public Personaje(String nombre) {
        this.nombre = nombre;
    }
    private String nombre;

    /**
     * 
     */
    private Set<HabilidadEspecial> habilidad;

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

    public String getNombre() {
        return this.nombre;
    }
}