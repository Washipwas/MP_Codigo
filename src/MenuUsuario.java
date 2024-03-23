public class MenuUsuario {
    public MenuUsuario(String nick, Manager manager) {
        this.terminal = new TextTerminal();
        this.manager = manager;
        this.usuarioActivo = manager.asociarUsuario(nick);
    }
    public TextTerminal terminal;
    public Usuario usuarioActivo;
    public Manager manager;

    public Boolean mostrarMenu() {
        terminal.show("Bienvenido " + this.usuarioActivo.getNombre());
        if (usuarioActivo instanceof UsuarioEstandar && ((UsuarioEstandar) usuarioActivo).getBloqueado()) {
            terminal.show("Su cuenta esta bloqueada, no puede realizar ninguna accion");
            terminal.show("Se le redirigirá automáticamente a la pantalla de inicio");
            return true;
        }
        else {
            terminal.show("Seleccione una opción escribiendo el numero correspondiente");
            if (this.usuarioActivo instanceof UsuarioEstandar) {
                terminal.show("1.Registrar personaje");
                terminal.show("2.Dar de baja mi personaje");
                terminal.show("3.Elegir armas y armaduras");
                terminal.show("4.Desafiar a otro usuario");
                terminal.show("5.Ver historial de combate");
                terminal.show("6.Ver ranking global");
                terminal.show("7.Darme de baja");
                terminal.show("8.Volver a la pantalla de inicio");
            } else {
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
            terminal.show("Baja completada");
        } else {
            eliminado = false;
        }
        return eliminado;
    }


    //public void actualizarFichero(Object bj , fichero Fichero) {
        // TODO implement here
    //}

}