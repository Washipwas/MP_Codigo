import java.util.Set;

public class Demonio extends Esbirro {
    public Demonio(String nombre, int vida, String pacto) {
        super(nombre, vida);
        this.pacto = pacto;
    }
    @Override
    public void mostrarExtra() {
        System.out.println("Pacto: " + this.pacto);
    }

    @Override
    protected void editarExtra() {
        TextTerminal terminal = new TextTerminal();
        terminal.show("¿Cambiar Pacto ? (Si/No)");
        String opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            terminal.show(UtilConstants.ANSI_BLUE + "Pacto actual: " + this.pacto + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nuevo pacto");
            this.pacto = terminal.read();
            terminal.show(UtilConstants.ANSI_YELLOW + "Pacto nuevo: " + this.pacto + UtilConstants.ANSI_RESET);
        }
    }

    private String pacto;

}