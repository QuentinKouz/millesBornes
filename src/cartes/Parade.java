package cartes;

public class Parade extends Bataille {

	public Parade(int n, Type t) {
		super(n, t);
	}
	
	public String toString() {
		switch (this.getType()) {
		case FEU: {
			return "FeuVert";
		}
		case ESSENCE:{
			return "Essence";
		}
		case CREVAISON:{
			return "RoueDeSecours";
		}
		case ACCIDENT:{
			return "Réparations";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.getType());
		}
	}
}
