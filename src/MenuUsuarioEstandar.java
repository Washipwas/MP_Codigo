/**
 * 
 */
public class MenuUsuarioEstandar extends MenuUsuario {

    /**
     * Default constructor
     */
    public MenuUsuarioEstandar(String nick, Manager manager) {
        super(nick,manager);//llama al constructor de la clase padre y se le pasan los parámetros nick y manager// a su vez este h
    }
    //ahora la clase menu-usuario-estandar tiene en sus atributos a un mánager,
    //en su atributo usuario-activo tiene al usuario que cumpla con el nick pasado
    //tiene un atributo terminal


    @Override
    public void seleccionarOpcion() {
            int opcion = Integer.parseInt(this.terminal.read());
            while (opcion != 8) {
                if (opcion == 1) {
                    registrarPersonaje();
                } else if (opcion == 2) {
                    eliminarPersonaje();
                } else if (opcion == 3) {
                    elegirArmasYArmaduras();
                    this.usuarioActivo.mostrarArmas();
                    this.usuarioActivo.mostrarArmadura();
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
                    terminal.show(UtilConstants.ANSI_RED + "La opcion no es valida" + UtilConstants.ANSI_RESET);
                }
                terminal.show(UtilConstants.ANSI_YELLOW+ "Pulse cualquier tecla para continuar" + UtilConstants.ANSI_RESET);
                terminal.read();
                mostrarMenu();
                opcion = Integer.parseInt(this.terminal.read());
        }
    }
    public void registrarPersonaje() {
        this.manager.mostrar(2);
        this.terminal.show("Escribe el nombre del personaje");
        String nombre = terminal.read();
        while (! this.manager.existe(nombre,2)) {
            terminal.show(UtilConstants.ANSI_RED + "El nombre no es correcto" + UtilConstants.ANSI_RESET);
            terminal.show("Escribe el nombre del personaje");
            nombre = terminal.read();
        }
        Personaje personaje = (Personaje) this.manager.getObject(nombre,2);
        this.usuarioActivo.newPersonajeUser(personaje);
        terminal.show(UtilConstants.ANSI_GREEN + "Personaje " +  personaje.getNombre() + " registrado correctamente en el usuario " + usuarioActivo.getNombre() + UtilConstants.ANSI_RESET);
        this.manager.guardar();
    }

    public void eliminarPersonaje() {
        if (usuarioActivo.getPersonaje() == null){
            terminal.show(UtilConstants.ANSI_RED +"No tiene ningún personaje asociado a su cuenta" + UtilConstants.ANSI_RESET);
        } else{
            terminal.show("Se va a eliminar el personaje " + usuarioActivo.getPersonaje().getNombre() + " vinculado al usuario " + usuarioActivo.getNombre());
            terminal.show("¿Continuar? (Si/No)");
            String opcion = terminal.read();
            if ("Si".equalsIgnoreCase(opcion)) {
                this.usuarioActivo.setPersonajeUser((Personaje) null);
                terminal.show(UtilConstants.ANSI_GREEN + "Baja de personaje completada" + UtilConstants.ANSI_RESET);
            } else {
                terminal.show(UtilConstants.ANSI_RED + "Baja de personaje cancelada" + UtilConstants.ANSI_RESET);
            }
            this.manager.guardar();
        }
    }

    public void elegirArmasYArmaduras() {
        if (usuarioActivo.getPersonaje() == null){
            terminal.show(UtilConstants.ANSI_RED +"No tiene ningún personaje asociado a su cuenta" + UtilConstants.ANSI_RESET);
        } else {
            terminal.show("Escoge una opción (1/2)");
            terminal.show("Escoger Armas");
            terminal.show("Escoger Armaduras");
            String opcion = terminal.read();
            if ("1".equalsIgnoreCase(opcion)) {
                escogerArmas();
            } else{
                escogerArmadura();
            }
        }
    }

