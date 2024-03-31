import java.util.Set;

/**
 * 
 */
public class Demonio extends Esbirro {

    /**
     * Default constructor
     */
    public Demonio(String nombre, int vida, String pacto) {
        super(nombre, vida);
        this.pacto = pacto;
    }

    @Override
    public void mostrarExtra() {
        System.out.println("Pacto: " + this.pacto);
    }
    private String pacto;

    /**
     * @return
     */
    public Set<Esbirro> esbirros() {
        // TODO implement here
        return null;
    }

}