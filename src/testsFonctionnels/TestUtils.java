package testsFonctionnels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.Utils;

public class TestUtils {
	public static void main(String[] args) {
      JeuDeCartes jeuDeCartes = new JeuDeCartes();
      List<Carte> listeCartes = jeuDeCartes.getListeCartes();

      // Vérifier que le nombre d'occurrences reste inchangé après mélange
      boolean melangeOk = testerMelange(listeCartes);
      System.out.println("Le melange est correct : " + melangeOk);
      testerOccurrences(listeCartes);
      

//      // Vérifier le rassemblement sur différentes listes
//      testerRassemblement(new ArrayList<>()); // []
//      testerRassemblement(Arrays.asList(1, 1, 2, 1, 3)); // [1;1;2;1;3]
//      testerRassemblement(Arrays.asList(1, 4, 3, 2)); // [1;4;3;2]
//      testerRassemblement(Arrays.asList(1, 1, 2, 3, 1)); // [1;1;2;3;1]
//      List<Integer> liste = Arrays.asList(1,2,1,3,4);
//      boolean testFalse = Utils.verifierRassemblement(liste);
//      System.out.println("Pour la liste  : " + liste );
//      System.out.println("Le rassemblement est : " + testFalse);
		JeuDeCartes jeu2 = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = jeu2.getListeCartes();
		List<Carte> listeCartes1 = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes1);
		listeCartes1 = Utils.melanger(listeCartes1);
		System.out.println(listeCartes1);
		System.out.println("liste mélangée sans erreur ? " + Utils.verifierMelange(listeCarteNonMelangee, listeCartes1));
		listeCartes1 = Utils.rassembler(listeCartes1);
		System.out.println(listeCartes1);
		System.out.println("liste rassemblée sans erreur ? " + Utils.verifierRassemblement(listeCartes1));
		

  }

  public static boolean testerMelange(List<Carte> listeCartes) {
      List<Carte> copie = new ArrayList<>(listeCartes);
      List<Carte> melangee = Utils.melanger(copie);

      // Vérifier que le nombre d'occurrences reste inchangé
      return Utils.verifierMelange(listeCartes, melangee);
  }

  public static void testerRassemblement(List<Integer> liste) {
      List<Integer> rassemblee = Utils.rassembler(new ArrayList<>(liste));
      boolean rassemblementOk = Utils.verifierRassemblement(rassemblee);

      System.out.println("Liste initiale : " + liste);
      System.out.println("Liste rassemblée : " + rassemblee);
      System.out.println("Le rassemblement est correct : " + rassemblementOk);
  }
  
  public static void testerOccurrences(List<Carte> listeCartes) {
      for (Carte carte : listeCartes) {
          int occurrencesInitiales = Collections.frequency(listeCartes, carte);
          int occurrencesMelangees = Collections.frequency(listeCartes, carte);
          if (occurrencesInitiales != occurrencesMelangees) {
              System.out.println("Erreur pour la carte : " + carte);
              System.out.println("Occurrences initiales : " + occurrencesInitiales);
              System.out.println("Occurrences mélangées : " + occurrencesMelangees);
          }
      }
      System.out.println("Vérification des occurrences terminée.");
  }
}
