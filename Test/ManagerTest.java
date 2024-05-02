import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {



    @Test
    void aniadir() {

        TextTerminal terminal = new TextTerminal();

        UsuarioEstandar usuarioEstandar = new UsuarioEstandar("Alex", "Alex123", "Alex123123");
        UsuarioEstandar usuarioEstandar2 = new UsuarioEstandar("Gabi", "Gabi123123", "Gabi123123");
        Cazador cazador = new Cazador("Gabi", 5, 4, 4, terminal);
        Combate combate = new Combate(usuarioEstandar,usuarioEstandar2,50,"Mortal");
        Arma arma = new Arma("Skibidi",3,1,3,3);
        Armadura armadura = new Armadura("Compa",3,1,3);

        Manager manager = new Manager();

        manager.aniadir(usuarioEstandar, "ficheros/");
        manager.aniadir(cazador,"ficheros/");
        manager.aniadir(combate,"ficheros/");
        manager.aniadir(arma,"ficheros/");
        manager.aniadir(armadura,"ficheros/");

        assertEquals(true, manager.existe("Compa", 5));

    }

    @Test
    void eliminar() {

        TextTerminal terminal = new TextTerminal();

        UsuarioEstandar usuarioEstandar = new UsuarioEstandar("Alex", "Alex123", "Alex123123");
        UsuarioEstandar usuarioEstandar2 = new UsuarioEstandar("Gabi", "Gabi123123", "Gabi123123");
        Cazador cazador = new Cazador("Gabi", 5, 4, 4, terminal);
        Combate combate = new Combate(usuarioEstandar,usuarioEstandar2,50,"Mortal");
        Arma arma = new Arma("Skibidi",3,1,3,3);
        Armadura armadura = new Armadura("Compa",3,1,3);

        Manager manager = new Manager();

        manager.aniadir(usuarioEstandar, "ficheros/");
        manager.aniadir(cazador,"ficheros/");
        manager.aniadir(combate,"ficheros/");
        manager.aniadir(arma,"ficheros/");
        manager.aniadir(armadura,"ficheros/");

        manager.eliminar(usuarioEstandar, "ficheros/");
        manager.eliminar(cazador,"ficheros/");
        manager.eliminar(combate,"ficheros/");
        manager.eliminar(arma,"ficheros/");
        manager.eliminar(armadura,"ficheros/");

        assertEquals(false, manager.existe("Compa", 5));


    }

    @Test
    void mostrar() {

        // Redirigir la salida estándar para capturarla en un ByteArrayOutputStream
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        TextTerminal terminal = new TextTerminal();

        UsuarioEstandar usuarioEstandar = new UsuarioEstandar("Alex", "Alex123", "Alex123123");
        Manager manager = new Manager();
        UsuarioEstandar usuarioEstandar2 = new UsuarioEstandar("Gabi", "Gabi123123", "Gabi123123");
        Cazador cazador = new Cazador("Gabi", 5, 4, 4, terminal);
        Combate combate = new Combate(usuarioEstandar,usuarioEstandar2,50,"Mortal");
        Arma arma = new Arma("Skibidi",3,1,3,3);
        Armadura armadura = new Armadura("Compa",3,1,3);


        manager.aniadir(usuarioEstandar, "ficheros/");
        manager.aniadir(cazador,"ficheros/");
        manager.aniadir(combate,"ficheros/");
        manager.aniadir(arma,"ficheros/");
        manager.aniadir(armadura,"ficheros/");


        manager.mostrar(1);

        assertEquals("Clave: " + "Alex123",outputStreamCaptor.toString().trim());



    }

    @Test
    void bloquear_desbloquear() {

        UsuarioEstandar usuarioEstandar = new UsuarioEstandar("Gabi", "Gabi123123", "Gabi123123");
        Manager manager = new Manager();
        manager.aniadir(usuarioEstandar, "ficheros/");

        manager.bloquear_desbloquear("x",true);
        assertEquals(false,usuarioEstandar.getBloqueado());



    }

    @Test
    void mostrarUsuariosBloqueados() {

        UsuarioEstandar usuarioEstandar = new UsuarioEstandar("Gabi", "Gabi123123", "Gabi123123");
        UsuarioEstandar usuarioEstandar1 = new UsuarioEstandar("Ruben", "Ruben33", "Ruben33333");
        Manager manager = new Manager();
        manager.aniadir(usuarioEstandar, "ficheros/");
        manager.aniadir(usuarioEstandar1,"ficheros/");

        manager.bloquear_desbloquear("Gabi123123",true);
        manager.bloquear_desbloquear("Ruben33",true);

        manager.mostrarUsuariosBloqueados();




    }

    @Test
    void mostrarUsuariosNoNormas() {

        Manager manager = new Manager();

        UsuarioEstandar usuarioEstandar = new UsuarioEstandar("Gabi", "Gabi123123", "Gabi123123");
        manager.aniadir(usuarioEstandar, "ficheros/");
        usuarioEstandar.setPosibleBloqueado(true);

        manager.mostrarUsuariosNoNormas();


    }



    @Test
    void mostrarRegistro() {

       TextTerminal terminal = new TextTerminal();
       TextTerminal terminal2 = new TextTerminal();

        Cazador cazador = new Cazador("Gab",3,3,5,terminal);
        Cazador cazador2 = new Cazador("Gabss",5,5,5,terminal2);

        PersonajeUser personajeUser = new PersonajeUser(cazador);
        PersonajeUser personajeUser1 = new PersonajeUser(cazador2);


        UsuarioEstandar usuarioEstandar = new UsuarioEstandar("Gabi", "Gabi123123", "Gabi123123");
        UsuarioEstandar usuarioEstandar1 = new UsuarioEstandar("Ruben", "Ruben33", "Ruben33333");
        Manager manager = new Manager();

        usuarioEstandar1.setPersonaje(cazador);
        usuarioEstandar.setPersonaje(cazador2);

        usuarioEstandar1.setPersonajeUser(personajeUser);
        usuarioEstandar.setPersonajeUser(personajeUser1);


        manager.aniadir(usuarioEstandar, "ficheros/");
        manager.aniadir(usuarioEstandar1,"ficheros/");



        Combate combate = new Combate(usuarioEstandar,usuarioEstandar1,3,"333");
        combate.empezar();

        manager.mostrarRegistro("Gabi123123");

    }










}