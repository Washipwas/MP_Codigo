import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DebilidadTest {
    @Test
    void Debilidad(){
        Debilidad debilidad = new Debilidad("Luz", 3);
        assertEquals("Luz", debilidad.getNombre());
    }

}