package com.makzzi;

import java.util.Scanner;

public class ConsoleUtils {

    public int getInt() {
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextInt()) {
            int i = scan.nextInt();
            return i;
        }
        return getInt();
    }

    public int[] getIntArray(int lengthArray) {
        lengthArray = Math.abs(lengthArray);
        if (lengthArray < 0) lengthArray = 0;
        int[] intArr = new int[lengthArray];
        for (int i = 0; i < lengthArray; i++)
            intArr[i] = getInt();
        return intArr;
    }

    public String getNumber() {
        Scanner scan = new Scanner(System.in);
        if (scan.hasNext("\\s*[-]?(\\d+|\\d+[.]\\d+)\\s*")) return scan.next();
        return getNumber();
    }


    public String[] getNumberArray(int lengthArray) {
        lengthArray = Math.abs(lengthArray);
        if (lengthArray < 0) lengthArray = 0;
        String[] numArr = new String[lengthArray];
        for (int i = 0; i < lengthArray; i++)
            numArr[i] = getNumber();
        return numArr;
    }

}
