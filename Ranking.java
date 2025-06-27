import java.io.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class Ranking {
    private static final String ARQUIVO = "ranking.json";
    private Map<String, RankingEntry> rankingMap;

    public Ranking() {
        rankingMap = carregarRanking();
    }

    public RankingEntry getRanking(String nomeJogador) {
        if (!rankingMap.containsKey(nomeJogador)) {
            rankingMap.put(nomeJogador, new RankingEntry(nomeJogador));
        }
        return rankingMap.get(nomeJogador);
    }

    public void registrarResultado(String nome, boolean venceu) {
        RankingEntry entry = getRanking(nome);
        if (venceu) {
            entry.adicionarVitoria();
        } else {
            entry.resetarVitorias();
        }
        salvarRanking(); // salva após cada partida
    }

    public void mostrarRanking() {
        System.out.println("\n===== RANKING POR VITORIAS CONSECUTIVAS =====");
        rankingMap.values().stream()
            .sorted((a, b) -> Integer.compare(b.getVitoriasConsecutivas(), a.getVitoriasConsecutivas()))
            .forEach(entry ->
                System.out.println(entry.getNome() + ": " + entry.getVitoriasConsecutivas() + " vitória(s)")
            );
        System.out.println("=============================================\n");
    }

    private void salvarRanking() {
        try (Writer writer = new FileWriter(ARQUIVO)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(rankingMap, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar ranking: " + e.getMessage());
        }
    }

    private Map<String, RankingEntry> carregarRanking() {
        try (Reader reader = new FileReader(ARQUIVO)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, new TypeToken<Map<String, RankingEntry>>(){}.getType());
        } catch (IOException e) {
            return new HashMap<>(); // arquivo não existe ou erro
        }
    }
}
