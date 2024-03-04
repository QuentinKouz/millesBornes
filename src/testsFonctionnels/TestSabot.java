package testsFonctionnels;

import java.util.Iterator;

import cartes.Attaque;
import cartes.Botte;
import cartes.Carte;
import cartes.Parade;
import cartes.Probleme;
import jeu.Sabot;

public class TestSabot {
	
	public static void main(String[] args) {
        Sabot sabot = new Sabot(100);
        
        Carte accident = new Attaque(3, Probleme.Type.ACCIDENT);
        Carte reparation = new Parade(3, Probleme.Type.ACCIDENT);
        Carte asDuVolant = new Botte(1, Probleme.Type.ACCIDENT);
        
        //sabot.ajouterFamilleCarte(accident);
        //sabot.ajouterFamilleCarte(reparation);
        sabot.ajouterFamilleCarte(asDuVolant);
        sabot.ajouterFamilleCarte(reparation,accident);

        Iterator<Carte> iter = sabot.iterator();
        while (iter.hasNext()) {
            //Carte cartePiochee = iter.next();
            Carte cartePiochee = sabot.piocher();
            System.out.println("Je pioche " + cartePiochee.toString());
            //iter.remove();
            
            //EXCEPTION levé : ConcurrentModificationException
            //cartePiochee = sabot.piocher();
        	//sabot.ajouterFamilleCarte(asDuVolant);
            

            
            
        }
        
    }
	
}
