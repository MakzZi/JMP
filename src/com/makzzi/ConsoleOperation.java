package com.makzzi;

public class ConsoleOperation {

    public int[] createIntArray() {
        int length = 0;
        ConsoleUtils consoleUtils = new ConsoleUtils();
        while (length < 1) {
            System.out.printf("Enter a positive length for the array: ");
            length = consoleUtils.getInt();
        }
        System.out.printf("Enter an integer for the array: ");
        return consoleUtils.getIntArray(length);
    }



}
