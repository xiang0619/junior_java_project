// Payment (Java Class)
class Payment {
    private String paymentID;
    private Ticket ticket;
    private double totalPrice = 0;

    public Payment(Ticket ticket) {
        this.ticket = ticket;
        this.totalPrice = calculateTotalPrice();

        // Generate payment ID
        paymentID = generatePaymentID();
    }

    private String generatePaymentID() {
        // Logic to generate unique payment ID
        // Example: "py001", "py002", etc.
        return "py" + String.format("%03d", generatePaymentNumber());
    }

    private static int paymentCounter = 1;

    private int generatePaymentNumber() {
        return paymentCounter++;
    }

    public boolean confirmTransaction() {
        boolean isValidPayment = false;

        if (validateCreditCard() || validateEwallet()) {
            isValidPayment = true;
            System.out.println("Payment confirmed.");
        } else {
            System.out.println("Invalid payment details. Please try again.");
        }

        return isValidPayment;
    }

    public boolean validateCreditCard() {
        // Logic to validate credit card details
        // Returns true if valid, false otherwise
        // Example implementation:
        // - Check if credit card number is 16 digits and has 5 different digits
        // - Check if CVV is 3 digits and has 2 different digits
        return false;
    }

    public boolean validateEwallet() {
        // Logic to validate e-wallet details
        // Returns true if valid, false otherwise
        // Example implementation:
        // - Check if e-wallet number is 10 digits and starts with "01"
        // - Check if e-wallet number has 2 different digits
        return false;
    }

    public String getTicketID() {
        return ticket.getTicketID();
    }

    public double calculateTotalPrice() {
        // Logic to calculate total price
        // Example: quantity * ticket price (RM15)
        return totalPrice = ticket.getQuantity() * 15.0;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID='" + paymentID + '\'' +
                ", ticket=" + ticket +
                ", totalPrice=" + totalPrice +
                '}';
    }
}