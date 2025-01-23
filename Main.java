import data.Data;
import output.Clicker;
import utilities.Input;
import utilities.Interface;
import utilities.Output;

public class Main {

    private static final Clicker clicker = new Clicker(Data.MOUSE_BUTTON.get(), Data.CLICKER_DELAY.get());

    private static final Interface[] interfaceArray = new Interface[] {
        new Interface(1, "Start Clicker", () -> clicker.startClicking()),
        new Interface(2, "Stop Clicker", () -> clicker.stopClicking()),
        new Interface(0, "Exit Program", () -> Output.terminateProgram())
    };

    private static final int INTERFACE_MIN = 0;
    private static final int INTERFACE_MAX = interfaceArray.length - 1;

    public static void main(String[] args) {
        while(true) {
            Interface.printInterface(interfaceArray);
            int userInput = Input.getUserInputInt("Choose Action", INTERFACE_MIN, INTERFACE_MAX);
            System.out.printf("%n");
            Interface.inputRunnable(interfaceArray, userInput);
        }
    }

}