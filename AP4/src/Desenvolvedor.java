package AP4.src;

import java.io.Serializable;
public class Desenvolvedor implements Serializable {

	private String nome;
	private int idade;
	private String cpf;
	private String modeloDeContratacao;
	private double salario;


	public Desenvolvedor(String nome, int idade, String cpf, String modeloDeContratacao, double salario) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.modeloDeContratacao = modeloDeContratacao;
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Desenvolvedor [\nNome: " + nome +
				"\nIdade: " + idade +
				"\nCPF: " + cpf +
				"\nModelo De Contratação: " + modeloDeContratacao +
				"\nSalário: " + salario +
				"\n]";
	}
		public String getNome() {return nome;}
		public void setNome(String nome) {this.nome = nome;}

		public int getIdade() {return idade;}
		public void setIdade(int idade) {this.idade = idade;}

		public String getCPF() {return cpf;}
		public void setCPF(String cpf) {this.cpf = cpf;}

		public String getModeloDeContratacao() {return modeloDeContratacao;}
		public void setmodeloDeContratacao(String modeloDeContratacao) {this.modeloDeContratacao = modeloDeContratacao;}

		public double getSalario() {return salario;}
		public void setSalario(double salario) {this.salario = salario;}

}

