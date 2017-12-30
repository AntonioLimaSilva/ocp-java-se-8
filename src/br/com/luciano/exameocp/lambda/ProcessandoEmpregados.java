package br.com.luciano.exameocp.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * @author Luciano Lima
 *
 */
public class ProcessandoEmpregados {

	public static void main(String[] args) {
		
		Empregado empregados[] = {
			new Empregado(1, "Antonio", "Lima", 15_000.00, "TI"),
			new Empregado(2, "Ediane", "Silva", 10_000.00, "RH"),
			new Empregado(3, "Marcelo", "Miranda", 8_000.00, "TI"),
			new Empregado(4, "Antonia", "Lima", 7_000.00, "Ouvidoria"),
			new Empregado(4, "Carlos", "Gomes", 9_000.00, "Administração"),
			new Empregado(4, "Marcus", "Oliveira", 5_000.00, "TI"),
			new Empregado(4, "Zelia", "Ribeiro", 6_000.00, "Ouvidoria")
		};

//		Arrays.asList(empregados).stream().forEach(System.out::println);
//		Arrays.stream(empregados).forEach(System.out::println);
		
		List<Empregado> list = Arrays.asList(empregados);		
//		list.stream().forEach(System.out::println);
		
		Predicate<Empregado> salariosMaiores = (e) -> (e.getSalario() > 9_000.00 && e.getSalario() < 16_000.00);
		
		list.stream()
			.filter(salariosMaiores)
			.sorted(Comparator.comparing(Empregado::getSalario))
			.forEach(System.out::println);
		
		//Exibir o primeiro salário nesse intervalo
		Empregado empregado = list.stream()
			.filter(salariosMaiores)
			.findFirst()
			.get();
		
		System.out.printf("%nPrimeiro empregado com salário maior %n%s%n", empregado);
		
		/**
		 * Filtra os salários dado critério, depois mapeia o atributo salário da classe empregado e em seguida realiza soma e retorna
		 * atravez do método reduce, caso contrario retornaria o valor 0.0
		 */
		Double total = list.stream()
			.filter(e -> e.getSalario() >= 10_000.00 && e.getSalario() <= 15_000.00)
			.map(Empregado::getSalario)
			.reduce((x, y) -> x + y)
			.orElse(Double.valueOf(0));
			
		System.out.printf("Valor total da soma %.2f\n", total);
		
		// Functions para obter o nome e o sobrenome de um empregado
		Function<Empregado, String> porPrimeiroNome = Empregado::getNome;
		Function<Empregado, String> porSegundoNome = (e) -> e.getSobrenome();
		System.out.println(porPrimeiroNome.apply(empregado));
		
		// Comparator para comparar empregados pelo nome, e pelo sobrenome
		Comparator<Empregado> comparador = Comparator.comparing(porPrimeiroNome).thenComparing(porSegundoNome);
		
		System.out.printf("%nEmpegados em ordem ascendente por primeiro nome e segundo nome:%n");
		list.stream()
			.sorted(comparador)
			.forEach(System.out::println);
		
		System.out.printf("%nEmpegados em ordem decrescente com nome e sobrenome:%n");
		list.stream()
			.sorted(comparador.reversed())
			.forEach(System.out::println);
		
		System.out.printf("%nEmpegados em ordem ascendente com sobrenomes únicos:%n");
		list.stream()
			.map(Empregado::getSobrenome)
			.distinct()
			.sorted()
			.forEach(System.out::println);
		
		System.out.printf("%nEmpegados em ordem decrescente com nome completo:%n");
		list.stream()
			.sorted(comparador)
			.map(Empregado::getNomeCompleto)
			.forEach(System.out::println);
		
		// Agrupando empregados por departamento
		System.out.printf("%nEmpregados por departamentos:%n");
		Map<String, List<Empregado>> agrupandoPorDepartamento = list.stream().collect(Collectors.groupingBy(Empregado::getDepartamento));
		agrupandoPorDepartamento.forEach((departamento, empregadosDoDepartamento) -> {
			System.out.println("============== " + departamento + " =============");
			empregadosDoDepartamento.forEach(System.out::println);
		});
		
		// Conta o número de empregados em cada departamento
		System.out.printf("%nConta o número de empregados por departamento:%n");
		Map<String, Long> quantidadeEmpregadosPorDepartamento = list.stream()
				.collect(Collectors.groupingBy(Empregado::getDepartamento, Collectors.counting()));
		
		quantidadeEmpregadosPorDepartamento.forEach((chave, valor) -> {System.out.printf("%s tem %d empregado(s)%n", chave, valor);});
		
		// Calcula a soma dos salários dos empregados com o método de soma DoubleStream
		System.out.printf("%nSoma o salários dos empregadis (via sum method): %.2f%n", list.stream()
				.mapToDouble(Empregado::getSalario)
				.sum());
		
		// Calcula soma dos salários dos Employees com o método reduce Stream
		System.out.printf("Soma o salários dos emppregados (via reduce method): %.2f%n", list.stream()
				.mapToDouble(Empregado::getSalario)
				.reduce(0, (valor1, valor2) -> valor1 + valor2));
		
		// Calcula a média de salários dos empregados com o método average DoubleStream
		System.out.printf("Média de salários dos empregados: %.2f%n", list.stream()
				.mapToDouble(Empregado::getSalario)
				.average()
				.getAsDouble()); // O método orElse poderia ser usado no lugar do getAsDouble, seria até mais seguro!
	}
}
