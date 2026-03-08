package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import reservation.Passager;
import reservation.Reservation;
import reservation.ReservationService;
import reservation.SiegeDejaOccupeException;

public class ReservationServiceTest {
	
	@Test 
	public void testAjouterReservation() throws SiegeDejaOccupeException {
		
		// préparer les objets
		ReservationService service = new ReservationService();
		Passager p = new Passager(1, "Mana", "Nilton", "11/01/1998");
		Reservation r = new Reservation(1, p, "Bruxelles", 12, "2026-03-01");
		
		// exécuter l'action
		service.ajouterReservation(r);
		
		// verifier le résultat
		assertEquals(1, service.getReservations().size());

	}
	
	@Test 
	public void testAnnulerReservation() throws SiegeDejaOccupeException {
		ReservationService service = new ReservationService();
		Passager p = new Passager(1, "Mana", "Nilton", "11/01/1998");
		Reservation r = new Reservation(1, p, "Bruxelles", 12, "2026-03-01");
		
		service.ajouterReservation(r);
		service.annulerReservation(1);
		
		assertEquals(0, service.getReservations().size());
	}
	
	@Test
	public void testSiegeDejaOccupe() throws SiegeDejaOccupeException {
		ReservationService service = new ReservationService();
		Passager p = new Passager(1, "Mana", "Nilton", "11/01/1998");
		Reservation r1 = new Reservation(1, p, "Bruxelles", 12, "2026-03-01");
		Reservation r2 = new Reservation(2, p, "Bruxelles", 12, "2026-03-01");
		
		service.ajouterReservation(r1);
		
		assertThrows(SiegeDejaOccupeException.class, () -> {
			service.ajouterReservation(r2);
		});
	}

}
