import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TalentoTest {

    @Test
    public void testConstructor() {
        Talento talento =  new Talento("Precisión", 3,1);
        // Verificar que los valores se inicialicen correctamente
        assertEquals("Precisión",talento.getNombre());
        assertEquals(3,talento.getValorAtaque());
        assertEquals(1,talento.getValorDefensa());
    }

    @Test
    void mostrarHabilidadExtra() {
        Talento talento =  new Talento("Precisión", 3,1);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        talento.mostrarHabilidadExtra();
        String expectedOutput = "";

        String actualOutput = outContent.toString().trim(); // Elimina espacios en blanco al inicio y al final

        assertEquals(expectedOutput, actualOutput);
    }
}