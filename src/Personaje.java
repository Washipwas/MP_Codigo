import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Personaje implements Serializable {
    private String nombre;
    private final transient TextTerminal terminal;
    private Set<HabilidadEspecial> habilidad;
    private Map<String, Arma> armas = null;
    private Map<String, Armadura> armaduras = null;
    private Set<Esbirro> esbirros;
    private Debilidad debilidadActiva;
    private Fortaleza fortalezaActiva;

    public int getSalud() {
        return this.salud;
    }

    private final int salud;
    private final int poder;

    private final Map<String, Debilidad> debilidades;
    private final Map<String, Fortaleza> fortalezas;
    private Arma arma1;
    private Arma arma2;
    private int manosOcupadas;
    private Armadura armadura;

    public Personaje(String nombre, int salud, int poder) {
        this.terminal = new TextTerminal();
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
        terminal.show("¿Cambiar nombre?");
        String opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            terminal.show("Nombre actual: " + this.nombre);
            terminal.show("Escribe el nuevo nombre");
            this.nombre = terminal.read();
            terminal.show("Nombre nuevo: " + this.nombre);
        }
        terminal.show("¿Cambiar ...");
        //Implementar resto de características
    }

    public void crearArmas() {
        Arma arma1 = new Arma("Pump", 1, 3, 0);
        armas.put(arma1.getId(), arma1);
        Arma arma2 = new Arma("Catana", 2, 2, 0);
        armas.put(arma2.getId(), arma2);
        Arma arma3 = new Arma("Cañon de mano", 1, 2, 0);
        armas.put(arma3.getId(), arma3);
        Arma arma4 = new Arma("Lanza Cohetes", 2, 3, 1);
        armas.put(arma4.getId(), arma4);
    }

    public void crearArmaduras() {
        Armadura armadura1 = new Armadura("Armadura de papel", 0, 1);
        armaduras.put(armadura1.getId(), armadura1);
        Armadura armadura2 = new Armadura("Armadura de dioses", 1, 3);
        armaduras.put(armadura2.getId(), armadura2);
        Armadura armadura3 = new Armadura("Armadura ardiente", 3, 1);
        armaduras.put(armadura3.getId(), armadura3);
        Armadura armadura4 = new Armadura("Armadura siniestra", 2, 2);
        armaduras.put(armadura4.getId(), armadura4);
    }

    public void escogerArmas() {
        terminal.show("Estas son tus armas disponibles:");
        //msotrar las armas disponibles
        for (String nombre : armas.keySet()) {
            Arma arma = armas.get(nombre);
            terminal.show(nombre + ", manos:" + arma.getManos());

        }
        //no tiene ningun arma
        if (manosOcupadas == 0) {
            terminal.show("Escriba el nombre del arma a seleccionar:");
            String opcion = terminal.read();
            if (armas.get(opcion).getManos() == 1) {
                arma1 = armas.get(opcion);
                manosOcupadas += 1;
                terminal.show("¿Quieres escoger otra Arma?: (si/no)");
                String otro = terminal.read();
                if (otro.equalsIgnoreCase("si")) {
                    terminal.show("Escoja otra arma: ");
                    String opcion2 = terminal.read();
                    if (armas.get(opcion2).getManos() == 2) {
                        terminal.show("Solo puedes escoger armas de 1 mano");
                        escogerArmas();
                    } else {
                        manosOcupadas += 1;
                    }
                }

            } else {
                terminal.show("Arma elegida con exito");
                manosOcupadas = 2;
            }
            //tiene ya 1 arma de 1 mano elegida
        } else if (manosOcupadas == 1) {
            terminal.show("Escriba el nombre del arma a seleccionar:");
            String opcion = terminal.read();
            if (armas.get(opcion).getManos() == 2) {
                terminal.show("Solo puedes escoger armas de 1 mano");
                escogerArmas();
            } else {
                arma2 = armas.get(opcion);
                manosOcupadas += 1;
                terminal.show("Arma elegida con exito");
            }
            //tiene las manos ocupadas
        } else {
            terminal.show("¿Tienes las manos ocupadas, quieres cambiar tus armas?: (si/no)");
            String opcion = terminal.read();
            if (opcion.equalsIgnoreCase("si")) {
                manosOcupadas = 0;
                escogerArmas();
            }
        }


    }

    public void escogerArmaduras() {
        terminal.show("Estas son tus armaduras disponibles:");
        //mostrar las armadura disponibles
        for (String nombre : armaduras.keySet()) {
            terminal.show(nombre);
        }

        if (armadura == null) {
            terminal.show("Escriba el nombre de la armadura a seleccionar: ");
            String opcion = terminal.read();
            armadura = armaduras.get(opcion);
            terminal.show("Armadura elegida con éxito");

        } else {

            terminal.show("Tu armadura actual es " + armadura.getId() + ", ¿deseas cambiarla? (si/no)");
            String opcion = terminal.read();
            if (opcion.equalsIgnoreCase("si")) {
                armadura = null;
                escogerArmaduras();
            }

        }

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

}