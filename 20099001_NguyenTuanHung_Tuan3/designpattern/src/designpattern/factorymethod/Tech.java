package designpattern.factorymethod;

public class Tech {
    interface Phone {
        String call();
    }

    interface Laptop {
        String work();
    }

    // Add static keyword to all nested classes
    static class IPhone implements Phone {
        @Override
        public String call() {
            return "Gọi điện bằng iPhone";
        }
    }

    static class MacBook implements Laptop {
        @Override
        public String work() {
            return "Làm việc trên MacBook";
        }
    }

    static class GalaxyPhone implements Phone {
        @Override
        public String call() {
            return "Gọi điện bằng Galaxy";
        }
    }

    static class GalaxyBook implements Laptop {
        @Override
        public String work() {
            return "Làm việc trên Galaxy Book";
        }
    }

    interface TechFactory {
        Phone createPhone();
        Laptop createLaptop();
    }

    static class AppleFactory implements TechFactory {
        @Override
        public Phone createPhone() {
            return new IPhone();
        }

        @Override
        public Laptop createLaptop() {
            return new MacBook();
        }
    }

    static class SamsungFactory implements TechFactory {
        @Override
        public Phone createPhone() {
            return new GalaxyPhone();
        }

        @Override
        public Laptop createLaptop() {
            return new GalaxyBook();
        }
    }

    static class AbstractFactoryExample {
        public static void testTech(TechFactory factory) {
            Phone phone = factory.createPhone();
            Laptop laptop = factory.createLaptop();
            System.out.println(phone.call());
            System.out.println(laptop.work());
        }

        public static void main(String[] args) {
            System.out.println("Sản phẩm Apple:");
            testTech(new AppleFactory());

            System.out.println("\nSản phẩm Samsung:");
            testTech(new SamsungFactory());
        }
    }
}