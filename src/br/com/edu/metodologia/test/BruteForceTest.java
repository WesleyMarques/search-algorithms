package br.com.edu.metodologia.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import br.com.edu.metodologia.main.search.BruteForce;
import br.com.edu.metodologia.main.search.RabinKarp;
import br.com.edu.metodologia.main.search.Searchable;

public class BruteForceTest {

	private Searchable search;

	@Before
	public void setUp() {
		search = new BruteForce("teste");
	}

	@Test
	public void test() {
		search = new BruteForce("decided by analogical measurements");
	}

	@Test
	public void testArquivoSimples() throws IOException {
		String txt = new String(Files.readAllBytes(Paths.get("resources/textos/texto2.txt")),
				StandardCharsets.UTF_8);
		assertTrue(search.search(txt)[0]!=-1);
	}
	@Test
	public void testArquivoSimplesNotFound() throws IOException {
		search = new BruteForce("TestandoNotFound");
		String txt = new String(Files.readAllBytes(Paths.get("resources/textos/texto2.txt")),
				StandardCharsets.UTF_8);
		assertTrue(search.search(txt)[0]==txt.length());
	}

}
