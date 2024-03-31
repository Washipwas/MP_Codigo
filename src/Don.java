/**
 * 
 */
public class Don extends HabilidadEspecial {

    /**
     * Default constructor
     */
    public Don(String nombre, int valorAtaque, int valorDefensa, int rabia) {
        super(nombre, valorAtaque, valorDefensa);
        this.rabia = rabia;
    }

    @Override
    public void mostrarHabilidadExtra() {
        System.out.println("Rabia: " + this.rabia);
    }
    private int rabia;

    public int getRabia(){
        return this.rabia;
    }

    @Override
    protected void editarExtra() {
        TextTerminal terminal = new TextTerminal();
        terminal.show("¿Cambiar valor de rabia? ? (Si/No)");
        String opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            terminal.show(UtilConstants.ANSI_BLUE + "Puntos de rabia actual: " + this.rabia + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nuevo valor (mayor que 0)");
            int opcionNum = Integer.parseInt(terminal.read());
            while (opcionNum < 0 ){
                terminal.show(UtilConstants.ANSI_RED + "Valor incorrecto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el nuevo valor (mayor que 0)");
                opcionNum = Integer.parseInt(terminal.read());
            }
            this.rabia = opcionNum;
            terminal.show(UtilConstants.ANSI_YELLOW + "Puntos de rabia nuevo: " + this.rabia + UtilConstants.ANSI_RESET);
        }
    }

}