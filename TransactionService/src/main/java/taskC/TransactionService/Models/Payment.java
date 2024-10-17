package taskC.TransactionService.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long bookingId;
    private Double amount;
    private String paymentMethod; // e.g., credit card, PayPal
    private boolean successful;
    private LocalDateTime timestamp;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setPaymentMethod(String method){
        this.paymentMethod = method;
    }

    public String getPaymentMethod(){
        return paymentMethod;
    }


    //Other getters and setters...
}
