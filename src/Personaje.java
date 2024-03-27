import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Personaje implements Serializable {

    public Personaje(String nombre, int salud, int poder) {
        this.terminal = new TextTerminal();
        this.nombre = nombre;
        this.salud = salud;
        this.poder = poder;
        this.armas = new HashMap<>();
        this.armaduras = new HashMap<>();
        crearArmas();
        crearArmaduras();
    }
    private String nombre;
    private transient TextTerminal terminal;

    private Set<HabilidadEspecial> habilidad;

    private Map< String, Arma> armas = null;

    private Map< String, Armadura> armaduras = null;
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

    public int getPoder() {
        return this.poder;
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

    public void crearArmas(){
        Arma arma1 =  new Arma("Pump", 1, 3,0);
        armas.put(arma1.getId(), arma1);
        Arma arma2 =  new Arma("Catana", 2, 2,0);
        armas.put(arma2.getId(), arma2);
        Arma arma3 =  new Arma("Cañon de mano", 1, 2,0);
        armas.put(arma3.getId(), arma3);
        Arma arma4 =  new Arma("Lanza Cohetes", 2, 3,1);
        armas.put(arma4.getId(), arma4);
    }
    public void crearArmaduras(){
        Armadura armadura1 =  new Armadura("Armadura de papel", 0, 1);
        armaduras.put(armadura1.getId(),armadura1);
        Armadura armadura2 =  new Armadura("Armadura de dioses", 1, 3);
        armaduras.put(armadura2.getId(), armadura2);
        Armadura armadura3 =  new Armadura("Armadura ardiente", 3, 1);
        armaduras.put(armadura3.getId(),armadura3);
        Armadura armadura4 =  new Armadura("Armadura siniestra", 2, 2);
        armaduras.put(armadura4.getId(), armadura4);
    }




}