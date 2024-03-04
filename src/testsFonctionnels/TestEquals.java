package testsFonctionnels;

import cartes.Attaque;
import cartes.Botte;
import cartes.Parade;
import cartes.Probleme;

public class TestEquals {
	public static void main(String[] args) {
		Attaque attaque1 = new Attaque(4,Probleme.Type.FEU);
		Parade parade1 = new Parade(4, Probleme.Type.FEU);
		Botte botte1 = new Botte(5, Probleme.Type.FEU);
		Attaque attaque2 = new Attaque(4,Probleme.Type.FEU);
		Parade parade2 = new Parade(4, Probleme.Type.CREVAISON);
		Botte botte2 = new Botte(5, Probleme.Type.ACCIDENT);
		
		// Deux classes différentes de même type
		if (attaque1.equals(botte1)){
			System.out.println("Problème lié à deux classe différente de même type, renvoie : true");
		} else {
			System.out.println("Deux classes différentes de même type -> OK");
		}
		// Deux mêmes classes mais de type différents
		if (parade1.equals(parade2)) {
			System.out.println("Problème lié à deux mêmes classes de type différent, renvoie : true");
		}else {
			System.out.println("Deux mêmes classes mais de type différents ne fonctionne pas -> OK");
		}
		// Deux même classes de même type
		if (attaque1.equals(attaque2)) {
			System.out.println("Deux mêmes classes de même type -> OK");
		} else {
			System.out.println("Problème lié à deux mêmes classes de même type, renvoie : false");
		}
		// Deux classes différentes de type différents
		if (attaque1.equals(botte2)){
			System.out.println("Prlbème lié à deux classes différentes de type différent, renvoie : true");
		}else {
			System.out.println("Deux classes différentes de type différents ne fonctionne pas -> OK");
		}
	
		
	}
}
