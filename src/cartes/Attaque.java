package cartes;

public class Attaque extends Bataille {

	public Attaque(int n, Type t) {
		super(n, t);
	}
	
	public String toString() {
		switch (this.getType()) {
		case FEU: {
			return "FeuRouge";
		}
		case ESSENCE:{
			return "PanneEssence";
		}
		case CREVAISON:{
			return "Crevaison";
		}
		case ACCIDENT:{
			return "Accident";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.getType());
		}
	}
	
}
