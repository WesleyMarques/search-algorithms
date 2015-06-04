package br.com.edu.metodologia.main.search;

import java.math.BigInteger;
import java.util.Random;

public class RabinKarp extends Searchable {

	private String pat; // the pattern // needed only for Las Vegas
	private long patHash; // pattern hash value
	private int M; // pattern length
	private long Q; // a large prime, small enough to avoid long overflow
	private int R; // radix
	private long RM; // R^(M-1) % Q

	public RabinKarp(int R, char[] pattern) {
		throw new UnsupportedOperationException("Operation not supported yet");
	}

	public RabinKarp(String pat) {
		this.pat = pat; // save pattern (needed only for Las Vegas)
		R = 256;
		M = pat.length();
		Q = longRandomPrime();

		// precompute R^(M-1) % Q for use in removing leading digit
		RM = 1;
		for (int i = 1; i <= M - 1; i++)
			RM = (R * RM) % Q;
		patHash = hash(pat, M);
	}

	// Compute hash for key[0..M-1].
	private long hash(String key, int M) {
		long h = 0;
		for (int j = 0; j < M; j++)
			h = (R * h + key.charAt(j)) % Q;
		return h;
	}

	// Las Vegas version: does pat[] match txt[i..i-M+1] ?
	private boolean check(String txt, int i) {
		for (int j = 0; j < M; j++)
			if (pat.charAt(j) != txt.charAt(i + j))
				return false;
		return true;
	}

	// Monte Carlo version: always return true
	private boolean check(int i) {
		return true;
	}

	// a random 31-bit prime
	private static long longRandomPrime() {
		BigInteger prime = BigInteger.probablePrime(31, new Random());
		return prime.longValue();
	}

	@Override
	public int[] search(String text) {
		int passos = 0;
		int N = text.length();
		if (N < M)
			return new int[]{N, ++passos};
		long txtHash = hash(text, M);

		// check for match at offset 0
		if ((patHash == txtHash) && check(text, 0)) {
			passos++;
			return new int[]{0, passos};
		}

		// check for hash match; if hash match, check for exact match
		for (int i = M; i < N; i++) {
			passos++;
			// Remove leading digit, add trailing digit, check for match.
			txtHash = (txtHash + Q - RM * text.charAt(i - M) % Q) % Q;
			txtHash = (txtHash * R + text.charAt(i)) % Q;

			// match
			int offset = i - M + 1;
			if ((patHash == txtHash) && check(text, offset))
				return new int[]{offset, ++passos};
		}

		// no match
		return new int[]{N, passos};
	}
}
