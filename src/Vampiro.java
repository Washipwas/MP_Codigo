/**
 * 
 */
public class Vampiro extends Personaje {


    public Vampiro(String nombre, int salud, int poder,int puntoSangre,int edad) {
        super(nombre,poder,salud);
        this.puntoSangre = puntoSangre;
        this.edad = edad;
        this.disciplina = disciplina;

    }


    public int sumarPotencialAtaque() {
        int potencial;
        int sangre = getPuntoSangre();
        potencial = sangre + disciplina.getValorAtaque() + super.getPoder();
        if (sangre > 5){
            potencial+= 2;
        }
        return potencial;
    }

    public int getPuntoSangre() {
        return this.puntoSangre;
    }





    private int puntoSangre;
    private int edad;
    private Disciplina disciplina;




}