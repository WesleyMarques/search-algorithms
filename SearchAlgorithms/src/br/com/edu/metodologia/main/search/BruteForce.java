package br.com.edu.metodologia.main.search;

public class BruteForce extends Searchable {

	public BruteForce(String pattern) {
		this.pattern = pattern;
	}
	
	@Override
	public int search(String text) {
		int M = pattern.length();
        int N = text.length();
        int i, j;
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (text.charAt(i) == pattern.charAt(j)) j++;
            else { i -= j; j = 0;  }
        }
        if (j == M) return i - M;    // found
        else        return N;        // not found
	}

	@Override
	public int search(char[] text) {
		// TODO Auto-generated method stub
		return 0;
	}
}