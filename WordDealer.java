import java.util.Random;

public class WordDealer {

    String escolherTipoAleatorio() {
        String[][] repertorios = {
            {"abelha", "abutre", "aguia", "alpaca", "andorinha", "anta", "aranha", "arara",
             "avestruz","babuino", "bacalhau", "bagre", "baleia", "barata", "barracuda"},
             
            {"wesley", "tintomax", "tavares", "andre", "vitor", "corinthians", "aspas", "guaratubaman"},
             
            {"banana", "uva", "laranja", "melancia", "pera", "abacaxi", "manga"}
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
            palavraOculta.append("_");
        }
        System.out.println("Palavra: " + palavraOculta);
        return palavraOculta.toString();
    }
}
