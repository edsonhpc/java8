package br.com.defaultMethods;

@FunctionalInterface
public interface Autentica {

	public abstract boolean autenticaSenha(String senha);

}
