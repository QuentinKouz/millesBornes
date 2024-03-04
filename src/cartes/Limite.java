package cartes;

public abstract class Limite extends Carte {

	protected Limite(int nombre) {
		super(nombre);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Limite) {
			Limite limite = (Limite) obj;
			return (limite.getClass().equals(getClass()));
		}
		return false;
	}

}
