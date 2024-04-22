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

    public abstract void setDesafiante(Usuario usuarioActivo);

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

    public void setArmaIzq(Arma arma) {
    }

    public void setArmaDer(Arma arma2) {
    }

    public int getManosLibres() {
        return 0;
    }

    public void mostrarArmas() {
    }

    public void mostrarArmadura() {
    }

    public boolean notieneArmadura() {
        return false;
    }

    public void setArmadura(Armadura armadura) {
    }

    public void mostrarTodasArmas() {
    }

    public Object getArma(String opcion) {
        return null;
    }

    public boolean existeEquipo(String opcion) {
        return false;
    }

    public int manosSuficientes(String opcion) {
        return 0;
    }

    public void mostrarTodasArmaduras() {
    }

    public boolean existeEquipoArmadura(String opcion) {
        return false;
    }

    public Object getArmadura(String opcion) {
        return null;
    }

    public void setBloqueado() {
    }

    public Object getArmaduraActiva() {
        return null;
    }

    public Object getArmaActiva() {
        return null;
    }

    public void setPosibleBloqueado(boolean b) {
    }

    public boolean getPosibleBloqueado() {
        return false;
    }

    public boolean getBloqueado() {
        return false;
    }
}