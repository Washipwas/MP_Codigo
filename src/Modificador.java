import java.io.Serializable;

/**
 *
 */
public abstract class Modificador implements Serializable {


    public Modificador(String nombre, int valor) {

        this.nombre = nombre;
        this.valor = valor;
    }


    public String getNombre() {
        return this.nombre;
    }

    public int getValor() {
        return this.valor;
    }


    private String nombre;

    private int valor;

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
        terminal.show("¿Cambiar puntos de modificador? (Si/No)");
        opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            terminal.show(UtilConstants.ANSI_BLUE + "Puntos de modificador actual: " + this.valor + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nuevo valor (entre 1 y 5)");
            int opcionNum = Integer.parseInt(terminal.read());
            while (opcionNum > 5 || opcionNum < 1 ){
                terminal.show(UtilConstants.ANSI_RED + "Valor incorrecto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el nuevo valor (entre 1 y 5)");
                opcionNum = Integer.parseInt(terminal.read());
            }
            this.valor = opcionNum;
            terminal.show(UtilConstants.ANSI_YELLOW + "Puntos de modificador nuevo: " + this.valor + UtilConstants.ANSI_RESET);
        }
    }

    public void mostrar() {
        System.out.print("Nombre: " + this.nombre + "     ");
        System.out.println("Puntos de modificador: " + this.valor);
    }
}


// generar potencial ataque y defensa no deberian de ir aquí
/**
 * public int generarPotencialAtaque() {
 * // TODO implement here
 * return 0;
 * }
 * <p>
 * <p>
 * <p>
 * <p>
 * public int generarPotencialDefensa() {
 * // TODO implement here
 * return 0;
 * }
 */


