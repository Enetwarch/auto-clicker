package com.github.enetwarch.autoclicker.input;
import com.github.enetwarch.autoclicker.output.Clicker;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

public class GlobalKeyListener implements NativeKeyListener {

    private final Clicker clicker;
    private final int keyboardButton;
    public GlobalKeyListener(Clicker clicker, int keyboardButton) {
        this.clicker = clicker;
        this.keyboardButton = keyboardButton;
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        // Unused override
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == keyboardButton) {
            clicker.toggleClicker();
        }
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
        // Unused override
    }

}