import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FortalezaTest {
    @Test
    void Fortaleza(){
        Fortaleza fortaleza = new Fortaleza(    "Rayo", 5);
        assertEquals("Rayo", fortaleza.getNombre());
    }

}