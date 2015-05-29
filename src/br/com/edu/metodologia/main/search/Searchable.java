package br.com.edu.metodologia.main.search;

/**
 * Interface definida para realizar buscar de um determinado valor em um texto.
 * 
 */
public abstract class Searchable {

	protected String pattern;
	
	/**
	 * 
	 * 
	 * @param text
	 * @return
	 */
	public abstract int search(String text);
}