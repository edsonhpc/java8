package br.com.defaultMethods;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ClienteTeste {

	public static void main(String[] args) {
	
		Cliente c1 = new Cliente("Edson Cavalcanti", "95455-7610", true);
		Cliente c2 = new Cliente("Juliana Cavalcanti", "99855-4453", false);
		
		List<Cliente> clientes = Arrays.asList(c1,c2);

		ImprimeCliente consumerCliente = new ImprimeCliente();
		clientes.forEach(consumerCliente);
		
	}

}

class ImprimeCliente implements Consumer<Cliente> {

	@Override
	public void accept(Cliente t) {
		
		System.out.println("Imprimindo cliente: " + t.getNome());
		t.enviaSms(t.getTelefone());
	}
	
}