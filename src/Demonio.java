import java.util.Set;

public class Demonio extends Esbirro {
    public Demonio(String nombre, int vida, String pacto) {
        super(nombre, vida);
        this.pacto = pacto;
    }

    @Override
    public void mostrarExtra() {
        System.out.println("Pacto: " + this.pacto);
    }
    private String pacto;


    public Set<Esbirro> esbirros() {
        // TODO implement here
        return null;
    }

}