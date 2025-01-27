package com.github.enetwarch.autoclicker.data;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import java.awt.event.InputEvent;

public enum InputData {

    KEYBOARD_BUTTON(NativeKeyEvent.VC_F6);

    private final int inputData;

    InputData(int inputData) {
        this.inputData = inputData;
    }

    public int get() {
        return inputData;
    }

}