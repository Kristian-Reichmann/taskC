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

    public List<Refund> getAllRefunds() {
        return refundRepository.findAll();
    }

    public Refund createRefund(Refund refund){
        return refundRepository.save(refund);
    }
/*
    public Refund processRefund(RefundRequest request){
        Payment payment = paymentRepository.findById(request.getBookingId())
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found"));

        Refund refund = new Refund();
        refund.setBookingId(payment.getId());
        refund.setAmount(request.getAmount());
        return refundRepository.save(refund);
    }

    public Refund getRefundById(Long id) {
        return refundRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Refund not found"));
    }

*/

}
