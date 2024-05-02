import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipoTest {
    @Test
    void Equipo(){
        Arma pump = new Arma("pump", 1, 2, 3, 0);
        assertEquals("pump", pump.getId());
        assertEquals(3, pump.getModificadorDeAtaque());
    }

}