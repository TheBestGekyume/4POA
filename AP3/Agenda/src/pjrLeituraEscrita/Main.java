package pjrLeituraEscrita;

public class Main {
    public static void main(String[] args) {
        AgendaView view = new AgendaView();
        AgendaController controller = new AgendaController(view);
        controller.iniciar();
    }
}
