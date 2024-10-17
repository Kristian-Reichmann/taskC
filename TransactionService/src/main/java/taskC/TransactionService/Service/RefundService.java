package taskC.TransactionService.Service;

import org.springframework.stereotype.Service;


import taskC.TransactionService.Models.Payment;
import taskC.TransactionService.Models.Refund;
import taskC.TransactionService.Repositories.PaymentRepository;
import taskC.TransactionService.Repositories.RefundRepository;
import taskC.TransactionService.dto.RefundRequest;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class RefundService {
    @Autowired
    private RefundRepository refundRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    public Refund processRefund(RefundRequest request){
        Payment payment = paymentRepository.findById(request.getPaymentId())
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found"));

        Refund refund = new Refund();
        refund.SetPaymentId(payment.getId());
        refund.SetAmount(request.getAmount());
        refund.setStatus("PENDING");
        return refundRepository.save(refund);
    }

    public Refund getRefundById(Long id) {
        return refundRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Refund not found"));
    }

    public List<Refund> getAllRefunds() {
        return refundRepository.findAll();
    }

}
