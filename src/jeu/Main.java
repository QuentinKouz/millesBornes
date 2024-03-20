package jeu;

import java.util.Iterator;

import cartes.Carte;

public interface Main {
	void prendre(Carte carte);
	void jouer(Carte carte);
	Iterator<Carte> iterator();
}
