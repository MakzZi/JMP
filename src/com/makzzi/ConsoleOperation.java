package com.makzzi;

import java.util.Arrays;

public class ConsoleOperation {

    public int[] createIntArray() {
        System.out.printf("Enter a positive length for the array: ");
        ConsoleUtils consoleUtils = new ConsoleUtils();
        int length = consoleUtils.getInt();
        System.out.printf("Enter an integer for the array: ");
        return consoleUtils.getIntArray(length);
    }

    public String[] createNumberArray() {
        System.out.printf("Enter a positive length for the array: ");
        ConsoleUtils consoleUtils = new ConsoleUtils();
        int length = consoleUtils.getInt();
        System.out.printf("Enter a number for the array: ");
        return consoleUtils.getNumberArray(length);
    }

    public void printArray(int[] array) {
        String strArray = Arrays.toString(array);
        System.out.println(strArray);
    }

    public void printArray(String[] array) {
        String strArray = Arrays.toString(array);
        System.out.println(strArray);
    }

}
