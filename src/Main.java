import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GerenciadorDeGastos gerenciador = new GerenciadorDeGastos();

        // Criando pessoas
        Pessoa pessoa1 = new Pessoa("Tafnes", 22);
        Pessoa pessoa2 = new Pessoa("Jones", 28);

        // adicionando ao gerenciador
        gerenciador.adicionarPessoa(pessoa1);
        gerenciador.adicionarPessoa(pessoa2);

        // Criando transações
        Transacao transacao1 = new Transacao("Salário", BigDecimal.valueOf(2000), TipoTransacao.RECEITA, pessoa1);
        // adicionando ao gerenciador
        gerenciador.adicionarTransacao(transacao1);
        Transacao transacao2 = new Transacao("Mercado", BigDecimal.valueOf(600), TipoTransacao.DESPESA, pessoa1);
        gerenciador.adicionarTransacao(transacao2);
        Transacao transacao3 = new Transacao("Salário:", BigDecimal.valueOf(2000), TipoTransacao.RECEITA, pessoa2);
        gerenciador.adicionarTransacao(transacao3);
        Transacao transacao4 = new Transacao("Celular:", BigDecimal.valueOf(1800), TipoTransacao.DESPESA, pessoa2);
        gerenciador.adicionarTransacao(transacao4);
        // Imprimindo os detalhes
        gerenciador.listarTotais();
    }
}