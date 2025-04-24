package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModificaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obter números e operação da requisição
		double numero1 = 0, numero2 = 0;
		String operacao = request.getParameter("operacao");
		String resultadoCalculadora = "";

		try {
			numero1 = Double.parseDouble(request.getParameter("numero1"));
			numero2 = Double.parseDouble(request.getParameter("numero2"));

			// Realizando a operação escolhida
			if ("multiplicacao".equals(operacao)) {
				resultadoCalculadora = "Resultado da multiplicação: " + (numero1 * numero2);
			} else if ("divisao".equals(operacao)) {
				if (numero2 == 0) {
					resultadoCalculadora = "Erro: Não é possível dividir por zero!";
				} else {
					resultadoCalculadora = "Resultado da divisão: " + (numero1 / numero2);
				}
			}
		} catch (NumberFormatException e) {
			resultadoCalculadora = "Erro: Por favor, insira números válidos.";
		}

		// Passando o resultado para a página JSP
		request.setAttribute("resultadoCalculadora", resultadoCalculadora);

		// Encaminhando a requisição para a mesma página JSP
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
