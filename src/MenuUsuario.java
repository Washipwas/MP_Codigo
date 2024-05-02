public abstract class MenuUsuario {
    public Manager getManager() {
        return manager;
    }

    public MenuUsuario(String nick, Manager manager) { //constructor llamado por el hijo
        this.terminal = new TextTerminal();
        this.manager = manager; //se le pasa el manager extraido en menu principal
        this.usuarioActivo = manager.asociarUsuario(nick); //a su atributo usuarioactivo se le asoscia aquel usuario que coincida con el nick
                                                            // del usuario que tenga en la lista el manager
    }

    //ahora la clase menu-usuario tiene en sus atributos a un mánager,
    //en su atributo usuario-activo tiene al usuario que cumpla con el nick pasado
    //tiene un atrubuto termina

    public TextTerminal terminal;

    public Usuario getUsuarioActivo() {
        return usuarioActivo;
    }

    public Usuario usuarioActivo;
    public Manager manager;

    public Boolean mostrarMenu() {
        terminal.show("Bienvenido " + this.usuarioActivo.getNombre());
        if (usuarioActivo instanceof UsuarioEstandar && usuarioActivo.getDesafiante() != null) {
            comprobarDesafio();
            mostrarMenu();
            return false;
        }
        if (usuarioActivo instanceof UsuarioEstandar && ((UsuarioEstandar) usuarioActivo).getBloqueado()) {//si el usuario pasado es un Usuario-estandar  y si no está bloqueado
            terminal.show(UtilConstants.ANSI_RED + "Su cuenta esta bloqueada, no puede realizar ninguna accion" + UtilConstants.ANSI_RESET);
            terminal.show("Se le redirigirá automáticamente a la pantalla de inicio");
            return true;
        }
        else {
            terminal.show(UtilConstants.ANSI_BLUE +"Seleccione una opción escribiendo el numero correspondiente" + UtilConstants.ANSI_RESET);
            if (this.usuarioActivo instanceof UsuarioEstandar) { //si es un usuario-estandar
                terminal.show("1.Registrar personaje");
                terminal.show("2.Dar de baja mi personaje");
                terminal.show("3.Elegir armas y armaduras");
                terminal.show("4.Desafiar a otro usuario");
                terminal.show("5.Ver historial de combate");
                terminal.show("6.Ver ranking global");
                terminal.show("7.Darme de baja");
                terminal.show("8.Volver a la pantalla de inicio");
            } else { //si es un operador
                terminal.show("1.Editar personaje");
                terminal.show("2.Aniadir armas/armaduras/fortalezas/debilidades/esbirros");
                terminal.show("3.Validar desafios");
                terminal.show("4.Bloquear usuarios");
                terminal.show("5.Desbloquear usuarios");
                terminal.show("6.Darme de baja");
                terminal.show("7.Volver a la pantalla de inicio");
            }
            return false;
        }
    }

    public void seleccionarOpcion() {
        int opcion = Integer.parseInt(terminal.read());
    }

    public boolean darmeBaja(){
        Boolean eliminado = true;
        terminal.show("¿Esta seguro de darse de baja?");
        String opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)){
            this.manager.eliminar(this.usuarioActivo,UtilConstants.FILE_USERS);
            terminal.show(UtilConstants.ANSI_GREEN + "Baja completada" + UtilConstants.ANSI_RESET);
        } else {
            eliminado = false;
        }
        return eliminado;
    }

    public abstract Boolean comprobarDesafio();


}