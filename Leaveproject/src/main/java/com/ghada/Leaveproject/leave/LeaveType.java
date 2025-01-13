package com.ghada.Leaveproject.leave;

public enum LeaveType {
    WAITING("Waiting for approval"),
    SUBMITTED("Leave submitted"),
    REJECTED("Leave rejected");

    private final String label;

    LeaveType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
