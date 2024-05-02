import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PersonajeTest {


    @Test
    void mostrarAtributos() {
        // Configurar la salida estándar para capturarla en un ByteArrayOutputStream
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Crear una instancia de Vampiro con valores conocidos
        Vampiro vampiro = new Vampiro("Gabi", 4, 4, 5, 33, null);

        // Llamar al método mostrarAtributos
        vampiro.mostrarAtributos();

        // Verificar la salida esperada
        String expectedOutput = "Nombre: Gabi    Salud: 4    Poder: 4";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    void mostrarTodasArmas() {

        // Redirigir la salida estándar para capturarla en un ByteArrayOutputStream
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Crear una instancia de Cazador con valores conocidos
        Cazador cazador = new Cazador("Gabi", 5, 4, 4, null);

        // Crear las armas para el cazador
        cazador.crearArmas();

        // Llamar al método mostrarTodasArmas
        cazador.mostrarTodasArmas();

        // Verificar la salida esperada
        String expectedOutput = "* Nombre: Cañon de mano    Manos: 1    Modificador de Ataque: 2    Modificador de Defensa: 0" +
                System.lineSeparator() +
                "* Nombre: Pump    Manos: 1    Modificador de Ataque: 3    Modificador de Defensa: 0" +
                System.lineSeparator();
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }



    @Test
    void mostrarTodasArmaduras() {
        // Redirigir la salida estándar para capturarla en un ByteArrayOutputStream
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Crear una instancia de Cazador con valores conocidos
        Cazador cazador = new Cazador("Gabi", 5, 4, 4, null);

        // Crear las armaduras para el cazador
        cazador.crearArmaduras();

        // Llamar al método mostrarTodasArmaduras
        cazador.mostrarTodasArmaduras();

        // Verificar la salida esperada
        String expectedOutput = "* Nombre: Armadura ardiente    Modificador de Ataque: 3    Modificador de Defensa: 1" +
                System.lineSeparator() +
                "* Nombre: Armadura siniestra    Modificador de Ataque: 2    Modificador de Defensa: 2" +
                System.lineSeparator() +
                "* Nombre: Armadura de dioses    Modificador de Ataque: 1    Modificador de Defensa: 3" +
                System.lineSeparator();
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    void mostrarEsbirros() {


        //no termina de ejecutarse


        // Redirigir la salida estándar para capturarla en un ByteArrayOutputStream
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        TextTerminal terminal = new TextTerminal();

        // Crear una instancia de Cazador con valores conocidos
        Cazador cazador = new Cazador("Gabi", 5, 4, 4, terminal);
        cazador.aniadirEsbirros();

        // Simular entrada de usuario para el primer esbirro (Humano)
        ByteArrayInputStream in = new ByteArrayInputStream("Humano\nJuan\nSi\n3\nAlta\n".getBytes());
        System.setIn(in);

        cazador.mostrarEsbirros();

        // Capturar la salida esperada
        String expectedOutput = "Esbirro Añadido\nNombre: Juan\nSalud: 3\nLealtad: Alta\n";

        // Verificar la salida esperada
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }




    @Test
    void mostrarHabilidadEspecial() {

        // Redirigir la salida estándar para capturarla en un ByteArrayOutputStream
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Talento talento = new Talento("Talentoso",3,3);

        Manager manager = new Manager();

        // Crear una instancia de Cazador con valores conocidos
        Cazador cazador = new Cazador("Gabi", 5, 4, 4, null);
        manager.aniadir(talento,"ficheros/");
        manager.aniadir(cazador,"ficheros/");

        cazador.setHabilidad(talento);

        cazador.mostrarHabilidadEspecial();


    }

    @Test
    void editar(){

        Cazador cazador = new Cazador("Gabi", 5, 4, 4, null);

        ByteArrayInputStream in = new ByteArrayInputStream("Si\nGabillo\nno\nno\n".getBytes());
        System.setIn(in);
        cazador.editar();

        String a = cazador.getNombre();
        int b = cazador.getSalud();
        int c = cazador.getPoder();
        //int d = cazador.getvoluntad();

        assertEquals(a,cazador.getNombre());


    }
    @Test
    void aniadirFortalezas(){
        InputStream in = new ByteArrayInputStream("Conocimiento\nSentidos Agudizados\n4".getBytes());
        System.setIn(in);

        Personaje personaje = new Cazador("Arqueras", 1, 2, 3, new TextTerminal());
        Fortaleza fortaleza = new Fortaleza("Conocimiento", 5);
        personaje.setFortalezaActiva(fortaleza);

        //Fortaleza fortaleza2 = new Fortaleza("Rayo", 5);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //personaje.aniadirFortalezas();//quitamos el acceso provado y ya estaria
        assertTrue(outContent.toString().contains("Fortaleza añadida:"));
    }

    @Test
    void aniadir() {
        InputStream in = new ByteArrayInputStream("si\nsi\nsi\nsi\nsi\n".getBytes());
        System.setIn(in);

        Personaje personaje = new Cazador("Arqueras", 1, 2, 3, new TextTerminal());

        personaje.aniadir();


    }

    //editarmodificadores

            //aniadir

   // aniadirEsbirros

                    //aniadirFortaleza
   // aniadirDebilidades
                           // aniadirArmaduras
    //aniadirArmas
                                    //editarEquipo
    //editar-Esbirros
}