package com.makzzi;

import java.util.Arrays;

public class ChapterTwo {

    public void showShortLongNumberInArray(String[] array) {
        int lengthArray = array.length;
        if (lengthArray > 0) {
            int lengthNum = array[0].length();
            int indexShort = 0;
            int indexLong = 0;
            int shortNum = lengthNum;
            int longNum = lengthNum;
            for (int i = 1; i < lengthArray; i++) {
                lengthNum = array[i].length();
                if (lengthNum < shortNum) {
                    shortNum = lengthNum;
                    indexShort = i;
                }
                if (lengthNum > longNum) {
                    longNum = lengthNum;
                    indexLong = i;
                }
            }
            System.out.printf("Short number: %s%nLong number: %s%n", array[indexShort], array[indexLong]);
        }
    }

    private String[] sortingArrayByLengthOfNumbers(String[] arrayString, boolean ascending) {
        int length = arrayString.length-1;
        int[] arrayLength = getArrayLength(arrayString);
        boolean swaped = true;
        int tmpLength;
        String tmpNumber;
        if (ascending) {
            while (swaped && length != 0) {
                swaped = false;
                for (int i = 0; i < length; i++) {
                    if (arrayLength[i] > arrayLength[i+1]) {
                        tmpLength = arrayLength[i];
                        arrayLength[i] = arrayLength[i+1];
                        arrayLength[i+1] = tmpLength;
                        tmpNumber = arrayString[i];
                        arrayString[i] = arrayString[i+1];
                        arrayString[i+1] = tmpNumber;
                        swaped = true;
                    }
                }
            }
            length--;
        }
        else {
            while (swaped && length != 0) {
                swaped = false;
                for (int i = 0; i < length; i++) {
                    if (arrayLength[i] < arrayLength[i+1]) {
                        tmpLength = arrayLength[i];
                        arrayLength[i] = arrayLength[i+1];
                        arrayLength[i+1] = tmpLength;
                        tmpNumber = arrayString[i];
                        arrayString[i] = arrayString[i+1];
                        arrayString[i+1] = tmpNumber;
                        swaped = true;
                    }
                }
                length--;
            }
        }
        return arrayString;
    }

    public void showSortedArrayByLengthOfNumber(String[] array) {
        System.out.println("Initial array: " + Arrays.toString(array));
        System.out.println("Sorted array in ascending order by length of numbers: " + Arrays.toString(sortingArrayByLengthOfNumbers(array, true)));
        System.out.println("Sorted array in descending order by length of numbers: " + Arrays.toString(sortingArrayByLengthOfNumbers(array, false)));
    }

    private int[] getArrayLength(String[] arrayNums) {
        int[] arrayLength = new int[arrayNums.length];
        for (int i = 0; i < arrayNums.length; i++)
            arrayLength[i] = arrayNums[i].length();
        return arrayLength;
    }

    private int getAverageNumber(int[] arrayInt) {
        int sum = 0;
        for (int num : arrayInt)
            sum += num;
        return sum / arrayInt.length;
    }

    public void showGreaterAndLessThanAverageNumberInArray(String[] arrayNums) {
        int[] arrayLength = getArrayLength(arrayNums);
        int average = getAverageNumber(arrayLength);
        String greater = "", less = "";
        for (int i = 0; i < arrayNums.length; i++) {
            if (arrayLength[i] > average)
                greater += " "+arrayNums[i];
            else
                less += " "+arrayNums[i];
        }
        System.out.println("Numbers greater than the average length number in the array:" + greater);
        System.out.println("Numbers less than the average length number in the array:" + less);
    }

}