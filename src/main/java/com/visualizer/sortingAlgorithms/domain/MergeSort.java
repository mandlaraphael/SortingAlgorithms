package com.visualizer.sortingAlgorithms.domain;

import java.util.List;

public class MergeSort {

   private void merge(int mainArray[], int startIdx, int middleIdx, int endIdx, int auxiliaryArray[], List<int[]> animations){
       int k = startIdx;
       int i = startIdx ;
       int j = middleIdx + 1;

       while (i <= middleIdx && j <= endIdx) {
            animations.add(new int[] {i, j});
            animations.add(new int[] {i, j});
           if (auxiliaryArray[i] <= auxiliaryArray[j]) {
               animations.add(new int[] {k, auxiliaryArray[i]});
               mainArray[k++] = auxiliaryArray[i++];
           }else {
               animations.add(new int[] {k, auxiliaryArray[j]});
               mainArray[k++] = auxiliaryArray[j++];
           }
       }
       while (i <= middleIdx) {
           animations.add(new int[] {i, i});
           animations.add(new int[] {i, i});
           animations.add(new int[] {k, auxiliaryArray[i]});
           mainArray[k++] = auxiliaryArray[i++];
       }
       while (j <= endIdx) {
           animations.add(new int[] {j, j});
           animations.add(new int[] {j, j});
           animations.add(new int[] {k, auxiliaryArray[j]});
           mainArray[k++] = auxiliaryArray[j++];
       }
   }

   public void sort(int array[], int startIndex, int lastIndex, int auxiliaryArray[], List<int[]> animations) {
        if (startIndex < lastIndex) {

            int middleIndex = (int) Math.floor((startIndex + lastIndex) / 2);

            sort(auxiliaryArray, startIndex, middleIndex, array, animations);
            sort(auxiliaryArray,middleIndex + 1, lastIndex, array, animations);

            merge(array, startIndex, middleIndex, lastIndex, auxiliaryArray, animations);
        }
    }
}
