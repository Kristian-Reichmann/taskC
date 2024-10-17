package taskC.TransactionService.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Long paymentId;
    private Double amount;
    private String status;


    public void SetPaymentId(Long id) {
        this.id = id;
    }
    public void SetAmount(Double amount){
        this.amount = amount;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
