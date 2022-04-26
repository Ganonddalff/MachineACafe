package fr.isika.cda15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MachineACafe {
	private List<Boisson> lesBoissons= new ArrayList<Boisson>();
	private double montantDonne;
	
	//Création d'une nouvelle machine à café
	public MachineACafe() {
		this.setMontantDonne(0);
		this.lesBoissons.add(new Boisson("Café court", 1.50));
		this.lesBoissons.add(new Boisson("Café allongé", 1.70));
		this.lesBoissons.add(new Boisson("Chocolat chaud", 1.80));
		this.lesBoissons.add(new Boisson("Cappuccino", 2.10));
	}
	
	//La boisson a été choisie, cette méthode permet de la sucrer ou non
	public Boisson sucrer(Boisson boisson) {
		System.out.println("Souhaitez vous sucrer votre boisson ? 1 : oui, 2 : non");
		try (Scanner sc = new Scanner(System.in)){
			String choix = sc.nextLine();
			if(Integer.parseInt(choix) == 1) boisson.sucrer();
			System.out.println("Votre " + boisson.toString() + " est servi !");
			return boisson;
		}
	}
	
	//Demande à l'utilisateur s'il souhaite ajouter de l'argent ou choisir sa boisson
	public void choixDepart() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("1 : Choisir une boisson\n2 : Insérez de la monnaie");
			int choix = sc.nextInt();
			if(choix == 1) this.choisirBoisson();
			else this.implementeMontant();
		}
	}
	
	//Demande à l'utilisateur combien d'argent il souhaite ajouter
	public void implementeMontant() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Insérez une pièce (Entrez le montant au clavier) :");
			int montant = sc.nextInt();
			this.setMontantDonne(this.getMontantDonne() + (double)montant);
			this.choixDepart();
		}
	}
	
	//Demande à l'utilisateur quelle boisson il souhaite acheter et vérifie s'il dispose du montant nécessaire
	public Boisson choisirBoisson() {
		int i = 1;
		for(Boisson boisson : this.lesBoissons) {
			System.out.println(boisson.getNom() + " " + boisson.getPrix() + " €" + " : " + i);
			i++;
		}
		try (Scanner sc = new Scanner(System.in)) {
			int choix = sc.nextInt();
			Boisson boissonChoisie = this.lesBoissons.get(choix-1);
			if(this.montantDonne >= boissonChoisie.getPrix())
				return this.sucrer(boissonChoisie);
			else {
				System.out.println("Il manque " + (boissonChoisie.getPrix()-this.montantDonne));
				this.choixDepart();
				return null;
			}	
		}
	}
	
	public double getMontantDonne() {
		return montantDonne;
	}
	
	public void setMontantDonne(double d) {
		this.montantDonne = d;
	}
}
