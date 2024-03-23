import java.io.Serializable;

/**
 * 
 */
public class PersonajeUser implements Serializable {

    /**
     * Default constructor
     */
    public PersonajeUser() {
        this.personaje = new Personaje("prueba");
    }

    /**
     * 
     */
    private Personaje personaje;

    /**
     * 
     */
    private Arma armaIzq;

    /**
     * 
     */
    private Arma armaDer;

    /**
     * 
     */
    private Armadura armadura;

    /**
     * 
     */
    private int salud;

    /**
     * 
     */
    private boolean cuentaAtras;

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

    /**
     * @return
     */
    public boolean estaVivo() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public int oro() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public boolean oroSufiencte() {
        // TODO implement here
        return false;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public Personaje getPersonaje() {
        return this.personaje;
    }
}