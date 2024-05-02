import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void Usuario() {
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo1 = new Licantropo("titan",5,3,2,terminal);
        PersonajeUser personajeuser1=new PersonajeUser(licantropo1);
        Arma armaaux=new Arma("DestrozaNoobs",1,1,1,0);
        personajeuser1.setArmaIzq(armaaux);
        Arma armaaux1=new Arma("Destrozadioses",1,1,1,0);
        personajeuser1.setArmaDer(armaaux1);
        Armadura armaduraaux=new Armadura("ProtectorDeDioses",1,3,4);
        personajeuser1.setArmadura(armaduraaux);

        Operador usuarioestandar1=new Operador("Operatooor","danger","pedrito12");
        System.out.println(usuarioestandar1.getNombre()+" "+usuarioestandar1.getNick()+" "+usuarioestandar1.getPassword());

    }
}