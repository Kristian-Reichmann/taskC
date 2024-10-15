package taskC.ListingService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskC.ListingService.dto.BookingDTO;
import taskC.ListingService.Exceptions.ResourceNotFoundException;
import taskC.ListingService.Models.Booking;
import taskC.ListingService.Repositories.BookingRepository;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking createBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setEventId(bookingDTO.getEventId());
        booking.setUserId(bookingDTO.getUserId());
        booking.setBookingDate(bookingDTO.getBookingDate());
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, BookingDTO bookingDTO) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
        booking.setEventId(bookingDTO.getEventId());
        booking.setUserId(bookingDTO.getUserId());
        booking.setBookingDate(bookingDTO.getBookingDate());
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new ResourceNotFoundException("Booking not found with id: " + id);
        }
        bookingRepository.deleteById(id);
    }
}
