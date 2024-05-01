import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DonTest {

    @Test
    public void testConstructor() {
        Don don =  new Don("Aullido", 2,1,2);
        // Verificar que los valores se inicialicen correctamente
        assertEquals("Aullido",don.getNombre());
        assertEquals(2,don.getValorAtaque());
        assertEquals(1,don.getValorDefensa());
        assertEquals(2,don.getRabia());
    }

    @Test
    void mostrarHabilidadExtra() {
        Don don =  new Don("Aullido", 2,1,2);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        don.mostrarHabilidadExtra();
        String expectedOutput = "Rabia: " + 2;

        String actualOutput = outContent.toString().trim(); // Elimina espacios en blanco al inicio y al final

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void editarExtra() {
        Don don =  new Don("Aullido", 2,1,2);

        ByteArrayInputStream in = new ByteArrayInputStream("Si\n-1\n5".getBytes());
        System.setIn(in);

        don.editarExtra();


        // Verificar que los valores se inicialicen correctamente
        assertEquals(5,don.getRabia());
    }
}