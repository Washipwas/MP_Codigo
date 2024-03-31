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
    private Map<String,Esbirro> esbirros;
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
        this.esbirros = new HashMap<>();
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

    public void editarModificadores() {
        TextTerminal terminal = new TextTerminal();
        terminal.show("¿Cambiar Debilidades? (Si/No)");
        String opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            Map<String, Debilidad> listaDebilidades = getDebilidades();
            for (Map.Entry<String, Debilidad> entry : listaDebilidades.entrySet()) {
                String key = entry.getKey();
                Debilidad debilidadMostrar = getDebilidad(key);
                debilidadMostrar.mostrar();
            }
            terminal.show("Escribe el nombre de la Debilidad");
            String opcionDeb = terminal.read();
            while (!existeDebilidad(opcionDeb)){
                terminal.show(UtilConstants.ANSI_RED + "El nombre no es correcto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el nombre de la Debilidad");
                opcionDeb = terminal.read();
            }
            Debilidad debilidadNew = getDebilidad(opcionDeb);
            String nombreOld = debilidadNew.getNombre();
            debilidadNew.editar();
            terminal.show(UtilConstants.ANSI_YELLOW + "Debilidad actualizada:" + UtilConstants.ANSI_RESET);
            debilidadNew.mostrar();
            actualizar(debilidadNew,nombreOld);
        }


        terminal.show("¿Cambiar Fortalezas? (Si/No)");
        opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            Map<String, Fortaleza> listaFortalezas = getFortalezas();
            for (Map.Entry<String, Fortaleza> entry : listaFortalezas.entrySet()) {
                String key = entry.getKey();
                Fortaleza fortalezaMostrar = getFortaleza(key);
                fortalezaMostrar.mostrar();
            }
            terminal.show("Escribe el nombre de la Fortaleza");
            String opcionDeb = terminal.read();
            while (!existeFortaleza(opcionDeb)){
                terminal.show(UtilConstants.ANSI_RED + "El nombre no es correcto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el nombre de la Fortaleza");
                opcionDeb = terminal.read();
            }
            Fortaleza fortalezaNew = getFortaleza(opcionDeb);
            String nombreOld = fortalezaNew.getNombre();
            fortalezaNew.editar();
            terminal.show(UtilConstants.ANSI_YELLOW + "Fortaleza actualizada:" + UtilConstants.ANSI_RESET);
            fortalezaNew.mostrar();
            actualizarFortaleza(fortalezaNew,nombreOld);
        }
    }

    private void actualizarFortaleza(Fortaleza fortalezaNew, String nombreOld) {
        fortalezas.remove(nombreOld);
        fortalezas.put(fortalezaNew.getNombre(),fortalezaNew);
    }

    private boolean existeFortaleza(String opcionDeb) {
        return fortalezas.containsKey(opcionDeb);
    }

    private Fortaleza getFortaleza(String key) {
        return fortalezas.get(key);
    }

    private void actualizar(Debilidad debilidadNew, String nombreOld) {
        debilidades.remove(nombreOld);
        debilidades.put(debilidadNew.getNombre(),debilidadNew);
    }

    private Debilidad getDebilidad(String opcionDeb) {
        return debilidades.get(opcionDeb);
    }

    private boolean existeDebilidad(String opcionDeb) {
        return debilidades.containsKey(opcionDeb);
    }

    public void aniadir() {
        TextTerminal terminal = new TextTerminal();
        terminal.show("¿Añadir armas? (Si/No)");
        String opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            aniadirArmas();
        }
        terminal.show("¿Añadir armaduras? (Si/No)");
        opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            aniadirArmaduras();
        }
        terminal.show("¿Añadir fortalezas? (Si/No)");
        opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            aniadirFortalezas();
        }
        terminal.show("¿Añadir debilidades? (Si/No)");
        opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            aniadirDebilidades();
        }
        terminal.show("¿Añadir esbirros? (Si/No)");
        opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            aniadirEsbirros();
        }
    }

    private void aniadirEsbirros() {
        TextTerminal terminal = new TextTerminal();
        terminal.show("Escribe el tipo de Esbirro (Humano/Ghoul/Demonio)");
        String opcionTipo = terminal.read();
        if (this instanceof Vampiro){
            while (!"Ghoul".equalsIgnoreCase(opcionTipo) && !"Demonio".equalsIgnoreCase(opcionTipo)){
                terminal.show(UtilConstants.ANSI_RED + "Los vampiros no pueden tener esbirros Humanos" + UtilConstants.ANSI_RESET);
                terminal.show(UtilConstants.ANSI_RED + "El tipo no es correcto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el tipo de Esbirro (Humano/Ghoul/Demonio)");
                opcionTipo = terminal.read();
            }
        } else{
            while (!"Humano".equalsIgnoreCase(opcionTipo) && !"Ghoul".equalsIgnoreCase(opcionTipo) && !"Demonio".equalsIgnoreCase(opcionTipo)){
                terminal.show(UtilConstants.ANSI_RED + "El tipo no es correcto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el tipo de Esbirro (Humano/Ghoul/Demonio)");
                opcionTipo = terminal.read();
            }
        }

        terminal.show("Escribe el nombre del Esbirro");
        String opcionNombre = terminal.read();
        while (existeEsbirro(opcionNombre)) {
            terminal.show(UtilConstants.ANSI_RED + "Ya existe un esbirro con ese nombre" + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nombre del Esbirro");
            opcionNombre = terminal.read();
        }

        terminal.show("Escribe el valor de salud (entre 0 y 5)");
        int modificador = Integer.parseInt(terminal.read());
        while (modificador > 5 || modificador < 0) {
            terminal.show(UtilConstants.ANSI_RED + "El valor es incorrecto" + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el valor de salud (entre 0 y 5)");
            modificador = Integer.parseInt(terminal.read());
        }

        if ("Humano".equalsIgnoreCase(opcionTipo)){
            terminal.show("Escribe el valor de lealtad (ALTA/NORMAL/BAJA)");
            String lealtad = terminal.read();
            while (!"ALTA".equalsIgnoreCase(lealtad) && !"NORMAL".equalsIgnoreCase(lealtad) && !"BAJA".equalsIgnoreCase(lealtad)){
                terminal.show(UtilConstants.ANSI_RED + "El tipo no es correcto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el valor de lealtad (ALTA/NORMAL/BAJA)");
            }
            Humano humano = new Humano(opcionNombre,modificador,lealtad);
            esbirros.put(opcionNombre,humano);
            terminal.show("Esbirro Añadido");
            humano.mostrar();
        }
        if ("Ghoul".equalsIgnoreCase(opcionTipo)){
            terminal.show("Escribe el valor de dependencia (entre 0 y 5)");
            int dependencia = Integer.parseInt(terminal.read());
            while (dependencia > 5 || dependencia < 0) {
                terminal.show(UtilConstants.ANSI_RED + "El valor es incorrecto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el valor de dependencia (entre 0 y 5)");
                dependencia = Integer.parseInt(terminal.read());
            }
            Ghoul ghoul = new Ghoul(opcionNombre,modificador,dependencia);
            esbirros.put(opcionNombre,ghoul);
            terminal.show("Esbirro Añadido");
            ghoul.mostrar();
        }
        if ("Demonio".equalsIgnoreCase(opcionTipo)){
            terminal.show("Escribe la descripción del Pacto");
            String pacto = terminal.read();
            Demonio demonio = new Demonio(opcionNombre,modificador,pacto);
            esbirros.put(opcionNombre,demonio);
            terminal.show("Esbirro Añadido");
            demonio.mostrar();
        }
    }

    private boolean existeEsbirro(String opcionNombre) {
        return esbirros.containsKey(opcionNombre);
    }

    private void aniadirFortalezas() {
        TextTerminal terminal = new TextTerminal();
        Map<String, Fortaleza> listaFortalezas = getFortalezas();
        terminal.show("Escribe el nombre de la Fortaleza");
        String opcionNombre = terminal.read();
        while (existeFortaleza(opcionNombre)) {
            terminal.show(UtilConstants.ANSI_RED + "Ya existe una fortaleza con ese nombre" + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nombre de la Fortaleza");
            opcionNombre = terminal.read();
        }
        terminal.show("Escribe el valor de puntos de modificador (entre 0 y 5)");
        int modificador = Integer.parseInt(terminal.read());
        while (modificador > 5 || modificador < 0) {
            terminal.show(UtilConstants.ANSI_RED + "El valor es incorrecto" + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el valor de puntos de modificador (entre 0 y 5)");
            modificador = Integer.parseInt(terminal.read());
        }
        Fortaleza fortaleza = new Fortaleza(opcionNombre,modificador);
        terminal.show(UtilConstants.ANSI_YELLOW + "Fortaleza añadida:" + UtilConstants.ANSI_RESET);
        fortaleza.mostrar();
        fortalezas.put(opcionNombre,fortaleza);
    }

    private void aniadirDebilidades() {
        TextTerminal terminal = new TextTerminal();
        Map<String, Debilidad> listaDebilidades = getDebilidades();
        terminal.show("Escribe el nombre de la Debilidad");
        String opcionNombre = terminal.read();
        while (existeDebilidad(opcionNombre)) {
            terminal.show(UtilConstants.ANSI_RED + "Ya existe una debilidad con ese nombre" + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nombre de la Debilidad");
            opcionNombre = terminal.read();
        }
        terminal.show("Escribe el valor de puntos de modificador (entre 0 y 5)");
        int modificador = Integer.parseInt(terminal.read());
        while (modificador > 5 || modificador < 0) {
            terminal.show(UtilConstants.ANSI_RED + "El valor es incorrecto" + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el valor de puntos de modificador (entre 0 y 5)");
            modificador = Integer.parseInt(terminal.read());
        }
        Debilidad debilidad = new Debilidad(opcionNombre,modificador);
        terminal.show(UtilConstants.ANSI_YELLOW + "Debilidad añadida:" + UtilConstants.ANSI_RESET);
        debilidad.mostrar();
        debilidades.put(opcionNombre,debilidad);
    }

    private void aniadirArmaduras() {
        TextTerminal terminal = new TextTerminal();
        int num = 0;
        if (this instanceof Vampiro){
            num = 1;
        } else if (this instanceof Licantropo){
            num = 2;
        } else if (this instanceof Cazador){
            num = 3;
        }
        String opcion = "Si";
        if ("Si".equalsIgnoreCase(opcion)) {
            Map<String, Armadura> listaArmaduras = getArmaduras();
            terminal.show("Escribe el nombre de la Armadura");
            String opcionNombre = terminal.read();
            while (existeEquipoArmadura(opcionNombre)) {
                terminal.show(UtilConstants.ANSI_RED + "Ya existe una armadura con ese nombre" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el nombre de la Armadura");
                opcionNombre = terminal.read();
            }

            terminal.show("Escribe el valor de potencial de defensa (entre 0 y 5)");
            int potencialDefensa = Integer.parseInt(terminal.read());
            while (potencialDefensa > 5 || potencialDefensa < 0) {
                terminal.show(UtilConstants.ANSI_RED + "El valor es incorrecto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el valor de potencial de defensa (entre 0 y 5)");
                potencialDefensa = Integer.parseInt(terminal.read());
            }

            terminal.show("¿Añadir potencial de ataque? (Si/No)");
            opcion = terminal.read();
            int potencialAtaque = 0;
            if ("Si".equalsIgnoreCase(opcion)) {
                terminal.show("Escribe el valor de potencial de ataque (entre 0 y 5)");
                potencialAtaque = Integer.parseInt(terminal.read());
                while (potencialAtaque > 5 || potencialAtaque < 0) {
                    terminal.show(UtilConstants.ANSI_RED + "El valor es incorrecto" + UtilConstants.ANSI_RESET);
                    terminal.show("Escribe el valor de potencial de ataque (entre 0 y 5)");
                    potencialAtaque = Integer.parseInt(terminal.read());
                }
            }
            Armadura armaduraNew = new Armadura(opcionNombre, num, potencialAtaque, potencialDefensa);
            terminal.show(UtilConstants.ANSI_YELLOW + "Armadura añadida:" + UtilConstants.ANSI_RESET);
            armaduraNew.mostrar();
            armaduras.put(opcionNombre, armaduraNew);
        }
    }

    public void aniadirArmas() {
        TextTerminal terminal = new TextTerminal();
        int num = 0;
        if (this instanceof Vampiro){
            num = 1;
        } else if (this instanceof Licantropo){
            num = 2;
        } else if (this instanceof Cazador){
            num = 3;
        }
        String opcion = "Si";
        if ("Si".equalsIgnoreCase(opcion)) {
            Map<String, Arma> listaArmas = getArmas();
            terminal.show("Escribe el nombre del Arma");
            String opcionNombre = terminal.read();
            while (existeArma(opcionNombre)){
                terminal.show(UtilConstants.ANSI_RED + "Ya existe un arma con ese nombre" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el nombre del Arma");
                opcionNombre = terminal.read();
            }

            terminal.show("Escribe el valor de potencial de ataque (entre 0 y 5)");
            int potencialAtaque = Integer.parseInt(terminal.read());
            while (potencialAtaque > 5 || potencialAtaque < 0){
                terminal.show(UtilConstants.ANSI_RED + "El valor es incorrecto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el valor de potencial de ataque (entre 0 y 5)");
                potencialAtaque = Integer.parseInt(terminal.read());
            }

            terminal.show("¿Añadir potencial de defensa? (Si/No)");
            opcion = terminal.read();
            int potencialDefensa = 0;
            if ("Si".equalsIgnoreCase(opcion)){
                terminal.show("Escribe el valor de potencial de defensa (entre 0 y 5)");
                potencialDefensa = Integer.parseInt(terminal.read());
                while (potencialDefensa > 5 || potencialDefensa < 0){
                    terminal.show(UtilConstants.ANSI_RED + "El valor es incorrecto" + UtilConstants.ANSI_RESET);
                    terminal.show("Escribe el valor de potencial de defensa (entre 0 y 5)");
                    potencialDefensa = Integer.parseInt(terminal.read());
                }
            }

            terminal.show("Escribe el numero de manos del arma (1/2)");
            int manos = Integer.parseInt(terminal.read());
            while (manos > 2 || manos < 1){
                terminal.show(UtilConstants.ANSI_RED + "El valor es incorrecto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el numero de manos del arma (1/2)");
                manos = Integer.parseInt(terminal.read());
            }

            Arma armaNew = new Arma(opcionNombre,num,manos,potencialAtaque,potencialDefensa);
            terminal.show(UtilConstants.ANSI_YELLOW + "Arma añadida:" + UtilConstants.ANSI_RESET);
            armaNew.mostrar();
            armas.put(opcionNombre,armaNew);
        }

    }

    private boolean existeArma(String opcionDeb) {
        return armas.containsKey(opcionDeb);
    }

    Map<String,Arma> getArmas() {
        return this.armas;
    }

    public void mostrarTodasArmas() {
        Map<String, Arma> listaArmas = getArmas();
        for (Map.Entry<String, Arma> entry : listaArmas.entrySet()) {
            String key = entry.getKey();
            Arma armaMostrar = getArma(key);
            armaMostrar.mostrar();
        }
    }

    Arma getArma(String key) {
        return armas.get(key);
    }

    public boolean existeEquipo(String opcion) {
        return armas.containsKey(opcion);
    }

    public int manosSuficientes(String opcion) {
        Arma arma = armas.get(opcion);
        return arma.getManos();
    }

    public void mostrarTodasArmaduras() {
        Map<String, Armadura> listaArmaduras = getArmaduras();
        for (Map.Entry<String, Armadura> entry : listaArmaduras.entrySet()) {
            String key = entry.getKey();
            Armadura armaduraMostrar = getArmadura(key);
            armaduraMostrar.mostrar();
        }
    }

    private Armadura getArmadura(String key) {
        return this.armaduras.get(key);
    }

    Map<String,Armadura> getArmaduras() {
        return this.armaduras;
    }

    public boolean existeEquipoArmadura(String opcion) {
        return armaduras.containsKey(opcion);
    }

    public Object getAmadura(String opcion) {
        return this.armaduras.get(opcion);
    }

    public void mostrarEsbirros() {
        TextTerminal terminal = new TextTerminal();
        if (esbirros.isEmpty()){
            terminal.show("El personaje " + this.nombre + " no tiene esbirros");
        }
        else {
            terminal.show("Esbirros del personaje " + this.nombre);
            for (Map.Entry<String, Esbirro> entry : esbirros.entrySet()) {
                String key = entry.getKey();
                Esbirro esbirro = esbirros.get(key);
                esbirro.mostrar();
            }
        }
    }

    public void editarEquipo() {
        TextTerminal terminal = new TextTerminal();
        terminal.show("¿Cambiar Armas? (Si/No)");
        String opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            Map<String, Arma> listaArmas = getArmas();
            for (Map.Entry<String, Arma> entry : listaArmas.entrySet()) {
                String key = entry.getKey();
                Arma arma = getArma(key);
                arma.mostrar();
            }
            terminal.show("Escribe el nombre del Arma");
            String opcionDeb = terminal.read();
            while (!existeArma(opcionDeb)){
                terminal.show(UtilConstants.ANSI_RED + "El nombre no es correcto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el nombre del Arma");
                opcionDeb = terminal.read();
            }
            Arma armaNew = getArma(opcionDeb);
            String nombreOld = armaNew.getId();
            armaNew.editar();
            terminal.show(UtilConstants.ANSI_YELLOW + "Arma actualizada:" + UtilConstants.ANSI_RESET);
            armaNew.mostrar();
            actualizarArmas(armaNew,nombreOld);
        }


        terminal.show("¿Cambiar Armaduras? (Si/No)");
        opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            Map<String, Armadura> listaArmaduras = getArmaduras();
            for (Map.Entry<String, Armadura> entry : listaArmaduras.entrySet()) {
                String key = entry.getKey();
                Armadura armadura = getArmadura(key);
                armadura.mostrar();
            }
            terminal.show("Escribe el nombre de la Armadura");
            String opcionDeb = terminal.read();
            while (!existeEquipoArmadura(opcionDeb)){
                terminal.show(UtilConstants.ANSI_RED + "El nombre no es correcto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el nombre de la armadura");
                opcionDeb = terminal.read();
            }
            Armadura armaduraNew = getArmadura(opcionDeb);
            String nombreOld = armaduraNew.getId();
            armaduraNew.editar();
            terminal.show(UtilConstants.ANSI_YELLOW + "Armadura actualizada:" + UtilConstants.ANSI_RESET);
            armaduraNew.mostrar();
            actualizarArmadura(armaduraNew,nombreOld);
        }
    }

    private void actualizarArmadura(Armadura armaduraNew, String nombreOld) {
        armaduras.remove(nombreOld);
        armaduras.put(armaduraNew.getId(),armaduraNew);
    }

    private void actualizarArmas(Arma armaNew, String nombreOld) {
        armas.remove(nombreOld);
        armas.put(armaNew.getId(),armaNew);
    }

    public void editarEsbirros() {
        TextTerminal terminal = new TextTerminal();
        terminal.show("¿Cambiar Esbirros? (Si/No)");
        String opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            if (esbirros.isEmpty()) {
                terminal.show("El personaje " + this.nombre + " no tiene esbirros");
            } else {
                mostrarEsbirros();
                terminal.show("Escribe el nombre del Esbirro");
                String opcionDeb = terminal.read();
                while (!existeEsbirro(opcionDeb)) {
                    terminal.show(UtilConstants.ANSI_RED + "El nombre no es correcto" + UtilConstants.ANSI_RESET);
                    terminal.show("Escribe el nombre del Esbirro");
                    opcionDeb = terminal.read();
                }

                Esbirro esbirro = esbirros.get(opcionDeb);
                String nombreOld = esbirro.getNombre();
                esbirro.editar();
                terminal.show(UtilConstants.ANSI_YELLOW + "Esbirro actualizado:" + UtilConstants.ANSI_RESET);
                esbirro.mostrar();
                actualizarEsbirro(esbirro, nombreOld);

            }
        }
    }

    private void actualizarEsbirro(Esbirro esbirro, String nombreOld) {
        esbirros.remove(nombreOld);
        esbirros.put(esbirro.getNombre(),esbirro);
    }
}