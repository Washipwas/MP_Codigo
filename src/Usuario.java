import java.io.Serializable;

/**
 * 
 */
public abstract class Usuario implements Serializable {

    public Usuario(String nombre, String nick, String password) {
        this.nombre = nombre;
        this.nick = nick;
        this.contrasenia = password;
    }
    private String nombre;
    private String nick;
    private String contrasenia;

    public boolean datosCorrectos(String n, String c) {
        // TODO implement here
        return false;
    }

    public String getNick(){
        return this.nick;
    }

    public String getPassword() {
        return this.contrasenia;
    }

    public String getNombre() {
        return  this.nombre;
    }

    public void setPersonajeUser(PersonajeUser personaje) {
    }

    public abstract void setPersonajeUser(Personaje personaje);

    public Personaje getPersonaje() {
        return null;
    }

    public boolean getPersonajeNull() {
        return true;
    }

    public Object getDesafiante() {
        return null;
    }

    public boolean oroValido(int dinero) {
        return true;
    }

    public PersonajeUser getPersonajeUser() {
        return null;
    }

    public void setPersonaje(Object o) {
        setPersonajeUser((PersonajeUser) o);
    }

    public void newPersonajeUser(Personaje personaje) {
    }

    public void setArma(Arma arma) {
    }
}