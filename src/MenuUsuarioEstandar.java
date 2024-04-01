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

                    if (usuarioActivo.getPersonaje() == null){
                        terminal.show(UtilConstants.ANSI_RED +"No tiene ningún personaje asociado a su cuenta" + UtilConstants.ANSI_RESET);
                    } else{
                        elegirArmasYArmaduras();
                        this.usuarioActivo.mostrarArmas();
                        this.usuarioActivo.mostrarArmadura();
                    }

                } else if (opcion == 4) {
                    desafiarUsuarios();
                    if (this.usuarioActivo.getBloqueado()) {
                        terminal.show(UtilConstants.ANSI_RED + "Su cuenta esta bloqueada, no puede realizar ninguna accion" + UtilConstants.ANSI_RESET);
                        terminal.show("Se le redirigirá automáticamente a la pantalla de inicio");
                        break;
                    }
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
                if (!estaBloqueado()) {
                    opcion = Integer.parseInt(this.terminal.read());
                }
        }
    }
    public void registrarPersonaje() {
        if (usuarioActivo.getPersonaje() == null) {
            this.manager.mostrar(2);
            this.terminal.show("Escribe el nombre del personaje");
            String nombre = terminal.read();
            while (!this.manager.existe(nombre, 2)) {
                terminal.show(UtilConstants.ANSI_RED + "El nombre no es correcto" + UtilConstants.ANSI_RESET);
                terminal.show("Escribe el nombre del personaje");
                nombre = terminal.read();
            }
            Personaje personaje = (Personaje) this.manager.getObject(nombre, 2);
            this.usuarioActivo.newPersonajeUser(personaje);
            terminal.show(UtilConstants.ANSI_GREEN + "Personaje " + personaje.getNombre() + " registrado correctamente en el usuario " + usuarioActivo.getNombre() + UtilConstants.ANSI_RESET);
            this.manager.guardar();
        } else{
            terminal.show(UtilConstants.ANSI_RED +"Ya tiene un personaje asociado a su cuenta" + UtilConstants.ANSI_RESET);
            terminal.show(UtilConstants.ANSI_BLUE + "Personaje actual: " + usuarioActivo.getPersonaje().getNombre() + UtilConstants.ANSI_RESET);
        }
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
            terminal.show("1. Escoger Armas");
            terminal.show("2. Escoger Armaduras");
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
        usuarioActivo.mostrarArmas();
        int manosLibres = usuarioActivo.getManosLibres();
        if (manosLibres == 2){
            terminal.show("Estas son tus armas disponibles, elija una escribiendo el nombre:");
            this.usuarioActivo.mostrarTodasArmas();
            String opcion = terminal.read();

            while (!this.usuarioActivo.existeEquipo(opcion)){
                terminal.show(UtilConstants.ANSI_RED + "El nombre no es correcto" + UtilConstants.ANSI_RESET);
                terminal.show("Estas son tus armas disponibles, elija una escribiendo el nombre:");
                this.usuarioActivo.mostrarTodasArmas();
                opcion = terminal.read();
            }
            Arma arma = (Arma) usuarioActivo.getArma(opcion);
            this.usuarioActivo.setArmaIzq(arma);
            terminal.show(UtilConstants.ANSI_GREEN + "Arma elegida con éxito" + UtilConstants.ANSI_RESET);
        } else if (manosLibres == 1){
            terminal.show("¿Quieres escoger otra Arma (Si) o hacer una nueva seleccion? (No):");
            String opcion = terminal.read();
            if (opcion.equalsIgnoreCase("Si")) {
                terminal.show("Escoja otra arma (Solo puede escoger armas de 1 mano): ");
                this.usuarioActivo.mostrarTodasArmas();
                opcion = terminal.read();
                while (!this.usuarioActivo.existeEquipo(opcion) || (this.usuarioActivo.manosSuficientes(opcion) != 1)) {
                    terminal.show(UtilConstants.ANSI_RED + "El nombre no es correcto/ No hay manos libres para ese arma" + UtilConstants.ANSI_RESET);
                    terminal.show("Estas son tus armas disponibles, elija una escribiendo el nombre:");
                    this.usuarioActivo.mostrarTodasArmas();
                    opcion = terminal.read();
                }
                Arma arma2 = (Arma) usuarioActivo.getArma(opcion);
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
        usuarioActivo.mostrarArmadura();
        if (usuarioActivo.notieneArmadura()){
            terminal.show("Estas son tus armaduras disponibles, elija una escribiendo el nombre:");
            this.usuarioActivo.mostrarTodasArmaduras();
            String opcion = terminal.read();
            while (!this.usuarioActivo.existeEquipoArmadura(opcion)){
                terminal.show(UtilConstants.ANSI_RED + "El nombre no es correcto" + UtilConstants.ANSI_RESET);
                terminal.show("Estas son tus armaduras disponibles, elija una escribiendo el nombre:");
                this.usuarioActivo.mostrarTodasArmaduras();
                opcion = terminal.read();
            }
            Armadura armadura = (Armadura) usuarioActivo.getArmadura(opcion);
            this.usuarioActivo.setArmadura(armadura);
            terminal.show(UtilConstants.ANSI_GREEN + "Armadura elegida con éxito" + UtilConstants.ANSI_RESET);
        } else {
            terminal.show("Ya tiene una armadura seleccionada, ¿desea cambiarla? (Si/No)");
            String opcion = terminal.read();
            if ("Si".equalsIgnoreCase(opcion)) {
                usuarioActivo.setArmadura(null);
                escogerArmadura();
            } else{
                terminal.show(UtilConstants.ANSI_RED + "Elección cancelada" + UtilConstants.ANSI_RESET);
            }
        }
        this.manager.guardar();
    }

    public void desafiarUsuarios() {
        if (this.manager.hayUsuariosParaDesafiar(usuarioActivo.getNick())){
            if (usuarioActivo.getPersonaje() == null){
                terminal.show(UtilConstants.ANSI_RED + "No tiene ningún personaje asociado a su cuenta para desafiar a otros jugadores" + UtilConstants.ANSI_RESET);
            }
            else if(usuarioActivo.getArmaduraActiva()==null||usuarioActivo.getArmaActiva()==null){
                terminal.show(UtilConstants.ANSI_RED + "No tiene el equipamiento completo para desafiar a otros jugadores" + UtilConstants.ANSI_RESET);
            }
            else{
                terminal.show("A que usuario quiere desafiar");
                this.manager.mostrarUsuariosParaDesafiar(usuarioActivo.getNick());
                String opcion = terminal.read();
                if (this.manager.existeDesafiar(opcion)){
                    UsuarioEstandar usuario2 = (UsuarioEstandar) this.manager.asociarUsuario(opcion);
                    if (this.manager.perdidoMenosHoras(usuario2)){
                        usuarioActivo.setPosibleBloqueado(true);
                    }
                    terminal.show("Que cantidad de dinero desea apostar?");
                    int dinero = Integer.parseInt(terminal.read());
                    if (usuarioActivo.oroValido(dinero)&&usuario2.oroValido(dinero)){
                        this.usuarioActivo.getPersonajeUser().sumarOro(-dinero);
                        usuario2.getPersonajeUser().sumarOro(-dinero);
                        Combate combate = new Combate((UsuarioEstandar) usuarioActivo,usuario2,dinero,this.usuarioActivo.getNick()+usuario2.getNick());
                        this.manager.aniadir(combate,UtilConstants.FILE_COMBATS);
                        this.usuarioActivo.setBloqueado();
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
        } else{
            terminal.show(UtilConstants.ANSI_RED + "No hay usuarios para desafiar" + UtilConstants.ANSI_RESET);
        }


    }
    public void gestionarInvitacionDesafio() {
        // TODO implement here
    }

    public void consultarRegistro() { //consultaremos al hashmap con el key del nombre del usuario
        String NombreUsuario=this.usuarioActivo.getNombre();
        if (this.manager.desafioVacio(NombreUsuario)){
            terminal.show("No tiene registro de desafíos");
        }else {
            this.manager.mostrarRegistro(NombreUsuario);
            terminal.show("Seleccione el id del combate:");
            String combateseleccionado = terminal.read();
            if (!this.manager.existeCombate(combateseleccionado, NombreUsuario)) {

                terminal.show("seleccione una opción válida");
                terminal.show("Seleccione el id del combate:");
                combateseleccionado = terminal.read();
            }
            Combate combate = this.manager.getCombate(combateseleccionado);
            combate.mostrarResumen();
        }
    }


    public void consultarRanking() { // en teoría cuando saquemos la información del fichero cada usuario tiene a
        this.manager.mostarRanking();
    }

    public boolean combatePendiente() {
        // TODO implement here
        return false;
    }

    public boolean estaBloqueado() {
        return this.usuarioActivo.getBloqueado();
    }

    @Override
    public Boolean comprobarDesafio() {
        if (usuarioActivo instanceof UsuarioEstandar && usuarioActivo.getDesafiante() != null) {//si es un usuario estandar y tiene algun desafio pendiente
            UsuarioEstandar desafiante = (UsuarioEstandar) usuarioActivo.getDesafiante();
            terminal.show(desafiante.getNick());
            terminal.show("Tiene una solicitud de combate de " + desafiante.getNombre());
            terminal.show("¿Aceptar? (Si/No)");
            String opcion = terminal.read();
            if ("Si".equalsIgnoreCase(opcion)) {
                terminal.show(UtilConstants.ANSI_GREEN + "Combate aceptado" + UtilConstants.ANSI_RESET);
                  while(usuarioActivo.getArmaduraActiva()==null||usuarioActivo.getArmaActiva()==null){
                    terminal.show(UtilConstants.ANSI_RED + "No tiene el equipamiento completo para desafiar a otros jugadores" + UtilConstants.ANSI_RESET);
                    elegirArmasYArmaduras();

                }
                terminal.show("Equipamiento correcto, ¿desea realizar alguna última modificación?");
                elegirArmasYArmaduras();
                Combate combate=this.manager.getCombatePendiente(this.usuarioActivo.getNombre());
                combate.empezar();
                ((UsuarioEstandar) usuarioActivo).setDesafiante(null);
                this.manager.guardar();
            } else {
                Combate combate=this.manager.getCombatePendiente(this.usuarioActivo.getNombre());
                combate.combateCancelarPorciento();
                terminal.show("Combate cancelado");
            }
            ((UsuarioEstandar) usuarioActivo).setDesafiante(null);
            ((UsuarioEstandar) usuarioActivo).setBloqueado(false);
            this.manager.guardar();
            return false;
        }
        return false;
    }

}