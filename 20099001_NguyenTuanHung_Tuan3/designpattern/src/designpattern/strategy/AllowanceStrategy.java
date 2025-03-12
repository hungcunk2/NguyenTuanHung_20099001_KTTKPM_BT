package designpattern.strategy;

interface AllowanceStrategy {
    double calculateAllowance();
}

class PhDAllowance implements AllowanceStrategy {
    public double calculateAllowance() {
        return 1000; 	
    }
}

class TeamLeaderAllowance implements AllowanceStrategy {
    public double calculateAllowance() {
        return 500; 
    }
}

class NoAllowance implements AllowanceStrategy {
    public double calculateAllowance() {
        return 0;
    }
}

class Employee {
    private String name;
    private double baseSalary = 5000;
    private AllowanceStrategy allowance;

    public Employee(String name, AllowanceStrategy allowance) {
        this.name = name;
        this.allowance = allowance;
    }

    public double calculateIncome() {
        return baseSalary + allowance.calculateAllowance();
    }

    public String toString() {
        return name + " - Thu nhập: " + calculateIncome();
    }
}


