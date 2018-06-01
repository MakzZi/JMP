package com.makzzi;

public class Main {

    public static void main(String[] args) {
        //ConsoleOperation createArray = new ConsoleOperation();
        ChapterTwo chapterTwo = new ChapterTwo();
        //String[] arrayNums = createArray.createNumberArray();
        //2.1.a//chapterTwo.showShortLongNumberInArray(arrayNums);
        //2.2.a//chapterTwo.showSortedArrayByLengthOfNumber(arrayNums);
        //2.3.a//chapterTwo.showGreaterAndLessThanAverageNumberInArray(arrayNums);
        //2.4.a//chapterTwo.showNumberWithMinimunUniqueDigits(arrayNums);
        //2.5.a//chapterTwo.showOnlyEvenOrSameEvenOddDigitsInNumbers(arrayNums);
        //2.6.a//chapterTwo.showNumberContainDigitsInAscendingOrder(arrayNums);
        //2.7.a//chapterTwo.showNumberConsistDifferentDigits(arrayNums);
        //2.8.a//chapterTwo.showPalindrome(arrayNums);
        //2.1.b//int k = 2, n = 2, m = 3;
        //       chapterTwo.showNumberBelongInterval(k, n, m);
        //2.2.b//chapterTwo.showMatrix(102);
        //2.3.b//chapterTwo.quadraticEquation();
        //2.4.b//chapterTwo.showMonth();
        //2.1.c//chapterTwo.sortRowMatrix(chapterTwo.getMatrixNxN(), 1);
        //       chapterTwo.sortColumnMatrix(chapterTwo.getMatrixNxN(), 1);
        //2.2.c//chapterTwo.moveMatrix();
        //2.3.c//chapterTwo.largestNumberElementsMatrixInAscendingOrder();
        //2.4.c//chapterTwo.sumBetweenFirstPositiveTwoNumbersInLine();
        //2.5.c//chapterTwo.transposeMatrix();
        //chapterTwo.determinantMatrix();
        int[][] matrix = {{1,2,3,10},{4,5,6,11},{7,8,9,12},{16,15,14,13}};
        chapterTwo.printMatrix(matrix);

        chapterTwo.fractionMatrix(matrix);
    }

}