package reservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReservationService {
	
	private ArrayList<Reservation> reservations = new ArrayList<>();
	private HashMap<String, List<Reservation>> indexParDestination = new HashMap<>();
	

	
	
	public void ajouterReservation(Reservation r) throws SiegeDejaOccupeException {
		for (Reservation existing : reservations) {
			if (existing.getNumeroSiege() == r.getNumeroSiege()
				&& existing.getDestination().equals(r.getDestination())) {
				throw new SiegeDejaOccupeException("Siege" + r.getNumeroSiege() + " déjà occupé!");
			}
		}
				
		reservations.add(r);
		// partie HashMap..
		if(indexParDestination.containsKey(r.getDestination())) {
			// destination existe -> on ajoute à la liste
			indexParDestination.get(r.getDestination()).add(r);
		} else {
			// destination nouvelle -> on crée une liste
			List<Reservation> liste = new ArrayList<>();
			liste.add(r);
			indexParDestination.put(r.getDestination(), liste);
			
		}
		/**
		 * HashMap = classeur, 
		 * chaque onglet = une destination ("Bruxelles", "Paris")
		 * chaque onglet contient une liste de réservations
		 */
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}
	
	public void annulerReservation(int id) {
		for (Reservation r : reservations) {
			if (r.getId() == id) {
				reservations.remove(r);
				break; // on arrête après avoir trouvé
			}
		}
	}
	
	public List<Reservation> chercherParPassager(String nom) {
		List<Reservation> resultat = new ArrayList<>();
		for (Reservation r : reservations) {
			if (r.getPassager().getNom().equals(nom)) {
				resultat.add(r); 
		}
	}
		return resultat;
}
}