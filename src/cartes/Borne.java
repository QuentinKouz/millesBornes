package cartes;

public class Borne extends Carte {
	private int km;
	
	public Borne(int n, int km) {
		super(n);
		this.km = km;
	}
	
	public int getKm() {
		return km;
	}
	
	public String toString() {
	    return "Borne - km: " + this.getKm();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Borne) {
			Borne borne = (Borne) obj;
			return km == borne.getKm();
		}
		return false;
	}

}