    public void escogerArmas() {
        terminal.show(UtilConstants.ANSI_BLUE + "Armas actuales" + UtilConstants.ANSI_RESET);
        this.usuarioActivo.mostrarArmas();
        int manosLibres = usuarioActivo.getManosLibres();
        int num = 0;
        if (usuarioActivo.getPersonaje() instanceof Vampiro){
            num = 1;
        } else if (usuarioActivo.getPersonaje() instanceof Licantropo){
            num = 2;
        } else if (usuarioActivo.getPersonaje() instanceof Cazador){
            num = 3;
        }
        if (manosLibres == 2){
            terminal.show("Estas son tus armas disponibles, elija una escribiendo el nombre:");
            manager.mostrarEquipo(num);
            String opcion = terminal.read();

            while (!this.manager.existeEquipo(opcion,num)){
                terminal.show(UtilConstants.ANSI_RED + "El nombre no es correcto" + UtilConstants.ANSI_RESET);
                terminal.show("Estas son tus armas disponibles, elija una escribiendo el nombre:");
                manager.mostrarEquipo(num);
                opcion = terminal.read();
            }
            Arma arma = (Arma) manager.getObject(opcion,4);
            this.usuarioActivo.setArmaIzq(arma);
            terminal.show(UtilConstants.ANSI_GREEN + "Arma elegida con éxito" + UtilConstants.ANSI_RESET);
            manosLibres = 2 - arma.getManos();
            if (manosLibres == 1){
                escogerArmas();
            }
        } else if (manosLibres == 1){
            terminal.show("¿Quieres escoger otra Arma (Si) o hacer una nueva seleccion? (No):");
            String opcion = terminal.read();
            if (opcion.equalsIgnoreCase("Si")) {
                terminal.show("Escoja otra arma (Solo puede escoger armas de 1 mano): ");
                manager.mostrarEquipo(num);
                opcion = terminal.read();
                while (!this.manager.existeEquipo(opcion,num) || (this.manager.manosSuficientes(opcion) != 1)) {
                    terminal.show(UtilConstants.ANSI_RED + "El nombre no es correcto/ No hay manos libres para ese arma" + UtilConstants.ANSI_RESET);
                    terminal.show("Estas son tus armas disponibles, elija una escribiendo el nombre:");
                    manager.mostrarEquipo(num);
                    opcion = terminal.read();
                }
                Arma arma2 = (Arma) manager.getObject(opcion,4);
                this.usuarioActivo.setArmaDer(arma2);
                terminal.show(UtilConstants.ANSI_GREEN + "Arma elegida con éxito" + UtilConstants.ANSI_RESET);
            } else{
                usuarioActivo.setArmaIzq(null);
                escogerArmas();
            }

        } else if (manosLibres == 0){
            terminal.show("Tienes las manos ocupadas, ¿quieres cambiar tus armas?: (Si/No)");
            String opcion = terminal.read();
            if ("Si".equalsIgnoreCase(opcion)) {
                usuarioActivo.setArmaDer(null);
                usuarioActivo.setArmaIzq(null);
                escogerArmas();
            } else{
                terminal.show(UtilConstants.ANSI_RED + "Elección cancelada" + UtilConstants.ANSI_RESET);
            }
        }
        this.manager.guardar();
    }

    public void escogerArmadura(){
        terminal.show(UtilConstants.ANSI_BLUE + "Armadura actual" + UtilConstants.ANSI_RESET);
        this.usuarioActivo.mostrarArmadura();
        int num = 0;
        if (usuarioActivo.getPersonaje() instanceof Vampiro){
            num = 1;
        } else if (usuarioActivo.getPersonaje() instanceof Licantropo){
            num = 2;
        } else if (usuarioActivo.getPersonaje() instanceof Cazador){
            num = 3;
        }
        if (usuarioActivo.notieneArmadura()){
            terminal.show("Estas son tus armaduras disponibles, elija una escribiendo el nombre:");
            manager.mostrarEquipoArmadura(num);
            String opcion = terminal.read();
            while (!this.manager.existeEquipoArmadura(opcion,num)){
                terminal.show(UtilConstants.ANSI_RED + "El nombre no es correcto" + UtilConstants.ANSI_RESET);
                terminal.show("Estas son tus armaduras disponibles, elija una escribiendo el nombre:");
                manager.mostrarEquipo(num);
                opcion = terminal.read();
            }
            Armadura armadura = (Armadura) manager.getObject(opcion,5);
            this.usuarioActivo.setArmadura(armadura);
            terminal.show(UtilConstants.ANSI_GREEN + "Armadura elegida con éxito" + UtilConstants.ANSI_RESET);
        } else {
            terminal.show("Ya tiene una armadura seleccionada, ¿desea camiarla? (Si/No)");
            String opcion = terminal.read();
            if ("Si".equalsIgnoreCase(opcion)) {
                usuarioActivo.setArmadura(null);
                escogerArmadura();
            } else{
                terminal.show(UtilConstants.ANSI_RED + "Elección cancelada" + UtilConstants.ANSI_RESET);
            }
        }
        terminal.show(UtilConstants.ANSI_BLUE + "Armadura actual" + UtilConstants.ANSI_RESET);
        this.usuarioActivo.mostrarArmadura();
        this.manager.guardar();
    }

    public void desafiarUsuarios() {
        if (usuarioActivo.getPersonaje() == null){
            terminal.show(UtilConstants.ANSI_RED + "No tiene ningún personaje asociado a su cuenta para desafiar a otros jugadores" + UtilConstants.ANSI_RESET);
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
                    terminal.show(UtilConstants.ANSI_GREEN + "Solicitud de desafio enviada" + UtilConstants.ANSI_RESET);
                } else{
                    terminal.show(UtilConstants.ANSI_RED + "La cantidad de oro apostada no es válida" + UtilConstants.ANSI_RESET);
                    terminal.show(UtilConstants.ANSI_RED + "Combate cancelado" + UtilConstants.ANSI_RESET);
                }
            } else {
                terminal.show(UtilConstants.ANSI_RED + "El nick no es correcto" + UtilConstants.ANSI_RESET);
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