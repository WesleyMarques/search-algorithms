package br.com.edu.metodologia.main.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;

import br.com.edu.metodologia.main.search.BruteForce;
import br.com.edu.metodologia.main.search.KMP;
import br.com.edu.metodologia.main.search.RabinKarp;
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

		Long inicio = System.currentTimeMillis();

		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					Process processo = Runtime.getRuntime().exec(
							"pidstat -C java");
					processo.waitFor();

					StringBuilder result = new StringBuilder();

					BufferedReader buff = new BufferedReader(
							new InputStreamReader(processo.getInputStream()));

					String line = "";
					while ((line = buff.readLine()) != null) {
						result.append(line);
					}
					System.out.println(result.toString());
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t1.run();
		int contem = doExperiment(algoritmo, conteudo, busca);
		Long fim = System.currentTimeMillis();
		Long tempo = fim - inicio;

		result(arquivoConteudo.getPath(), arquivoBusca.getPath(), contem, tempo);
	}

	private static void result(String conteudo, String busca, int contem,
			Long tempo) {
		String result = String
				.format("texto_buscado:%s texto_busca:%s resultado: %s tempo_execucao: %f consumo_memo:%d num_operacaoes: %d",
						conteudo, busca, contem, tempo * 0.001, 0, 0);
		System.out.println(result);
	}

	private static int doExperiment(String algoritmo, String conteudo,
			String busca) {
		if (ESearch.KMP.getName().equals(algoritmo)) {
			Searchable search = new KMP(busca);
			return search.search(conteudo);
		} else if (ESearch.BRUTE_FORCE.getName().equals(algoritmo)) {
			Searchable search = new BruteForce(busca);
			return search.search(conteudo);
		} else if (ESearch.RABIN_KARP.getName().equals(algoritmo)) {
			Searchable search = new RabinKarp(busca);
			return search.search(conteudo);
		} else {
			System.err
					.println("O algoritmo expecificado não existe neste experimento.");
			return -1;
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