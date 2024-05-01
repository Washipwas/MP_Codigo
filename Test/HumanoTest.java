import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class HumanoTest {

    @Test
    void mostrarExtra() {
        //creamos a la clase humano
        Humano humano= new Humano("Pedro",5,null);
        //llamamos a la funcion que nos muestra el valor de lealtad del humano
        humano.mostrarExtra();
    }

    @Test
    void editarExtra() {
       // TextTerminal terminal=new TextTerminal();
        Humano humano=new Humano("Pedro",5,"NORMAL");
        ByteArrayInputStream in = new ByteArrayInputStream("Si\nnull\nALTA".getBytes()); //ver que valores hay que meter para hacer la funcion editar y luego la llamamos
        System.setIn(in);
        humano.editarExtra();
    }
}