package SortAlgo;

import java.util.Arrays;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name SortAlgo
 * @description
 * @create 2020/09/27 15:18
 **/

/**
 * 堆排序
 */
public class HeapSort {
    public int[] harr;

    public HeapSort(int[] harr) {
        this.harr = harr;
    }

    public HeapSort() {
    }

    public void heapSort(int[] harr) {
        int length = harr.length;

        // 建堆（你也可以考虑进行上面的插入操作）但是这里调用的是Heapify
        // 可以达到同样的建堆效果
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(harr, length, i);
        }

        // 从堆中一个一个地选择出最大元素
        for (int i = length - 1; i > 0; i--) {
            // 交换堆的根结点(最大元素)与当前最后一个元素(i)
            int tmp = harr[0];
            harr[0] = harr[i];
            harr[i] = tmp;

            // 在去掉最后一个元素的堆上进行堆化操作
            // 这里传入的 harr.length = i
            heapify(harr, i, 0);
        }
    }

    /**
     * 堆化操作
     * 因为是升序排序，所以需要使用到大顶堆
     *
     * @param harr   存储了堆的数组
     * @param length 堆的 size
     * @param i      节点的编号，从 0 开始
     */
    public void heapify(int[] harr, int length, int i) {
        int largest = i; // 初始化最大的元素为根节点
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // 如果左孩子节点比根节点大，更新 largest 为左孩子
        if (left < length && harr[left] > harr[largest]) {
            largest = left;
        }

        // 如果右孩子比最大元素大，更新 largest 为右孩子
        if (right < length && harr[right] > harr[largest]) {
            largest = right;
        }

        // 如果最大元素不是根节点，进行交换操作并递归调用 Heapify
        if (largest != i) {
            int tmp = harr[i];
            harr[i] = harr[largest];
            harr[largest] = tmp;

            // 对由于交换操作受到影响的子树递归调用Heapify
            heapify(harr, length, largest);
        }
    }


    /**
     * 验证排序是否成功
     *
     * @return
     */
    public boolean verifySort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println("排序失败，以下数据排序失败");
                System.out.println(arr[i] + " : " + arr[i + 1]);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8, 4};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);

        System.out.println(Arrays.toString(arr));

        // 随机生成测试数据
        int resLength = 2000;
        int[] res = new int[resLength];
        for (int i = 0; i < resLength; i++) {
            int number = ((int) (Math.random() * resLength) % resLength);
            res[i] = number;
        }
        heapSort.heapSort(res);
        System.out.println("输出随机生成的数据，其排序后的结果");
        int p = 0;
        for (int i = 0; i < 100; i++) {
            int t = resLength / 100;
            int[] tmp = new int[t];
            for (int j = 0; j < t; j++) {
                tmp[j] = res[p++];
            }
            System.out.println(Arrays.toString(tmp));
        }
        System.out.println(heapSort.verifySort(res));
    }
}
