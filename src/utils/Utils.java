package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Utils {
	public static <T> T extraire(List<T> liste) {
        if (liste.isEmpty()) {
            throw new IllegalArgumentException("La liste est vide");
        }
        int randomIndex = new Random().nextInt(liste.size());
        return liste.remove(randomIndex);
    }

    public static <T> T extraire(ListIterator<T> iterator) {
        if (!iterator.hasNext()) {
            throw new IllegalArgumentException("La liste est vide");
        }
        int randomIndex = new Random().nextInt(iterator.nextIndex());
        while (iterator.nextIndex() != randomIndex) {
            iterator.next();
        }
        return iterator.next();
    }
    
    public static <T> List<T> melanger(List<T> liste) {
        List<T> melangee = new ArrayList<>(liste);
        Collections.shuffle(melangee);
        liste.clear();
        return melangee;
    }
    
    public static <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
        for (T element : liste1) {
            if (Collections.frequency(liste1, element) != Collections.frequency(liste2, element)) {
                return false;
            }
        }
        return true;
    }

    public static <T> List<T> rassembler(List<T> liste) {
        List<T> listeRassemblee = new ArrayList<>();
        for (T current : liste) {
        	if(!listeRassemblee.contains(current)) {
                int occ = Collections.frequency(liste, current);

                // Ajouter les copies de l'élément actuel
                for (int k = 0; k < occ; k++) {
                    listeRassemblee.add(current);
                }
        	}
        }
        return listeRassemblee;
    }
    
    public static <T> boolean verifierRassemblement(List<T> liste) {
        ListIterator<T> it1 = liste.listIterator();
        int size = liste.size();
        ListIterator<T> it2 = liste.listIterator(size);
        if (!it1.hasNext()) {
            return true;
        }
        while (it1.hasNext()) {
        	T element1 = it1.next();
            while(it2.hasPrevious() && it2 != it1) {
            	T element2 = it2.previous();
            	if (element2.equals(element1) && it2.hasPrevious() && !it2.previous().equals(element1)) {
            		return false;
            	}
           }
        }
        return true;
    }
}
