package taskC.TransactionService.dto;

import jakarta.validation.constraints.NotNull;

public class PaymentRequest {
    @NotNull(message = "Booking ID cannot be null")
    private Long bookingId;

    @NotNull(message = "Amount cannot be null")
    private Double amount;

    @NotNull(message = "Payment method cannot be null")
    private String paymentMethod;

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
