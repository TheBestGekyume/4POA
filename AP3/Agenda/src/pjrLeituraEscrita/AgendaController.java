package pjrLeituraEscrita;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaController {
    private List<Anotacao> anotacoes;
    private AgendaView view;
    private LeituraEscritaArquivo persistencia;
    private static final String CAMINHO_ARQUIVO = "agenda/data/arq.txt";
    private static final String SENHA = "minha senha muito segura";

    public AgendaController(AgendaView view) {
        this.view = view;
        this.persistencia = new LeituraEscritaArquivo();
        this.anotacoes = persistencia.lerAnotacoes();
    }

    public void iniciar() {
        if (!autenticarUsuario()) {
            System.out.println("Senha incorreta. Encerrando o programa...");
            return;
        }
        
        boolean rodando = true;
        while (rodando) {
            int opcao = view.mostrarMenu();
            switch (opcao) {
                case 1:
                    adicionarAnotacao();
                    break;
                case 2:
                    listarAnotacoes();
                    break;
                case 3:
                    buscarAnotacao();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private boolean autenticarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a senha para acessar a agenda: ");
        String senhaDigitada = scanner.nextLine();
        return SENHA.equals(senhaDigitada);
    }

    private void adicionarAnotacao() {
        Anotacao anotacao = view.obterDadosAnotacao();
        anotacoes.add(anotacao);
        persistencia.salvarAnotacao(anotacao);
        System.out.println("Anotação adicionada com sucesso!");
    }

    private void listarAnotacoes() {
        view.exibirAnotacoes(anotacoes);
    }

    private void buscarAnotacao() {
        String tituloBusca = view.solicitarTituloParaBusca();
        List<Anotacao> encontrados = new ArrayList<>();

        for (Anotacao anotacao : anotacoes) {
            if (anotacao.getTitulo().equalsIgnoreCase(tituloBusca)) {
                encontrados.add(anotacao);
            }
        }

        view.exibirAnotacoes(encontrados);
    }
}
