package designpattern.strategy;

public class Mainnnn {
	public static void main(String[] args) {
        Employee emp = new Employee("Nguyễn Văn A", new PhDAllowance());
        System.out.println(emp);
    }
}
