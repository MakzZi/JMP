package com.makzzi;

import java.util.Scanner;

public class ConsoleUtils {

    public int[] getIntArray(int lengthArray) {
        try {
            int[] arr = new int[lengthArray];
            for (int i = 0; i < lengthArray; i++)
                arr[i] = getInt();
            return arr;
        }
        catch (NegativeArraySizeException ex) {
            System.out.printf("Exception: %s%nEnter a positive length for the array: ", ex);
            int index = getInt();
            while (index < 0) index = getInt();
            return getIntArray(index);
        }
    }

    public int getInt() {
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextInt()) {
            int i = scan.nextInt();
            return i;
        }
        return getInt();
    }

}
