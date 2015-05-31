package br.com.edu.metodologia.main.manager;

import java.io.File;

public class Manager {
	
	private static final int QUANTIDADE_OBRIGATORIA = 3;

	public static void main(String[] args) {
		if (args.length != QUANTIDADE_OBRIGATORIA) {
			System.err.println("É necessário que sejam passados os três parâmetros específicos.");
		} else {
			run(args);
		}
	}
	
	private static void run(String[] args) {
		String algoritmo = args[0];
		File conteudo = new File(args[1]);
		File busca = new File(args[2]);
		
		System.out.println(algoritmo);
		System.out.println(conteudo.toString());
		System.out.println(busca.toString());
		
		validarParametros(algoritmo, conteudo, busca);
	}

	private static void validarParametros(String algoritmo, File conteudo,
			File busca) {
		// TODO Auto-generated method stub
		
	}
}