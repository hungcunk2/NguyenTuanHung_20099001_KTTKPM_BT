package designpattern.statepattern;

public class Mainn {
	public static void main(String[] args) {
        Employee emp = new Employee("Nguyễn Văn A", new PhDState());
        System.out.println(emp);
    }
}
