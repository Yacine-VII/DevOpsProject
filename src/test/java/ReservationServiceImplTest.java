import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repository.ReservationRepository;
import tn.esprit.tpfoyer.service.ReservationServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReservationServiceImplTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationServiceImpl reservationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRetrieveAllReservations() {
        // Arrange
        List<Reservation> mockReservations = new ArrayList<>();
        when(reservationRepository.findAll()).thenReturn(mockReservations);

        // Act
        List<Reservation> result = reservationService.retrieveAllReservations();

        // Assert
        assertEquals(mockReservations, result);
        verify(reservationRepository, times(1)).findAll();
    }

    @Test
    void testRetrieveReservation() {
        // Arrange
        String reservationId = "123";
        Reservation mockReservation = new Reservation();
        when(reservationRepository.findById(reservationId)).thenReturn(Optional.of(mockReservation));

        // Act
        Reservation result = reservationService.retrieveReservation(reservationId);

        // Assert
        assertEquals(mockReservation, result);
        verify(reservationRepository, times(1)).findById(reservationId);
    }

    @Test
    void testAddReservation() {
        // Arrange
        Reservation reservation = new Reservation();
        when(reservationRepository.save(reservation)).thenReturn(reservation);

        // Act
        Reservation result = reservationService.addReservation(reservation);

        // Assert
        assertEquals(reservation, result);
        verify(reservationRepository, times(1)).save(reservation);
    }

    @Test
    void testModifyReservation() {
        // Arrange
        Reservation reservation = new Reservation();
        when(reservationRepository.save(reservation)).thenReturn(reservation);

        // Act
        Reservation result = reservationService.modifyReservation(reservation);

        // Assert
        assertEquals(reservation, result);
        verify(reservationRepository, times(1)).save(reservation);
    }

    @Test
    void testTrouverResSelonDateEtStatus() {
        // Arrange
        Date date = new Date();
        boolean status = true;
        List<Reservation> mockReservations = new ArrayList<>();
        when(reservationRepository.findAllByAnneeUniversitaireBeforeAndEstValide(date, status)).thenReturn(mockReservations);

        // Act
        List<Reservation> result = reservationService.trouverResSelonDateEtStatus(date, status);

        // Assert
        assertEquals(mockReservations, result);
        verify(reservationRepository, times(1)).findAllByAnneeUniversitaireBeforeAndEstValide(date, status);
    }

    @Test
    void testRemoveReservation() {
        // Arrange
        String reservationId = "123";

        // Act
        reservationService.removeReservation(reservationId);

        // Assert
        verify(reservationRepository, times(1)).deleteById(reservationId);
    }
}
