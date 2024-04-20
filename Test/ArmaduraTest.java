import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ArmaduraTest {

    @Test
    void editar() {
        Armadura armadura = new Armadura("Armadura vieja", 1, 2, 3);
        // Redirigir la entrada estándar para simular la entrada del usuario
        ByteArrayInputStream in = new ByteArrayInputStream("Si\nNuevo Nombre\nSi\n3\nNo".getBytes());
        System.setIn(in);

        armadura.editar();

        assertEquals("Nuevo Nombre", armadura.getId());
        assertEquals(3, armadura.getModificadorDeAtaque());
    }
}