/**
 * 
 */
public class MenuOperador extends MenuUsuario {

    public MenuOperador(String nick, Manager manager) {
        super(nick,manager);
    }

    @Override
    public void seleccionarOpcion() {
        int opcion = Integer.parseInt(this.terminal.read());
        while (opcion != 7){
            if (opcion == 1){
                editarPersonaje();
            } else if (opcion == 2){
                aniadirAlPersonaje();
            } else if (opcion == 3){
                validarDesafios();
            } else if (opcion == 4){
                bloquearUsuarios();
            } else if (opcion == 5){
                desbloquearusuarios();
            } else if (opcion == 6){
                if (darmeBaja()){
                    break;
                }
            } else {
                terminal.show("La opción no es válida");
            }
            mostrarMenu();
            opcion = Integer.parseInt(this.terminal.read());
        }

    }

    public void editarPersonaje() {
        // TODO implement here
    }

    public void aniadirAlPersonaje() {
        // TODO implement here
    }

    public void validarDesafios() {
        terminal.show("Desafios pendientes de validar");
        this.manager.mostrar(3);
        terminal.show("¿Qué desafio quiere escoger?");
        String opcion = terminal.read();
        if (this.manager.existe(opcion,3)){
            terminal.show("Validar (Si/No)");
            String opcion2 = terminal.read();
            if ("Si".equalsIgnoreCase(opcion2)) {
                this.manager.asociarDesafio(opcion);
            } else {
                this.manager.eliminar(opcion,UtilConstants.FILE_COMBATS);
                this.manager.guardar();
                terminal.show("Desafio rechazado");
            }
        } else {
            terminal.show("Opción no válida");
        }
    }

    public void bloquearUsuarios() {
        this.manager.mostrarUsuariosNoNormas();
        terminal.show("Escribe le nick del usuario que quiere bloquear");
        String nick = terminal.read();
        if (manager.existe(nick,1)){
            this.manager.bloquear_desbloquear(nick,true);
        } else {
            terminal.show("El nick no es válido");
        }
    }

    public void desbloquearusuarios() {
        this.manager.mostrarUsuariosBloqueados();
        terminal.show("Escribe le nick del usuario que quiere desbloquear");
        String nick = terminal.read();
        if (manager.existe(nick,1)){
            this.manager.bloquear_desbloquear(nick,false);
        } else {
            terminal.show("El nick no es válido");
        }
    }

}