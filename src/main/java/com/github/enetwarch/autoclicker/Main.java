package com.github.enetwarch.autoclicker;
import com.github.enetwarch.autoclicker.input.GlobalKeyListener;
import com.github.enetwarch.autoclicker.util.Format;

public class Main {

    public static void main(String[] args) {
        GlobalKeyListener globalKeyListener = new GlobalKeyListener();
        Format.printMessage("Autoclicker initialized!");
    }

}