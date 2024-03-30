/**
 * 
 */
public class Cazador extends Personaje {

    /**
     * Default constructor
     */
    private int voluntad;
    private Talento talento;

    public Cazador(String nombre, int salud, int poder,TextTerminal terminal) {
        super(nombre,poder,salud,terminal);
        this.voluntad = 3;
        talento = new Talento("Talento", 4,2);
        crearDebilidades();
        crearFortalezas();
    }

    @Override
    public int sumarPotencialAtaque() {
        int valor = super.getPoder() + talento.getValorAtaque() + voluntad + getValorAtaqueArmaActiva() + getValorAtaqueArmaduraActiva();
        int valorModificador = getFortalezaActiva().getValor(); //Valor de la fortaleza presente
        return valor + valorModificador;// se le fuma la fortaleza al potencial de ataque
    }

    @Override
    public int sumarPotencialDefensa() {
        int valor =  super.getPoder() + talento.getValorDefensa() +  voluntad + getValorDefensaArmaActiva() +getValorDefensaArmaduraActiva();
        int valorModificador =  getDebilidadActiva().getValor();
        return valor - valorModificador;// se le resta la debilidad en el potencial defensa
    }

    private void crearDebilidades(){
        Debilidad debilidad1 = new Debilidad("Dependencia emocional", 3);
        getDebilidades().put(debilidad1.getNombre(), debilidad1);
        Debilidad debilidad2 = new Debilidad("Sirenas", 4);
        getDebilidades().put(debilidad2.getNombre(), debilidad2);

    }

    private void crearFortalezas(){
        Fortaleza fortaleza1 = new Fortaleza("Valentia", 5);
        getFortalezas().put(fortaleza1.getNombre(), fortaleza1);
        Fortaleza fortaleza2 = new Fortaleza("Conocimiento", 3);
        getFortalezas().put(fortaleza2.getNombre(), fortaleza2);
    }


    public void mostrarAtributosExtras() {
        System.out.println("Voluntad: " + String.valueOf(voluntad));
    }

    public void editarAtributosExtras() {
        TextTerminal terminal = new TextTerminal();
        terminal.show("¿Cambiar Puntos de voluntad? (Si/No)");
        String opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            terminal.show(UtilConstants.ANSI_BLUE + "Puntos de voluntad actual: " + this.voluntad + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nuevo valor (entre 0 y 3)");
            int opcionNum = Integer.parseInt(terminal.read());
            while (opcionNum > 3 || opcionNum < 0 ){
                terminal.show(UtilConstants.ANSI_RED + "Valor incorrecto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el nuevo valor (entre 0 y 3)");
                opcionNum = Integer.parseInt(terminal.read());
            }
            this.voluntad = opcionNum;
            terminal.show(UtilConstants.ANSI_YELLOW + "Puntos de voluntad nuevo: " + this.voluntad + UtilConstants.ANSI_RESET);
        }
    }
}