import java.util.Scanner;

public class letras {

    public boolean guessLetter(String gameWord, int wordNumLetters, String hiddenWord, boolean modoDesafio) {

        char[] ch = gameWord.toLowerCase().toCharArray();
        char[] chHidden = hiddenWord.toCharArray();

        int rightLetters = 0;
        int numTrys = 7;

        Scanner scan = new Scanner(System.in);
        long tempoLimite = modoDesafio ? System.currentTimeMillis() + 60000 : Long.MAX_VALUE;

        while (true) {

            boolean letterWasRight = false;

            if (modoDesafio && System.currentTimeMillis() > tempoLimite) {
                System.out.println("\nTempo esgotado! Você perdeu.");
                return false;
            }

            System.out.println("\nChute uma letra:");
            String input = scan.nextLine().toLowerCase();

            if (modoDesafio && System.currentTimeMillis() > tempoLimite) {
                System.out.println("\nTempo esgotado! Você perdeu.");
                return false;
            }

            if (input.length() > 1) {
                if (input.equals(gameWord.toLowerCase())) {
                    System.out.println("\nParabéns, você acertou a palavra inteira! :)");
                    return true;
                } else {
                    numTrys--;
                    System.out.println("Palavra errada! Você perdeu uma tentativa.");
                }
            } else if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                char letter = input.charAt(0);

                for (int i = 0; i < ch.length; i++) {
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
                System.out.println("Digite uma letra válida ou tente a palavra inteira.");
                continue;
            }

            System.out.println("\nVocê tem mais " + numTrys + " tentativas.");

            if (rightLetters == wordNumLetters) {
                System.out.println("\nParabéns, você acertou :)");
                return true;
            }

            if (numTrys <= 0) {
                System.out.println("\nPoxa, suas chances acabaram :(");
                return false;
            }
        }
    }
}
