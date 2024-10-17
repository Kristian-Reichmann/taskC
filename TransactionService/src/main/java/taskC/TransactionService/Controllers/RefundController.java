package taskC.TransactionService.Controllers;

import org.springframework.web.bind.annotation.*;
import taskC.TransactionService.Models.Refund;
import taskC.TransactionService.Service.RefundService;
import taskC.TransactionService.dto.RefundRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/refund")
public class RefundController {

    @Autowired
    private RefundService refundService;

    @PostMapping
    public ResponseEntity<Refund> createRefund(@Valid @RequestBody Refund refund) {
        Refund createdrefund = refundService.createRefund(refund);
        return ResponseEntity.status(HttpStatus.CREATED).body(refund);
    }

    @GetMapping
    public List<Refund> getAllRefunds(){
        return refundService.getAllRefunds();
    }

}
