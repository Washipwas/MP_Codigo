import java.io.*;

public class MenuInicial {

    private TextTerminal terminal;
    private Manager manager;

    public MenuInicial() {
        this.terminal = new TextTerminal();
        File archivo = new File(UtilConstants.FILE_USERS + "usuarios.ser");
        if (!archivo.exists()) {
            manager = new Manager(UtilConstants.FILE_USERS);
            try (ObjectOutputStream objetoSalida = new ObjectOutputStream(new FileOutputStream(UtilConstants.FILE_USERS + "usuarios.ser"))) {
                objetoSalida.writeObject(manager);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        try (ObjectInputStream objetoEntrada = new ObjectInputStream(new FileInputStream(archivo))) {
            manager = (Manager) objetoEntrada.readObject();
            manager.setTerminal();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void mostrarMenu() {
        terminal.show("Seleccione una opción escribiendo el número correspondiente");
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
                terminal.show("Acceso correcto");
                MenuUsuario userMenu = null;
                if (manager.datosUsuarioEstandar(nick)){
                    userMenu = new MenuUsuarioEstandar(nick,this.manager);
                } else {
                    userMenu = new MenuOperador(nick,this.manager);
                }

                Boolean bloqueado = userMenu.mostrarMenu();
                if (!bloqueado){
                    userMenu.seleccionarOpcion();
                }
            } else {
                terminal.show("La contraseña es incorrecta");
            }
        } else {
            terminal.show("El nick no es correcto");
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
                terminal.show("Ya existe ese nick, elija otro");
            }
        }
        correcto = false;
        String password = " ";
        while (! correcto) {
            terminal.show("Pasword: (debe contener entre 8 y 12 caracteres)");
            password = terminal.read();
            if (8 <= password.length() && password.length() <= 12) {
                correcto = true;
            } else {
                terminal.show("Contraseña no válida");
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

            terminal.show("Se ha completado el registro de " + palabra);
        } else {
            terminal.show("Se ha cancelado el registro de " + palabra);
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
                terminal.show("La opción no es válida");
            }
            mostrarMenu();
            num = Integer.parseInt(terminal.read());
        }
    }
}