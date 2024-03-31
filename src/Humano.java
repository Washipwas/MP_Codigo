/**
 * 
 */
public class Humano extends Esbirro {

    private String valorLealtad;
    public Humano(String nombre, int vida, String valorLealtad) {
        super(nombre, vida);
        this.valorLealtad = valorLealtad;
    }
    @Override
    protected void mostrarExtra() {
        System.out.println("Valor Lealtad: " + this.valorLealtad);
    }
    @Override
    protected void editarExtra() {
        TextTerminal terminal = new TextTerminal();
        terminal.show("¿Cambiar valor de Lealtad ? (Si/No)");
        String opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            terminal.show(UtilConstants.ANSI_BLUE + "Puntos de valor de Lealtad actual: " + this.valorLealtad + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nuevo valor (ALTA/NORMAL/BAJA)");
            String opcionNum = terminal.read();
            while (!"ALTA".equalsIgnoreCase(opcionNum) && !"NORMAL".equalsIgnoreCase(opcionNum) && !"BAJA".equalsIgnoreCase(opcionNum)){
                terminal.show(UtilConstants.ANSI_RED + "Valor incorrecto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el nuevo valor (ALTA/NORMAL/BAJA)");
                opcionNum = terminal.read();
            }
            this.valorLealtad = opcionNum;
            terminal.show(UtilConstants.ANSI_YELLOW + "Puntos de salud nuevos: " + this.valorLealtad + UtilConstants.ANSI_RESET);
        }
    }
}