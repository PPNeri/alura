package Aplication;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import busness.JogadorImpl;
import model.Jogador;

public class Aplication {

	public static void main(String[] args) {

		String path = "C:\\Users\\pedro.neri\\Documents\\jogadores";

		String nameFile = "listadejogadores.txt";

		JogadorImpl impl = new JogadorImpl();

		Boolean thereIsFile;

		try {
			if (!impl.checksFileExists(Paths.get(path), nameFile)) {
				fileNotFound();
			} else {

				List<Jogador> jogadores = impl.getListaDeJogadores(Paths.get(path + "\\" + nameFile));
//				impl.imprimirJogadores(jogadores);
//				impl.printJogadorByTime(jogadores, "flamengo");
//				impl.printJogadoresBytimeMaiorQue10Gols(jogadores, "flamengo");
//				System.out.println("Media de idade dos Jogadores da Lista "
//						+ String.format("%.2f", impl.getAvgAgeJogadores(jogadores)));

				System.out.println(String.format("%s", impl.getOldestJogador(jogadores)));

			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	private static String fileNotFound() {
		return "Arquivo não encontrado";
	}

}
