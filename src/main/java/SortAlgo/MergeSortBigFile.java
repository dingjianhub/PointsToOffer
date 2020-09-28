package SortAlgo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name SortAlgo
 * @description
 * @create 2020/09/26 12:57
 **/

public class MergeSortBigFile {
    /**
     * 最大可用内存空间
     */
    public static int maxMemorySize = 4;

    /**
     * 分割后的小文件，使用 List 存储起来
     */
    public static List<int[]> smallFiles = new LinkedList<>();

    /**
     * 分割后的小文件，使用 quickSort 排序完成
     * 使用 List 存储起来
     */
    public static List<int[]> smallFilesSorted = new LinkedList<>();

    /**
     * 最终输出的有序的文件
     */
    public static List<Integer> outputSortedFile = new LinkedList<>();

    /**
     * 输出缓冲区 outputSortedBuffer
     */
    public static int[] outputSortedBuffer = new int[maxMemorySize];

    // 划分为多个小的文件
    public static void divide(int[] arr) {
        int pos = 0;
        while (pos < arr.length) {
            int[] smallFile = new int[maxMemorySize];
            for (int i = 0; i < maxMemorySize && pos < arr.length; i++) {
                smallFile[i] = arr[pos++];
            }
            smallFiles.add(smallFile);
        }
//        System.out.println();
    }

    // 对小的文件使用 quickSort 进行排序
    public static void smallFilesSort() {
        for (int[] ints : smallFiles) {
            Arrays.sort(ints);
            smallFilesSorted.add(ints);
        }
//        System.out.println();
    }

    // 多路合并 这里选择四路合并
    // 一共需要 5 个指针
    public static void merge() {
        int smallFilesGroupSize = smallFilesSorted.size();

        int smallFilesPointer = 0;
        int outputSortedBufferPointer = 0;
        int smallFilesPointer1 = 0;
        int smallFilesPointer2 = 0;
        int smallFilesPointer3 = 0;
        int smallFilesPointer4 = 0;
        if (smallFilesGroupSize >= 4) {
            int[] smallFile1 = smallFilesSorted.get(smallFilesPointer++);
            int[] smallFile2 = smallFilesSorted.get(smallFilesPointer++);
            int[] smallFile3 = smallFilesSorted.get(smallFilesPointer++);
            int[] smallFile4 = smallFilesSorted.get(smallFilesPointer++);

            while (smallFilesPointer1 < maxMemorySize &&
                    smallFilesPointer2 < maxMemorySize &&
                    smallFilesPointer3 < maxMemorySize &&
                    smallFilesPointer4 < maxMemorySize) {
                int maxElement1 = Math.max(smallFile1[smallFilesPointer1], smallFile2[smallFilesPointer2]);
                int maxElement2 = Math.max(smallFile3[smallFilesPointer3], smallFile4[smallFilesPointer4]);
                int maxElementLast = Math.max(maxElement1, maxElement2);

            }
            int[] readySort = new int[maxMemorySize];
            while (smallFilesPointer < smallFilesGroupSize) {
                for (int i = 0; i < maxMemorySize; i++) {
                    readySort[i] = smallFilesSorted.get(smallFilesPointer)[i];

                }
                smallFilesPointer++;
            }
        } // end of if
    }// end of func


    public static void main(String[] args) {
        int[] res1 = new int[]{3, 7, 15, 4, 11, 9, 13, 2, 10, 14, 5, 6, 12, 8, 1, 16, 17};
        divide(res1);
        smallFilesSort();
        merge();
        System.out.println("归并排序 多路归并排序 升序排序 " + Arrays.toString(outputSortedFile.toArray()));
    }
}
