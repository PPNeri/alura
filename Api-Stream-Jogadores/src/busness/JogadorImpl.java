package busness;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Jogador;

public class JogadorImpl {

	public Boolean checksFileExists(Path path, String fileName) throws IOException {

		Boolean ans = false;

		// retorna todos os arquivos de um diretorio atraves de um Stream<Path>
		Stream<Path> filesStream = Files.list(path);

		// filtra se existe um file que tenha o nome do arquivo passado no metodo
		Optional<Path> file = filesStream.filter(files -> files.toString().endsWith(fileName)).findAny();

		ans = file.isPresent();

		return ans;

	}

//	Preenche a lista de jogadores vindas do arquibo

	public List<Jogador> getListaDeJogadores(Path path) throws IOException {

		Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1);
		List<String> lineList = lines.collect(Collectors.toList());

		List<Jogador> listaDeJogadores = new ArrayList<>();
		Jogador jogador;
		Iterator it = lineList.listIterator();
		String str = null;

		while (it.hasNext()) {
			str = (String) it.next();
			String info[] = str.split(",");
			jogador = new Jogador();
			jogador.setNome(info[0]);
			jogador.setPosicao(info[1]);
			jogador.setIdade(Integer.parseInt(info[2]));
			jogador.setTimeAtual(info[3]);
			jogador.setGolsMarcados(Integer.parseInt(info[4]));
			listaDeJogadores.add(jogador);
		}
		return listaDeJogadores;
	}

	// Imprime Jogadores
	public void imprimirJogadores(List<Jogador> jogadores) {
		jogadores.stream().forEach(System.out::println);
	}

	// Exercicio_01-Imprimir jogadores por times
	public void printJogadorByTime(List<Jogador> jogadores, String time) {
		jogadores.stream().filter(jogador -> jogador.getTimeAtual().toUpperCase().equals(time.toUpperCase()))
				.forEach(System.out::println);
	}

	// Exercicio_02-Imprime jogadores de um certo time com gols maiores que 10

	public void printJogadoresBytimeMaiorQue10Gols(List<Jogador> jogadores, String time) {

		jogadores.stream()
				.filter(j -> j.getTimeAtual().toUpperCase().equals(time.toUpperCase()) && j.getGolsMarcados() > 15)
				.forEach(System.out::println);

	}

	// Exercicio_03-Imprimir a media de idade dos jogadores

	public Double getAvgAgeJogadores(List<Jogador> jogadores) {

		return jogadores.stream().mapToDouble(Jogador::getIdade).average().getAsDouble();

	}

	public String getOldestJogador(List<Jogador> jogadores) {
		Jogador maisVelho = jogadores.stream().max(Comparator.comparingInt(Jogador::getIdade)).get();
		return maisVelho.getNome() + " é o jogador mais velho e possui " + maisVelho.getIdade() + " anos";
	}
	
	
	public int imprimirSomatorioGols (List<Jogador> jogadores){
        int soma = jogadores.stream().mapToInt(jogador -> jogador.getGolsMarcados()).sum();
        return soma;
     }
        public void agruparJogadoresPeloTime(List<Jogador> jogadores){
        Map<String, List<Jogador>> groupByTime = jogadores.stream().collect(
        Collectors.groupingBy(Jogador::getTimeAtual));
        System.out.println(groupByTime);
     }
        public void ordenarJogadoresGols(List<Jogador> jogadores){
        jogadores.stream().sorted(Comparator.comparingInt(Jogador::getGolsMarcados).
        reversed()).forEach(System.out::println);
     }


}
