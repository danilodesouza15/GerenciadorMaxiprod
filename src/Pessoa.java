import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private int id;
    private String nome;
    private int idade;
    private static int proximoId = 1;
    private List<Transacao> transacoes = new ArrayList<>();

    public Pessoa(String nome, int idade){
        this.id = proximoId++;
        this.nome = nome;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void addTransacao(Transacao transacao){
        transacoes.add(transacao);
    }
}

