package br.com.defaultMethods;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class PercorreMapBiConsumir {
	public static void main(String... args) {

		Map<Integer, String> mapLinguagens = new HashMap<>();

		mapLinguagens.put(1, "Java");
		mapLinguagens.put(2, "Node");
		mapLinguagens.put(3, "Ruby");
		mapLinguagens.put(4, "Go");

		BiConsumer<Integer, String> biConsumer = (key, value) -> {
			System.out.println("chave : " + key + " valor : " + value);
		};

		mapLinguagens.forEach(biConsumer);
	}
	
}
