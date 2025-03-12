package designpattern.decorator;

public class Mainnn {
	public static void main(String[] args) {
        Income emp = new BasicEmployee("Nguyễn Văn A");
        emp = new PhDDecorator(emp); 
        emp = new TeamLeaderDecorator(emp); 
        System.out.println(emp);
    }
}
