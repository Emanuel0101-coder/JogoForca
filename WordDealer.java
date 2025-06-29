import java.util.Random;

public class WordDealer {

    String escolherTipoAleatorio() {
        String[][] repertorios = {
            {"cachorro", "gato", "elefante", "leao", "tigre","cavalo", "coelho", "girafa", "jacare", "urso",
            "tartaruga", "golfinho", "aguia", "coruja", "zebra","canguru", "lobo", "rato", "porco", "pinguim", "abelha"},

            {"tintomax", "cinderela", "batman", "chaves", "naruto", "guaratubaman", "goku", "spiderman", "sherlock", "aspas",
             "thor", "pikachu", "simba", "mickey", "rapunzel", "hulk", "shrek", "moana", "olaf", "sonic"},
            
            {"banana", "uva", "laranja", "melancia", "pera", "abacaxi", "manga", "goiaba", "morango", "caju", "amora", 
            "maracuja", "pitanga", "maca", "kiwi", "limao", "acerola", "jabuticaba", "framboesa", "figo"}
        };

        String[] nomesRepertorios = {"Animais", "Especiais", "Frutas"};

        Random rand = new Random();
        int indiceRepertorio = rand.nextInt(repertorios.length);

        System.out.println("Categoria sorteada: " + nomesRepertorios[indiceRepertorio]);

        return escolherPalavraAleatoria(repertorios[indiceRepertorio]);
    }

    String escolherPalavraAleatoria(String[] palavras) {
        Random rand = new Random();
        return palavras[rand.nextInt(palavras.length)];
    }

    String construirPalavraOculta(String palavra) {
        StringBuilder palavraOculta = new StringBuilder();
        for (int i = 0; i < palavra.length(); i++) {
            palavraOculta.append(" _ ");
        }
        System.out.println("Palavra: " + palavraOculta);
        return palavraOculta.toString();
    }
}
