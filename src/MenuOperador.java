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
            terminal.show(UtilConstants.ANSI_YELLOW+ "Pulse cualquier tecla para continuar" + UtilConstants.ANSI_RESET);
            terminal.read();
            mostrarMenu();
            opcion = Integer.parseInt(this.terminal.read());
        }

    }

    @Override
    public Boolean comprobarDesafio() {
        return null;
    }

    public void editarPersonaje() {
        terminal.show("Elige un personaje");
        manager.mostrar(2);
        String opcion = terminal.read();
        if (this.manager.existe(opcion,2)){
            Personaje personaje = (this.manager.asociarPersonaje(opcion));
            String nombre = personaje.getNombre();
            personaje.editar();
            if (personaje instanceof Vampiro){
                ((Vampiro) personaje).editarAtributosExtras();
            } else if (personaje instanceof Licantropo) {
                ((Licantropo) personaje).editarAtributosExtras();
            } else{
                ((Cazador) personaje).editarAtributosExtras();
            }
            personaje.editarEquipo();
            personaje.editarModificadores();
            personaje.editarEsbirros();
            personaje.editarHabilidad();
            this.manager.actualizar(personaje,nombre);
            this.manager.guardar();
        } else {
            terminal.show("El nombre es incorrecto");
        }
    }

    public void aniadirAlPersonaje() {
        terminal.show("Elige un personaje");
        manager.mostrar(2);
        String opcion = terminal.read();
        if (this.manager.existe(opcion,2)) {
            Personaje personaje = (this.manager.asociarPersonaje(opcion));
            personaje.aniadir();
        } else {
        terminal.show("El nombre es incorrecto");
        }
        this.manager.guardar();
    }

    public void validarDesafios() {
        if(this.manager.hayDesafios()){
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
        }else {
            terminal.show(UtilConstants.ANSI_RED+"No existen desafios pendientes"+UtilConstants.ANSI_RESET);
        }

    }

    public void bloquearUsuarios() {
        this.manager.mostrarUsuariosNoNormas();
        terminal.show("Escribe el nick del usuario que quiere bloquear");
        String nick = terminal.read();
        if (manager.existe(nick,1)){
            this.manager.bloquear_desbloquear(nick,true);
        } else {
            terminal.show("El nick no es válido");
        }
    }

    public void desbloquearusuarios() {
        this.manager.mostrarUsuariosBloqueados();
        terminal.show("Escribe el nick del usuario que quiere desbloquear");
        String nick = terminal.read();
        if (manager.existe(nick,1)){
            this.manager.bloquear_desbloquear(nick,false);
        } else {
            terminal.show("El nick no es válido");
        }
    }

}