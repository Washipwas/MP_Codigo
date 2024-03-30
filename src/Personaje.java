import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Personaje implements Serializable {
    private String nombre;
    private transient TextTerminal terminal;
    private Set<HabilidadEspecial> habilidad;
    private Map<String, Arma> armas = null;
    private Map<String, Armadura> armaduras = null;
    private Set<Esbirro> esbirros;
    private Debilidad debilidadActiva;
    private Fortaleza fortalezaActiva;

    public int getSalud() {
        return this.salud;
    }

    private int salud;
    private int poder;

    private final Map<String, Debilidad> debilidades;
    private final Map<String, Fortaleza> fortalezas;
    private Arma arma1;
    private Arma arma2;
    private int manosOcupadas;
    private Armadura armadura;

    public Personaje(String nombre, int salud, int poder,TextTerminal terminal) {
        this.terminal = terminal;
        this.nombre = nombre;
        this.salud = salud;
        this.poder = poder;
        this.armas = new HashMap<>();
        this.armaduras = new HashMap<>();
        this.debilidades = new HashMap<>();
        this.fortalezas = new HashMap<>();
        crearArmas();
        crearArmaduras();
    }


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

    public Map<String, Debilidad> getDebilidades() {
        return debilidades;
    }

    public Map<String, Fortaleza> getFortalezas() {
        return fortalezas;
    }

    public void editar() {
        this.terminal = new TextTerminal();
        this.terminal.show("¿Cambiar nombre? (Si/No)");
        String opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            terminal.show(UtilConstants.ANSI_BLUE + "Nombre actual: " + this.nombre + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nuevo nombre");
            this.nombre = terminal.read();
            terminal.show(UtilConstants.ANSI_YELLOW + "Nombre nuevo: " + this.nombre + UtilConstants.ANSI_RESET);
        }
        this.terminal.show("¿Cambiar puntos de Salud? (Si/No)");
        opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            terminal.show(UtilConstants.ANSI_BLUE + "Puntos de salud actual: " + this.salud + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nuevo valor (entre 0 y 5)");
            int opcionNum = Integer.parseInt(terminal.read());
            while (opcionNum > 5 || opcionNum < 0 ){
                terminal.show(UtilConstants.ANSI_RED + "Valor incorrecto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el nuevo valor (entre 0 y 5)");
                opcionNum = Integer.parseInt(terminal.read());
            }
            this.salud = opcionNum;
            terminal.show(UtilConstants.ANSI_YELLOW + "Puntos de salud nuevo: " + this.salud + UtilConstants.ANSI_RESET);
        }
        this.terminal.show("¿Cambiar puntos de Poder? (Si/No)");
        opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            terminal.show(UtilConstants.ANSI_BLUE + "Puntos de poder actual: " + this.salud + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nuevo valor (entre 1 y 5)");
            int opcionNum = Integer.parseInt(terminal.read());
            while (opcionNum > 5 || opcionNum < 1 ){
                terminal.show(UtilConstants.ANSI_RED + "Valor incorrecto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el nuevo valor (entre 1 y 5)");
                opcionNum = Integer.parseInt(terminal.read());
            }
            this.poder = opcionNum;
            terminal.show(UtilConstants.ANSI_YELLOW + "Puntos de poder nuevo: " + this.poder + UtilConstants.ANSI_RESET);
        }
    }

    public void crearArmas() {
        Arma arma1 = new Arma("Pump", 1,1, 3, 0);
        armas.put(arma1.getId(), arma1);
        Arma arma2 = new Arma("Catana",2, 2, 2, 0);
        armas.put(arma2.getId(), arma2);
        Arma arma3 = new Arma("Cañon de mano", 2,1, 2, 0);
        armas.put(arma3.getId(), arma3);
        Arma arma4 = new Arma("Lanza Cohetes", 2,2, 3, 1);
        armas.put(arma4.getId(), arma4);
    }

    public void crearArmaduras() {
        Armadura armadura1 = new Armadura("Armadura de papel",2,0, 1);
        armaduras.put(armadura1.getId(), armadura1);
        Armadura armadura2 = new Armadura("Armadura de dioses",1, 1, 3);
        armaduras.put(armadura2.getId(), armadura2);
        Armadura armadura3 = new Armadura("Armadura ardiente", 2,3, 1);
        armaduras.put(armadura3.getId(), armadura3);
        Armadura armadura4 = new Armadura("Armadura siniestra",3, 2, 2);
        armaduras.put(armadura4.getId(), armadura4);
    }




    public int getValorAtaqueArmaduraActiva(){
        return armadura.getModificadorDeAtaque();
    }


    public int getValorDefensaArmaduraActiva(){
        return armadura.getModificadorDeDefensa();
    }

    public int getValorAtaqueArmaActiva() {
        int valor;
        if (manosOcupadas == 0) {
            valor = 0;
        } else if (manosOcupadas == 1) {
            valor = arma1.getModificadorDeAtaque();
        } else {
            valor = arma1.getModificadorDeAtaque() + arma2.getModificadorDeAtaque();
        }
        return valor;
    }

    public int getValorDefensaArmaActiva() {
        int valor;
        if (manosOcupadas == 0) {
            valor = 0;
        } else if (manosOcupadas == 1) {
            valor = arma1.getModificadorDeDefensa();
        } else {
            valor = arma1.getModificadorDeDefensa() + arma2.getModificadorDeDefensa();
        }
        return valor;
    }

    //se tiene que crear una funcion para escoger la debilidad y fortaleza activa(lo hace el operador)
    //hacerlo todo en las clases que heredan de personaje porque cada personaje tiene distintas fortalezas y debilidades

    public Debilidad getDebilidadActiva(){
        return debilidadActiva;
    }
    public Fortaleza getFortalezaActiva(){
        return fortalezaActiva;
    }

    public void mostrarAtributos() {
        System.out.print("Nombre: " + nombre + "    ");
        System.out.print("Salud: " + String.valueOf(salud) + "    ");
        System.out.print("Poder: " + String.valueOf(poder) + "    ");
    }
}