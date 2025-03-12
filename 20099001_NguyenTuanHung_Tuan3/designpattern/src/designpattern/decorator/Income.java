package designpattern.decorator;

interface Income {
    double getIncome();
}

class BasicEmployee implements Income {
    private String name;
    private double baseSalary = 5000;

    public BasicEmployee(String name) {
        this.name = name;
    }

    public double getIncome() {
        return baseSalary;
    }

    @Override
    public String toString() {
        return name + " - Thu nhập: " + getIncome();
    }
}

abstract class IncomeDecorator implements Income {
    protected Income decoratedEmployee;

    public IncomeDecorator(Income employee) {
        this.decoratedEmployee = employee;
    }

    public double getIncome() {
        return decoratedEmployee.getIncome();
    }
}

class PhDDecorator extends IncomeDecorator {
    public PhDDecorator(Income employee) {
        super(employee);
    }

    @Override
    public double getIncome() {
        return super.getIncome() + 1000; 
    }
}

class TeamLeaderDecorator extends IncomeDecorator {
    public TeamLeaderDecorator(Income employee) {
        super(employee);
    }

    @Override
    public double getIncome() {
        return super.getIncome() + 500; 
    }
}


