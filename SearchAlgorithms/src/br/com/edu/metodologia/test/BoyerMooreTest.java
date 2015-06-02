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
import br.com.edu.metodologia.main.search.Searchable;

public class BoyerMooreTest {

	private Searchable search;
	private File file;
	private BoyerMoore boyermoore2, boyermoore1;
	private Scanner scanner;

	@Before
	public void setUp() {
		search = new BoyerMoore("teste");
		String pat = "teste";
		char[] pattern = pat.toCharArray();
		boyermoore1 = new BoyerMoore(pat);
		boyermoore2 = new BoyerMoore(pattern, 256);
	}

	@Test
	public void test() {
		String txt = "sssteste     ndo";
		char[] text = txt.toCharArray();
		assertEquals(3, boyermoore1.search(txt));
		assertEquals(3, boyermoore2.search(text));
	}

	@Test
	public void testArquivoSimples() throws IOException {
		String txt = new String(Files.readAllBytes(Paths.get("resources/palavras/palavra1.txt")),
				StandardCharsets.UTF_8);
		char[] text = txt.toCharArray();
		assertEquals(txt.length(), boyermoore1.search(txt));
		assertEquals(txt.length(), boyermoore2.search(text));
	}

}

// // test client
// public static void main(String[] args) {
// String pat = args[0];
// String txt = args[1];
// char[] pattern = pat.toCharArray();
// char[] text = txt.toCharArray();
//
// BoyerMoore boyermoore1 = new BoyerMoore(pat);
// BoyerMoore boyermoore2 = new BoyerMoore(pattern, 256);
// int offset1 = boyermoore1.search(txt);
// int offset2 = boyermoore2.search(text);
//
// // print results
// StdOut.println("text:    " + txt);
//
// StdOut.print("pattern: ");
// for (int i = 0; i < offset1; i++)
// StdOut.print(" ");
// StdOut.println(pat);
//
// StdOut.print("pattern: ");
// for (int i = 0; i < offset2; i++)
// StdOut.print(" ");
// StdOut.println(pat);
// }