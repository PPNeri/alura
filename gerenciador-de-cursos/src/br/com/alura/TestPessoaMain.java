package br.com.alura;


public class TestPessoaMain {

	public static void main(String[] args) {

		Pessoa p = new Pessoa("Fulano ", "Tal");

		String nomeCompleto = p.getNomeCompleto();
		

		
		System.out.println(nomeCompleto);
	}

	public static void testObterNomeCompleto() {

	}

}
