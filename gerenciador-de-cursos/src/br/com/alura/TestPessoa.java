package br.com.alura;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestPessoa {
	@Test
	public void testNomeCompleto() {
//cenario
		Pessoa p = new Pessoa("Pedro", "Neri");

		String result = p.getNomeCompleto();// Codigo que o Programador fez
//		System.out.println(result);

		String expectedResult = "PedroNeri";// O que eu espero que aconteca

		assertEquals(expectedResult, result);
	}

}
