import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class DemonioTest {

    @Test
    void mostrarExtra() {
        Demonio demonio1 = new Demonio("DemonioMortal",3,"pacto de unión entre el demonio ");
        demonio1.mostrarExtra();

    }

    @Test
    void editarExtra() {
        // TextTerminal terminal=new TextTerminal();
        Demonio demonio1=new Demonio("DemonioMortal",3,"pacto de unión entre el demonio ");

        ByteArrayInputStream in = new ByteArrayInputStream("Si\n".getBytes()); //ver que valores hay que meter para hacer la funcion editar y luego la llamamos
        ByteArrayInputStream nullInput = new ByteArrayInputStream(new byte[0]);
        // Redirigimos la entrada estándar para que lea de nuestro ByteArrayInputStream
        System.setIn(in);

        // Llamamos al método que queremos probar
        demonio1.editarExtra();

        // Restauramos la entrada estándar original
        System.setIn(nullInput);

    }
}