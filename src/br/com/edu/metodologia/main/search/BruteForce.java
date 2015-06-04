package br.com.edu.metodologia.main.search;

public class BruteForce extends Searchable {

	public BruteForce(String pattern) {
		this.pattern = pattern;
	}
	
	@Override
	public int[] search(String text) {
		int passos = 0;
		int M = pattern.length();
        int N = text.length();
        int i, j;
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (text.charAt(i) == pattern.charAt(j)) {
            	j++; passos++;
            }
            else { i -= j; j = 0; passos++; }
        }
        if (j == M) return new int[]{i - M, ++passos};    // found
        else        return new int[]{N, ++passos};        // not found
	}
}