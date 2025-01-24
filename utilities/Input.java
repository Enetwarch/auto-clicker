package utilities;
import java.util.Scanner;

public class Input {
    
    public static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_ERROR = "INPUT ERROR";

    private static void inputMessageInt(String message) {
        System.out.printf("%s: ", message);
    }

    private static void inputErrorInt(int min, int max) {
        System.out.printf("%s. Accepts integers %d to %d.%n", INPUT_ERROR, min, max);
    }

    public static int getUserInputInt(String message, int min, int max) {
        int userInput;
        while (true) {
            try {
                inputMessageInt(message);
                userInput = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                inputErrorInt(min, max); 
                continue;
            }
            if (userInput >= min && userInput <= max) {
                return userInput; 
            } else {
                inputErrorInt(min, max);
            }
        }
    }

}