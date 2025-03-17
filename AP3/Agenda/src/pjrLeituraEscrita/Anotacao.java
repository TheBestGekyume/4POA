package pjrLeituraEscrita;

public class Anotacao {
    private String titulo;
    private String descricao;
    private String data;
    private String hora;

    public Anotacao(String titulo, String descricao, String data, String hora) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.hora = hora;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String toString() {
        return  "\n" +
                "Título: " + titulo + "\n" +
                "Descrição: " + descricao + "\n" +
                "Data: " + data + "\n" +
                "Hora: " + hora + "\n" +
                "-----------------------------";
    }

    public String toFileString() {
        return titulo + ";" + descricao + ";" + data + ";" + hora;
    }

    public static Anotacao fromString(String linha) {
        String[] partes = linha.split(";");
        if (partes.length == 4) {
            return new Anotacao(partes[0], partes[1], partes[2], partes[3]);
        }
        return null;
    }
}
