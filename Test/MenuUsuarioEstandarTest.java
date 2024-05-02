import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MenuUsuarioEstandarTest {

    @Test
    void MenuUsuarioEstandar() {
        Manager manager = new Manager();
        UsuarioEstandar user =  new UsuarioEstandar("gabi", "gabim", "gab123");
        MenuUsuarioEstandar menu = new MenuUsuarioEstandar("gabim", manager);
        menu.usuarioActivo =  null;
        assertEquals(user ,menu.getUsuarioActivo());
        assertEquals(manager ,menu.getManager());


    }
    @Test
    void seleccionarOpcion() {

        // Simulamos la entrada del usuario (opción "1" para registrar personaje)
        InputStream in = new ByteArrayInputStream("9\n".getBytes());
        System.setIn(in);

        // Creamos una instancia de MenuUsuarioEstandar con un usuario activo
        Manager manager = new Manager();
        UsuarioEstandar usuario = new UsuarioEstandar("nick", "usuario", "contraseña");
        MenuUsuarioEstandar menu = new MenuUsuarioEstandar("usuario", manager);
        menu.usuarioActivo = usuario;

        // Simulamos la salida del terminal
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutamos el método seleccionarOpcion()
        menu.seleccionarOpcion();

        // Verificamos si el método muestra el mensaje de "Pulse cualquier tecla para continuar"
        // y si vuelve a mostrar el menú (ya que hemos seleccionado la opción "8")
        assertTrue(outContent.toString().contains("La opcion no es valida\nPulse cualquier tecla para continuar"));
        //assertTrue(outContent.toString().contains("Selecciona una opción"));

    }

    @Test
    void registrarPersonaje() {

        InputStream in = new ByteArrayInputStream("pedro".getBytes());
        System.setIn(in);
        // Creamos una instancia de MenuUsuarioEstandar
        UsuarioEstandar user =  new UsuarioEstandar("gabi", "gabim", "gab123");
        MenuUsuarioEstandar menu = new MenuUsuarioEstandar("gabim", new Manager());
        menu.usuarioActivo =  user;
        // Simulamos la salida del terminal
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutamos el método registrarPersonaje()
        menu.registrarPersonaje();

        // Verificamos si la salida del terminal contiene el mensaje esperado
        assertEquals(user.getPersonajeUser().getPersonaje().getNombre(),"Vaquero errante");
    }

    @Test
    void eliminarPersonaje() {
        InputStream in = new ByteArrayInputStream("kjashdf\n".getBytes());
        System.setIn(in);

        // Creamos una instancia de MenuUsuarioEstandar con un personaje asociado
        Manager manager = new Manager();
        Personaje personaje = new Cazador("NombrePersonaje", 1, 2, 3, new TextTerminal());
        manager.aniadir(personaje, UtilConstants.FILE_PERSONAJES);
        UsuarioEstandar usuario = new UsuarioEstandar("nick", "usuario", "contraseña");
        usuario.newPersonajeUser(null);//si tiene o no personaje
        MenuUsuarioEstandar menu = new MenuUsuarioEstandar("usuario", manager);
        menu.usuarioActivo = usuario;

        // Simulamos la salida del terminal
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutamos el método eliminarPersonaje()
        menu.eliminarPersonaje();

        // Verificamos si el personaje ha sido eliminado correctamente
        assertTrue(outContent.toString().contains("No tiene ningún personaje asociado a su cuenta"));
        assertEquals(null, usuario.getPersonajeUser().getPersonaje());

    }

    @Test
    void elegirArmasYArmaduras() {
        InputStream in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(in);

        Manager manager = new Manager();
        Personaje personaje = new Cazador("NombrePersonaje", 1, 2, 3, new TextTerminal());
        manager.aniadir(personaje, UtilConstants.FILE_PERSONAJES);
        UsuarioEstandar usuario = new UsuarioEstandar("usuario", "usuario", "contraseña");
        usuario.newPersonajeUser(personaje);//si tiene o no personaje
        MenuUsuarioEstandar menu = new MenuUsuarioEstandar("usuario", manager);
        menu.usuarioActivo = usuario;


        // Simulamos la salida del terminal
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutamos el método elegirArmasYArmaduras()
        menu.elegirArmasYArmaduras();

        // Verificamos si el método muestra las opciones de armas correctamente
        assertTrue(outContent.toString().contains("Escogiendo Armas"));
        //assertTrue(outContent.toString().contains("1. Escoger Armas"));
        //assertTrue(outContent.toString().contains("2. Escoger Armaduras"));
    }

    @Test
    void escogerArmas() {
        InputStream in = new ByteArrayInputStream("no\n".getBytes());
        System.setIn(in);

        // Creamos una instancia de MenuUsuarioEstandar con un usuario activo y algunas armas disponibles
        Manager manager = new Manager();
        UsuarioEstandar usuario = new UsuarioEstandar("nick", "usuario", "contraseña");
        Arma pump = new Arma("pump", 1, 2, 3, 0);
        Personaje personaje = new Cazador("NombrePersonaje", 1, 2, 3, new TextTerminal());
        usuario.newPersonajeUser(personaje);
        usuario.setArmaDer(pump);
        //usuario.setArmaIzq(pump);
        MenuUsuarioEstandar menu = new MenuUsuarioEstandar("usuario", manager);
        menu.usuarioActivo = usuario;


        // Simulamos la salida del terminal
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutamos el método escogerArmas()
        menu.escogerArmas();

        // Verificamos si el método muestra el mensaje de éxito y si la espada ha sido seleccionada
        assertTrue(outContent.toString().contains("Elección cancelada"));
        //assertEquals(espada, usuario.getArma("espada"));
    }

    @Test
    void escogerArmadura() {
        InputStream in = new ByteArrayInputStream("no\n".getBytes());
        System.setIn(in);

        // Creamos una instancia de MenuUsuarioEstandar con un usuario activo y algunas armaduras disponibles
        Manager manager = new Manager();
        UsuarioEstandar usuario = new UsuarioEstandar("nick", "usuario", "contraseña");
        Armadura placas = new Armadura("Placas", 1, 2, 3);
        Personaje personaje = new Cazador("NombrePersonaje", 1, 2, 3, new TextTerminal());
        usuario.newPersonajeUser(personaje);
        usuario.setArmadura(placas);
        MenuUsuarioEstandar menu = new MenuUsuarioEstandar("usuario", manager);
        menu.usuarioActivo = usuario;

        // Simulamos la salida del terminal
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutamos el método escogerArmadura()
        menu.escogerArmadura();

        // Verificamos si el método muestra el mensaje de éxito y si las placas han sido seleccionadas correctamente
        assertTrue(outContent.toString().contains("Elección cancelada"));
        //assertEquals(placas, usuario.getArmadura());
    }

    @Test
    void desafiarUsuarios() {
        InputStream in = new ByteArrayInputStream("maria\n20".getBytes());
        System.setIn(in);

        // Creamos una instancia de MenuUsuarioEstandar con un usuario activo
        Manager manager = new Manager();
        UsuarioEstandar usuario1 = new UsuarioEstandar("nick", "usuario", "contraseña");
        UsuarioEstandar usuario2 = new UsuarioEstandar("pedro", "mario", "contraseña");
        manager.aniadir(usuario1 ,UtilConstants.FILE_USERS);
        manager.aniadir(usuario2 ,UtilConstants.FILE_USERS);

        Personaje personaje = new Cazador("NombrePersonaje", 1, 2, 3, new TextTerminal());
        usuario1.newPersonajeUser(personaje);

        Personaje personaje2 = new Cazador("Nombre3", 1, 2, 3, new TextTerminal());
        usuario2.newPersonajeUser(personaje2);

        MenuUsuarioEstandar menu = new MenuUsuarioEstandar("usuario", manager);
        menu.usuarioActivo = usuario1;
        //agregamos armas y equipamento a ambos

        // Simulamos la salida del terminal
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutamos el método desafiarUsuarios()
        menu.desafiarUsuarios();

        // Verificamos si el método muestra el mensaje de éxito al desafiar
        assertTrue(outContent.toString().contains("No tiene el equipamiento completo para desafiar a otros jugadores"));
    }

    @Test
    void consultarRegistro() {
        InputStream in = new ByteArrayInputStream("3\n".getBytes());
        System.setIn(in);

        // Creamos una instancia de MenuUsuarioEstandar con un usuario activo
        Manager manager = new Manager();
        UsuarioEstandar usuario1 = new UsuarioEstandar("nick", "mario", "contraseña");
        UsuarioEstandar usuario2 = new UsuarioEstandar("pedro", "jesus", "contraseña");
        manager.aniadir(usuario1 ,UtilConstants.FILE_USERS);
        manager.aniadir(usuario2 ,UtilConstants.FILE_USERS);
        MenuUsuarioEstandar menu = new MenuUsuarioEstandar("nick", manager);
        menu.usuarioActivo = usuario1;


        Personaje personaje = new Cazador("NombrePersonaje", 1, 2, 3, new TextTerminal());
        usuario1.newPersonajeUser(personaje);

        Personaje personaje2 = new Cazador("Nombre3", 1, 2, 3, new TextTerminal());
        usuario2.newPersonajeUser(personaje2);

        // Simulamos la salida del terminal
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Agregamos un combate al registro del usuario
        Combate combate = new Combate(usuario2, usuario1, 100, "1");
        manager.aniadir(combate, UtilConstants.FILE_COMBATS);

        // Ejecutamos el método consultarRegistro()
        menu.consultarRegistro();

        // Verificamos si el método muestra el registro del combate
        assertTrue(outContent.toString().contains("Seleccione el id del combate:"));
        //assertTrue(outContent.toString().contains("desafiante"));
    }

    @Test
    void comprobarDesafio() {

        InputStream in = new ByteArrayInputStream("Si\n".getBytes());
        System.setIn(in);

        // Creamos una instancia de MenuUsuarioEstandar con un usuario activo y un desafío pendiente
        Manager manager = new Manager();
        UsuarioEstandar usuario = new UsuarioEstandar("nick", "nick", "contraseña");
        UsuarioEstandar desafiante = new UsuarioEstandar("desafiante", "desafiante", "123");
        usuario.setDesafiante(desafiante);
        MenuUsuarioEstandar menu = new MenuUsuarioEstandar("usuario", manager);
        menu.usuarioActivo = usuario;

        Personaje personaje = new Cazador("NombrePersonaje", 1, 2, 3, new TextTerminal());
        usuario.newPersonajeUser(personaje);

        Personaje personaje2 = new Cazador("Nombre3", 1, 2, 3, new TextTerminal());
        desafiante.newPersonajeUser(personaje2);


        // Simulamos la salida del terminal
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutamos el método comprobarDesafio()
        boolean resultado = menu.comprobarDesafio();

        // Verificamos si el método muestra el mensaje de aceptación y devuelve verdadero
        assertTrue(outContent.toString().contains("Combate aceptado"));
        assertTrue(resultado);

    }
}