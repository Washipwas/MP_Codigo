
public class Ghoul extends Esbirro {

    public Ghoul(String nombre, int vida, int dependencia) {
        super(nombre,vida);
        this.dependencia = dependencia;
    }
    @Override
    public void mostrarExtra() {
        System.out.println("Dependencia: " + this.dependencia);
    }

    @Override
    protected void editarExtra() {
        TextTerminal terminal = new TextTerminal();
        terminal.show("¿Cambiar valor de dependencia ? (Si/No)");
        String opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            terminal.show(UtilConstants.ANSI_BLUE + "Puntos de dependencia actual: " + this.dependencia + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nuevo valor (entre 1 y 5)");
            int opcionNum = Integer.parseInt(terminal.read());
            while (opcionNum > 5 || opcionNum < 1 ){
                terminal.show(UtilConstants.ANSI_RED + "Valor incorrecto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el nuevo valor (entre 1 y 5)");
                opcionNum = Integer.parseInt(terminal.read());
            }
            this.dependencia = opcionNum;
            terminal.show(UtilConstants.ANSI_YELLOW + "Puntos de dependencia nuevos: " + this.dependencia + UtilConstants.ANSI_RESET);
        }
    }

    private int dependencia;

}