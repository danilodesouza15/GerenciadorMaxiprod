import java.util.ArrayList;
import java.util.List;

public class CadastroPessoas {
    private static List<Pessoa> pessoas = new ArrayList<>();
    private static int nextId = 1;

    public static void adicionarPessoa(Pessoa pessoa) {
        pessoa.setId(nextId++);
        pessoas.add(pessoa);
    }

    public static void removerPessoa(int id) {
        pessoas.removeIf(p -> p.getId() == id);
    }

    public static void listarPessoas() {
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }


    public static Pessoa buscarPessoaPorId(int id) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }


    public static List<Pessoa> getPessoas() {
        return pessoas;
    }
}