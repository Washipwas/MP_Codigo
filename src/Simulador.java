//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Simulador {
    public static void main(String[] args) {
        MenuInicial menuIni = new MenuInicial();
        System.out.println("Bienvenido");
        menuIni.mostrarMenu();
        menuIni.seleccionarOpcion();
        System.out.println("Hasta luego");
        System.out.println("Prueba");
    }
}