/**
 * 
 */
public class Disciplina extends HabilidadEspecial {

    /**
     * Default constructor
     */
    public Disciplina(String nombre, int valorAtaque, int valorDefensa, int coste) {
        super(nombre,valorAtaque,valorDefensa);
        this.coste = coste;
    }

    public int getCoste() {
        if(this==null){
            return 0;
        }
        return this.coste;
    }


    @Override
    public void mostrarHabilidadExtra() {
        System.out.println("Coste: " + this.coste);
    }

    @Override
    protected void editarExtra() {
        TextTerminal terminal = new TextTerminal();
        terminal.show("¿Cambiar valor de coste? ? (Si/No)");
        String opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)) {
            terminal.show(UtilConstants.ANSI_BLUE + "Coste actual: " + this.coste + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nuevo valor (entre 1 y 3)");
            int opcionNum = Integer.parseInt(terminal.read());
            while (opcionNum > 3 || opcionNum < 1 ){
                terminal.show(UtilConstants.ANSI_RED + "Valor incorrecto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el nuevo valor (entre 1 y 3)");
                opcionNum = Integer.parseInt(terminal.read());
            }
            this.coste = opcionNum;
            terminal.show(UtilConstants.ANSI_YELLOW + "Coste nuevo: " + this.coste + UtilConstants.ANSI_RESET);
        }
    }

    private int coste;

}