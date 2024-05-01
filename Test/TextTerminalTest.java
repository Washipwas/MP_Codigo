import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TextTerminalTest {

    @Test
    void read() {
        TextTerminal terminal = new TextTerminal();
        ByteArrayInputStream in = new ByteArrayInputStream("Hola".getBytes());
        System.setIn(in);
        String cadena = terminal.read();
        assertEquals("Hola",cadena);
    }

    @Test
    void show() {
        TextTerminal terminal = new TextTerminal();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String cadena = "";
        terminal.show(cadena);
        String expectedOutput = "";

        String actualOutput = outContent.toString().trim(); // Elimina espacios en blanco al inicio y al final

        assertEquals(expectedOutput, actualOutput);
    }
}