package com.makzzi;

import javax.naming.NameNotFoundException;
import java.util.Arrays;
import java.util.Random;

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
        System.out.println("Sorted array in ascending order by length of numbers: "
                + Arrays.toString(sortingArrayByLengthOfNumbers(array, true)));
        System.out.println("Sorted array in descending order by length of numbers: "
                + Arrays.toString(sortingArrayByLengthOfNumbers(array, false)));
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

    private int qntyUniqueDigitsInNumber(String number) {
        number = number.replaceAll("\\W", "");
        int count = 0;
        while (number.length() > 0) {
            number = number.replaceAll(number.substring(0,1), "");
            count++;
        }
        return count;
    }

    public void showNumberWithMinimunUniqueDigits(String[] nums) {
        int current, indexMin = 0, minimum = qntyUniqueDigitsInNumber(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            current = qntyUniqueDigitsInNumber(nums[i]);
            if (minimum > current) {
                minimum = current;
                indexMin = i;
            }
        }
        System.out.println("Number in which the minimum quantity of unique digits: " + nums[indexMin]);
    }

    public void showOnlyEvenOrSameEvenOddDigitsInNumbers(String[] nums) {
        String even = "";
        String evenOdd = "";
        String num;
        int countEven, countOdd;
        for (int i = 0; i < nums.length; i++) {
            num = nums[i].replaceAll("\\W", "");
            countEven = 0;
            countOdd = 0;
            for (int j = 0; j < num.length(); j++) {
                if ((int) num.charAt(j) % 2 == 0)
                    countEven++;
                else
                    countOdd++;
            }
            if (countEven == num.length())
                even += nums[i] + " ";
            else if (countEven == countOdd)
                evenOdd += nums[i] + " ";
        }
        System.out.println("Numbers to which all digits are even : " + even);
        System.out.println("Numbers to which even and odd digits in the same: " + evenOdd);
    }

    public void showNumberContainDigitsInAscendingOrder(String[] nums) {
        String num;
        int previous, digit;
        boolean found = false;
        for (int indexNumber = 0; !found && indexNumber < nums.length; indexNumber++) {
            found = true;
            num = nums[indexNumber].replace("\\W", "");
            previous = (int) num.charAt(0);
            for (int indexDigit = 1; found && indexDigit < num.length(); indexDigit++) {
                found = false;
                digit = (int)num.charAt(indexDigit);
                if (digit > previous) {
                    previous = digit;
                    found = true;
                }
            }
            if (found) System.out.println("Number: " + nums[indexNumber]);
        }
    }

    public void showNumberConsistDifferentDigits(String[] nums) {
        String num;
        boolean diff = false;
        for (int indexNumber = 0; !diff && indexNumber < nums.length; indexNumber++) {
            num = nums[indexNumber].replace("\\W", "");
            diff = true;
            for (int targetDigit = 1; diff && targetDigit < num.length(); targetDigit++) {
                for (int i = 0; diff && i < targetDigit; i++) {
                    if (num.charAt(targetDigit) == num.charAt(i)) {
                        diff = false;
                    }
                }
            }
            if (diff) System.out.println("Number that consists of different digits: " + nums[indexNumber]);
        }
    }


    private boolean isPalindrome(String num) {
        for (int i = 0, j = num.length()-1; i < num.length()/2; i++, j--)
            if (num.charAt(i) != num.charAt(j))
                return false;
        return true;
    }

    public void showPalindrome(String[] nums) {
        int count = 0;
        String palindrome = "none";
        for (int i = 0; i < nums.length && count < 2; i++) {
            if (isPalindrome(nums[i])) {
                palindrome = nums[i];
                count++;
            }
        }
        System.out.printf("Palindrome #%d: %s%n", count, palindrome);
    }

    public void showNumberBelongInterval(int k, int n, int m) {
        if (k > n && k <= m)
            System.out.printf("%d ∈ (%d, %d]%n", k, n, m);
        else
            System.out.printf("%d ∉ (%d, %d]%n", k, n, m);
        if (k >= n && k < m)
            System.out.printf("%d ∈ [%d, %d)%n", k, n, m);
        else
            System.out.printf("%d ∉ [%d, %d)%n", k, n, m);
        if (k > n && k < m)
            System.out.printf("%d ∈ (%d, %d)%n", k, n, m);
        else
            System.out.printf("%d ∉ (%d, %d)%n", k, n, m);
        if (k >= n && k <= m)
            System.out.printf("%d ∈ [%d, %d]%n", k, n, m);
        else
            System.out.printf("%d ∉ [%d, %d]%n", k, n, m);
    }

    public void showNumberBelongInterval(double k, double n, double m) {
        if (k > n && k <= m)
            System.out.printf("%d ∈ (%d, %d]%n", k, n, m);
        else
            System.out.printf("%d ∉ (%d, %d]%n", k, n, m);
        if (k >= n && k < m)
            System.out.printf("%d ∈ [%d, %d)%n", k, n, m);
        else
            System.out.printf("%d ∉ [%d, %d)%n", k, n, m);
        if (k > n && k < m)
            System.out.printf("%d ∈ (%d, %d)%n", k, n, m);
        else
            System.out.printf("%d ∉ (%d, %d)%n", k, n, m);
        if (k >= n && k <= m)
            System.out.printf("%d ∈ [%d, %d]%n", k, n, m);
        else
            System.out.printf("%d ∉ [%d, %d]%n", k, n, m);
    }

    private String printFixedLength(String str, int length) {
        int space = length - str.length() + 1;
        while (space != 0) {
            str += " ";
            space--;
        }
        return str;
    }

    public void showMatrix(int k) {
        double dN = Math.sqrt(k);
        int n = (int)dN;
        if (dN*dN != n*n) n++;
        int num = 1;
        int lengthLastNumber = Integer.toString(k).length();
        for (int i = 1; i <= k / n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(printFixedLength(Integer.toString(num), lengthLastNumber));
                num++;
            }
            System.out.println();
        }
        for (int j = 1; j <= n; j++) {
            if (num <= k)
            {
                System.out.print(printFixedLength(Integer.toString(num), lengthLastNumber));
                num++;
            }
            else {
                System.out.print(printFixedLength("0", lengthLastNumber));
                num++;
            }
        }
    }

    public void showMatrixNB(int k) {
        double dN = Math.sqrt(k);
        int n = (int)dN;
        if (dN*dN != n*n) n++;
        int[][] matrix = new int[n][n];
        int count = 1;
        for (int i = 0; i < n && count <= k; i++) {
            for (int j = 0; j < n && count <= k; j++) {
                matrix[i][j] = count;
                count++;
            }
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public void quadraticEquation() {
        System.out.println("ax^2 + bx + c = 0");
        ConsoleUtils utils = new ConsoleUtils();
        System.out.print("a: ");
        int a = utils.getInt();
        System.out.print("b: ");
        int b = utils.getInt();
        System.out.print("c: ");
        int c = utils.getInt();
        System.out.printf("%n%dx^2 + %dx + %d = 0%n", a, b, c);
        double d = Math.sqrt(Math.pow(b,2)-4*a*c);
        if (d < 0 || Double.isNaN(d))
            System.out.println("has not roots");
        else if (d == 0)
            System.out.printf("x = %.3f%n", (double)-b/2*a);
        else
            System.out.printf("x1 = %.3f%nx2 = %.3f%n", (-b + d) / (2*a), (-b - d) / (2*a));
    }

    private String month(int num) {
        switch (num) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "Invalid month";
        }
    }

    public void showMonth() {
        System.out.print("Enter month number: ");
        ConsoleUtils month = new ConsoleUtils();
        int number = month.getInt();
        System.out.println(month(number));
    }

    private int[][] createMatrixNxN(int n) {
        int[][] matrix = new int[n][n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = rnd.nextInt(n*2+1)-n;
        return matrix;
    }

    private void printMatrix(int[][] matrix, int n) {
        int lengthN = Integer.toString(-n).length()+3;
        int lengthNumber;
        String number;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                number = Integer.toString(matrix[i][j]);
                lengthNumber = number.length();
                if (number.charAt(0) != '-') {
                    number = " " + number;
                    lengthNumber++;
                }
                for (int s = 0; s < lengthN - lengthNumber; s++)
                    number += " ";
                System.out.print(number);
            }
            System.out.println();
        }
    }

    public void showMatrixNxN() {
        System.out.print("Enter N: ");
        ConsoleUtils getN = new ConsoleUtils();
        int n = getN.getInt();
        int[][] matrix = createMatrixNxN(n);
        printMatrix(matrix, n);
    }

}
