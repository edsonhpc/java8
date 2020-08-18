package br.com.lambdas;

import java.util.Arrays;
import java.util.List;

/**
 * @author edson.h.cavalcanti
 * 
 * Lambdas
 * 	- Uma interface que possui apenas um m�todo abstrato � agora conhecida como interface funcional (Consumer, Predicate)
 *  - A interface funcional ela pode conter outros m�todos, contanto que sejam default ou static,
 *    essa estrutura � fundamental pois o compilador sabe exatamente que o corpo da express�o lambda
 *    que escrevemos � a implementa��o de seu �nico m�dodo abstrato.
 *  - Dica importante: para trabalharmos com lambdas, uma interface funcional precisa estar envolvida.
 * Static Methods em interface
 *  - Podemos usar sem a necessidade de implementa��o da interface por uma classe, posso reunir m�todos utilit�rios
 *    que semanticamente ficam melhor localizados em interfaces.   
 *      
 */
public class OrdenaString {

	public static void main(String[] args) {

		List<String> palavras = Arrays.asList("alura online", "casa do c�digo", "caelum");

		palavras.sort((s1, s2) -> {
			if (s1.length() < s2.length())
				return -1;
			if (s1.length() > s2.length())
				return 1;
			return 0;
		});
		
		// O Integer.compare compara dois inteiros e retorna positivo, negativo ou zero.
		// argumentos -> a��es
		palavras.sort((s1,s2) -> { 
			return Integer.compare(s1.length(), s2.length());
		});
		
		// Essa sintaxe funciona para qualquer interface que tenha apenas um m�todo abstrato.
		palavras.forEach((s) -> System.out.println(s)); // Sendo apenas com um parametro posso retirar as chaves.

	}

}
