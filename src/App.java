import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class App {

  public static void main(String[] args) {
    List<Pessoa> lista = Arrays.asList(
    new Pessoa(1, "Huguinho", Departamento.FINANCEIRO, 40),
    new Pessoa(4, "Zezinho", Departamento.FINANCEIRO, 32),
    new Pessoa(3, "Luizinho", Departamento.VENDAS, 57),
    new Pessoa(9, "Patinhas",   Departamento.VENDAS, 40),
    new Pessoa(10, "Donald", Departamento.GERENCIA, 54),
    new Pessoa(2, "Margarida", Departamento.FINANCEIRO, 40),
    new Pessoa(8, "Joe Doe", Departamento.VENDAS, 34),
    new Pessoa(5, "Jane Doe", Departamento.VENDAS, 22),
    new Pessoa(6, "Sr Smith", Departamento.VENDAS, 40),
    new Pessoa(7, "Sra Smith", Departamento.GERENCIA, 39),
    new Pessoa(11, "Trinity", Departamento.VENDAS, 34),
    new Pessoa(14, "Morpheus", Departamento.FINANCEIRO, 22),
    new Pessoa(16, "AgenteSmith", Departamento.VENDAS, 47),
    new Pessoa(13, "Neo ", Departamento.GERENCIA, 29)
    );

    /***
    *  Exercício
    *  escreva as consultas solicitadas utilizando
    *  apenas expressões lambda e operações de agregação
    */    
    System.out.println("\n1. Funcionários do setor de vendas:");
    lista.stream().filter((Pessoa p) -> p.getDpto() == Departamento.VENDAS).forEach(System.out::println);

    System.out.println("\n2. Funcionários do setor de vendas com idade entre 20 e 30 anos");
    lista.stream().filter((Pessoa p) -> p.getDpto() == Departamento.VENDAS && p.getIdade() >= 20 && p.getIdade() <= 30).forEach(System.out::println);

    System.out.println("\n3. Nomes (em maiúsculas) dos funcionários do setor de vendas (usando reduce)");
    System.out.println(lista.stream().filter((Pessoa p) -> p.getDpto() == Departamento.VENDAS).reduce("", (String acumulador, Pessoa p) -> acumulador + p.getNome().toUpperCase() + "\n", String::concat));

    System.out.println("\n4. Todos os gerentes:");
    lista.stream().filter((Pessoa p) -> p.getDpto() == Departamento.GERENCIA).forEach(System.out::println);

    System.out.println("\n5. Idade média dos gerentes:");
    System.out.println(lista.stream().filter((Pessoa p) -> p.getDpto() == Departamento.GERENCIA).mapToInt((Pessoa p) -> p.getIdade()).average().getAsDouble());

    System.out.println("\n6. Funcionarios ordenados pelo código:");
    Collections.sort(lista, (Pessoa p, Pessoa q) -> p.getCodigo() - q.getCodigo());
    lista.forEach(System.out::println);

    System.out.println("\n7. Funcionários ordenados pela idade+nome:");
    Collections.sort(lista, (Pessoa p, Pessoa q) -> p.getIdade() - q.getIdade());
    lista.stream().forEach((Pessoa p) -> System.out.println(p.getNome() + "    \t" + p.getIdade()) );

    System.out.println("\n8. Criar uma nova lista apenas com os funcionarios do financeiro:");
    lista.stream().filter((Pessoa p) -> p.getDpto() == Departamento.FINANCEIRO).collect(Collectors.toList()).forEach(System.out::println);

    System.out.println("\n9. Nome e setor da pessoa mais jovem:");
    Pessoa maisJovem = lista.stream().min((Pessoa p, Pessoa q) -> p.getIdade() - q.getIdade()).get();
    System.out.println(maisJovem.getNome()  + "\t" + maisJovem.getDpto());
  }
}

