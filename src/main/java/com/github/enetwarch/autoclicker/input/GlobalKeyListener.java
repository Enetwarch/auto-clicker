package com.github.enetwarch.autoclicker.input;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.enetwarch.autoclicker.util.Format;
import com.github.enetwarch.autoclicker.output.MouseClicker;

public class GlobalKeyListener implements NativeKeyListener {

    private static final int TOGGLE_SWITCH = NativeKeyEvent.VC_F9;
    private static final int KILL_SWITCH = NativeKeyEvent.VC_F10;

    public GlobalKeyListener() {
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }
        GlobalScreen.addNativeKeyListener(this);
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KILL_SWITCH) {
            Format.printMessage("Program terminated.");
            System.exit(0);
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == TOGGLE_SWITCH) {
            MouseClicker.toggleClicker();
        }
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
        // Unused override
    }

}