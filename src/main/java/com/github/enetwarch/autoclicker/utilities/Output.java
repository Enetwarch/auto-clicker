package com.github.enetwarch.autoclicker.utilities;
import java.awt.AWTException;
import java.awt.Robot;

public class Output {
   
    public static Robot robot;
    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void terminateProgram() {
        StringBuilder terminateProgram = new StringBuilder();
        terminateProgram.append(String.format("Auto Clicker%n"));
        terminateProgram.append(String.format("Code by Enetwarch%n"));
        System.out.print(terminateProgram);
        Input.scanner.close();
        System.exit(0);
    }

}