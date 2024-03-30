import java.util.Set;

public class Demonio extends Esbirro {

    public Demonio(String nombre, int vida, String pacto) {
        super(nombre, vida);
        this.pacto = pacto;
    }

    private String pacto;  // pacto no hace nada


    public Set<Esbirro> esbirros() {
        // TODO implement here
        return null;
    }

}