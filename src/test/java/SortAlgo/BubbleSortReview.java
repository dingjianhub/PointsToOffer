package SortAlgo;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.jar.JarEntry;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name SortAlgo
 * @description
 * @create 2020/09/24 14:49
 **/

public class BubbleSortReview {

    public int[] bubbleSort(int[] arr, int length) {
        int i, j;
        int tmp;
        // 需要冒泡 length - 1 轮
        for (i = 0; i < length - 1; i++) {
            // 第 i 轮下，继续将较大的数字 向后“冒”
            for (j = 0; j < length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    @Test
    public void testBubbleSort() {
        int[] res = bubbleSort(new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9}, 9);
        System.out.println("普通冒泡排序，双重循环无优化 " + Arrays.toString(res));

        int[] res1 = new int[1000];
        for (int i = 0; i < res1.length; i++) {
            res1[i] = (int) (Math.random() * 1000 % 1000);
        }
        int[] res2 = bubbleSort(res1, res1.length);
        for (int i = 0; i < 50; i++) {
            int[] tmp = new int[20];
            for (int j = 0; j < tmp.length; j++) {
                tmp[j] = res2[i * 20 + j];
            }
            System.out.println(Arrays.toString(tmp));
        }
    }



    /*----------------------------------------------------------------------------------------------------*/


    // 一次优化版本
    public int[] bubbleSortWithOptimizationAsc(int[] arr, int length) {
        int i, j;
        int tmp;
        boolean swapped;
        // 冒泡需要排序 length - 1 趟
        for (i = 0; i < length - 1; i++) {
            // 每轮的循环
            swapped = false;
            for (j = 0; j < length - 1; j++) {
                if (arr[j] < arr[j + 1]) {
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

    @Test
    public void testBubbleSortWithOptimizationAsc() {
        int[] res = new int[1000];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) (Math.random() * 1000 % 1000);
        }
        int[] res1 = bubbleSortWithOptimizationAsc(res, res.length);
        System.out.println("冒泡排序，双重循环 一次优化 ");
        for (int i = 0; i < 50; i++) {
            int[] tmp = new int[20];
            for (int j = 0; j < tmp.length; j++) {
                tmp[j] = res1[i * 20 + j];
            }
            System.out.println(Arrays.toString(tmp));
        }
    }


    /*----------------------------------------------------------------------------------------------------*/


    // 两次优化版本
    public int[] bubbleSortWithOptimizationTwo(int[] arr, int length) {
        int i, j;
        int tmp;
        boolean swapped;
        int lastSwappedIndex = 0; // 记录最后一次交换的位置
        int sortBorder = length - 1; // 有序和无序的分界线
        // 冒泡需要排序 length - 1 趟
        for (i = 0; i < length - 1; i++) {
            // 每轮的循环
            swapped = false;
            for (j = 0; j < sortBorder; j++) {
                if (arr[j] < arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                    lastSwappedIndex = j;
                }
            }

            sortBorder = lastSwappedIndex;
            if (!swapped) {
                break;
            }
        }
        return arr;
    }


    @Test
    public void testBubbleSortWithOptimizationTwo() {
        int[] res = new int[100000];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) (Math.random() * 100000 % 100000);
        }
        int[] res1 = bubbleSortWithOptimizationTwo(res, res.length);
        System.out.println("冒泡排序，双重循环 两次优化 ");
        for (int i = 0; i < 5000; i++) {
            int[] tmp = new int[20];
            for (int j = 0; j < tmp.length; j++) {
                tmp[j] = res1[i * 20 + j];
            }
            System.out.println(Arrays.toString(tmp));
        }
    }


    /*----------------------------------------------------------------------------------------------------------*/


    // 递归实现冒泡排序
    public int[] bubbleSortRecursion(int[] arr, int length) {
        if (length == 1) {
            return arr;
        }


        // 冒泡排序一趟
        // 结束后，末尾的数字最大
        // 然后递归地开始排序 前面的 length - 1 个
        for (int j = 0; j < length - 1; j++) {
            int tmp;
            if (arr[j] > arr[j + 1]) {
                tmp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = tmp;
            }
        }

        bubbleSortRecursion(arr, length - 1);

        return arr;
    }


    @Test
    public void testBubbleSortRecursion() {
        int[] res = new int[1000];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) (Math.random() * 1000 % 1000);
        }
        int[] res1 = bubbleSortRecursion(res, res.length);
        System.out.println("冒泡排序 递归实现 无优化");
        for (int i = 0; i < 50; i++) {
            int[] tmp = new int[20];
            for (int j = 0; j < tmp.length; j++) {
                tmp[j] = res1[i * 20 + j];
            }
            System.out.println(Arrays.toString(tmp));
        }
    }

