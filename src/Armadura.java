import java.io.Serializable;

/**
 * 
 */
public class Armadura extends Equipo implements Serializable {

    public Armadura(String nombre, int equipoClase, int modificadorAtaque, int modificadorDefensa) {
        super(nombre,equipoClase,modificadorAtaque, modificadorDefensa);

    }


    public void mostrar() {
        System.out.print( "* ");
        System.out.print("Nombre: " + this.getId() + "    ");
        System.out.print("Modificador de Ataque: " + this.getModificadorDeAtaque() + "    ");
        System.out.println("Modificador de Defensa: " + this.getModificadorDeDefensa());
    }

    public void editar() {
        TextTerminal terminal = new TextTerminal();
        terminal.show("¿Cambiar nombre? (Si/No)");
        String opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            terminal.show(UtilConstants.ANSI_BLUE + "Nombre actual: " + this.getId() + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nuevo nombre");
            String nombre = terminal.read();
            this.setId(nombre);
            terminal.show(UtilConstants.ANSI_YELLOW + "Nombre nuevo: " + this.getId() + UtilConstants.ANSI_RESET);
        }
        terminal.show("¿Cambiar modificador de ataque? ? (Si/No)");
        opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            terminal.show(UtilConstants.ANSI_BLUE + "Puntos de modificador de ataque actual: " + this.getModificadorDeAtaque() + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nuevo valor (entre 0 y 5)");
            int opcionNum = Integer.parseInt(terminal.read());
            while (opcionNum > 5 || opcionNum < 0 ){
                terminal.show(UtilConstants.ANSI_RED + "Valor incorrecto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el nuevo valor (entre 0 y 5)");
                opcionNum = Integer.parseInt(terminal.read());
            }

            int valor = opcionNum;
            this.setModificadorDeAtaque(valor);
            terminal.show(UtilConstants.ANSI_YELLOW + "Puntos de modificador nuevo: " + this.getModificadorDeAtaque() + UtilConstants.ANSI_RESET);
        }
        terminal.show("¿Cambiar modificador de defensa? ? (Si/No)");
        opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            terminal.show(UtilConstants.ANSI_BLUE + "Puntos de modificador de ataque actual: " + this.getModificadorDeDefensa() + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nuevo valor (entre 1 y 5)");
            int opcionNum = Integer.parseInt(terminal.read());
            while (opcionNum > 5 || opcionNum < 1 ){
                terminal.show(UtilConstants.ANSI_RED + "Valor incorrecto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el nuevo valor (entre 1 y 5)");
                opcionNum = Integer.parseInt(terminal.read());
            }

            int valor = opcionNum;
            this.setModificadorDeDefensa(valor);
            terminal.show(UtilConstants.ANSI_YELLOW + "Puntos de modificador nuevo: " + this.getModificadorDeDefensa() + UtilConstants.ANSI_RESET);
        }
    }
}