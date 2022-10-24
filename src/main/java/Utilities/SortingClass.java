package Utilities;

import Data.Car;

import java.util.ArrayList;
import java.util.List;

public class SortingClass {

    public enum SortByEnum {
        PRICE,
        MARK,
        EFFICIENCY,
        COLOR
    }

    public static void mergeSort(List<Car> array, SortByEnum s, int n) {

        if (n < 2) return;
        int middleIndex = n / 2;

        ArrayList<Car> leftArray = new ArrayList<Car>();
        ArrayList<Car> rightArray = new ArrayList<Car>();


        for (int i = 0; i < middleIndex; i++) {
            leftArray.add(array.get(i));
        }
        for (int i = middleIndex; i < n; i++) {
            rightArray.add(array.get(i));
        }

        mergeSort(leftArray, s, middleIndex);
        mergeSort(rightArray, s, n - middleIndex);

        merge(leftArray, rightArray, array, middleIndex, n - middleIndex, s);

    }

    private static void merge(ArrayList<Car> leftArray, ArrayList<Car> rightArray, List<Car> array, int leftSize, int rightSize, SortByEnum s) {


        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (s == SortByEnum.PRICE) {
                if (leftArray.get(i).price() <= rightArray.get(j).price()) {
                    array.set(k++, leftArray.get(i++));
                } else {
                    array.set(k++, rightArray.get(j++));
                }
            } else if (s == SortByEnum.COLOR) {
                if ((leftArray.get(i).color()).compareToIgnoreCase(rightArray.get(j).color()) <= 0) {
                    array.set(k++, leftArray.get(i++));
                } else {
                    array.set(k++, rightArray.get(j++));
                }
            } else if (s == SortByEnum.MARK) {
                if ((leftArray.get(i).mark()).compareToIgnoreCase(rightArray.get(j).mark()) <= 0) {
                    array.set(k++, leftArray.get(i++));
                } else {
                    array.set(k++, rightArray.get(j++));
                }
            }
            else if (s == SortByEnum.EFFICIENCY) {
                if (leftArray.get(i).efficiency() <= rightArray.get(j).efficiency()) {
                    array.set(k++, leftArray.get(i++));
                } else {
                    array.set(k++, rightArray.get(j++));
                }
            }

        }

        while (i < leftSize) {
            array.set(k++, leftArray.get(i++));
        }
        while (j < rightSize) {
            array.set(k++, rightArray.get(j++));
        }

    }


}
