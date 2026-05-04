import java.util.ArrayList;
import java.util.Scanner;

class Aluno {
    String nome;
    int idade;
    String curso;

    public Aluno(String nome, int idade, String curso) {
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
    }

    public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Curso: " + curso);
        System.out.println("----------------------");
    }
}

public class SistemaAlunos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Aluno> alunos = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE CADASTRO DE ALUNOS =====");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Buscar aluno");
            System.out.println("4 - Remover aluno");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do aluno: ");
                    String nome = scanner.nextLine();

                    while (nome.trim().isEmpty()) {
                        System.out.print("Nome não pode ficar vazio. Digite novamente: ");
                        nome = scanner.nextLine();
                    }

                    System.out.print("Digite a idade do aluno: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();

                    while (idade <= 0) {
                        System.out.print("Idade inválida. Digite uma idade maior que 0: ");
                        idade = scanner.nextInt();
                        scanner.nextLine();
                    }

                    System.out.print("Digite o curso do aluno: ");
                    String curso = scanner.nextLine();

                    while (curso.trim().isEmpty()) {
                        System.out.print("Curso não pode ficar vazio. Digite novamente: ");
                        curso = scanner.nextLine();
                    }

                    Aluno novoAluno = new Aluno(nome, idade, curso);
                    alunos.add(novoAluno);

                    System.out.println("Aluno cadastrado com sucesso!");
                    break;

                case 2:
                    if (alunos.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {
                        System.out.println("\n===== LISTA DE ALUNOS =====");
                        System.out.println("Total de alunos cadastrados: " + alunos.size());
                        System.out.println("----------------------");

                        for (Aluno aluno : alunos) {
                            aluno.mostrarDados();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome do aluno que deseja buscar: ");
                    String nomeBusca = scanner.nextLine();

                    boolean encontrado = false;

                    for (Aluno aluno : alunos) {
                        if (aluno.nome.equalsIgnoreCase(nomeBusca)) {
                            System.out.println("\nAluno encontrado:");
                            aluno.mostrarDados();
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o nome do aluno que deseja remover: ");
                    String nomeRemover = scanner.nextLine();

                    Aluno alunoRemover = null;

                    for (Aluno aluno : alunos) {
                        if (aluno.nome.equalsIgnoreCase(nomeRemover)) {
                            alunoRemover = aluno;
                            break;
                        }
                    }

                    if (alunoRemover != null) {
                        alunos.remove(alunoRemover);
                        System.out.println("Aluno removido com sucesso!");
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}