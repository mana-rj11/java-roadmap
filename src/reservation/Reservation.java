package reservation;

public class Reservation {
	
	private int id;
	private Passager passager;
	private String destination;
	private int numeroSiege;
	private String date;
	
	public Reservation(int id, Passager passager, String destination, int numeroSiege, String date) {
		this.id = id;
		this.passager = passager;
		this.destination = destination;
		this.numeroSiege = numeroSiege;
		this.date = date;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", passager=" + passager + ", destination=" + destination + ", numeroSiege="
				+ numeroSiege + ", date=" + date + "]";
	}

	public int getNumeroSiege() {
		return numeroSiege;
	}

	public void setNumeroSiege(int numeroSiege) {
		this.numeroSiege = numeroSiege;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
