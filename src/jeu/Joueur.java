package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import cartes.*;
import cartes.Probleme.Type;

public class Joueur {
	private String nom;
	private List<Limite> limitesVitesse;
	private List<Bataille> pileBataille;
	private Collection<Borne> collectionBornes;
	private Set<Botte> ensembleBottes;
	private Main main;
	
	public Joueur(String nom) {
	        this.nom = nom;
	        this.limitesVitesse = new ArrayList<>();
	        this.pileBataille = new ArrayList<>();
	        this.collectionBornes = new ArrayList<>();
	        this.ensembleBottes = new HashSet<>();
	        this.main = new MainAsListe();
	    }
	 
	public String getNom() {
		return nom;
	}
	 
	public List<Limite> getLimitesVitesse() {
		return limitesVitesse;
	}
	 
	public List<Bataille> getPileBataille() {
		return pileBataille;
	}
	 
	public Collection<Borne> getCollectionBornes() {
		return collectionBornes;
	}
	 
	public Set<Botte> getEnsembleBottes() {
		return ensembleBottes;
	}
	
	public Main getMain() {
		return main;
	}
	 
	@Override
	public String toString() {
		return nom;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == getClass()) {
			Joueur joueur = (Joueur) obj;
			return (toString().equals(joueur.toString()));
		}
		return false;
	}
	
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public Carte prendreCarte(List<Carte> sabot) {
		if (!sabot.isEmpty()) {
			Carte carteDonner = sabot.get(0);
			this.donner(carteDonner);
			return carteDonner;
		}
		return null;
	}
	
    public int getKM() {
    	int totalKM = 0;
    	for (Borne borne : collectionBornes) {
            totalKM += borne.getKm();
        }
        return totalKM;
    }
    
    public boolean estPrioritaire() {
    	for (Botte botte : ensembleBottes) {
    		if (botte.getType() == Type.FEU) {
    			return true;
    		}
    	}
		return false;
	}
	 
    public int getLimite() {
    	boolean prioritaire = estPrioritaire();
        if (limitesVitesse.isEmpty() || limitesVitesse.get(limitesVitesse.size() - 1) instanceof FinLimite || prioritaire) {
            return 200; // Limite de vitesse de 200 si la pile de limites est vide, si le sommet est une fin de limite, ou si le joueur a la botte de type FEU
        } else {
            return 50; // Sinon, la limite de vitesse est de 50
        }
    }
    

    
    public boolean estBloque() {
    	boolean prioritaire = estPrioritaire();
		if (pileBataille.isEmpty() && prioritaire) {
			return false;
		}
		if (!pileBataille.isEmpty()) {
			Carte sommetCarte = pileBataille.get(pileBataille.size()-1);
			Carte feuVert = new Parade(1,Type.FEU);
			Carte feuRouge = new Attaque(1,Type.FEU);
			if (sommetCarte instanceof Parade && sommetCarte.equals(feuVert)) {
				return false;
			}
			if (sommetCarte instanceof Parade && prioritaire) {
				return false;
			}
			if (sommetCarte instanceof Attaque && sommetCarte.equals(feuRouge) && prioritaire) {
				return false;
			}
			if (sommetCarte instanceof Attaque && prioritaire) {
				Attaque carte = (Attaque) sommetCarte;
				for (Botte botte : ensembleBottes) {
					if (botte.getType() == carte.getType()) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
