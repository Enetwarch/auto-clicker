package com.github.enetwarch.autoclicker.input;
import com.github.enetwarch.autoclicker.output.Clicker;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import java.util.logging.Logger;
import java.util.logging.Level;
import com.github.enetwarch.autoclicker.util.Format;

public class GlobalKeyListener implements NativeKeyListener {

    private final Clicker clicker;
    private final int toggleSwitch;
    private final int killSwitch;

    public GlobalKeyListener(Clicker clicker, int toggleSwitch, int killSwitch) {
        this.clicker = clicker;
        this.toggleSwitch = toggleSwitch;
        this.killSwitch = killSwitch;
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == killSwitch) {
            Format.printMessage("Program terminated.");
            System.exit(0);
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == toggleSwitch) {
            clicker.toggleClicker();
        }
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
        // Unused override
    }

}