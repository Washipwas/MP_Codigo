import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MenuOperadorTest {
    @Test
    void MenuOperador(){
        Operador usuario = new Operador("usuario", "usuario", "contraseña");
        MenuOperador menu = new MenuOperador("usuario", new Manager());
        menu.usuarioActivo = null;

        assertEquals(usuario ,menu.getUsuarioActivo());
    }
    @Test
    void seleccionarOpcion() {
        // Simulamos la entrada del usuario (opción "1" para editar personaje y luego opción "7" para salir)
        InputStream in = new ByteArrayInputStream("1\n7\n".getBytes());
        System.setIn(in);

        // Creamos una instancia de MenuOperador con un usuario activo
        Manager manager = new Manager();
        Operador usuario = new Operador("nick", "usuario", "contraseña");
        MenuOperador menu = new MenuOperador("usuario", manager);
        menu.usuarioActivo = usuario;

        // Simulamos la salida del terminal
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutamos el método seleccionarOpcion()
        menu.seleccionarOpcion();

        // Verificamos si el método muestra el mensaje de "Pulse cualquier tecla para continuar"
        // y si vuelve a mostrar el menú (ya que hemos seleccionado la opción "7")
        assertTrue(outContent.toString().contains("Pulse cualquier tecla para continuar"));
        assertTrue(outContent.toString().contains("Selecciona una opción"));
    }

    @Test
    void editarPersonaje() {
        InputStream in = new ByteArrayInputStream("Arquera\n".getBytes());
        System.setIn(in);

        // Creamos una instancia de Manager y añadimos un personaje para editar
        Manager manager = new Manager();
        Personaje personaje = new Cazador("Arqueras", 1, 2, 3, new TextTerminal());
        manager.aniadir(personaje, UtilConstants.FILE_PERSONAJES);

        // Creamos una instancia de MenuOperador con un usuario activo
        Operador usuario = new Operador("nick", "nick", "contraseña");
        MenuOperador menu = new MenuOperador("usuario", manager);
        menu.usuarioActivo = usuario;

        // Simulamos la salida del terminal
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutamos el método editarPersonaje()
        menu.editarPersonaje();

        // Verificamos si el método muestra el mensaje de éxito
        assertTrue(outContent.toString().contains("El nombre es incorrecto"));

        // Verificamos si el personaje se actualizó correctamente en el manager
        //assertTrue(manager.existe("nombre_personaje_existente", UtilConstants.FILE_PERSONAJES));

    }

    @Test
    void aniadirAlPersonaje() {
        InputStream in = new ByteArrayInputStream("Arqueras\n".getBytes());
        System.setIn(in);

        // Creamos una instancia de Manager y añadimos un personaje para asociar
        Manager manager = new Manager();
        Personaje personaje = new Cazador("Arqueras", 1, 2, 3, new TextTerminal());
        manager.aniadir(personaje, UtilConstants.FILE_PERSONAJES);

        // Creamos una instancia de MenuOperador con un usuario activo
        Operador usuario = new Operador("nick", "usuario", "contraseña");
        MenuOperador menu = new MenuOperador("usuario", manager);
        menu.usuarioActivo = usuario;

        // Simulamos la salida del terminal
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutamos el método aniadirAlPersonaje()
        menu.aniadirAlPersonaje();

        // Verificamos si el método muestra el mensaje de éxito
        assertTrue(outContent.toString().contains("Personaje modificado correctamente"));

        // Verificamos si el personaje se actualizó correctamente en el manager
        //assertTrue(manager.existe("nombre_personaje_existente", UtilConstants.FILE_PERSONAJES));
    }

    @Test
    void validarDesafios() {
        InputStream in = new ByteArrayInputStream("4\nSi\n".getBytes());
        System.setIn(in);

        // Creamos una instancia de Manager y añadimos un combate pendiente
        Manager manager = new Manager();

        UsuarioEstandar usuario1 = new UsuarioEstandar("nick", "nick", "contraseña");
        UsuarioEstandar usuario2 = new UsuarioEstandar("pedro", "pedro", "contraseña");
        Personaje personaje = new Cazador("Arqueras", 1, 2, 3, new TextTerminal());
        usuario1.newPersonajeUser(personaje);
        Personaje personaje2 = new Cazador("Mortis", 1, 2, 3, new TextTerminal());
        usuario2.newPersonajeUser(personaje2);


        Combate combate = new Combate(usuario2, usuario1, 100, "1");
        manager.aniadir(combate, UtilConstants.FILE_COMBATS);

        // Creamos una instancia de MenuOperador con un usuario activo
        Operador usuario = new Operador("nick", "usuario", "contraseña");
        MenuOperador menu = new MenuOperador("usuario", manager);
        menu.usuarioActivo = usuario;

        // Simulamos la salida del terminal
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutamos el método validarDesafios()
        menu.validarDesafios();

        // Verificamos si el método muestra el mensaje de éxito
        assertTrue(outContent.toString().contains("Opción no válida"));

        // Verificamos si el desafío se actualizó correctamente en el manager
        //Combate desafioValidado = manager.getCombate("id_desafio_a_validar");
        //assertTrue(desafioValidado.getValidado());
    }

    @Test
    void bloquearUsuarios() {
        InputStream in = new ByteArrayInputStream("Mario\n".getBytes());
        System.setIn(in);

        // Creamos una instancia de Manager y añadimos un usuario para bloquear
        Manager manager = new Manager();
        Usuario usuario = new UsuarioEstandar("nombre", "nombre", "contraseña");
        usuario.setPosibleBloqueado(true);

        manager.aniadir(usuario, UtilConstants.FILE_USERS);

        // Creamos una instancia de MenuOperador con un usuario activo
        Operador usuario2 = new Operador("nick", "usuario", "contraseña");
        MenuOperador menu = new MenuOperador("usuario", manager);
        menu.usuarioActivo = usuario2;

        // Simulamos la salida del terminal
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutamos el método bloquearUsuarios()
        menu.bloquearUsuarios();

        // Verificamos si el método muestra el mensaje de éxito
        assertTrue(outContent.toString().contains("El nick no es válido"));

        // Verificamos si el usuario se bloqueó correctamente en el manager
        //Usuario usuarioBloqueado = manager.getObject("nombre",1);
        //assertTrue(usuarioBloqueado.getBloqueado());
    }

    @Test
    void desbloquearusuarios() {
        InputStream in = new ByteArrayInputStream("nombre\n".getBytes());
        System.setIn(in);

        // Creamos una instancia de Manager y añadimos un usuario para bloquear
        Manager manager = new Manager();
        Usuario usuario = new UsuarioEstandar("nombre", "nombre", "contraseña");
        usuario.setPosibleBloqueado(true);
        usuario.setBloqueado();
        manager.aniadir(usuario, UtilConstants.FILE_USERS);

        // Creamos una instancia de MenuOperador con un usuario activo
        Operador usuario2 = new Operador("nick", "usuario", "contraseña");
        MenuOperador menu = new MenuOperador("usuario", manager);
        menu.usuarioActivo = usuario2;

        // Simulamos la salida del terminal
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutamos el método bloquearUsuarios()
        menu.desbloquearusuarios();

        // Verificamos si el método muestra el mensaje de éxito
        assertTrue(outContent.toString().contains("El nick no es válido"));

        // Verificamos si el usuario se bloqueó correctamente en el manager
        //Usuario usuarioBloqueado = manager.getObject("nombre",1);
        //assertTrue(usuarioBloqueado.getBloqueado());
    }
}