package SortAlgo;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name sortAlgo
 * @description
 * @create 2020/09/23 11:03
 **/

public class BubbleSort {
    public static int[] bubbleSortRaw(int[] arr, int length) {
        int i, j;
        int tmp;
        // 第一轮 冒泡 结束后，末尾元素是 数组 中最大的元素
        for (i = 0; i < length - 1; i++)
            // 每一次找出一个元素的合适位置
            for (j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }

            }
        return arr;
    }

    /**
     * 一次优化的方式
     * 冒泡排序中，一轮排序下来没有交换，则已经有序，退出 for 循环
     * 通过 第二层 循环中 if 条件来控制 asc/desc
     * <p>
     * 这里我们增加了一个标识数组是否有序的布尔变量 swapped
     * 当冒泡排序过程中没有交换操作时，swapped = false ，也意味着数组有序；
     * 否则数组无序继续进行冒泡排序。
     * 不要小看这个变量，因为这个变量，当数组有序的时候，冒泡排序的时间复杂度将降至 O(n)
     * 因为其只需要执行一遍内层的 for 循环就可以结束冒泡排序
     * 没有这个变量，数组有序也需要 O(n ^ 2) 的时间复杂度
     * </p>
     *
     * @param arr    需要排序的数组
     * @param length 数组的长度
     * @return 排序后的数组
     */
    public static int[] bubbleSortWithOptimizationAsc(int[] arr, int length) {
        int i, j;
        int tmp;
        boolean swapped; // 记录数组是否已经有序
        for (i = 0; i < length - 1; i++) {
            swapped = false;
            // 每一次找出一个元素的合适位置
            for (j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) { // 大于交换，等于不交换
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
        return arr;
    }

    /**
     * 一次优化的方式
     * 冒泡排序中，一轮排序下来没有交换，则已经有序，退出 for 循环
     * 通过 第二层 循环中 if 条件来控制 asc/desc
     * <p>
     * 这里我们增加了一个标识数组是否有序的布尔变量 swapped
     * 当冒泡排序过程中没有交换操作时，swapped = false ，也意味着数组有序；
     * 否则数组无序继续进行冒泡排序。
     * 不要小看这个变量，因为这个变量，当数组有序的时候，冒泡排序的时间复杂度将降至 O(n)
     * 因为其只需要执行一遍内层的 for 循环就可以结束冒泡排序
     * 没有这个变量，数组有序也需要 O(n ^ 2) 的时间复杂度
     * </p>
     *
     * @param arr    需要排序的数组
     * @param length 数组的长度
     * @return 排序后的数组
     */
    public static int[] bubbleSortWithOptimizationDesc(int[] arr, int length) {
        int i, j;
        int tmp;
        boolean swapped; // 记录数组是否已经有序
        for (i = 0; i < length - 1; i++) {
            swapped = false;
            // 每一次找出一个元素的合适位置
            for (j = 0; j < length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) { // 小于交换，否则不交换
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
        return arr;
    }


    /**
     * <p>
     * 两次次优化的方式。
     * 思考一个情况，如果经过几次 冒泡排序 后，数组尾部的数据已经有序了，那么这些有序的部分，
     * 不需要比较也不需要交换了，例如 [4,2,1,5,6,8]，
     * 有序和无序的分界点是 1 和 5 之间。
     * 只要确定出这个区间来，对前面的无序部分进行排序就可以了。
     * 这个边界就是上一趟冒泡排序的过程中最后一次发生交换的位置 j 。
     * </p>
     * <p>
     * 相比于一次优化的实现方式，二次优化的实现方式进一步减少了不必要的执行次数，
     * 两种优化后的实现方式需要冒泡排序的趟数是一样的，本质上没有什么区别。
     * 所以即使对于一个有序的数组，两种方式的时间复杂度都是 O(n) 。
     * </p>
     *
     * @param arr    需要排序的数组
     * @param length 数组的长度
     * @return 排序后的数组
     */
    public static int[] bubbleSortWithOptimizationTwo(int[] arr, int length) {
        int i, j;
        int tmp;
        boolean swapped; // 记录数组是否已经有序
        int lastSwappedIndex = 0; // 记录最后一次交换的位置
        int sortBorder = length - 1; // 将有序和无序的边界部分初始化为最后一个元素
        for (i = 0; i < length - 1; i++) {
            swapped = false;
            // 每一次找出一个元素的合适位置
            for (j = 0; j < sortBorder; j++) {
                if (arr[j] > arr[j + 1]) { // 大于交换，否则不交换
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                    lastSwappedIndex = j;
                }
            }
            sortBorder = lastSwappedIndex;
            // 如果没有交换，数组有序，退出排序
            if (!swapped) {
                break;
            }
        }
        return arr;
    }

    /****************************************************************************************************/


    /**
     * <p>
     * 使用递归的方式实现冒泡排序
     * 函数功能：进行一趟冒泡排序
     * </p>
     * <p>
     * 1.明确这个函数想要干什么
     * 2.寻找递归结束的条件
     * 3.找出函数的等价关系式
     * </p>
     *
     * @param arr    需要排序的数组
     * @param length 数组的长度
     * @return 排序后的数组
     */
    public static void bubbleSortWithOptimizationRecursion(int[] arr, int length) {
        // 2.寻找递归结束条件
        // 如果数组只有一个一个元素时，有序，返回
        if (length == 1) {
            return;
        }

        // 3.找出函数的等价关系式
        // 进行一趟冒泡排序
        for (int i = 0; i < length - 1; i++) {
            // 每一次找出一个元素的合适位置
            if (arr[i] > arr[i + 1]) { // 大于交换，否则不交换
                // 交换 arr[i], arr[i + 1]
                int tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
            }
        }

        // 找到了数组最大的元素
        // 递归对除最大元素之外的数组进行冒泡排序
        bubbleSortWithOptimizationRecursion(arr, length - 1);
    }


    /**
     * <p>
     * 使用冒泡排序实现 字符串 数组的排序
     * </p>
     *
     * @param arr    需要排序的数组
     * @param length 数组的长度
     * @return 排序后的数组
     */
    public static String[] bubbleSortString(String[] arr, int length) {
        int i, j;
        String tmp;
        for (i = 0; i < length; i++) {
            for (j = 0; j < length - 1; j++) {
                // 每一次找出一个元素的合适位置
                if (arr[j].compareTo(arr[j + 1]) > 0) { // 大于交换，否则不交换
                    // 交换 arr[i], arr[i + 1]
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }


    /**
     * <p>
     * 使用 栈 辅助，实现冒泡排序
     * </p>
     *
     * @param arr    需要排序的数组
     * @param length 数组的长度
     * @return 排序后的数组
     */
    public static int[] bubbleSortUsingStack(int[] arr, int length) {
        Deque<Integer> stack1 = new LinkedList<>();
        // 将 arr 中的数字依次压入到 栈 中
        for (int i : arr) {
            stack1.offerLast(i);
        }

        Deque<Integer> stack2 = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            // 初始时 stack1 不为空，使用 i 的奇偶来决定将哪一个栈中的元素转移到另外一个栈
            // 如果为 偶数，那么需要将 stack1 中的数据转移到 stack2 中去
            // 反之，如果 i 为奇数，说明数据此时在 stack2 中，需要转移到 stack1 中去
            if (i % 2 == 0) {
                while (!stack1.isEmpty()) {
                    int tmp = stack1.pollLast();

                    if (stack2.isEmpty()) { // 如果此时 stack2 为空，说明只有一个元素，那么直接压入 stack2 即可
                        stack2.offerLast(tmp);
                    } else {
                        if (stack2.peekLast() > tmp) { // stack2 顶部元素要大
                            int t = stack2.pollLast(); // 弹出 stack2 顶部元素
                            stack2.offerLast(tmp); // 将较小的 tmp 压入
                            stack2.offerLast(t); // 最后将较大的 t 压入，保证 stack2 的栈顶始终是最大值
                        } else {
                            stack2.offerLast(tmp); // stack2 栈顶元素较小，直接把 tmp 压入 stack2 即可
                        }
                    }
                }
                // stack1 空后，stack2 的栈顶元素为本趟冒泡的最大值
                // 找到的最大元素的正确位置 length - i - 1
                arr[length - i - 1] = stack2.pollLast();
            } else { // 偶数情况下，此时 stack2 是存储了元素，stack1 为空
                while (!stack2.isEmpty()) {
                    int tmp = stack2.pollLast();

                    if (stack1.isEmpty()) { // 如果 stack1 为空，直接压入到 stack1 即可
                        stack1.offerLast(tmp);
                    } else { // stack1 不为空
                        if (stack1.peekLast() > tmp) { // stack1 的栈顶元素较大
                            int t = stack1.pollLast(); // 那么需要先弹出 stack1 的栈顶元素
                            stack1.offerLast(tmp); // 将较小的 tmp 压入
                            stack1.offerLast(t); // 再将较大的原先的栈顶元素压入
                        } else {
                            stack1.offerLast(tmp); // tmp 元素大于栈顶元素，是更大的值，直接压入即可
                        }
                    }
                }
                // stack2 空后，stack1 的栈顶元素是本趟冒泡排序的最大值
                // 找到的最大元素的正确位置 length - i - 1
                arr[length - i - 1] = stack1.pollLast();
            }
        }
        return arr;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }


    /**
     * <p>
     * 对单项链表实现冒泡排序
     * </p>
     *
     * @param head 需要排序的单向链表的头
     * @return 排序后的数组
     */
    public static ListNode bubbleSortListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode ptrLeft = head;
        boolean swapped = false; // 标记是否有过交换
        while (!swapped) { // 如果没有交换，有序，则退出循环
            while (ptrLeft.next != null) { // 如果不是最后一个节点，那么进行前后节点值的判断，仅仅交换节点值
                if (ptrLeft.val > ptrLeft.next.val) {
                    int tmp = ptrLeft.val;
                    ptrLeft.val = ptrLeft.next.val;
                    ptrLeft.next.val = tmp;
                    swapped = true;
                }
                ptrLeft = ptrLeft.next; // ptr 指针向后移动
            }

            if (!swapped) {
                break;
            }
            ptrLeft = head; // 重新进行新的一趟冒泡排序
            swapped = false; // 标记 swapped 的原始值
        }

        return head;
    }


    /*--------------------------------------------------------------------------------------------*/

    public static void main(String[] args) {
        int[] res = bubbleSortRaw(new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9}, 9);
        System.out.println("普通冒泡排序，双重循环无优化 " + Arrays.toString(res));

        int[] res1 = bubbleSortWithOptimizationAsc(new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9}, 9);
        System.out.println("冒泡排序 一次优化 升序 " + Arrays.toString(res1));

        int[] res2 = bubbleSortWithOptimizationDesc(new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9}, 9);
        System.out.println("冒泡排序 一次优化 降序 " + Arrays.toString(res2));

        int[] res3 = bubbleSortWithOptimizationTwo(new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9}, 9);
        System.out.println("冒泡排序 两次优化 升序 " + Arrays.toString(res3));


        int[] res4 = new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9};
        bubbleSortWithOptimizationRecursion(res4, 9);
        System.out.println("递归实现冒泡排序 " + Arrays.toString(res4));

        String[] res5 = bubbleSortString(new String[]{"abc", "efg", "gkh", "kem", "iow", "fow", "zie"}, 7);
        System.out.println("冒泡排序 实现 对字符串的排序 " + Arrays.toString(res5));


        int[] res6 = bubbleSortUsingStack(new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9}, 9);
        System.out.println("冒泡排序 栈辅助实现 升序 " + Arrays.toString(res6));


        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head = bubbleSortListNode(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

