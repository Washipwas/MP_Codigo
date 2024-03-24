import java.io.Serializable;
import java.util.Set;

public class Personaje implements Serializable {

    public Personaje(String nombre) {
        this.terminal = new TextTerminal();
        this.nombre = nombre;
    }
    private String nombre;
    private transient TextTerminal terminal;

    private Set<HabilidadEspecial> habilidad;

    private Set<Arma> armas;

    private Set<Armadura> armadura;
    private Set<Esbirro> esbirros;

    private int salud;

    private int poder;

    private Set<Debilidad> debilidades;

    private Set<Fortaleza> fortalezas;

    public int sumarPotencialAtaque() {
        // TODO implement here
        return 0;
    }

    public int sumarPotencialDefensa() {
        // TODO implement here
        return 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void editar() {
        terminal.show("¿Cambiar nombre?");
        String opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)){
            terminal.show("Nombre actual: " + this.nombre);
            terminal.show("Escribe el nuevo nombre");
            this.nombre = terminal.read();
            terminal.show("Nombre nuevo: " + this.nombre);
        }
        terminal.show("¿Cambiar ...");
        //Implementar resto de características
    }
}