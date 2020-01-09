package com.visualizer.sortingAlgorithms.infrastructure;

import com.visualizer.sortingAlgorithms.domain.MergeSort;
import com.visualizer.sortingAlgorithms.domain.SortingService;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;


@Repository
public class SortingServiceImpl implements SortingService {

    private final int NUMBER_OF_ARRAY_BARS = 310;

    @Override
    public void mergeSortAlgorithms(int[] array, List<int[]> animations) {
        MergeSort mergeSort = new MergeSort();
        int[] auxiliaryArray = shuffleArray(array);
        printArray(auxiliaryArray);
        mergeSort.sort(array, 0, array.length - 1, auxiliaryArray, animations);
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    @Override
    public int[] generateArray(int start, int end) {

        int bars[] = new int[NUMBER_OF_ARRAY_BARS];
        Random r = new Random();

        for (int i = 0; i < bars.length; i++) {
            bars[i] = r.nextInt(end - start) + start;
        }

        return bars;
    }


    private int[] shuffleArray(int[] array) {
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            int temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }

        return array;
    }
}
