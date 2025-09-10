import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AlunoDAO dao = new AlunoDAO();
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Listar");
            System.out.println("2 - Inserir");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    List<Aluno> lista = dao.listar();
                    for (Aluno a : lista) {
                        System.out.println(a);
                    }
                    break;
                case 2:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Curso: ");
                    String curso = sc.nextLine();
                    dao.inserir(new Aluno(0, nome, idade, curso));
                    break;
                case 3:
                    System.out.print("ID do aluno a atualizar: ");
                    int idAt = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    String nomeAt = sc.nextLine();
                    System.out.print("Nova idade: ");
                    int idadeAt = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo curso: ");
                    String cursoAt = sc.nextLine();
                    dao.atualizar(new Aluno(idAt, nomeAt, idadeAt, cursoAt));
                    break;
                case 4:
                    System.out.print("ID do aluno a excluir: ");
                    int idExc = sc.nextInt();
                    dao.excluir(idExc);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}
