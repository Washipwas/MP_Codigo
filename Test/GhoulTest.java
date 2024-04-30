import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class GhoulTest {

    @Test
    void mostrarExtra() {
        Ghoul ghoul1 = new Ghoul("GhoulUltimo",3,4);
        ghoul1.mostrarExtra();
    }

    @Test
    void editarExtra() {
        Ghoul ghoul1=new Ghoul("Pedro",3,5);
        ByteArrayInputStream in = new ByteArrayInputStream("Si\n".getBytes()); //ver que valores hay que meter para hacer la funcion editar y luego la llamamos
        ByteArrayInputStream inputStream2 = new ByteArrayInputStream("".getBytes()); // Segunda entrada es null

        // Cambiar el sistema de entrada para que la primera entrada sea "Si" y la segunda sea null
        System.setIn(in);
        ghoul1.editarExtra(); // Se leerá "Si" en la primera entrada

        System.setIn(inputStream2);
        ghoul1.editarExtra(); // Se leerá null en la segunda entrada
    }
}