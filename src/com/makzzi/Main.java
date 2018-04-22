package com.makzzi;

public class Main {

    private int[] readConsoleIntArray() {
        int length = 0;
        ReadInputConsole ric = new ReadInputConsole();
        while (length < 1) {
            System.out.printf("Enter a positive length for the array: ");
            length = ric.getInt();
        }
        System.out.printf("Enter an integer for the array: ");
        return ric.getIntArray(length);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.readConsoleIntArray();
    }
}
