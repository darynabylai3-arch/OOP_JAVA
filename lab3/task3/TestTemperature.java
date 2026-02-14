package task3;
public class TestTemperature {
    public static void main(String[] args) {
        Temperature t1 = new Temperature(100, 'C');
        System.out.println(t1.getFahrenheit());

        Temperature t2 = new Temperature(32, 'F');
        System.out.println(t2.getCelsius());
    }
}