package testsFonctionnels;

import cartes.Carte;
import cartes.JeuDeCartes;

public class TestJeuDeCartes {
	public static void main(String[] args) {
	    JeuDeCartes jeu = new JeuDeCartes();
	    for (Carte carte : jeu.getListeCartes()) {
	        System.out.println(carte);
	    }
	    jeu.checkCount();
	}

}
