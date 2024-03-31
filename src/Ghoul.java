
public class Ghoul extends Esbirro {

    public Ghoul(String nombre, int vida, int dependencia) {
        super(nombre,vida);
        this.dependencia = dependencia;
    }
    @Override
    public void mostrarExtra() {
        System.out.println("Dependencia: " + this.dependencia);
    }
    private int dependencia;

}