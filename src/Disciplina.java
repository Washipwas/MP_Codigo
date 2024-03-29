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

    public int getCoste() {
        return this.coste;
    }




    private int coste;

}