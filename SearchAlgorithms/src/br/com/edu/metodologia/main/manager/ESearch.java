package br.com.edu.metodologia.main.manager;

public enum ESearch {
	
	KMP("Kmp"),
	BOYER_MOORE("BoyerMoore"),
	RABIN_KARP("RabinCarp"),
	BRUTE_FORCE("BruteForce");
	
	private String name;
	
	private ESearch(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}