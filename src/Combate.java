import java.io.Serializable;

/**
 * 
 */
public class Combate implements Serializable {

    /**
     * Default constructor
     */
    public Combate(UsuarioEstandar usuarioActivo, UsuarioEstandar usuario2, int dinero,String id) {
        this.personaje1 = usuarioActivo;
        this.personaje2 = usuario2;
        this.oroApostado = dinero;
        this.id = id;
        this.rondas = 0;
    }

    private String id;
    private UsuarioEstandar personaje1;

    private UsuarioEstandar personaje2;
    private int oroApostado;

    private String ganador;
    private int rondas;

    public String getGanador(){
        return ganador;
    }

    public UsuarioEstandar getPersonaje1(){
        return personaje1;
    }
    public UsuarioEstandar getPersonaje2(){
        return personaje2;
    }
    public int getOroApostado(){
        return oroApostado;
    }
    public Boolean hayGanador() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Boolean esbirrosVivos() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public PersonajeUser calcularPotencial() {
        // TODO implement here
        return null;
    }

    public int generPotencialAtaque() {
        // TODO implement here
        return 0;
    }

    public int generarPotencialDefensa() {
        // TODO implement here
        return 0;
    }

    public String getId() {
        return this.id;
    }

    public void asociarDesafio() {
        this.personaje2.setDesafiante(this.personaje1);
    }
}