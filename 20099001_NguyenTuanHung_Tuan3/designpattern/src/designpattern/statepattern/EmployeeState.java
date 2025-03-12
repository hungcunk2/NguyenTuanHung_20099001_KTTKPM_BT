package designpattern.statepattern;

interface EmployeeState {
    double calculateExtraIncome();
}

class BasicState implements EmployeeState {
    public double calculateExtraIncome() {
        return 0; 
    }
}

class PhDState implements EmployeeState {
    public double calculateExtraIncome() {
        return 1000; 
    }
}

class TeamLeaderState implements EmployeeState {
    public double calculateExtraIncome() {
        return 500; 
    }
}

class Employee {
    private String name;
    private double baseSalary = 5000;
    private EmployeeState state;

    public Employee(String name, EmployeeState state) {
        this.name = name;
        this.state = state;
    }

    public double calculateIncome() {
        return baseSalary + state.calculateExtraIncome();
    }

    @Override
    public String toString() {
        return name + " - Thu nhập: " + calculateIncome();
    }
}

