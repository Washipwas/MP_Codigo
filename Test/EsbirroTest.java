import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class EsbirroTest {

    @Test
    void mostrar() {
        Ghoul esbirro1= new Ghoul("GhoulInmortal",3,4);
        esbirro1.mostrar();
        Demonio demonio1 = new Demonio("DemonioMortal",3,"pacto de unión entre el demonio ");
        demonio1.mostrar();
        Humano humano1= new Humano("Pedro",5,"ALTA");
        humano1.mostrar();
      }

    @Test
    void editar() {
        Ghoul esbirro1= new Ghoul("GhoulInmortal",3,4);
        ByteArrayInputStream in = new ByteArrayInputStream("No\nSi\n2".getBytes());
        System.setIn(in);
        esbirro1.editar();
    }

}