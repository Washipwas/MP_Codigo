import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

/**
 * 
 */
public class Combate implements Serializable {

    /**
     * Default constructor
     */
    public Combate(UsuarioEstandar usuarioActivo, UsuarioEstandar usuario2, int dinero,String id) {
        this.personaje1 = usuarioActivo;
        this.personaje2 = usuario2;
        this.oroApostado = dinero;
        this.id = id;
        this.rondas = 0;
        this.ganador=null;
        this.validado = false;
    }

    private String id;
    private UsuarioEstandar personaje1;

    private UsuarioEstandar personaje2;
    private int oroApostado;
    private Boolean validado;
    private LocalDate Fecha;
    private String ganador;
    private int rondas;
    private int valorvidainicial1;
    private int valorvidainicial2;

    public String getGanador(){
        return ganador;
    }
    public boolean getValidado(){
        return this.validado;
    }
    public void setValidado(boolean bool){
        this.validado = bool;
    }

    public UsuarioEstandar getPersonaje1(){
        return personaje1;
    }
    public UsuarioEstandar getPersonaje2(){
        return personaje2;
    }
    public int getOroApostado(){
        return oroApostado;
    }


    public String hayGanador() {
        if(personaje1.getPersonajeUser().estaVivo() && !personaje2.getPersonajeUser().estaVivo()){
            this.ganador=personaje1.getNombre();
            System.out.println("Gana el ususario: "+ this.ganador);
            return "Gana el personaje 1";
        }
        else if(!personaje1.getPersonajeUser().estaVivo() && personaje2.getPersonajeUser().estaVivo()){
            this.ganador=personaje2.getNombre();
            System.out.println("Gana el ususario: "+ this.ganador);
            return "Gana el personaje 2";
        }
        else if(!personaje1.getPersonajeUser().estaVivo() && !personaje2.getPersonajeUser().estaVivo()){
            this.ganador="Empate";
            System.out.println("Empate");
            return "Empate";
        }
        return null;
    }

    /**
     * @return
     */
    public Boolean esbirrosVivos() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int calcularPotencialAtaque(PersonajeUser auxpersonaje) {
        int sumPontenciales=auxpersonaje.sumarPotencialAtaque();
        return sumPontenciales;
    }

    public int generPotencial(int numero) {/*numero aleatorio*/
        int valor=0;
        for (int i =0; i <=numero;i++){
            Random random = new Random();
            int randomNumber = random.nextInt(7);
            if (randomNumber==5 || randomNumber==6){
                valor+=1;
            }
        }
        return valor;
    }

    public int calcularPotencialDef(PersonajeUser auxpersonaje) {
        int sumPontenciales=auxpersonaje.sumarPotencialDefensa();
        return sumPontenciales;
    }


    public String getId() {
        return this.id;
    }

    public void asociarDesafio() {
        this.personaje2.setDesafiante(this.personaje1);
    }

    public void empezar() {
        this.Fecha=LocalDate.now();
        TextTerminal terminal=new TextTerminal();
        terminal.show("Ha empezado el combate");
        valorvidainicial1=this.personaje1.getPersonaje().getSalud();
        valorvidainicial2=this.personaje2.getPersonaje().getSalud();
        int valorvida =this.personaje1.getPersonaje().setVida();
        this.personaje1.getPersonajeUser().setVida(valorvida);
        int valorvida2=this.personaje2.getPersonaje().setVida();
        this.personaje2.getPersonajeUser().setVida(valorvida2);
        terminal.show("Usuario1: "+this.personaje1.getNombre()+"    personaje: "+this.personaje1.getPersonaje().getNombre());
        terminal.show("Usuario2: "+this.personaje2.getNombre()+"    personaje: "+this.personaje2.getPersonaje().getNombre());
        int peleador1ataque=calcularPotencialAtaque(this.personaje1.getPersonajeUser());
        int peleador2ataque=calcularPotencialAtaque(this.personaje2.getPersonajeUser());
        int peleador1defensa=calcularPotencialDef(this.personaje1.getPersonajeUser());
        int peleador2defensa=calcularPotencialDef(this.personaje2.getPersonajeUser());
    while (this.hayGanador()==null){
        this.rondas+=1;
        int peleador1ataque_combate=generPotencial(peleador1ataque);
        int peleador2ataque_combate=generPotencial(peleador2ataque);
        int peleador1defensa_combate=generPotencial(peleador1defensa);
        int peleador2defensa_combate=generPotencial(peleador2defensa);
        if (peleador1ataque_combate>peleador2defensa_combate){
            this.personaje2.getPersonajeUser().restarVida();
            terminal.show("Personaje: "+this.personaje2.getPersonaje().getNombre()+" del ususario "+this.personaje2.getNombre() +" pierde 1 de vida");
        }
        if (peleador2ataque_combate>peleador1defensa_combate){
            this.personaje1.getPersonajeUser().restarVida();
            terminal.show("Personaje: "+this.personaje1.getPersonaje().getNombre()+ " del ususario "+this.personaje1.getNombre()+" pierde 1 de vida");
        }

    }
    this.personaje1.setBloqueado(false);
    this.personaje1.setDesafiante(null);
    mostrarResumen();
    if (this.ganador.equals(this.personaje1.getNombre())){
        this.personaje1.getPersonajeUser().sumarOro(this.oroApostado*2);
    } else if(this.ganador.equals(this.personaje2.getNombre())){
        this.personaje2.getPersonajeUser().sumarOro(this.oroApostado*2);
    } else{
        this.personaje1.getPersonajeUser().sumarOro(this.oroApostado);
        this.personaje2.getPersonajeUser().sumarOro(this.oroApostado);
      }
    }

