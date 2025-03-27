package pjrLeituraEscrita;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeituraEscritaArquivo {
    private static final String CAMINHO_ARQUIVO = "agenda/data/arq.txt";

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
            bw.write(anotacao.toFileString()); 
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
