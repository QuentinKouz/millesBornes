package cartes;


public abstract class Probleme extends Carte{
	public enum Type{FEU, ESSENCE, CREVAISON, ACCIDENT};
	private Type type;
	
	protected Probleme(int n, Type t) {
		super(n);
		type = t;
	}
	
	public Type getType() {
		return type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == getClass()) {
			Probleme probleme = (Probleme) obj;
			return (type.equals(probleme.getType()));
		}
		return false;
	}
	
	

}
