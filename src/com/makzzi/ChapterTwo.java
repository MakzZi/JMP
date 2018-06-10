package com.makzzi;

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

    public void printMatrix(int[][] matrix) {
        int lengthN = Integer.toString(-matrix[0].length).length()+3;
        int lengthNumber;
        String number;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                number = Integer.toString(matrix[row][column]);
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

    public void printMatrix(double[][] matrix) {
        int lengthN = Integer.toString(-matrix[0].length).length()+3;
        int lengthNumber;
        String number;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                number = Double.toString(matrix[row][column]);
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

    public int[][] getMatrixNxN() {
        System.out.print("Enter N: ");
        int n = new ConsoleUtils().getInt();
        int[][] matrix = createMatrixNxN(n);
        printMatrix(matrix);
        return matrix;
    }

    public void sortColumnMatrix(int[][] matrix, int k) {
        boolean sorting = true;
        int length = matrix[k].length-1;
        while(sorting) {
            for (int i = 0; i < length; i++) {
                sorting = false;
                if (matrix[i][k] > matrix[i+1][k]) {
                    int[] tmp = matrix[i];
                    matrix[i] = matrix[i+1];
                    matrix[i+1] = tmp;
                    sorting = true;
                }
            }
            length--;
        }
        System.out.println("\nSorted:");
        printMatrix(matrix);
    }

    public void sortRowMatrix(int[][] matrix, int k) {
        boolean sorting = true;
        int length = matrix[k].length-1;
        int tmp;
        while(sorting) {
            for (int column = 0; column < length; column++) {
                sorting = false;
                if (matrix[k][column] > matrix[k][column+1]) {
                    for (int row = 0; row < matrix[k].length; row++) {
                        tmp = matrix[row][column];
                        matrix[row][column] = matrix[row][column+1];
                        matrix[row][column+1] = tmp;
                    }
                    sorting = true;
                }
            }
            length--;
        }
        System.out.println("\nSorted:");
        printMatrix(matrix);
    }

    private int[][] moveUpMatrix(int[][] matrix, int k) {
        while(k != 0) {
            int[] tmp = matrix[0];
            for (int row = 1; row < matrix.length; row++)
                matrix[row-1] = matrix[row];
            matrix[matrix.length-1] = tmp;
            k--;
        }
        return matrix;
    }

    private int[][] moveDownMatrix(int[][] matrix, int k) {
        while(k != 0) {
            int[] tmp = matrix[matrix.length-1];
            for (int row = matrix.length-2; row >= 0; row--)
                matrix[row+1] = matrix[row];
            matrix[0] = tmp;
            k--;
        }
        return matrix;
    }

    private int[][] moveRightMatrix(int[][] matrix, int k) {
        int[] remember = new int[matrix.length];
        while(k != 0) {
            for (int row = 0; row < matrix.length; row++)
                remember[row] = matrix[row][matrix.length-1];
            for (int column = matrix.length-2; column >= 0; column--) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][column+1] = matrix[row][column];
                }
            }
            for (int row = 0; row < matrix.length; row++)
                matrix[row][0] = remember[row];
            k--;
        }
        return matrix;
    }

    private int[][] moveLeftMatrix(int[][] matrix, int k) {
        int[] remember = new int[matrix.length];
        while(k != 0) {
            for (int row = 0; row < matrix.length; row++)
                remember[row] = matrix[row][0];
            for (int column = 1; column < matrix.length; column++) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][column-1] = matrix[row][column];
                }
            }
            for (int row = 0; row < matrix.length; row++)
                matrix[row][matrix.length-1] = remember[row];
            k--;
        }
        return matrix;
    }

    public void moveMatrix() {
        int[][] matrix = getMatrixNxN();
        ConsoleUtils consoleUtils = new ConsoleUtils();
        System.out.print("How much to the RIGHT? : ");
        int k = consoleUtils.getInt();
        if (k > 0)
            moveRightMatrix(matrix, k);
        else {
            System.out.print("to the LEFT? : ");
            k = consoleUtils.getInt();
            if (k > 0)
                moveLeftMatrix(matrix, k);
        }
        System.out.print("How much to move UP? : ");
        k = consoleUtils.getInt();
        if (k > 0)
            moveUpMatrix(matrix, k);
        else {
            System.out.print("DOWN? : ");
            k = consoleUtils.getInt();
            if (k > 0)
                moveDownMatrix(matrix, k);
        }
        printMatrix(matrix);
    }

    public void largestNumberElementsMatrixInAscendingOrder() {
        int[][] matrix = getMatrixNxN();
        int ascending = 0;
        int descending = 0;
        for (int row = 0; row < matrix.length; row++) {
            int countAscending = 1;
            int countDescending = 1;
            for (int column = 0; column < matrix.length-1; column++) {
                if (matrix[row][column] <= matrix[row][column+1]) {
                    countAscending++;
                    if (countAscending > ascending) ascending = countAscending;
                }
                else countAscending = 1;
                if (matrix[row][column] >= matrix[row][column+1]) {
                    countDescending++;
                    if (countDescending > descending) descending = countDescending;
                }
                else countDescending = 1;
            }
        }
        for (int column = 0; column < matrix.length; column++) {
            int countAscending = 1;
            int countDescending = 1;
            for (int row = 0; row < matrix.length-1; row++) {
                if (matrix[row][column] <= matrix[row+1][column]) {
                    countAscending++;
                    if (countAscending > ascending) ascending = countAscending;
                }
                else countAscending = 1;
                if (matrix[row][column] >= matrix[row+1][column]) {
                    countDescending++;
                    if (countDescending > descending) descending = countDescending;
                }
                else countDescending = 1;
            }
        }
        System.out.printf("The largest number of elements in the matrix%n in ascending order: %d" +
                "%n in descending order: %d%n", ascending, descending);
    }

    public void sumBetweenFirstPositiveTwoNumbersInLine() {
        int[][] matrix = getMatrixNxN();
        int total = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length; column++) {
                int sumRow = 0;
                if (matrix[row][column] > 0) {
                    sumRow += matrix[row][column];
                    column++;
                    while (column < matrix.length) {
                        sumRow += matrix[row][column];
                        if (matrix[row][column] > 0) {
                            total += sumRow;
                            System.out.printf("Row #%d: %d%n", row+1, sumRow);
                            column = matrix.length;
                        }
                        column++;
                    }
                }
            }
        }
        System.out.printf("Total: %d%n", total);
    }

    public void transposeMatrix() {
        int[][] matrix = getMatrixNxN();
        int[][] transpose = new int[matrix.length][matrix.length];
        for (int row = 0; row < matrix.length; row++)
            for (int column = 0; column < matrix.length; column++)
                transpose[column][row] = matrix[row][column];
        System.out.println("Transpose:");
        printMatrix(transpose);
    }

    private int normMatrixRow(int[][] matrix) {
        int result = matrix[0][0];
        for (int row = 0; row < matrix.length; row++) {
            int rowSum = 0;
            for (int column = 0; column < matrix.length; column++)
                rowSum += Math.abs(matrix[row][column]);
            if (result < rowSum) result = rowSum;
        }
        return result;
    }

    private int normMatrixColumn(int[][] matrix) {
        int result = matrix[0][0];
        for (int column = 0; column < matrix.length; column++) {
            int columnSum = 0;
            for (int row = 0; row < matrix.length; row++)
                columnSum += Math.abs(matrix[row][column]);
            if (result < columnSum) result = columnSum;
        }
        return result;
    }

    private int determinantSarrusRule(int[][] matrix) {
        int result = 0;
        for (int column = 0; column < matrix.length; column++) {
            int multiplication = 1;
            for (int row = 0, below = column; row < matrix.length; row++) {
                multiplication *= matrix[row][below];
                below++;
                if (below > matrix.length-1) below -= matrix.length;
            }
            result += multiplication;
        }
        for (int column = 0; column < matrix.length; column++) {
            int multiplication = 1;
            for (int row = matrix.length-1, below = column; row >= 0; row--) {
                multiplication *= matrix[row][below];
                below++;
                if (below > matrix.length-1) below -= matrix.length;
            }
            result -= multiplication;
        }
        return result;
    }

    public void showNormMatrix() {
        int[][] matrix = getMatrixNxN();
        int normRow = normMatrixRow(matrix);
        int normColumn = normMatrixColumn(matrix);
        System.out.printf("Row-norm matrix: %d%nColumn-norm matrix: %d%n", normRow, normColumn);
    }

    private int[][] rotateLeftMatrix(int[][] matrix) {
        int[][] rotate = new int[matrix.length][matrix.length];
        for (int row = 0; row < matrix.length; row++)
            for (int column = matrix.length-1; column >= 0; column--)
                rotate[matrix.length-1-column][row] = matrix[row][column];
        return rotate;
    }

    private int[][] rotateRightMatrix(int[][] matrix) {
        int[][] rotate = new int[matrix.length][matrix.length];
        for (int row = matrix.length-1; row >= 0; row--)
            for (int column = 0; column < matrix.length; column++)
                rotate[column][matrix.length-1-row] = matrix[row][column];
        return rotate;
    }

    public void showRotateMatrix(boolean clockwise) {
        int[][] matrix = getMatrixNxN();
        System.out.println("Choose number:\n1 or any - 90\'\n2 - 180\'\n3 - 270\'");
        int num = new ConsoleUtils().getInt();
        if (clockwise)
            switch(num) {
                case 2:
                    matrix = rotateRightMatrix(matrix);
                    matrix = rotateRightMatrix(matrix);
                    break;
                case 3:
                    matrix = rotateLeftMatrix(matrix);
                    break;
                default:
                    matrix = rotateRightMatrix(matrix);
                    break;
            }
        else
            switch(num) {
                case 2:
                    matrix = rotateLeftMatrix(matrix);
                    matrix = rotateLeftMatrix(matrix);
                    break;
                case 3:
                    matrix = rotateRightMatrix(matrix);
                    break;
                default:
                    matrix = rotateLeftMatrix(matrix);
                    break;
            }
        printMatrix(matrix);
    }

    private int[][] cutMatrix(int[][] matrix, int rowCut, int columnCut) {
        int[][] piece = new int[matrix.length-rowCut-1][matrix.length-rowCut-1];
        for (int row = rowCut+1; row < matrix.length; row++) {
            for (int column = matrix.length-piece.length-1, columnPiece = 0; column < matrix.length; column++, columnPiece++) {
                if (column != columnCut)
                    piece[row-(rowCut+1)][columnPiece] = matrix[row][column];
                else
                    columnPiece--;
            }
        }
        return piece;
    }

    public int detMatrixLaplace(int[][] matrix) {
        int result = 0;
        for (int column = 0; column < matrix.length; column++) {
            int index = matrix[0][column];
            int[][] cut = cutMatrix(matrix, 0, column);
            if (column % 2 != 0 && column != 0) index *= -1;
            if (cut.length != 2)
                result += index * detMatrixLaplace(cut);
            else
                result +=  index * (cut[0][0] * cut[1][1] - cut[0][1] * cut[1][0]);
        }
        return result;
    }

    public void showDeterminantMatrix() {
        System.out.print("Enter N: ");
        int n = new ConsoleUtils().getInt();
        int[][] matrix = createMatrixNxN(n);
        printMatrix(matrix);
        System.out.printf("%nDeterminant matrix %d x %d = %d%n", n, n, detMatrixLaplace(matrix));
    }

    public int detMatrixGaussianElimination(double[][] matrix) {
        double result = matrix[0][0];
        int dgnlRow = 0;
        while (dgnlRow < matrix.length-1) {
            for (int row = dgnlRow+1; row < matrix.length; row++) {
                double multiplier = matrix[row][dgnlRow] / matrix[dgnlRow][dgnlRow];
                for (int column = dgnlRow; column < matrix.length; column++)
                    matrix[row][column] -=  multiplier * matrix[dgnlRow][column];
            }
            dgnlRow++;
            result *= matrix[dgnlRow][dgnlRow];
        }
        return (int)Math.round(result);
    }

    private int[][] delRow(int[][] matrix, int deleteRow) {
        int[][] result = new int[matrix.length-1][matrix[0].length];
        for (int rowMatrix = 0, rowResult = 0; rowMatrix < matrix.length; rowMatrix++, rowResult++) {
            if (rowMatrix != deleteRow)
                result[rowResult] = matrix[rowMatrix];
            else
                rowResult--;
        }
        return result;
    }

    private int[][] delColumn(int[][] matrix, int deleteColumn) {
        int[][] result = new int[matrix.length][matrix[0].length-1];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0, columnResult = 0; column < matrix[0].length; column++, columnResult++) {
                if (column != deleteColumn)
                    result[row][columnResult] = matrix[row][column];
                else
                    columnResult--;
            }
        }
        return result;
    }

    private int[][] delRowColumn(int[][] matrix, int deleteRow, int deleteColumn) {
        int[][] piece = new int[matrix.length-1][matrix.length-1];
        for (int row = 0, rowPiece = 0; row < matrix.length; row++, rowPiece++) {
            if (row != deleteRow) {
                for (int column = 0, columnPiece = 0; column < matrix.length; column++, columnPiece++) {
                    if (column != deleteColumn) {
                        piece[rowPiece][columnPiece] = matrix[row][column];
                    }
                    else {
                        columnPiece--;
                    }
                }
            }
            else {
                rowPiece--;
            }
        }
        return piece;
    }

    public void deleteMaxElementWithRowColumn() {
        int[][] matrix = getMatrixNxN();
        int maxElement = matrix[0][0];
        int delRow = 0;
        int delColumn = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length; column++) {
                if (maxElement < matrix[row][column]) {
                    maxElement = matrix[row][column];
                    delRow = row;
                    delColumn = column;
                }
            }
        }
        System.out.println("Matrix with a deleted row and column:");
        printMatrix(delRowColumn(matrix, delRow, delColumn));
    }

    private int[][] matrixSubtractionAverageElement(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int average = 0;
            for (int column = 0; column < matrix.length; column++) {
                average += Math.abs(matrix[row][column]);
            }
            average /= matrix.length;
            for (int column = 0; column < matrix.length; column++) {
                matrix[row][column] = Math.round(matrix[row][column] - average);
            }
        }
        return matrix;
    }

    public void showMatrixSubtractionAverageElement() {
        int[][] matrix = getMatrixNxN();
        System.out.println("Matrix:");
        printMatrix(matrixSubtractionAverageElement(matrix));
    }

    private int[][] trimMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            boolean delete = true;
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] != 0) {
                    delete = false;
                    break;
                }
            }
            if (delete) {
                matrix = delRow(matrix, row);
            }
        }
        for (int column = 0; column < matrix[0].length; column++) {
            boolean delete = true;
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][column] != 0) {
                    delete = false;
                    break;
                }
            }
            if (delete) {
                matrix = delColumn(matrix, column);
            }
        }
        return matrix;
    }

    public void showTrimMatrix() {
        int[][] matrix = getMatrixNxN();
        System.out.println("Trim matrix:");
        printMatrix(trimMatrix(matrix));
    }

}
