/**
 * 
 */
public class Licantropo extends Personaje {

    private int rabia;
    private Don don;


    public Licantropo(String nombre, int salud, int poder, int rabia,TextTerminal terminal) {
        super(nombre, poder , salud,terminal);
        this.rabia = rabia;
        don = new Don("Don",3, 1);
        crearDebilidades();
        crearFortalezas();

    }


    @Override
    public int sumarPotencialAtaque() {
        int valor = super.getPoder() + rabia + getValorAtaqueArmaActiva() + getValorAtaqueArmaduraActiva() + getFortalezaActiva().getValor();
        if (don.getRabia() < rabia){
            rabia -= don.getRabia();
            return valor + don.getValorAtaque();
        }
        else {
            return valor;
        }

    }

    @Override
    public int sumarPotencialDefensa() {
        int valor = super.getPoder() + rabia + getValorDefensaArmaActiva() + getValorDefensaArmaduraActiva() - getDebilidadActiva().getValor();
        if (don.getRabia() < rabia){
            rabia -= don.getRabia();
            return valor + don.getValorDefensa();
        }
        else {
            return valor;
        }

    }

    private void crearDebilidades(){
        Debilidad debilidad1 = new Debilidad("Agua Bendita", 3);
        getDebilidades().put(debilidad1.getNombre(), debilidad1);
        Debilidad debilidad2 = new Debilidad("Plata", 3);
        getDebilidades().put(debilidad2.getNombre(), debilidad2);

    }

    private void crearFortalezas(){
        Fortaleza fortaleza1 = new Fortaleza("Sentidos Agudizados", 2);
        getFortalezas().put(fortaleza1.getNombre(), fortaleza1);
        Fortaleza fortaleza2 = new Fortaleza("Fuerza Descontrolada", 4);
        getFortalezas().put(fortaleza2.getNombre(), fortaleza2);
    }

    public void crearArmas(){
        Arma arma3 = new Arma("Cañon de mano", 3, 1, 2, 0);
        getArmas().put(arma3.getId(), arma3);
        Arma arma2 = new Arma("Catana",2,2, 2, 0);
        getArmas().put(arma2.getId(), arma2);
    }

    public void crearArmaduras(){
        Armadura armadura1 = new Armadura("Armadura de papel",2,0, 1);
        getArmaduras().put(armadura1.getId(), armadura1);
        Armadura armadura3 = new Armadura("Armadura ardiente", 1,3, 1);
        getArmaduras().put(armadura3.getId(), armadura3);
        Armadura armadura4 = new Armadura("Armadura siniestra",3, 2, 2);
        getArmaduras().put(armadura4.getId(), armadura4);
    }


    public void mostrarAtributosExtras() {
        System.out.println("Rabia: " + String.valueOf(rabia));
    }

    public void editarAtributosExtras() {
        TextTerminal terminal = new TextTerminal();
        terminal.show("¿Cambiar Puntos de rabia? (Si/No)");
        String opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            terminal.show(UtilConstants.ANSI_BLUE + "Puntos de rabia actual: " + this.rabia + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nuevo valor (entre 0 y 3)");
            int opcionNum = Integer.parseInt(terminal.read());
            while (opcionNum > 3 || opcionNum < 0 ){
                terminal.show(UtilConstants.ANSI_RED + "Valor incorrecto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el nuevo valor (entre 0 y 3)");
                opcionNum = Integer.parseInt(terminal.read());
            }
            this.rabia = opcionNum;
            terminal.show(UtilConstants.ANSI_YELLOW + "Puntos de rabia nuevo: " + this.rabia + UtilConstants.ANSI_RESET);
        }
    }
}