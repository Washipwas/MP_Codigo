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
        escogerArmas();
        //escogerArmaduras();
    }

    public void escogerArmas() {
        terminal.show("Estas son tus armas disponibles, elija una escribiendo el nombre:");
        int num = 0;
        if (usuarioActivo.getPersonaje() instanceof Vampiro){
            num = 1;
        } else if (usuarioActivo.getPersonaje() instanceof Licantropo){
            num = 2;
        } else if (usuarioActivo.getPersonaje() instanceof Cazador){
            num = 3;
        }
        manager.mostrarEquipo(num);
        String opcion = terminal.read();

        while (!this.manager.existeEquipo(opcion,num)){
            terminal.show(UtilConstants.ANSI_RED + "El nombre no es correcto" + UtilConstants.ANSI_RESET);
            terminal.show("Estas son tus armas disponibles, elija una escribiendo el nombre:");
            manager.mostrarEquipo(num);
            opcion = terminal.read();
        }
        Arma arma = (Arma) manager.getObject(opcion,4);
        this.usuarioActivo.setArma(arma);
        terminal.show(UtilConstants.ANSI_GREEN + "Arma seleccionada correctamente" + UtilConstants.ANSI_RESET);
        this.manager.guardar();

        /*
        //no tiene ningun arma
        if (manosOcupadas == 0) {
            terminal.show("Escriba el nombre del arma a seleccionar:");
            String opcion = terminal.read();
            if (armas.get(opcion).getManos() == 1) {
                arma1 = armas.get(opcion);
                manosOcupadas += 1;
                terminal.show("¿Quieres escoger otra Arma?: (si/no)");
                String otro = terminal.read();
                if (otro.equalsIgnoreCase("si")) {
                    terminal.show("Escoja otra arma: ");
                    String opcion2 = terminal.read();
                    if (armas.get(opcion2).getManos() == 2) {
                        terminal.show("Solo puedes escoger armas de 1 mano");
                        escogerArmas();
                    } else {
                        manosOcupadas += 1;
                    }
                }

            } else {
                terminal.show("Arma elegida con exito");
                manosOcupadas = 2;
            }
            //tiene ya 1 arma de 1 mano elegida
        } else if (manosOcupadas == 1) {
            terminal.show("Escriba el nombre del arma a seleccionar:");
            String opcion = terminal.read();
            if (armas.get(opcion).getManos() == 2) {
                terminal.show("Solo puedes escoger armas de 1 mano");
                escogerArmas();
            } else {
                arma2 = armas.get(opcion);
                manosOcupadas += 1;
                terminal.show("Arma elegida con exito");
            }
            //tiene las manos ocupadas
        } else {
            terminal.show("¿Tienes las manos ocupadas, quieres cambiar tus armas?: (si/no)");
            String opcion = terminal.read();
            if (opcion.equalsIgnoreCase("si")) {
                manosOcupadas = 0;
                escogerArmas();
            }
        }
        */
    }

    /*
    public void escogerArmaduras() {
        terminal.show("Estas son tus armaduras disponibles:");
        //mostrar las armadura disponibles
        for (String nombre : armaduras.keySet()) {
            terminal.show(nombre);
        }

        if (armadura == null) {
            terminal.show("Escriba el nombre de la armadura a seleccionar: ");
            String opcion = terminal.read();
            armadura = armaduras.get(opcion);
            terminal.show("Armadura elegida con éxito");

        } else {

            terminal.show("Tu armadura actual es " + armadura.getId() + ", ¿deseas cambiarla? (si/no)");
            String opcion = terminal.read();
            if (opcion.equalsIgnoreCase("si")) {
                armadura = null;
                escogerArmaduras();
            }

        }

    }*/

    /**
     * @return
     */
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