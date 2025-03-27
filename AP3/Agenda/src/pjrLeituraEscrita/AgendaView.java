package pjrLeituraEscrita;

import java.util.List;
import java.util.Scanner;

public class AgendaView {
    private Scanner scanner;

    public AgendaView() {
        scanner = new Scanner(System.in);
    }

    public boolean solicitarSenha(String senhaCorreta) {
        System.out.print("Digite a senha para acessar a agenda: ");
        String senhaDigitada = scanner.nextLine();
        return senhaDigitada.equals(senhaCorreta);
    }

    public int mostrarMenu() {
        System.out.println("\n===== AGENDA DE ANOTAÇÕES =====");
        System.out.println("1. Adicionar Anotação");
        System.out.println("2. Listar Anotações");
        System.out.println("3. Buscar Anotação");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public Anotacao obterDadosAnotacao() {
        scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Data (dd/MM/yyyy): ");
        String data = scanner.nextLine();
        System.out.print("Hora (HH:mm): ");
        String hora = scanner.nextLine();
        return new Anotacao(titulo, descricao, data, hora);
    }

    public String solicitarTituloParaBusca() {
        scanner.nextLine();
        System.out.print("Digite o título da anotação: ");
        return scanner.nextLine();
    }

    public void exibirAnotacoes(List<Anotacao> anotacoes) {
        if (anotacoes.isEmpty()) {
            System.out.println("Nenhuma anotação encontrada.");
        } else {
            for (Anotacao anotacao : anotacoes) {
                System.out.println(anotacao);
            }
        }
    }
}
