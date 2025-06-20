import java.util.Scanner;

public class Player {

    private String name = "";
    private final Scanner scan = new Scanner(System.in);

    public String setName() {
        System.out.println("Qual o seu nome?");
        name = scan.nextLine().trim();
        return name;
    }
}
