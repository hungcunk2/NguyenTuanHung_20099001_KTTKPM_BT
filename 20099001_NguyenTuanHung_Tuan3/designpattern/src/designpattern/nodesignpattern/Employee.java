package designpattern.nodesignpattern;

class Employee {
    private String name;
    private String position; 
    private double baseSalary = 5000; 
    private boolean hasPhD; 

    public Employee(String name, String position, boolean hasPhD) {
        this.name = name;
        this.position = position;
        this.hasPhD = hasPhD;
    }

    public double calculateIncome() {
        double income = baseSalary;
        if (hasPhD) {
            income += 1000; 
        }
        if (position.equals("Tổ trưởng")) {
            income += 500;
        } else if (position.equals("Trưởng phòng")) {
            income += 1000;
        }
        return income;
    }

    @Override
    public String toString() {
        return name + " - Thu nhập: " + calculateIncome();
    }
}