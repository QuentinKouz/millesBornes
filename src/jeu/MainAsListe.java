package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cartes.*;

public class MainAsListe implements Main {
	private List<Carte> cartesEnMain = new ArrayList<>();
	
	@Override
	public void prendre(Carte carte) {
		cartesEnMain.add(carte);
		
	}

	@Override
	public void jouer(Carte carte) {
		assert cartesEnMain.contains(carte);
		cartesEnMain.remove(carte);
	}

	@Override
	public Iterator<Carte> iterator() {
		return cartesEnMain.iterator();
	}

}
