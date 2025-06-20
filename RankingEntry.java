public class RankingEntry {
    private String nome;
    private int vitoriasConsecutivas;

    public RankingEntry(String nome) {
        this.nome = nome;
        this.vitoriasConsecutivas = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVitoriasConsecutivas() {
        return vitoriasConsecutivas;
    }

    public void adicionarVitoria() {
        vitoriasConsecutivas++;
    }

    public void resetarVitorias() {
        vitoriasConsecutivas = 0;
    }

    public boolean modoDesafio() {
        return vitoriasConsecutivas >= 5;
    }
}
