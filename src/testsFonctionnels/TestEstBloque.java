package testsFonctionnels;

import java.util.ArrayList;
import java.util.HashSet;

import cartes.*;
import cartes.Probleme.Type;
import jeu.Joueur;
import jeu.MainAsListe;

public class TestEstBloque {
	public static void main(String[] args) {
        // Création d'un joueur avec un nom et des listes vides
        Joueur joueur = new Joueur("Alice", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new HashSet<>(), new MainAsListe());
        
        Carte prio = new Botte(1, Type.FEU);
        Carte as = new Botte(1, Type.ACCIDENT);
        joueur.getPileBataille().add(new Attaque(1,Type.FEU)); // feu rouge
        System.out.println("Avec feu rouge : "  + joueur.estBloque());
        joueur.getEnsembleBottes().add(new Botte(1, Type.FEU)); // vehicule prioritaire
        System.out.println("Avec vehicule prioritaire : "  + joueur.estBloque());
        joueur.getPileBataille().add(new Attaque(1,Type.ACCIDENT)); // accident
        System.out.println("Avec accident : "  + joueur.estBloque());
        joueur.getEnsembleBottes().add(new Botte(1, Type.ACCIDENT)); // as du volant
        System.out.println("Avec as du volant : "  + joueur.estBloque());
        joueur.getPileBataille().add(new Attaque(1, Type.ESSENCE)); // panne d'essenc
        System.out.println("Avec panne d'essence : "  + joueur.estBloque());
        joueur.getPileBataille().add(new Parade(1, Type.ESSENCE)); // essence
        System.out.println("Avec essence : "  + joueur.estBloque());
        joueur.getEnsembleBottes().clear(); // sans les bottes

        
        System.out.println("Sans les bottes : "  + joueur.estBloque());
        joueur.getPileBataille().add(new Parade(1,Type.FEU));
        System.out.println("Avec le feu vert : " + joueur.estBloque());
        
       
    }
}
