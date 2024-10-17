package taskC.TransactionService.Service;

import taskC.TransactionService.Models.Payment;
import taskC.TransactionService.Repositories.PaymentRepository;
import taskC.TransactionService.dto.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment createPayment(Payment payment){
        return paymentRepository.save(payment);
    }


    public Payment updatePayment(PaymentRequest request){
        Payment payment = new Payment();
        payment.setBookingId(request.getBookingId());
        payment.setAmount(request.getAmount());
        payment.setPaymentMethod(request.getPaymentMethod());

        return paymentRepository.save(payment);
    }


}
