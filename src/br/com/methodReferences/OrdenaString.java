package br.com.methodReferences;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * @author edson.h.cavalcanti
 * 
 * Method References (Referencia ao M�todo)
 * 	- Funciona apenas em interfaces funcionais
 *  - F�cil utiliza��o principalmente com simples invoca��o de m�todo.
 *      
 */
public class OrdenaString {

	public static void main(String[] args) {

		List<String> palavras = Arrays.asList("alura online", "casa do c�digo", "caelum");
		
		// M�todo Default Est�tico, nesse exemplo passamos um lambda com o crit�rio de compara��o.
		// palavras.sort(Comparator.comparing(s -> s.length())); // Comparator.comparing recebe uma instancia de uma interface funcional.
		
		// M�todo de Referencia (Method Reference) neste caso � equivalente a express�o lambda.
		// A vantagepode ser a legibilidade, o c�digo fica ainda mais enxuto.
		   palavras.sort(Comparator.comparing(String::length)); 
		
		// Outra forma de ordena��o
		  //palavras.sort(String.CASE_INSENSITIVE_ORDER); 
		
		// Quebrando para melhor entendimento
		Function<String, Integer> funcao = String::length; // Reference Method
		//Function<String, Integer> funcao = s -> s.length(); // Essa Function ajuda a montar o objeto que diz qual ser� a informa��o usada no crit�rio de compara��o
		Comparator<String> comparador = Comparator.comparing(funcao);
		palavras.sort(comparador);
		
		//palavras.forEach((s) -> System.out.println(s));
		
		// Dessa forma fica implic�to, o argumento recebido isso � cada palavra dentro da lista, n�o ser� a vari�vel onde o m�todo � invocado
		// O java 8 consegue perceber que tem um println que recebe objetos, e invocar� esse m�todo, passando a String da vez.
		palavras.forEach(System.out::println);
	}

}
