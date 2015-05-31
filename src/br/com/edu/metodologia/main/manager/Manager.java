package br.com.edu.metodologia.main.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

import br.com.edu.metodologia.main.search.KMP;
import br.com.edu.metodologia.main.search.Searchable;

/**
 * Classe para encapsular a execução do experimento.
 *
 */
public class Manager {

	private static final int QUANTIDADE_OBRIGATORIA = 3;
	private static final int ERROR = 1;

	public static void main(String[] args) {
		if (args.length != QUANTIDADE_OBRIGATORIA) {
			System.err
					.println("É necessário que sejam passados os três parâmetros específicos.");
		} else {
			run(args);
		}
	}

	/**
	 * Método para executar o experimento.
	 * 
	 * @param args
	 *            conjunto de parâmetros para executar o experimento.
	 */
	private static void run(String[] args) {
		String algoritmo = args[0];
		File arquivoConteudo = new File(args[1]);
		File arquivoBusca = new File(args[2]);

		validarParametros(algoritmo, arquivoConteudo, arquivoBusca);
		
		String conteudo = getStringFromFile(arquivoConteudo);
		String busca = getStringFromFile(arquivoBusca);
		
		doExperiment(algoritmo, conteudo, busca);
	}

	private static void doExperiment(String algoritmo, String conteudo,
			String busca) {
		
		if (ESearch.KMP.getName().equals(algoritmo)) {
			Searchable search = new KMP(busca);
			System.out.println("OPA");
			System.out.println(search.search(conteudo));
		}
	}

	private static String getStringFromFile(File arquivo) {
		byte[] encoded;
		try {
			encoded = Files.readAllBytes(arquivo.toPath());
			return new String(encoded);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String();
	}

	/**
	 * Método para validar se os parâmetros estão corretos. Validar se o
	 * algoritmo está implementado. Verificar se o arquivo que contém o conteúdo
	 * onde a busca será existe. Verificar se o arquivo que contém o que deseja
	 * buscar existe mesmo.
	 * 
	 * @param algoritmo
	 *            nome do algoritmo que realiza a busca
	 * @param conteudo
	 *            path do arquivo com conteúdo
	 * @param busca
	 *            path do arquivo que contém o que quer buscar.
	 */
	private static void validarParametros(String algoritmo, File conteudo,
			File busca) {
		boolean arquivosValidos = conteudo.exists() && busca.exists();
		
		if (!arquivosValidos) {
			System.err.println("Verique o path dos seus arquivos");
			System.exit(ERROR);
		}
	}
}