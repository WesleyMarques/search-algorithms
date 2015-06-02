package br.com.edu.metodologia.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import br.com.edu.metodologia.main.search.BoyerMoore;
import br.com.edu.metodologia.main.search.RabinKarp;
import br.com.edu.metodologia.main.search.Searchable;

public class RabinKarpTest {

	private Searchable search;
	private File file;
	private RabinKarp boyermoore2, RabinKarp;
	private Scanner scanner;

	@Before
	public void setUp() {
		search = new RabinKarp("teste");
		String pat = "teste";
		RabinKarp = new RabinKarp(pat);
	}

	@Test
	public void test() {
		String txt = "sssteste     ndo";
		assertEquals(3, RabinKarp.search(txt));
	}

	@Test
	public void testArquivoSimples() throws IOException {
		String txt = new String(Files.readAllBytes(Paths.get("resources/palavras/palavra1.txt")),
				StandardCharsets.UTF_8);
		assertEquals(txt.length(), RabinKarp.search(txt));
	}

}
