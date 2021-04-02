package br.com.alura;

public class Pessoa {

	private static String nome;
	private static String sobreNome;

	public Pessoa(String nome, String sobreNome) {
		super();
		this.nome = nome;
		this.sobreNome = sobreNome;
	};

	public static String getNomeCompleto() {
		return nome + sobreNome;

	}

}
