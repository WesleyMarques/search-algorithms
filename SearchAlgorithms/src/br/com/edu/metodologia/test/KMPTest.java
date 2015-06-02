package br.com.edu.metodologia.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import br.com.edu.metodologia.main.search.KMP;
import br.com.edu.metodologia.main.search.Searchable;

public class KMPTest {

	private Scanner scanner;
	private Searchable search;
	private File file;
	
	@Before
	public void setup() {
		search = new KMP("teste");
	}
	
	@Test
	public void testPalavraExistente() {
		String texto = "conteudo de texto";
		System.out.println(search.search(texto));
		System.out.println(texto.length());
		System.out.println(search.search("teste"));
	}
	
	@Test
	public void testArquivoSimples() throws FileNotFoundException {
		file = new File("resources/palavras/palavra1.txt");
		scanner = new Scanner(file);
		
		System.out.println(scanner.nextLine());
		System.out.println(file.toString());
	}
	
}
