package ManualMake.heap;

import java.util.Arrays;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ManualMake.heap
 * @description
 * @create 2020/09/27 13:06
 **/

public class Heap {
    public int[] harr;
    public int INT_MAX = Integer.MAX_VALUE;
    public int INT_MIN = Integer.MIN_VALUE;
    public int HEAP_SIZE;
    public int HEAP_CAPACITY;

    public Heap() {
    }

    public Heap(int[] harr, int HEAP_SIZE, int HEAP_CAPACITY) {
        this.harr = harr;
        this.HEAP_SIZE = HEAP_SIZE;
        this.HEAP_CAPACITY = HEAP_CAPACITY;
    }

    /**
     * 获取堆中的最小元素
     *
     * @return 堆中的最小元素的值
     */
    public int getMin() {
        return harr[0];
    }

    /**
     * 获取节点 i 的 父节点
     *
     * @param i 节点的编号
     * @return i 的父节点
     */
    public int parent(int i) {
        if (i == 0) {
            return 0;
        }
        return ((i - 1) / 2);
    }

    /**
     * 获取节点的左孩子
     *
     * @param i 节点的编号
     * @return
     */
    public int left(int i) {
        return 2 * i + 1;
    }

    /**
     * 获取节点的右孩子
     *
     * @param i 节点的编号
     * @return
     */
    public int right(int i) {
        return 2 * i + 2;
    }

    /**
     * 交换两个节点的值
     *
     * @param i1 节点 1 的 idx
     * @param i2 节点 2 的 idx
     */
    public void swap(int i1, int i2) {
        int tmp = harr[i1];
        harr[i1] = harr[i2];
        harr[i2] = tmp;
    }

    public int removeMin() {
        if (HEAP_SIZE <= 0) {
            return INT_MAX;
        }
        if (HEAP_SIZE == 1) {
            HEAP_SIZE--;
            return harr[0];
        }

        // 存储最小值（当前的堆顶的元素）
        // 将堆中的最后一个元素放到堆顶
        // 然后进行 Heapify() 堆化
        int rootVal = harr[0];
        harr[0] = harr[HEAP_SIZE - 1];
        HEAP_SIZE--;
        MinHeapify(0);

        return rootVal;
    }

    /**
     * 堆化，堆化成小顶堆
     *
     * @param i 节点的编号
     */
    public void MinHeapify(int i) {
        int leftIdx = left(i);
        int rightIdx = right(i);

        int smallest = i;


        // 计算出 左孩子，右孩子和 父节点 这三者中的最小值
        if (leftIdx < HEAP_SIZE && harr[leftIdx] < harr[smallest]) {
            smallest = leftIdx;
        }

        if (rightIdx < HEAP_SIZE && harr[rightIdx] < harr[smallest]) {
            smallest = rightIdx;
        }

        if (smallest != i) {
            swap(i, smallest);
            // 交换完毕后，smallest 此时已经不是最小值了
            // 继续向下进行堆化操作
            MinHeapify(smallest);
        }
    }

    /**
     * 插入数据到堆中去
     * 时间复杂度为 O(log n)
     *
     * @param newVal 需要插入的数据 newVal
     */
    public void insert(int newVal) {
        if (HEAP_SIZE == HEAP_CAPACITY) {
            System.out.println("Out Of Memory");
            return;
        }

        // 将新插入的结点插入最后一个位置 HEAP_SIZE - 1
        HEAP_SIZE++;
        int idx = HEAP_SIZE - 1;
        harr[idx] = newVal;

        while (idx != 0 && harr[parent(idx)] > harr[idx]) {
            swap(idx, parent(idx));
            idx = parent(idx);
        }
    }

    /**
     * 更新指定下标的值
     *
     * @param i      指定的下标，下标从 0 开始
     * @param newVal 更新到最新的值
     */
    public void updateKey(int i, int newVal) {
        if (newVal < harr[i]) { // 当 newVal 小于当前值，判断是否要更新 parent 节点即可
            harr[i] = newVal;
            while (i != 0 && harr[parent(i)] > harr[i]) {
                swap(i, parent(i));
                i = parent(i);
            }
        } else { // 大于当前值，则需要考虑堆化，保持小顶堆的特性不变
            harr[i] = newVal;
            MinHeapify(i);
        }
    }

    /**
     * 删除指定的节点
     *
     * @param i 要删除的节点的编号
     */
    public void delete(int i) {
        updateKey(i, INT_MIN); // 要删除的节点使用无穷小来替换
        removeMin(); // 将堆顶的元素移除
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

        int[] smallRes = new int[10];
        Heap smallHeap = new Heap(smallRes, 0, smallRes.length);
        smallHeap.insert(5);
        smallHeap.insert(1);
        smallHeap.insert(4);
        smallHeap.insert(2);
        smallHeap.insert(8);
        smallHeap.insert(7);
        System.out.println(Arrays.toString(smallRes));
        smallHeap.updateKey(3, 11);
        System.out.println(Arrays.toString(smallRes));
        smallHeap.delete(4);
        System.out.println(Arrays.toString(smallRes));

        int[] minRes = new int[10];
        int pos = 0;
        for (int i = 0; i < minRes.length; i++) {
            int t = smallHeap.removeMin();
            if (t != Integer.MAX_VALUE) {
                minRes[pos] = t;
                pos++;
            }
        }
        System.out.println("验证是否具有小顶堆的性质 : " + Arrays.toString(minRes));


        /*-------------------------------------------------------------------------------------*/

        // 随机生成测试数据
        int resLength = 2000;
        int[] res = new int[resLength];
        for (int i = 0; i < resLength; i++) {
            int number = ((int) (Math.random() * resLength) % resLength);
            res[i] = number;
        }

        Heap heap = new Heap(new int[resLength + 10], 0, resLength + 10);
        for (int i = 0; i < resLength; i++) {
            heap.insert(res[i]);
        }
        int[] sortArray = new int[2000];
        for (int i = 0; i < resLength; i++) {
            sortArray[i] = heap.removeMin();
        }
        int p = 0;
        for (int i = 0; i < 100; i++) {
            int t = resLength / 100;
            int[] tmp = new int[t];
            for (int j = 0; j < t; j++) {
                tmp[j] = sortArray[p++];
            }
            System.out.println(Arrays.toString(tmp));
        }
        System.out.println("是否具有小顶堆的性质 : " + heap.verifySort(sortArray));
    }
}
