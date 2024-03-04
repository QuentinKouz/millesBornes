package cartes;

public abstract class Carte {
	private int nombre;
	
	protected Carte(int n) {
		nombre = n;
	}
	
	public int getNombre() {
		return nombre;
	}
}
