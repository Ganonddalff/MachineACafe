package fr.isika.cda15;

public class Boisson {
	private String nom;
	private double prix;
	public boolean sucre;
	
	public Boisson(String nom, double prix) {
		this.nom = nom;
		this.prix = prix;
	}
	
	public double getPrix() {
		return prix;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void sucrer() {
		this.sucre = true;
	}
	
	public String toString() {
		if(sucre) return nom + " sucré";
		else return nom + " non sucré";
		
	}
}
