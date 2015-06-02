package br.com.edu.metodologia.main.search;

public class BoyerMoore extends Searchable {

	private final int R; // the radix
	private int[] right; // the bad-character skip array

	private char[] pattern; // store the pattern as a character array
	private String pat; // or as a string

	// pattern provided as a string
	public BoyerMoore(String pat) {
		this.R = 256;
		this.pat = pat;

		// position of rightmost occurrence of c in the pattern
		right = new int[R];
		for (int c = 0; c < R; c++)
			right[c] = -1;
		for (int j = 0; j < pat.length(); j++)
			right[pat.charAt(j)] = j;
	}

	// pattern provided as a character array
	public BoyerMoore(char[] pattern, int R) {
		this.R = R;
		this.pattern = new char[pattern.length];
		for (int j = 0; j < pattern.length; j++)
			this.pattern[j] = pattern[j];

		// position of rightmost occurrence of c in the pattern
		right = new int[R];
		for (int c = 0; c < R; c++)
			right[c] = -1;
		for (int j = 0; j < pattern.length; j++)
			right[pattern[j]] = j;
	}

	@Override
	public int search(String text) {
		int M = pat.length();
		int N = text.length();
		int skip;
		for (int i = 0; i <= N - M; i += skip) {
			skip = 0;
			for (int j = M - 1; j >= 0; j--) {
				if (pat.charAt(j) != text.charAt(i + j)) {
					skip = Math.max(1, j - right[text.charAt(i + j)]);
					break;
				}
			}
			if (skip == 0)
				return i; // found
		}
		return N; // not found
	}
	
	// return offset of first match; N if no match
    public int search(char[] text) {
        int M = pattern.length;
        int N = text.length;
        int skip;
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M-1; j >= 0; j--) {
                if (pattern[j] != text[i+j]) {
                    skip = Math.max(1, j - right[text[i+j]]);
                    break;
                }
            }
            if (skip == 0) return i;    // found
        }
        return N;                       // not found
    }

}
