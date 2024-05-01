import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
        // Redirigir la salida estándar para capturarla en un ByteArrayOutputStream
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Crear una instancia de Cazador con valores conocidos
        Cazador cazador = new Cazador("Gabi", 5, 4, 4, null);
        cazador.aniadirEsbirros();

        // Simular entrada de usuario para el primer esbirro (Humano)
        ByteArrayInputStream in = new ByteArrayInputStream("Humano\nJuan\nSi\n3\nAlta\n".getBytes());
        System.setIn(in);

        // Capturar la salida esperada
        String expectedOutput = "Esbirro Añadido\nNombre: Juan\nSalud: 3\nLealtad: Alta\n";

        // Verificar la salida esperada
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }




    @Test
    void mostrarHabilidadEspecial() {
    }
}