    public void mostrarResumen() {
        System.out.println("Resumen del combate");
        System.out.println("Usuario desafiante:"+this.personaje1.getNombre());
        System.out.println("Usuario desafiado: "+this.personaje2.getNombre());
        System.out.println("Rondas empleadas: "+ this.rondas);
        System.out.println("Fecha:"+this.Fecha );
        System.out.println("Ganador: "+ this.ganador);
        System.out.println("Usuario que mantuvo esbirros: ");
        if (this.valorvidainicial1<this.personaje1.getPersonajeUser().getVida()){
            System.out.println(this.personaje1.getNombre());
        }else if (this.valorvidainicial2<this.personaje2.getPersonajeUser().getVida()){
            System.out.println(this.personaje2.getNombre());
        }
        System.out.println("Oro apostado: "+ this.oroApostado);

    }

    public LocalDate getFecha() {
        return this.Fecha;
    }

    public void combateCancelar() {
        this.personaje1.setDesafiante(null);
        this.personaje1.setBloqueado(false);
        this.personaje1.getPersonajeUser().sumarOro(this.oroApostado);
        this.personaje2.getPersonajeUser().sumarOro(this.oroApostado);
    }

    public void asociarHabilidades() {
        TextTerminal terminal = new TextTerminal();
        if (this.personaje1.getPersonajeUser().getPersonaje().hayHabilidad()){
            terminal.show("Habilidad especial del personaje " + personaje1.getPersonajeUser().getPersonaje().getNombre() + " del usuario " + personaje1.getNombre());
            this.personaje1.getPersonajeUser().getPersonaje().mostrarHabilidadEspecial();
            terminal.show("¿Añadir habilidad especial? (Si/No)");
            String opcion = terminal.read();
            if ("No".equalsIgnoreCase(opcion)){
                this.personaje1.getPersonajeUser().getPersonaje().setHabilidad(null);
                terminal.show(UtilConstants.ANSI_RED + "Habilidad especial no añadida" + UtilConstants.ANSI_RESET);

            } else{
                terminal.show(UtilConstants.ANSI_GREEN + "Habilidad especial añadida" + UtilConstants.ANSI_RESET);
            }
        } else{
            terminal.show(UtilConstants.ANSI_RED + "El personaje " + personaje1.getPersonajeUser().getPersonaje().getNombre() + " no tiene habilidad especial" + UtilConstants.ANSI_RESET);
        }

        if (this.personaje1.getPersonajeUser().getPersonaje().hayHabilidad()) {
            terminal.show("Habilidad especial del personaje " + personaje2.getPersonajeUser().getPersonaje().getNombre() + " del usuario " + personaje2.getNombre());
            this.personaje2.getPersonajeUser().getPersonaje().mostrarHabilidadEspecial();
            terminal.show("¿Añadir habilidad especial? (Si/No)");
            String opcion = terminal.read();
            if ("No".equalsIgnoreCase(opcion)) {
                this.personaje2.getPersonajeUser().getPersonaje().setHabilidad(null);
                terminal.show(UtilConstants.ANSI_RED + "Habilidad especial no añadida" + UtilConstants.ANSI_RESET);

            } else {
                terminal.show(UtilConstants.ANSI_GREEN + "Habilidad especial añadida" + UtilConstants.ANSI_RESET);
            }
        } else {
            terminal.show(UtilConstants.ANSI_RED + "El personaje " + personaje2.getPersonajeUser().getPersonaje().getNombre() + " no tiene habilidad especial" + UtilConstants.ANSI_RESET);
        }
    }

    public void combateCancelarPorciento() {
        this.personaje1.setDesafiante(null);
        this.personaje1.setBloqueado(false);
        this.personaje1.getPersonajeUser().sumarOro(this.oroApostado);
        this.personaje2.getPersonajeUser().sumarOro((int) (this.oroApostado*0.9));
    }
}