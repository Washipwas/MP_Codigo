import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ArmaTest {

    @Test
    void mostrar() {
        Arma arma = new Arma("Armadura de prueba", 1, 2, 3, 2); // Supongamos que tienes un atributo 'manos'
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        arma.mostrar();

        String expectedOutput = "* Nombre: Armadura de prueba    Manos: 2    Modificador de Ataque: 3    Modificador de Defensa: 2\n";
        assertEquals(expectedOutput, outContent.toString());

    }

    @Test
    void editar() {
        Arma arma = new Arma("Arma vieja", 1, 2, 3,1);
        // Redirigir la entrada estándar para simular la entrada del usuario
        ByteArrayInputStream in = new ByteArrayInputStream("Si\nNuevo Nombre\nSi\n4\nSi\n5\nSi\n1".getBytes());
        System.setIn(in);

        arma.editar();

        assertEquals("Nuevo Nombre", arma.getId());
        assertEquals(4, arma.getModificadorDeAtaque());
        assertEquals(5, arma.getModificadorDeDefensa());
        assertEquals(1, arma.getManos());
    }
}
