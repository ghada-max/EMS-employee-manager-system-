package com.ghada.payrollProject.payroll.enums;


public enum PaymentType {
    BankTransfer("BankTransfer"),
    Check("Check"),
    Cash("Cash");

    private final String label;

    // Constructor to set the label for each enum
    PaymentType(String label) {
        this.label = label;
    }

    // Getter for the label
    public String getLabel() {
        return label;
    }
}
