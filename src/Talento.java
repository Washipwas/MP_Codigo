/**
 * 
 */
public class Talento extends HabilidadEspecial {


    public Talento(String nombre, int valorAtaque, int valorDefensa) {
        super(nombre, valorAtaque, valorDefensa);
    }

    @Override
    public void mostrarHabilidadExtra() {
        System.out.println("");
    }

    @Override
    protected void editarExtra() {
    }
}