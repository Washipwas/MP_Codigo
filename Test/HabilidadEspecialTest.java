import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class HabilidadEspecialTest {

    @Test
    public void testConstructor() {
        Don don =  new Don("Aullido", 2,1,2);
        // Verificar que los valores se inicialicen correctamente
        assertEquals("Aullido",don.getNombre());
        assertEquals(2,don.getValorAtaque());
        assertEquals(1,don.getValorDefensa());
    }

    @Test
    void editar() {
        Don don =  new Don("Aullido", 2,1,2);

        ByteArrayInputStream in = new ByteArrayInputStream("No\nSi\n5\n3\nNo".getBytes());
        System.setIn(in);

        don.editar();


        // Verificar que los valores se inicialicen correctamente
        assertEquals("Aullido",don.getNombre());
        assertEquals(3,don.getValorAtaque());
        assertEquals(1,don.getValorDefensa());
    }
}