package testsFonctionnels;

import jeu.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import cartes.*;
import cartes.Probleme.Type;

public class TestJoueur {
	public static void main(String[] args) {
        // Création d'un joueur avec un nom et des listes vides
        Joueur joueur = new Joueur("Alice");

        // Création de quelques bornes avec des distances
        Borne borne1 = new Borne(1,50); // Distance de 50 km
        Borne borne2 = new Borne(1,30); // Distance de 30 km
        Borne borne3 = new Borne(1,70); // Distance de 70 km

        // Ajout des bornes à la collectionBornes du joueur
        joueur.getCollectionBornes().add(borne1);
        joueur.getCollectionBornes().add(borne2);
        joueur.getCollectionBornes().add(borne3);

        // Calcul du kilométrage atteint
        int kilometresParcourus = joueur.getKM();

        // Affichage du résultat
        System.out.println("Kilométrage atteint par le joueur : " + kilometresParcourus + " km");
        
        // Test de getLimite
        System.out.println("Limite de vitesse en cours : " + joueur.getLimite() + " km/h");

        // Supposons que le joueur a une botte de type FEU
        Botte botteFeu = new Botte(1, Type.FEU);
        Set<Botte> ensembleBottes = new HashSet<>();
        ensembleBottes.add(botteFeu);

        joueur = new Joueur("Bob");

        // Test de getLimite avec botte de type FEU
        System.out.println("Limite de vitesse en cours (avec botte FEU) : " + joueur.getLimite() + " km/h");

        // Supposons que la pile de limites est vide
        joueur = new Joueur("Charlie");

        // Test de getLimite avec pile de limites vide
        System.out.println("Limite de vitesse en cours (pile de limites vide) : " + joueur.getLimite() + " km/h");

        // Supposons que le sommet de la pile est une fin de limite
        FinLimite finLimite = new FinLimite(1);
        List<Limite> limitesVitesse = new ArrayList<>();
        limitesVitesse.add(finLimite);

        joueur = new Joueur("David");
        joueur.getLimitesVitesse().addAll(limitesVitesse);
        // Test de getLimite avec sommet de la pile comme fin de limite
        System.out.println("Limite de vitesse en cours (sommet de la pile comme fin de limite) : " + joueur.getLimite() + " km/h");
    
	     // Supposons que la pile de limites n'est pas vide, le sommet de la pile n'est pas une fin de limite,
	     // et le joueur n'a pas la botte de type FEU
	     List<Limite> limitesVitesse2 = new ArrayList<>();

	     limitesVitesse2.add(new DebutLimite(60)); // Ajout d'une limite de vitesse non vide à la pile
	
	     joueur = new Joueur("Eve");
	     joueur.getLimitesVitesse().addAll(limitesVitesse2);
	
	     // Test de getLimite avec les conditions pour un résultat de 50
	     System.out.println("Limite de vitesse en cours (résultat de 50 avec une carte DébutLimite (60)) : " + joueur.getLimite() + " km/h");
	    }
}
