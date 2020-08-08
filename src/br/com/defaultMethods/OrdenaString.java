package br.com.defaultMethods;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author edson.h.cavalcanti
 * 
 * Default Methods 
 * 	- Com esse recurso possibilita adicionar métodos em interfaces e implementá-los ali mesmo!
 *  - É um método de interface que eu não preciso implementar na minha classe se não quiser, pois terei a implementação default.
 *  - Essa foi a forma que o Java encontrou para evoluir interfaces antigas, sem gerar incompatibilidades.
 *  - Em uma interface não posso ter atributos de instância, apenas métodos que delegam chamadas ou trabalham com os próprios métodos da interface.
 *  - Sempre que precisar adicionar a uma interface existente, é possivel usar o method default sem quebrar nenhuma classe da implementação existente.
 */
public class OrdenaString {

	public static void main(String[] args) {

		List<String> palavras = Arrays.asList("alura online", "casa do código", "caelum");

		Comparator<String> comparator = new ComparadorDeStringPorTamanho();
		//Collections.sort(palavras, comparator);
		  palavras.sort(comparator);
		//System.out.println(palavras);

		Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);

	}

}

class ImprimeNaLinha implements Consumer<String> {

	@Override
	public void accept(String s) {

		System.out.println(s);

	}

}

class ComparadorDeStringPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;
		return 0;
	}

}
