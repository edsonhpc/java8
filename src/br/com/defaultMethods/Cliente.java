package br.com.defaultMethods;

public class Cliente implements PublicaCliente, Autentica {

	private String nome;
	private String telefone;
	private boolean status;
	private String senha;

	public Cliente(String nome, String telefone, boolean status, String senha) {
		this.nome = nome;
		this.telefone = telefone;
		this.status = status;
		this.senha = senha;
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
	
	public String getSenha() {
		return senha;
	}

	@Override
	public void enviaEmail() {
		System.out.println("Enviando e-mail para: " + this.nome);
	}

	@Override
	public boolean autenticaSenha(String senha) {
		if(this.senha != senha) {
			System.out.println("Não Autenticado!");
			return false;
		}
		System.out.println("Autenticado");	
		return true;
	}

}
