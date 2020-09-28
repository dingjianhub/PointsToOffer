package SortAlgo;

import java.util.Arrays;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name SortAlgo
 * @description
 * @create 2020/09/26 18:03
 **/

/**
 * 基数排序
 * 其中使用到了 计数排序
 */
public class RadixSort {
    public int[] arr;

    public RadixSort(int[] arr) {
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
                System.out.println("排序失败，以下数据排序失败");
                System.out.println(arr[i] + " : " + arr[i + 1]);
                return false;
            }
        }
        return true;
    }

    /**
     * 求解数组的最大值
     *
     * @return
     */
    public int getMax() {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    public void countSort(int exp, int length) {
        int[] output = new int[length];

        int[] count = new int[10]; // 计数排序，计数范围从 0 ~ 9

        // 统计数组中元素第 exp 位的数目
        for (int i = 0; i < length; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // 对 count 数组进行转换
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 进行计数排序
        for (int i = length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // 输出到数组中
        if (length >= 0) {
            System.arraycopy(output, 0, arr, 0, length);
        }
    }

    public void radixSort(int length) {
        // 获取最大的数字
        int maxNumber = getMax();
        // 按照数字位数据进行 计数排序
        // 从 低位 到 高位 进行计数排序
        for (int exp = 1; maxNumber / exp > 0; exp *= 10) {
            countSort(exp, length);
        }
    }


    public static void main(String[] args) {
        // 随机生成测试数据
        int resLength = 2000;
        int[] res = new int[resLength];
        for (int i = 0; i < resLength; i++) {
            int number = ((int) (Math.random() * resLength) % resLength);
            res[i] = number;
        }

        // 输出 排序后的数据
        RadixSort radixSort = new RadixSort(res);
        radixSort.radixSort(res.length);
        int p = 0;
        for (int i = 0; i < 100; i++) {
            int t = resLength / 100;
            int[] tmp = new int[t];
            for (int j = 0; j < t; j++) {
                tmp[j] = res[p++];
            }
            System.out.println(Arrays.toString(tmp));
        }
        System.out.println(radixSort.verifySort());
    }
}
