import java.io.Serializable;

/**
 * 
 */
public class PersonajeUser implements Serializable {

    private Personaje personaje;
    private Arma armaIzq;
    private Arma armaDer;
    private Armadura armadura;

    private int oro;
    private int salud;

    private boolean cuentaAtras;
    public PersonajeUser() {
        this.personaje = null;
        this.oro = 500;

    }

    public int sumarPotencialAtaque() {
        // TODO implement here
        return 0;
    }

    public int sumarPotencialDefensa() {
        // TODO implement here
        return 0;
    }

    public boolean estaVivo() {
        // TODO implement here
        return false;
    }
    public boolean oroSufiencte(int dinero) {
        return dinero <= this.oro;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public Personaje getPersonaje() {
        return this.personaje;
    }



}