    /*----------------------------------------------------------------------------------------*/

    /**
     * <p>
     * 使用 栈 辅助，实现冒泡排序
     * </p>
     *
     * @param arr    需要排序的数组
     * @param length 数组的长度
     * @return 排序后的数组
     */
    public int[] bubbleSortUsingStack(int[] arr, int length) {
        Deque<Integer> stack1 = new LinkedList<>();

        for (Integer integer : arr) {
            stack1.offerLast(integer);
        }

        Deque<Integer> stack2 = new LinkedList<>();

        // 注意，这里需要 length 次的循环
        // 每次的栈操作，会产生一个当前的最大值，所以需要 length 次
        for (int i = 0; i < length; i++) {
            if (i % 2 != 0) { // 如果是奇数，那么采用 stack1 -> stack2 的操作
                while (!stack1.isEmpty()) {
                    int tmp = stack1.pollLast();

                    if (stack2.isEmpty()) {
                        stack2.offerLast(tmp);
                    } else {
                        if (stack2.peekLast() > tmp) {
                            int t = stack2.pollLast();
                            stack2.offerLast(tmp);
                            stack2.offerLast(t);
                        } else {
                            stack2.offerLast(tmp);
                        }
                    }
                }
                arr[length - i - 1] = stack2.pollLast();
            } else { // 此时 stack2 中装满了元素
                while (!stack2.isEmpty()) {
                    int tmp = stack2.pollLast();

                    if (stack1.isEmpty()) {
                        stack1.offerLast(tmp);
                    } else {
                        if (stack1.peekLast() > tmp) {
                            int t = stack1.pollLast();
                            stack1.offerLast(tmp);
                            stack1.offerLast(t);
                        } else {
                            stack1.offerLast(tmp);
                        }
                    }
                }
                arr[length - i - 1] = stack1.pollLast();
            }
        }
        return arr;
    }

    @Test
    public void testBubbleSortUsingStack() {
        int[] res = new int[1000];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) (Math.random() * 1000 % 1000);
        }
        int[] res1 = bubbleSortRecursion(res, res.length);
        System.out.println("冒泡排序 递归实现 无优化");
        for (int i = 0; i < 50; i++) {
            int[] tmp = new int[20];
            for (int j = 0; j < tmp.length; j++) {
                tmp[j] = res1[i * 20 + j];
            }
            System.out.println(Arrays.toString(tmp));
        }
    }

    /*--------------------------------------------------------------------------------------*/

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

        ListNode ptr = head;
        boolean swapped = false;
        while (!swapped) {
            while (ptr.next != null) {
                if (ptr.val > ptr.next.val) {
                    int tmp = ptr.val;
                    ptr.val = ptr.next.val;
                    ptr.next.val = tmp;
                    swapped = true;
                }
                ptr = ptr.next;
            }
            if (!swapped) {
                break;
            }

            ptr = head;
            swapped = false;
        }
        return head;
    }


    @Test
    public void testBubbleSortListNode() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next.next.next = new ListNode(2);
        head = bubbleSortListNode(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
