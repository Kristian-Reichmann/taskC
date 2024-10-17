package taskC.TransactionService.dto;

public class RefundRequest {
    private Long paymentId;
    private Double amount;

    public Long getPaymentId() {
        return paymentId;
    }

    public Double getAmount() {
        return this.amount;
    }
}
