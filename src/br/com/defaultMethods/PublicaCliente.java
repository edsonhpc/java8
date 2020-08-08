package br.com.defaultMethods;

public interface PublicaCliente {

	void enviaEmail();
	

	default void enviaSms(String telefone) {
		
		System.out.println("Enviando SMS para o Telefone: " + telefone);
	}
}
