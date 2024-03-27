/**
 * 
 */
public class MenuUsuarioEstandar extends MenuUsuario {

    /**
     * Default constructor
     */
    public MenuUsuarioEstandar(String nick, Manager manager) {
        super(nick,manager);//llama al constructor de la clase padre y se le pasan los parámetros nick y manager// a su vez este h
        this.personaje = usuarioActivo.getPersonajeUser(); //usuario activo es el atributo heredado de la clase padre
    }
    //ahora la clase menu-usuario-estandar tiene en sus atributos a un mánager,
    //en su atributo usuario-activo tiene al usuario que cumpla con el nick pasado
    //tiene un atrubuto terminal


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
        terminal.show("Escribe el nombre del personaje");
        String opcion = terminal.read();
        while (this.manager.existe(opcion,2)) {
            terminal.show("El nombre ya existe");
            terminal.show("Escribe el nombre del personaje");
            opcion = terminal.read();
        }
        terminal.show("Escribe...");
        // Implementar resto de atributos

        Personaje personaje = new Personaje(opcion);   // personaje es abstracto, y el constructor ahora tiene más parametros
        this.manager.aniadir(personaje,UtilConstants.FILE_PERSONAJES);
        this.personaje.setPersonaje(this.manager.asociarPersonaje(opcion));
        usuarioActivo.setPersonaje(this.personaje);
        this.manager.guardar();
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
                terminal.show("Que cantidad de dinero desea apostar?");
                int dinero = Integer.parseInt(terminal.read());
                if (usuarioActivo.oroValido(dinero)){
                    Combate combate = new Combate((UsuarioEstandar) usuarioActivo,usuario2,dinero,"id0");
                    this.manager.aniadir(combate,UtilConstants.FILE_COMBATS);
                    this.manager.guardar();
                    terminal.show("Solicitud de desafio enviada");
                } else{
                    terminal.show("La cantidad de oro apostad no es válida");
                    terminal.show("Combate cancelado");
                }
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
    public void consultarRegistro() { //consultaremos al hashmap con el key del nombre del usuario
        String NombreUsuario=this.usuarioActivo.getNombre();
        //con el nombre vamos a recorrer todo el mapa sacando el combate en cada ocasión
        this.manager.mostrarRegistro(NombreUsuario);
    }

    /**
     * 
     */
    public void consultarRanking() { // en teoría cuando saquemos la información del fichero cada usuario tiene a
        this.manager.mostarRanking();
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