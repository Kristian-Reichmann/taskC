package taskC.TransactionService.Controllers;

import taskC.TransactionService.Models.Payment;
import taskC.TransactionService.Service.PaymentService;
import taskC.TransactionService.dto.PaymentRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    //@Autowired
    private PaymentService paymentService;


    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }


    @PostMapping
    @ResponseBody
    public ResponseEntity<Payment> createPayment(@Valid @RequestBody PaymentRequest request) {
        Payment payment = paymentService.processPayment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }

    //Just trying stuff from the labs
        /*
    @PostMapping
    @ResponseBody
    public Payment createPayment(@RequestBody PaymentRequest paymentRequest){
        System.out.println("payment complete"+paymentRequest.getBookingId());
         Long bookingId = paymentService.
            //paymentRequestDTO));
         return bookingId;
        )
        */



    @GetMapping("/findAllBookings")
    @ResponseBody
    public ResponseEntity<List<Payment>> listPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }
}
