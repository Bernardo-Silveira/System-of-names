// Imports
import java.util.Scanner;

// Inicialization
public class Main {
    public static void main(String[] args) {
        // Scanner
        Scanner entradaUsuario = new Scanner(System.in);

        // Variables
        int quantidadeLinhas = 3;
        int quantidadeColunas = 3;
        String matriz[][] = new String[quantidadeLinhas][quantidadeColunas];

        boolean programaFuncionando = true;
        do {
            System.out.println("\n===== Menu =====");
            System.out.println("[ 1 ] - Adicionar nome");
            System.out.println("[ 2 ] - Ver nome(s)");
            System.out.println("[ 3 ] - Remover nome");
            System.out.println("[ 4 ] - Sair");
            System.out.println("Escolha uma opção: ");

            // Do this
            try {
                String entrada = entradaUsuario.nextLine().trim();

                // Doors Of Input (entrada)
                switch (entrada) {
                    case "1" -> {
                        // Input
                        System.out.println("Digite o nome: ");

                        // Verify if it's null
                        String nome = entradaUsuario.nextLine().trim();

                        if (nome.isEmpty()) {
                            System.out.println("Erro: 404 -> (Não encontrado!)"); // Error 404 = "Not found"
                            break;
                        }

                        boolean adicionadoNome = false;

                        // Structure of While -> (list names)
                        for (int linha = 0; linha < quantidadeLinhas && !adicionadoNome; linha++) {
                            for (int coluna = 0; coluna < quantidadeColunas; coluna++) {
                                if  (matriz[linha][coluna] == null) {
                                    matriz[linha][coluna] = nome;

                                    System.out.printf("Nome '%s' cadastrado em [%d][%d]%n", nome, linha, coluna);

                                    adicionadoNome = true;
                                    break;
                                }
                            }
                        }

                        // Verify if the list're full
                        if (!adicionadoNome)
                            System.out.println("Lista cheia, sequer remova pelo menos um nome!");
                    }

                    // Show the list of names
                    case "2" -> {
                        System.out.println("---- Lista de nomes ----");

                        boolean possuiNome = false;

                        for (int linha = 0; linha < quantidadeLinhas; linha++) {
                            for (int coluna = 0; coluna < quantidadeColunas; coluna++) {
                                String possuido = matriz[linha][coluna];

                                if (possuido != null) {
                                    System.out.printf("[%d][%d] = %s%n", linha, coluna, possuido);
                                    possuiNome = true;
                                }
                            }
                        }

                        // If there is no names
                        if (!possuiNome) {
                            System.out.println("Erro: 204 -> Sem conteúdo!"); // 204 = No Content
                        }
                    }

                    // Remove a name
                    case "3" -> {
                        System.out.println("Digite o nome que deseja remover: ");

                        String nomeRemover = entradaUsuario.nextLine().trim();

                        if (nomeRemover.isEmpty()) {
                            System.out.println("Erro: 400 -> Entrada inválida!"); // 400 = Bad Request
                            break;
                        }

                        boolean removido = false;

                        // Search name in matrix
                        for (int linha = 0; linha < quantidadeLinhas && !removido; linha++) {
                            for (int coluna = 0; coluna < quantidadeColunas; coluna++) {
                                if (matriz[linha][coluna] != null &&
                                        matriz[linha][coluna].equalsIgnoreCase(nomeRemover)) {

                                    matriz[linha][coluna] = null;

                                    System.out.printf("Nome '%s' removido de [%d][%d]%n", nomeRemover, linha, coluna);

                                    removido = true;
                                    break;
                                }
                            }
                        }

                        // If name not found
                        if (!removido) {
                            System.out.println("Erro: 404 -> Nome não encontrado!"); // 404 = Not Found
                        }
                    }

                    case "4" -> {
                        System.out.println("Finalizando programa...");
                        programaFuncionando = false;
                    }

                    default -> {
                        System.out.println("Erro: 400 -> Opção inválida!"); // 400 = Bad Request
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro: 500 -> Erro interno do sistema!"); // 500 = Internal Server Error
            }

        } while (programaFuncionando);

        entradaUsuario.close();
    }
}