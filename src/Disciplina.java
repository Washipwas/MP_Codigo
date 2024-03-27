/**
 * 
 */
public class Disciplina extends HabilidadEspecial {

    /**
     * Default constructor
     */
    public Disciplina(String nombre, int valorAtaque, int valorDefensa, int coste) {
        super(nombre,valorAtaque,valorDefensa);
        this.coste = coste;
    }

    /**
     * 
     */
    private int coste;

}