import java.io.Serializable;

/**
 * 
 */
public abstract class HabilidadEspecial implements Serializable {

    public HabilidadEspecial(String nombre, int valorAtaque, int valorDefensa) {
        this.nombre = nombre;
        this.valorAtaque = valorAtaque;
        this.valorDefensa = valorDefensa;
    }

    private String nombre;

    private int valorAtaque;

    private int valorDefensa;

    public  int getValorAtaque() {
        return this.valorAtaque;
    }

    public int getValorDefensa() {
        return this.valorDefensa;
    }


    public Object getNombre() {
        return this.nombre;
    }

    public void mostrarHabilidadExtra() {
    }

    public void editar() {
        TextTerminal terminal = new TextTerminal();
        terminal.show("¿Cambiar nombre? (Si/No)");
        String opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            terminal.show(UtilConstants.ANSI_BLUE + "Nombre actual: " + this.nombre + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nuevo nombre");
            this.nombre = terminal.read();
            terminal.show(UtilConstants.ANSI_YELLOW + "Nombre nuevo: " + this.nombre + UtilConstants.ANSI_RESET);
        }
        terminal.show("¿Cambiar modificador de ataque? ? (Si/No)");
        opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            terminal.show(UtilConstants.ANSI_BLUE + "Puntos de modificador de ataque actual: " + this.valorAtaque + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nuevo valor (entre 1 y 3)");
            int opcionNum = Integer.parseInt(terminal.read());
            while (opcionNum > 3 || opcionNum < 1 ){
                terminal.show(UtilConstants.ANSI_RED + "Valor incorrecto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el nuevo valor (entre 1 y 3)");
                opcionNum = Integer.parseInt(terminal.read());
            }

            this.valorAtaque = opcionNum;
            terminal.show(UtilConstants.ANSI_YELLOW + "Puntos de modificador nuevo: " + this.valorAtaque + UtilConstants.ANSI_RESET);
        }
        terminal.show("¿Cambiar modificador de defensa? ? (Si/No)");
        opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            terminal.show(UtilConstants.ANSI_BLUE + "Puntos de modificador de ataque actual: " + this.valorDefensa + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nuevo valor (entre 1 y 3)");
            int opcionNum = Integer.parseInt(terminal.read());
            while (opcionNum > 3 || opcionNum < 1 ){
                terminal.show(UtilConstants.ANSI_RED + "Valor incorrecto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el nuevo valor (entre 1 y 3)");
                opcionNum = Integer.parseInt(terminal.read());
            }

            this.valorDefensa = opcionNum;
            terminal.show(UtilConstants.ANSI_YELLOW + "Puntos de modificador nuevo: " + this.valorDefensa + UtilConstants.ANSI_RESET);
        }
        editarExtra();
    }

    protected abstract void editarExtra();
}