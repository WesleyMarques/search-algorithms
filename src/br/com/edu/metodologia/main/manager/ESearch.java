package br.com.edu.metodologia.main.manager;

public enum ESearch {
	
	KPM("Kpm");

	private String name;
	
	private ESearch(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}