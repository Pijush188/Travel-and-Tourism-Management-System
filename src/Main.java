import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int randomInt = random.nextInt(); // Random integer
        int randomIntWithinRange = random.nextInt(100); // Random integer between 0 (inclusive) and 100 (exclusive)
        double randomDouble = random.nextDouble(); // Random double between 0.0 and 1.0
        boolean randomBoolean = random.nextBoolean(); // Random boolean

        System.out.println("Random Integer: " + randomInt);
        System.out.println("Random Integer within Range (0-99): " + randomIntWithinRange);
        System.out.println("Random Double: " + randomDouble);
        System.out.println("Random Boolean: " + randomBoolean);
    }
}
