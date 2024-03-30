
public class Ghoul extends Esbirro {

    public Ghoul(String nombre, int vida, int dependencia) {
        super(nombre,vida);
        this.dependencia = dependencia;
    }


    private int dependencia;

}