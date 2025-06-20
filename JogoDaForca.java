import java.util.Scanner;

public class JogoDaForca {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Player player = new Player();
        Ranking ranking = new Ranking();

        String playerName = player.setName();
        System.out.println("Olá, " + playerName + ". Bem-vindo(a) ao Jogo da Forca.");
        System.out.println("Acerte a palavra com menos de 7 erros.");

        while (true) {

            RankingEntry jogadorRank = ranking.getRanking(playerName);
            boolean modoDesafio = jogadorRank.modoDesafio();

            WordDealer dealWord = new WordDealer();
            String gameWord = dealWord.escolherTipoAleatorio();
            int wordNumLetters = gameWord.length();
            String hiddenWord = dealWord.construirPalavraOculta(gameWord);

            letras dealLetter = new letras();
            boolean venceu = dealLetter.guessLetter(gameWord, wordNumLetters, hiddenWord, modoDesafio);

            System.out.println("A palavra era: " + gameWord);

            ranking.registrarResultado(playerName, venceu);
            ranking.mostrarRanking();

            String repeticao;
            while (true) {
                System.out.println("Deseja jogar novamente? s/n");
                repeticao = scan.nextLine().trim().toLowerCase();

                if (repeticao.equals("n")) {
                    System.out.println("Obrigado por jogar");
                    scan.close();
                    System.exit(0);
                } else if (repeticao.equals("s")) {
                    break;
                } else {
                    System.out.println("Por favor digite 's' para sim ou 'n' para não.");
                }
            }
        }
    }
}
