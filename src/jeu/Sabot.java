package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;



public class Sabot implements Iterable<Carte>{
	private int nbCartes = 0;
	private Carte [] cartesSabot;
	private int nbOperations = 0;
	
	
	public Sabot(int capacite) {
		this.cartesSabot = new Carte[capacite];
	}
	
	public boolean estVide() {
		return nbCartes == 0;
	}
	
	private void ajouterCarte(Carte carte) {
		cartesSabot[nbCartes] = carte;
		nbCartes = nbCartes + 1;
		nbOperations++;
	}
	
	public void ajouterFamilleCarte(Carte carte) {
		for(int i = 0; i < carte.getNombre(); i++) {
			ajouterCarte(carte);
		}
	}
	
	public void ajouterFamilleCarte(Carte... cartes) {
		for(int i = 0; i < cartes.length; i++) {
			ajouterFamilleCarte(cartes[i]);
		}
	}
	
	public Carte piocher() {
		Iterator<Carte> iter = iterator();
		if(iter.hasNext()) {
			Carte carte = iter.next();
			iter.remove();
			return carte;
		}
		throw new NoSuchElementException("Le sabot est vide.");
		
	}
	
	
	@Override
	public Iterator<Carte> iterator(){
		return new SabotIterator();
	}
	
	private class SabotIterator implements Iterator<Carte>{
		private int indiceIterator = 0;
		private int nbOperationsRef = nbOperations;
		private boolean canRemove = false;
		
		@Override
		public boolean hasNext() {
			return indiceIterator < nbCartes;
		}
		
		@Override
		public void remove() {
            if (nbOperations != nbOperationsRef) {
                throw new ConcurrentModificationException();
            }

            if (!canRemove) {
            	throw new IllegalStateException("Impossible de supprimer l'élément actuel.");
            }
            
            if (indiceIterator == 0 || indiceIterator > nbCartes) {
            	System.out.println(indiceIterator + " " + nbCartes);
                throw new IllegalStateException("Impossible de supprimer l'élément actuel.");
            }
            
            for (int i = indiceIterator - 1; i < nbCartes - 1; i++) {
                cartesSabot[i] = cartesSabot[i + 1];
            }
            nbOperationsRef++;
            nbOperations++;
            nbCartes--;
            indiceIterator--;
            canRemove = false;
        }
		
		@Override
		public Carte next() {
			verificationConcurrence();
			if(hasNext()) {
				Carte element = (Carte) cartesSabot[indiceIterator];
				indiceIterator++;
				canRemove = true;
				return element;
				
			}else {
				throw new NoSuchElementException("Pas d'élément suivant !");
			}
		}
		
		private void verificationConcurrence(){
			 if (nbOperations != nbOperationsRef) {
				 throw new ConcurrentModificationException();
			 }
			 
		 }
		
	}
	
}
