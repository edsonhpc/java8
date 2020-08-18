package br.com.methodReferences;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * @author edson.h.cavalcanti
 * 
 * Method References (Referencia ao Método)
 * 	- Funciona apenas em interfaces funcionais
 *  - Fácil utilização principalmente com simples invocação de método.
 *      
 */
public class OrdenaString {

	public static void main(String[] args) {

		List<String> palavras = Arrays.asList("alura online", "casa do código", "caelum");
		
		// Método Default Estático, nesse exemplo passamos um lambda com o critério de comparação.
		// palavras.sort(Comparator.comparing(s -> s.length())); // Comparator.comparing recebe uma instancia de uma interface funcional.
		
		// Método de Referencia (Method Reference) neste caso é equivalente a expressão lambda.
		// A vantagepode ser a legibilidade, o código fica ainda mais enxuto.
		   palavras.sort(Comparator.comparing(String::length)); 
		
		// Outra forma de ordenação
		  //palavras.sort(String.CASE_INSENSITIVE_ORDER); 
		
		// Quebrando para melhor entendimento
		Function<String, Integer> funcao = String::length; // Reference Method
		//Function<String, Integer> funcao = s -> s.length(); // Essa Function ajuda a montar o objeto que diz qual será a informação usada no critério de comparação
		Comparator<String> comparador = Comparator.comparing(funcao);
		palavras.sort(comparador);
		
		//palavras.forEach((s) -> System.out.println(s));
		
		// Dessa forma fica implicíto, o argumento recebido isso é cada palavra dentro da lista, não será a variável onde o método é invocado
		// O java 8 consegue perceber que tem um println que recebe objetos, e invocará esse método, passando a String da vez.
		palavras.forEach(System.out::println);
	}

}
