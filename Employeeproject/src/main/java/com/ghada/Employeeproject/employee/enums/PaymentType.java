package com.ghada.Employeeproject.employee.enums;

public enum PaymentType {
    BankTransfer("Bank Transfer"),
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
