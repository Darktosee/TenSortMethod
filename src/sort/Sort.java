package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sort {

    /**
     * 冒泡排序
     * @param arr
     * @return
     */
    public static int[]  Bubble_sort(int[] arr){
        for (int i = 0;i<arr.length;i++){
            for (int j = 0;j<arr.length-1-i;j++){
                if (arr[j+1]<arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 桶排序
     * @param list
     * @param bucketSize
     * @return
     */
    public static ArrayList<Integer> bucket_sort(ArrayList<Integer> list, Integer bucketSize) {

        ArrayList<Integer> resultList = new ArrayList<>();
        //找最大与最小值
        Integer min = list.get(0);
        Integer max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        /**
         * 桶数量
         */
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            arrayLists.add(new ArrayList<>());
        }
        for (int i = 0; i < list.size(); i++) {
            arrayLists.get((list.get(i) - min) / bucketSize).add(list.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            Collections.sort(arrayLists.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {

            for (int j = 0; j < arrayLists.get(i).size(); j++)
                resultList.add(arrayLists.get(i).get(j));
        }
        return resultList;

    }

    /**
     * 桶排序
     * @param arr
     * @return
     */
    public static int[] insert_sort(int[] arr) {
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {

                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                }
                else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
        return arr;
    }

    /**
     * 选择排序
     * @param arr
     * @return
     */
    public static int[] select_sort(int[] arr){

        for (int i = 0;i<arr.length;i++){
            int min = i;
            for (int j = i+1;j<arr.length;j++){
                if (arr[j]<arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

        }
        return arr;
    }

    /**
     * 希尔排序
     * @param arr
     * @return
     */
    public static int[] shell_sort(int[] arr) {
        System.out.println("begin："+ Arrays.toString(arr));
        int gap = arr.length / 2; //增量
        int temp,k = 1;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {

                temp = arr[i];
                int preIndex = i - gap;

                while (preIndex > 0 && arr[preIndex] > temp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;

                }
                arr[preIndex + gap] = temp;
            }
            gap = gap / 2;
            System.out.println("第"+ k++ +"趟："+ Arrays.toString(arr));
        }
        return arr;
    }
}
