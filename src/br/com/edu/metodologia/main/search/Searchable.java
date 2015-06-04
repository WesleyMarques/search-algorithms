package br.com.edu.metodologia.main.search;

/**
 * Interface definida para realizar buscar de um determinado valor em um texto.
 * 
 */
public abstract class Searchable {

	protected String pattern;

	/**
	 * Método para realizar busca de um determinado valor.
	 * 
	 * @param text
	 *            texto buscado
	 * @return índice do ínicio do conteúdo buscado.
	 */
	public abstract int[] search(String text);
}