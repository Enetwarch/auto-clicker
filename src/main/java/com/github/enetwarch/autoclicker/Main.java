package com.github.enetwarch.autoclicker;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.awt.Robot;
import java.awt.AWTException;
import com.github.enetwarch.autoclicker.output.Clicker;
import com.github.enetwarch.autoclicker.output.MouseClicker;
import com.github.enetwarch.autoclicker.data.OutputData;
import com.github.enetwarch.autoclicker.input.GlobalKeyListener;
import com.github.enetwarch.autoclicker.data.InputData;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            logger.log(Level.SEVERE, "There was a problem initializing the robot.");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        Clicker mouseClicker = new MouseClicker(robot, OutputData.MOUSE_BUTTON.get(), OutputData.CLICKER_DELAY.get(), logger);
        GlobalKeyListener globalKeyListener = new GlobalKeyListener(mouseClicker, InputData.TOGGLE_SWITCH.get(), InputData.KILL_SWITCH.get(), logger);
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            logger.log(Level.SEVERE, "There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }
        GlobalScreen.addNativeKeyListener(globalKeyListener);
        logger.log(Level.INFO, "Autoclicker initialized!");
    }

}