package br.com.luciano.exameocp.lambda;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 
 * @author Luciano Lima
 *
 */
public class StreamOfLines {

	public static void main(String[] args) throws Exception {

		Pattern pattern = Pattern.compile("\\s+");
		
		Map<String, Long> contadorDePalavras = Files.lines(Paths.get("C:\\Users\\lucli\\workspace\\exame-ocp\\file1.txt"))
			.map(line -> line.replaceAll("(?!')\\p{P}", ""))
			.flatMap(line -> pattern.splitAsStream(line))
			.collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()));
		
		contadorDePalavras.entrySet()
			.stream()
			.collect(Collectors.groupingBy(entry -> entry.getKey().charAt(0), TreeMap::new, Collectors.toList()))
			.forEach((letra, listaDePalavras) -> {
				System.out.printf("%n%C%n", letra);
				listaDePalavras.stream().forEach(palavra -> System.out.printf("%13s: %d%n", palavra.getKey(), palavra.getValue()));
			});	
	}
}
