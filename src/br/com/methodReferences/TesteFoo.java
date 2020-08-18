package br.com.methodReferences;

public class TesteFoo {

	public static void main(String[] args) {
		
		// Criando a instancia da classe
		UseFoo useFoo = new UseFoo(); 
		
		// Usando a interface funcional com expressão lambda
		// Foo foo = parameter -> parameter + " from lambda"; 
		
		Foo foo = (p) -> {
			return p = "i'm lambda";
		};
				
		String result = useFoo.add("Message", foo);
		
		System.out.println(result);
		
		
	}
}
