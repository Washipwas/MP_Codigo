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

    public void aniadirPersonaje() {
        terminal.show("Elige un personaje");
        manager.mostrar(2);
        String opcion = terminal.read();
        if (this.manager.existe(opcion,2)){
            this.personaje.setPersonaje(this.manager.asociarPersonaje(opcion));
            usuarioActivo.setPersonaje(this.personaje);
            this.manager.guardar();
        } else {
            terminal.show("El nombre es incorrecto");
        }

    }

    public void eliminarPersonaje() {
        if (usuarioActivo.getPersonajeNull()){
            terminal.show("No tiene ningún personaje asociado a su cuenta");
        } else{
            terminal.show("Se va a eliminar el personaje vinculado al usuario " + usuarioActivo.getNombre());
            terminal.show("¿Continuar? (Si/No)");
            String opcion = terminal.read();
            if ("Si".equalsIgnoreCase(opcion)) {
                usuarioActivo.setPersonaje(null);
            }
            this.manager.guardar();
        }
    }

    public void elegirArmasYArmaduras() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void desafiarUsuarios() {
        if (usuarioActivo.getPersonajeNull()){
            terminal.show("No tiene ningún personaje asociado a su cuenta para desafiar a otros jugadores");
        } else{
            terminal.show("A que usuario quiere desafiar");
            this.manager.mostrarUsuariosParaDesafiar(usuarioActivo.getNick());
            String opcion = terminal.read();
            if (this.manager.existeDesafiar(opcion)){
                UsuarioEstandar usuario2 = (UsuarioEstandar) this.manager.asociarUsuario(opcion);
                usuario2.setDesafiante(this.usuarioActivo);
                terminal.show("Solicitud de desafio enviada");
            } else {
                terminal.show("El nick no es correcto");
            }
        }
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