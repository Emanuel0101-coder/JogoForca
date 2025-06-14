import java.util.Scanner;

public class letras {
    void guessLetter(String gameWord, int wordNumLetters, String hiddenWord) {

        char[] ch = gameWord.toLowerCase().toCharArray();
        char[] chHidden = hiddenWord.toCharArray();

        int rightLetters = 0;
        int numTrys = 7;

        Scanner scan = new Scanner(System.in);

        while (true) {

            boolean letterWasRight = false;

            System.out.println("\nChute uma letra:");
            String input = scan.nextLine().toLowerCase();

            // Se o jogador tentou a palavra inteira
            if (input.length() > 1) {
                if (input.equals(gameWord.toLowerCase())) {
                    // Acertou a palavra inteira
                    System.out.println("\nParabéns, você acertou a palavra inteira! :)");
                    break;
                } else {
                    // Errou a palavra inteira, perde uma tentativa
                    numTrys--;
                    System.out.println("Palavra errada! Você perdeu uma tentativa.");
                }
            } 
            // Se o jogador digitou só uma letra
            else if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                char letter = input.charAt(0);

                for (int i = 0; i < ch.length; i++) {
                    // Só conta letra correta se ainda não tiver sido revelada
                    if (ch[i] == letter && chHidden[i] != letter) {
                        chHidden[i] = letter;
                        rightLetters++;
                        letterWasRight = true;
                    }
                    System.out.print(chHidden[i]);
                }

                if (!letterWasRight) {
                    numTrys--;
                    System.out.println("\nLetra errada!");
                }
            } else {
                // Entrada inválida (não letra nem palavra)
                System.out.println("Digite uma letra válida ou tente a palavra inteira.");
                continue; // volta sem descontar tentativa
            }

            System.out.println("\nVocê tem mais " + numTrys + " tentativas.");

            // Verifica se o usuário já completou a palavra com letras
            if (rightLetters == wordNumLetters) {
                System.out.println("\nParabéns, você acertou :)");
                break;
            }

            if (numTrys <= 0) {
                System.out.println("\nPoxa, suas chances acabaram :(");
                break;
            }
        }
    }
}
