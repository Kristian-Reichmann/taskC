package taskC.TransactionService.Repositories;

import taskC.TransactionService.Models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
