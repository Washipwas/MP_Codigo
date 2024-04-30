import java.io.*;

public class MenuInicial {

    private TextTerminal terminal;
    private Manager manager;

    public MenuInicial() {
        this.terminal = new TextTerminal();
        File archivo = new File(UtilConstants.FILE_USERS + "usuarios.ser"); // se lee el fichero con la direccion que te da utilconstanst.fileusers
        if (!archivo.exists()) {
            manager = new Manager();
            try (ObjectOutputStream objetoSalida = new ObjectOutputStream(new FileOutputStream(UtilConstants.FILE_USERS + "usuarios.ser"))) {
                objetoSalida.writeObject(manager);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        try (ObjectInputStream objetoEntrada = new ObjectInputStream(new FileInputStream(archivo))) { //se utiliza objectinputstream para leer los bytes del fichero
            manager = (Manager) objetoEntrada.readObject(); //convierte lo que lee en un objeto de clase manager y lo asoscia al atributo privado manager
            manager.setTerminal(); //crea un terminal
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //hasta aquí manager tiene el objeto leido del fichero File_users


    public void mostrarMenu() {
        terminal.show(UtilConstants.ANSI_BLUE + "Seleccione una opción escribiendo el número correspondiente" + UtilConstants.ANSI_RESET);
        terminal.show("1.Iniciar sesion");
        terminal.show("2.Registrarse como Usuario");
        terminal.show("3.Registrarse como Operador");
        terminal.show("4.Salir");
    }

    public void iniciarSesion() {
        terminal.show("Rellene la siguiente información para completar su inicio de sesión");
        terminal.show("Nick: ");
        String nick = terminal.read();
        terminal.show("Password: ");
        String password = terminal.read();
        if (manager.existe(nick,1)){
            if (manager.datosCorrectos(nick,password)){
                terminal.show(UtilConstants.ANSI_GREEN + "Acceso correcto" +  UtilConstants.ANSI_RESET);
                MenuUsuario userMenu = null; //se instancia a nulo el menu-usuario
                if (manager.datosUsuarioEstandar(nick)){
                    userMenu = new MenuUsuarioEstandar(nick,this.manager); //se crea el menu del usuario_estandar pasándole el nick y el manager  de este
                                                                            //menu el cual tiene toda la información
                } else {
                    userMenu = new MenuOperador(nick,this.manager);
                }

                Boolean bloqueado = userMenu.mostrarMenu();
                if (!bloqueado){
                    userMenu.seleccionarOpcion();
                }
            } else {
                terminal.show(UtilConstants.ANSI_RED+ "La contraseña es incorrecta" + UtilConstants.ANSI_RESET);
            }
        } else {
            terminal.show(UtilConstants.ANSI_RED + "El nick no es correcto" + UtilConstants.ANSI_RESET);
        }
    }

    public void registrar(int num) {
        String palabra;
        if (num == 2){
            palabra = "Usuario";
        } else {
            palabra = "Operador";
        }
        terminal.show("Rellene la siguiente información para completar su registro de " + palabra);
        terminal.show("Nombre:");
        String nombre = terminal.read();
        Boolean correcto = false;
        String nick = " ";
        while (!correcto){
            terminal.show("Nick:");
            nick = terminal.read();
            if (!manager.existe(nick,1)){
                correcto = true;
            } else {
                terminal.show(UtilConstants.ANSI_RED + "Ya existe ese nick, elija otro" + UtilConstants.ANSI_RESET);
            }
        }
        correcto = false;
        String password = " ";
        while (! correcto) {
            terminal.show("Password: (debe contener entre 8 y 12 caracteres)");
            password = terminal.read();
            if (8 <= password.length() && password.length() <= 12) {
                correcto = true;
            } else {
                terminal.show(UtilConstants.ANSI_RED + "Contraseña inválida" + UtilConstants.ANSI_RESET);
            }
        }
        terminal.show("Se va a crear un " + palabra + " de nombre " + nombre);
        terminal.show("Desea continuar (Si/No)?");
        String opcion = terminal.read();
        if ("Si".equalsIgnoreCase(opcion)){
            Usuario user;
            if (palabra == "Usuario"){
                user = new UsuarioEstandar(nombre,nick,password);
            } else {
                user = new Operador(nombre,nick,password);
            }
            manager.aniadir(user,UtilConstants.FILE_USERS);

            terminal.show(UtilConstants.ANSI_GREEN + "Se ha completado el registro de " + palabra + UtilConstants.ANSI_RESET);
        } else {
            terminal.show(UtilConstants.ANSI_RED +"Se ha cancelado el registro de " + palabra + UtilConstants.ANSI_RESET);
        }

    }
    public void seleccionarOpcion() {
        int num = Integer.parseInt(terminal.read());
        while (num != 4) {
            if (num == 1){
                iniciarSesion();
            } else if (num == 2 || num == 3) {
                registrar(num);
            } else{
                terminal.show(UtilConstants.ANSI_RED +"La opción no es válida" + UtilConstants.ANSI_RESET);
            }
            mostrarMenu();
            num = Integer.parseInt(terminal.read());
        }
    }

    public Object getManager() {
        return this.manager;
    }
}