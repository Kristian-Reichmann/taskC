package taskC.TransactionService.Controllers;

import taskC.TransactionService.Models.Refund;
import taskC.TransactionService.Service.RefundService;
import taskC.TransactionService.dto.RefundRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/refunds")
public class RefundController {
    @Autowired
    private RefundService refundService;

    @PostMapping
    public ResponseEntity<Refund> createRefund(@Valid @RequestBody RefundRequest refundRequest) {
        Refund refund = refundService.processRefund(refundRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(refund);
    }
}
