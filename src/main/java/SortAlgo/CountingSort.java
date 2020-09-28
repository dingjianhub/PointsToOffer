package SortAlgo;


/**
 * @author jerry
 * @program PointsToOffer
 * @package_name SortAlgo
 * @description
 * @create 2020/09/26 15:32
 **/

public class CountingSort {
    public int[] arr;

    public int maxArraySize = 4096;
    public int[] countArray = new int[maxArraySize];

    public CountingSort(int[] arr) {
        this.arr = arr;
    }

    /**
     * 验证排序是否成功
     *
     * @return
     */
    public boolean verifySort() {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println(arr[i] + " : " + arr[i + 1]);
                return false;
            }
        }
        return true;
    }


    public void countingSort() {
        for (int j : arr) {
            countArray[j]++;
        }
        int[] res = new int[arr.length];
        int p = 0;
        for (int i = 0; i < maxArraySize && p < arr.length; i++) {
            if (countArray[i] != 0) {
                for (int j = 0; j < countArray[i]; j++) {
                    res[p] = i + 1;
                    p++;
                }
            }
        }
        arr = res;
    }

    public static void main(String[] args) {
        int resLength = 2000;
        int[] res = new int[resLength];
        for (int i = 0; i < resLength; i++) {
            int number = ((int) (Math.random() * resLength) % resLength);
            res[i] = number;
        }

        CountingSort countingSort = new CountingSort(res);
        countingSort.countingSort();
        System.out.println(countingSort.verifySort());
    }
}
