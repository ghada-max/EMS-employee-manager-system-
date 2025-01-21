package com.ghada.Employeeproject.employee.communication;

public enum category {
    HR(2500.0),
    FinanceAndAccounting(2500.0),
    Marketing(2500.0),
    Sales(3000.0),
    CustomerSupport(2000.0),
    IT(3000.0);

    private Double salary;

    category(Double salary) {
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }
}
