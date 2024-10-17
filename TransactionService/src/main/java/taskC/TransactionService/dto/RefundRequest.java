package taskC.TransactionService.dto;

import jakarta.validation.constraints.NotNull;

public class RefundRequest {

    @NotNull
    private Long bookingId;
    private Double amount;

    public Long getBookingId() {
        return bookingId;
    }

    public void setbookingId(Long bookingId){
        this.bookingId = bookingId;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
