package cartes;

public class Botte extends Probleme {

	public Botte(int n, Type t) {
		super(n, t);
	}
	
	public String toString() {
		switch (this.getType()) {
		case FEU: {
			return "VéhiculePrioritaire";
		}
		case ESSENCE:{
			return "CiterneEssence";
		}
		case CREVAISON:{
			return "Increvable";
		}
		case ACCIDENT:{
			return "AsDuVolant";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.getType());
		}
	}

}
