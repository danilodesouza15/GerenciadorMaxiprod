import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeGastos {
    // Utilizando o cadastro de pessoas

    public void adicionarPessoa (Pessoa pessoa){
        CadastroPessoas.adicionarPessoa(pessoa);
    }

    public void removerPessoa(int idPessoa) {
        CadastroPessoas.removerPessoa(idPessoa);
    }

    public void adicionarTransacao(Transacao transacao) {
        // Valida se a pessoa existe
        Pessoa pessoa = CadastroPessoas.buscarPessoaPorId(transacao.getPessoaId());

        if (pessoa != null) {
            pessoa.getTransacoes().add(transacao);
        } else {
            throw new IllegalArgumentException("Pessoa não encontrada.");
        }
    }

    public void listarTotais() {
        CadastroPessoas.getPessoas().forEach(pessoa -> {

            BigDecimal totalReceita = pessoa.getTransacoes()
                    .stream()

                    .filter(t -> t.getTipo().equals(TipoTransacao.RECEITA)) //usando enum
                    .map(Transacao::getValor)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal totalDespesa = pessoa.getTransacoes()
                    .stream()

                    .filter(t -> t.getTipo().equals(TipoTransacao.DESPESA))
                    .map(Transacao::getValor)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal saldo = totalReceita.subtract(totalDespesa);

            System.out.println("Pessoa: " + pessoa.getNome());
            System.out.println("Receita: " + totalReceita);
            System.out.println("Despesa: " + totalDespesa);
            System.out.println("Saldo: " + saldo);
        });

        // Calcular totais gerais
        BigDecimal totalReceitaGeral = CadastroPessoas.getPessoas().stream()
                .flatMap(p -> p.getTransacoes().stream())
                .filter(t -> t.getTipo().equals(TipoTransacao.RECEITA)) //usando enum
                .map(Transacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalDespesaGeral = CadastroPessoas.getPessoas().stream()
                .flatMap(p -> p.getTransacoes().stream())
                .filter(t -> t.getTipo().equals(TipoTransacao.DESPESA)) //usando enum
                .map(Transacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal saldoGeral = totalReceitaGeral.subtract(totalDespesaGeral);

        System.out.println("\nTotal Geral:");
        System.out.println("\nReceita: " + totalReceitaGeral);
        System.out.println("Despesa: " + totalDespesaGeral);
        System.out.println("Saldo: " + saldoGeral);
    }
}


