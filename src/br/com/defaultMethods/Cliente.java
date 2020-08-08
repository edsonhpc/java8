package br.com.defaultMethods;

public class Cliente implements PublicaCliente {

	private String nome;
	private String telefone;
	private boolean status;

	public Cliente(String nome, String telefone, boolean status) {
		this.nome = nome;
		this.telefone = telefone;
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public boolean getStatus() {
		return status;
	}

	@Override
	public void enviaEmail() {
		System.out.println("Enviando e-mail para: " + this.nome);
	}

}
