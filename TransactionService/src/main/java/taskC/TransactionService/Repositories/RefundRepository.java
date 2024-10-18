package taskC.TransactionService.Repositories;

import taskC.TransactionService.Models.Refund;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RefundRepository extends JpaRepository<Refund, Long> {

}
