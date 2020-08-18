package br.com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Curso {
	
	private String nome;
	private int alunos;
	
	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos= alunos;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getAlunos() {
		return alunos;
	}

}

public class ExemploCursos {
	
	public static void main(String[] args) {
	
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("Javascript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		// Lambda
		//cursos.sort(Comparator.comparing(c -> c.getAlunos()));
		//cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
		
		// Method Reference
		//cursos.sort(Comparator.comparingInt(Curso::getAlunos)); 
		//cursos.forEach(c -> System.out.println(c.getNome()));
		
		
		// Streams -> n�o � um List e nem uma Collection
		
		// Modifica��es em um stream n�o modificam a cole��o/objeto que o gerou, tudo que � feito nesse stream n�o
		// impacta, n�o tem efeitos colaterais na cole��o original.
		//cursos.stream()
			//.filter(c -> c.getAlunos() > 100)
			//.forEach(c -> System.out.println(c.getNome()));
		
//		cursos.stream()
//			.filter(c -> c.getAlunos() > 100)
//			.map(c -> c.getAlunos())  // Dessa forma � feito um autoboxing que convert de int para Integer
		
//			.forEach(System.out::println);
//		
//
//		cursos.stream()
//			.filter(c -> c.getAlunos() > 100)
//			.mapToInt(Curso::getAlunos)  
//			.forEach(System.out::println);
		
//	int soma = cursos.stream()
//		.filter(c -> c.getAlunos() > 100)
//		.mapToInt(Curso::getAlunos)   // Esse outro jeito n�o � feito o autoboxing o que ajuda a n�o consumir ainda mais recursos da jvm
//		.sum();
//	System.out.println(soma);
	
	/*
	 * As opera��es intermedi�rias retornam um novo Stream para que possamos encadear v�rias opera��es intermedi�rias
	 * sem usar o ponto e v�rgula. Essas opera��es terminais geralmente retornam um resultado que n�o � um novo Stream.
	 * No exemplo abaixo filter, map sorted s�o opera��es intermedi�rias enquanto que forEach � uma opera��o terminal.
	 * 
	 * A maioria dos m�todos de Stream aceitam algum tipo de par�metro de express�o lambda, uma interface funcional que 
	 * espec�fica o comportamento exato da opera��o.
	 * 
	 * */
	
//	List<String> myList = Arrays.asList("a1","a2","b1","b2","c2","c1");
//	myList.stream()
//		   .filter(s -> s.startsWith("c"))
//		   .map(String::toUpperCase)
//		   .sorted()
//		   .forEach(System.out::println);
	
	//-----------------------------------------------------------------------------------------------------------
	
	/**
	 * Optional � uma importante nova classe do java 8, com ele podemos trabalhar de maneira mais organizada
	 * com poss�veis valores null. Em vez de ficar comparando alguma coisa com null
	 * 
	 * Ela nos oferece uma variedade imensa de novos m�todos que nos permite trabalhar de forma funcional 
	 * com nossos valores, tirando maior proveito dos novos recursos de default method, lambda, method reference
	 */
		
//	Optional<Curso> optionalCurso = cursos.stream()
//		.filter(c -> c.getAlunos() >= 100)
//		.findAny();
	
	// Esse m�todo executa um lambada (um consumir) no caso de existir um curso dentro daquele optional.
//	optionalCurso.ifPresent(c -> System.out.println(c.getNome()));
		
	
//	 cursos.stream()
//	  	.filter(c -> c.getAlunos() > 100)
//	  	.findAny()
//	  	.ifPresent(c -> System.out.println(c.getNome()));
	
		
		/**
		 * O M�todo Collect recebe um Collector, uma interface n�o t�o trivial de se implementar, podemos usar
		 * a classe Collectors (repare o s no final), cheio de factory methods que ajudam na cria��o de coletores.
		 * � atrav�s dos coletores que podemos retornar um stream para um collection.
		 */
	
//		List<Curso> resultados = cursos.stream()
//			.filter(c -> c.getAlunos() > 100)
//			.collect(Collectors.toList());
//	
//		resultados.forEach(c -> System.out.println(c.getNome()));
//	
	
	
//		cursos.stream()
//			.filter(c -> c.getAlunos() > 100)
//			.collect(Collectors.toList())
//			.forEach(c -> System.out.println(c.getNome()));
			
		/**
		 * Utilizando o Collectors.toMap ele recebe duas Functions a primeira indica o que vai ser a chave
		 * e a segunda o que ser� o valor.
		 * 
		 * Os streams foram desenhados de uma forma a tirar proveito da programa��o funcional.
		 */
		
		
		
//		Map<String, Integer> mapa = cursos.stream()
//			.filter(c -> c.getAlunos() > 100)
//			.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
//	
//		System.out.println(mapa);
//	
	
		cursos.stream()
				.filter(c -> c.getAlunos() > 100)
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
				.forEach((nome, alunos) -> System.out.println(nome +" - "+ alunos));
		
	
		/**
		 * Podemos usar esse outro stream em paralelo, ele mesmo vai decidir quantas threads usar e fazer todo
		 * o trabalho, utilizando APIs complicadas (como a de fork join) para ganhar performance
		 * 
		 * tomar cuidado para streamns pequenos, o custo dessas threads e manipular os dados entre elas � alto e pode ser 
		 * bem mais lento que o stream tradicional
		 */
		cursos.parallelStream()
		.filter(c -> c.getAlunos() > 100)
		.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
		.forEach((nome, alunos) -> System.out.println(nome +" - "+ alunos));
	
	
		Optional<Curso> pegaPrimeiro = cursos.stream()
			.filter(c -> c.getAlunos() > 50)
			.findFirst();
			
		pegaPrimeiro.ifPresent(c -> System.out.println(c.getNome()));
	
	
	
		OptionalDouble media = cursos.stream()
			.mapToInt(c -> c.getAlunos())
			.average();
			
		System.out.println(media.getAsDouble());
	
		

		 cursos.stream()
			.mapToInt(c -> c.getAlunos())
			.average()
			.ifPresent(System.out::println);
		
		
		
	}
}


