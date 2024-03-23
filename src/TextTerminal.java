import java.io.Serializable;
import java.util.Scanner;

public class TextTerminal{
    private Scanner scanner;

    public TextTerminal(){
        this.scanner = new Scanner(System.in);
    }

    public String read(){
        return scanner.nextLine();
    }

    public void show(String message){
        System.out.println(message);
    }
}
