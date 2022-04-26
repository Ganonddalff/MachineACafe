package fr.isika.cda15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MachineACafe {
	private List<Boisson> lesBoissons= new ArrayList<Boisson>();
	private double montantDonne;
	
	//Cr�ation d'une nouvelle machine � caf�
	public MachineACafe() {
		this.setMontantDonne(0);
		this.lesBoissons.add(new Boisson("Caf� court", 1.50));
		this.lesBoissons.add(new Boisson("Caf� allong�", 1.70));
		this.lesBoissons.add(new Boisson("Chocolat chaud", 1.80));
		this.lesBoissons.add(new Boisson("Cappuccino", 2.10));
	}
	
	//La boisson a �t� choisie, cette m�thode permet de la sucrer ou non
	public Boisson sucrer(Boisson boisson) {
		System.out.println("Souhaitez vous sucrer votre boisson ? 1 : oui, 2 : non");
		try (Scanner sc = new Scanner(System.in)){
			String choix = sc.nextLine();
			if(Integer.parseInt(choix) == 1) boisson.sucrer();
			System.out.println("Votre " + boisson.toString() + " est servi !");
			return boisson;
		}
	}
	
	//Demande � l'utilisateur s'il souhaite ajouter de l'argent ou choisir sa boisson
	public void choixDepart() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("1 : Choisir une boisson\n2 : Ins�rez de la monnaie");
			int choix = sc.nextInt();
			if(choix == 1) this.choisirBoisson();
			else this.implementeMontant();
		}
	}
	
	//Demande � l'utilisateur combien d'argent il souhaite ajouter
	public void implementeMontant() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Ins�rez une pi�ce (Entrez le montant au clavier) :");
			int montant = sc.nextInt();
			this.setMontantDonne(this.getMontantDonne() + (double)montant);
			this.choixDepart();
		}
	}
	
	//Demande � l'utilisateur quelle boisson il souhaite acheter et v�rifie s'il dispose du montant n�cessaire
	public Boisson choisirBoisson() {
		int i = 1;
		for(Boisson boisson : this.lesBoissons) {
			System.out.println(boisson.getNom() + " " + boisson.getPrix() + " �" + " : " + i);
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
