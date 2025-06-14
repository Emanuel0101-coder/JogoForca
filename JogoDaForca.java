import java.util.Scanner;

public class JogoDaForca {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Player player = new Player();

        String playerName = player.setName();
        System.out.println("Ola, " + playerName + ". Bem vindo(a) ao Jogo da Forca.");
        System.out.println("Acerte a palavra com menos de 7 erros.");

        while (true) {

            WordDealer dealWord = new WordDealer();

            String gameWord = dealWord.escolherTipoAleatorio();
            int wordNumLetters = gameWord.length();

            String hiddenWord = dealWord.construirPalavraOculta(gameWord);

            letras dealLetter = new letras();
            dealLetter.guessLetter(gameWord, wordNumLetters, hiddenWord);

            System.out.println("A palavra era: " + gameWord);

            String repeticao;
            while (true) {
                System.out.println("Deseja jogar novamente? s/n");
                repeticao = scan.nextLine().trim().toLowerCase();

                if (repeticao.equals("n")) {
                    System.out.println("Obrigado por jogar");
                    scan.close(); // Fecha o scanner
                    System.exit(0); // Encerra o programa
                } else if (repeticao.equals("s")) {
                    break;
                } else {
                    System.out.println("Por favor digite 's' para sim ou 'n' para não.");
                }
            }
        }
    }
}
