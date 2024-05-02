import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ModificadorTest {

    @Test
    void editar() {
            Debilidad debilidad1= new Debilidad("DebilidadSimple",2); //valores enre 1 y 5
        ByteArrayInputStream in = new ByteArrayInputStream("No\nSi\n4".getBytes());
        System.setIn(in);
        debilidad1.editar();
    }

    @Test
    void mostrar() {
        Debilidad debilidad1= new Debilidad(null,2); //valores enre 1 y 5
        debilidad1.mostrar();
    }
}