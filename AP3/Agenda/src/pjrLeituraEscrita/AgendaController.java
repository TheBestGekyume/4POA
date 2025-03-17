package pjrLeituraEscrita;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AgendaController {
    private List<Anotacao> anotacoes;
    private AgendaView view;
    private LeituraEscritaArquivo persistencia;
    private static final String CAMINHO_ARQUIVO = "data/arq.txt";

    public AgendaController(AgendaView view) {
        this.view = view;
        this.persistencia = new LeituraEscritaArquivo();
        this.anotacoes = persistencia.lerAnotacoes();
    }

    public void iniciar() {
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
    public List<Anotacao> lerAnotacoes() {
        List<Anotacao> anotacoes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Anotacao anotacao = Anotacao.fromString(linha);
                if (anotacao != null) {
                    anotacoes.add(anotacao);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Criando um novo.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return anotacoes;
    }

    public void salvarAnotacao(Anotacao anotacao) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO, true))) {
            bw.write(anotacao.toFileString()); // Mantendo o formato no arquivo
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




