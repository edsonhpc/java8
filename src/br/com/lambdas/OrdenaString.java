package br.com.lambdas;

import java.util.Arrays;
import java.util.List;

/**
 * @author edson.h.cavalcanti
 * 
 * Lambdas
 * 	- Uma interface que possui apenas um método abstrato é agora conhecida como interface funcional (Consumer, Predicate)
 *  - A interface funcional ela pode conter outros métodos, contanto que sejam default ou static,
 *    essa estrutura é fundamental pois o compilador sabe exatamente que o corpo da expressão lambda
 *    que escrevemos é a implementação de seu único médodo abstrato.
 *  - Dica importante: para trabalharmos com lambdas, uma interface funcional precisa estar envolvida.
 * Static Methods em interface
 *  - Podemos usar sem a necessidade de implementação da interface por uma classe, posso reunir métodos utilitários
 *    que semanticamente ficam melhor localizados em interfaces.   
 *      
 */
public class OrdenaString {

	public static void main(String[] args) {

		List<String> palavras = Arrays.asList("alura online", "casa do código", "caelum");

		palavras.sort((s1, s2) -> {
			if (s1.length() < s2.length())
				return -1;
			if (s1.length() > s2.length())
				return 1;
			return 0;
		});
		
		// O Integer.compare compara dois inteiros e retorna positivo, negativo ou zero.
		// argumentos -> ações
		palavras.sort((s1,s2) -> { 
			return Integer.compare(s1.length(), s2.length());
		});
		
		// Essa sintaxe funciona para qualquer interface que tenha apenas um método abstrato.
		palavras.forEach((s) -> System.out.println(s)); // Sendo apenas com um parametro posso retirar as chaves.

	}

}
