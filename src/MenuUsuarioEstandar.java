/**
 * 
 */
public class MenuUsuarioEstandar extends MenuUsuario {

    /**
     * Default constructor
     */
    public MenuUsuarioEstandar(String nick, Manager manager) {
        super(nick,manager);
    }

    @Override
    public void seleccionarOpcion() {
            int opcion = Integer.parseInt(this.terminal.read());
            while (opcion != 8) {
                if (opcion == 1) {
                    aniadirPersonaje();
                } else if (opcion == 2) {
                    eliminarPersonaje();
                } else if (opcion == 3) {
                    elegirArmasYArmaduras();
                } else if (opcion == 4) {
                    desafiarUsuarios();
                } else if (opcion == 5) {
                    consultarRegistro();
                } else if (opcion == 6) {
                    consultarRanking();
                } else if (opcion == 7) {
                    if (darmeBaja()) {
                        break;
                    }
                } else {
                    terminal.show("La opcion no es valida");
                }
                mostrarMenu();
                opcion = Integer.parseInt(this.terminal.read());
        }
    }
    private PersonajeUser personaje;

    /**
     * 
     */
    public void aniadirPersonaje() {
        // TODO implement here
    }

    /**
     * 
     */
    public void eliminarPersonaje() {
        // TODO implement here
    }

    /**
     * 
     */
    public void elegirArmasYArmaduras() {
        // TODO implement here
    }

    /**
     * @return
     */
    public Personaje desafiarUsuarios() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void gestionarInvitacionDesafio() {
        // TODO implement here
    }

    /**
     * 
     */
    public void consultarRegistro() {
        // TODO implement here
    }

    /**
     * 
     */
    public void consultarRanking() {
        // TODO implement here
    }

    /**
     * @return
     */
    public boolean combatePendiente() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean estaBloqueado() {
        // TODO implement here
        return false;
    }

}