//enum para determinar os possíveis tipos de transação

public enum TipoTransacao {
    DESPESA("despesa"),
    RECEITA("receita");

    private final String valor;

    TipoTransacao(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}