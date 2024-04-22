import java.io.Serializable;

/**
 * 
 */
public abstract class Esbirro implements Serializable {

    /**
     * Default constructor
     */
    public Esbirro(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
    }

    private String nombre;
    private int vida;

    public int getVida() {  // este metodo servira para sumar la vida de todos los esbirros de un personaje
       return this.vida;
    }

    public void mostrar() {
        if (this instanceof Humano){
            System.out.print("Clase: Humano     ");
        } else if (this instanceof Ghoul){
            System.out.print("Clase: Ghoul     ");
        } else if (this instanceof Demonio){
            System.out.print("Clase: Demonio     ");
        }
        System.out.print("Nombre: " + this.nombre + "    ");
        System.out.print("Salud: " + this.vida + "     ");
        mostrarExtra();
    }

    protected abstract void mostrarExtra();

    public String getNombre() {
        return this.nombre;
    }

    public void editar() {
        TextTerminal terminal = new TextTerminal();
        terminal.show("¿Cambiar nombre? (Si/No)");
        String opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            terminal.show(UtilConstants.ANSI_BLUE + "Nombre actual: " + this.nombre+ UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nuevo nombre");
            this.nombre = terminal.read();
            terminal.show(UtilConstants.ANSI_YELLOW + "Nombre nuevo: " + this.nombre + UtilConstants.ANSI_RESET);
        }
        terminal.show("¿Cambiar valor de salud? ? (Si/No)");
        opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            terminal.show(UtilConstants.ANSI_BLUE + "Puntos de salud actual: " + this.vida + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nuevo valor (entre 1 y 3)");
            int opcionNum = Integer.parseInt(terminal.read());
            while (opcionNum > 3 || opcionNum < 1 ){
                terminal.show(UtilConstants.ANSI_RED + "Valor incorrecto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el nuevo valor (entre 1 y 3)");
                opcionNum = Integer.parseInt(terminal.read());
            }
            this.vida = opcionNum;
            terminal.show(UtilConstants.ANSI_YELLOW + "Puntos de salud nuevos: " + this.vida + UtilConstants.ANSI_RESET);
        }
        editarExtra();
    }

    protected abstract void editarExtra();
}