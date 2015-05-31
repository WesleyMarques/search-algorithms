package br.com.edu.metodologia.main.manager;

public enum ESearch {
	
	KMP("Kmp");

	private String name;
	
	private ESearch(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}