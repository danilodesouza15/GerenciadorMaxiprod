import java.math.BigDecimal;

public class Transacao {
    private int id;
    //controla o id internamente, semelhante a classe Pessoa
    private static int proximoId = 1;
    private String descricao;
    private BigDecimal valor;
    private TipoTransacao tipo;
    private Pessoa pessoa;

    public Transacao(String descricao, BigDecimal valor, TipoTransacao tipo, Pessoa pessoa){
        this.id = proximoId++;
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.pessoa = pessoa;

        // comparando com o enum
        if (pessoa.getIdade() < 18 && tipo != TipoTransacao.DESPESA) {
            throw new IllegalArgumentException("Menores de 18 anos só podem realizar transações de despesa.");
        }
    }


    public int getPessoaId() {
        return pessoa.getId();
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
