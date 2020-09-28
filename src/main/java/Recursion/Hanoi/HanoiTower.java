package Recursion.Hanoi;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name Recursion
 * @description
 * @create 2020/09/24 13:46
 **/

public class HanoiTower {
    /**
     * 求解 汉诺塔 HanoiTower
     * 递归实现
     *
     * @param n 盘子的数量
     * @param x 柱子 x，从左向右的第 1 个柱子
     * @param y 柱子 y，从左向右的第 2 个柱子
     * @param z 柱子 z，从左向右的第 3 个柱子
     */
    public void move(int n, char x, char y, char z) {
        if (n == 1) {
            // 如果只有 1 个盘子，那么直接从 x -> z 即可
            System.out.println(x + " -> " + z);
        } else {
            // 将 x 上面的 n - 1 个盘子，通过 y 的辅助，移动到 z 上
            move(n - 1, x, z, y);
            // 移动 x 最下面的最大的盘子，从 x 移动到 z 上去
            System.out.println(x + " -> " + z);
            // 将 y 上剩余的 n - 1 个盘子，通过 x 的辅助，移动到 z 上去
            move(n - 1, y, x, z);
            // 至此，完成了移动
        }
    }


    /**
     * 描述当前 汉诺塔 的情况
     */
    class HanoiStruct {
        int n;
        char x;
        char y;
        char z;

        public HanoiStruct(int n, char x, char y, char z) {
            this.n = n;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    /**
     * 求解 汉诺塔 HanoiTower
     * 非递归实现
     *
     * @param n 盘子的数量
     * @param x 柱子 x，从左向右的第 1 个柱子
     * @param y 柱子 y，从左向右的第 2 个柱子
     * @param z 柱子 z，从左向右的第 3 个柱子
     */
    public void moveUsingStack(int n, char x, char y, char z) {
        Deque<HanoiStruct> stack = new LinkedList<>();
        HanoiStruct hanoiOuter = new HanoiStruct(n, x, y, z);

        while (!(hanoiOuter.n == 0 && stack.isEmpty())) {
            HanoiStruct hanoiInner = hanoiOuter;

            while (hanoiInner.n > 0) {
                stack.addLast(hanoiInner);
                hanoiInner.n--;
                char tmp;
                tmp = hanoiInner.y;
                hanoiInner.y = hanoiInner.z;
                hanoiInner.z = tmp;
            }

            hanoiOuter = stack.pollLast();
            System.out.println(hanoiOuter.x + " -> " + hanoiOuter.z);
            hanoiOuter.n--;
            char tmp;
            tmp = hanoiOuter.x;
            hanoiOuter.x = hanoiOuter.y;
            hanoiOuter.y = tmp;
        }
    }

    public static void main(String[] args) {
        HanoiTower hanoiTower = new HanoiTower();
        System.out.println("n = 3 下的移动路径");
        hanoiTower.move(3, 'x', 'y', 'z');
        System.out.println("n = 6 下的移动路径");
        hanoiTower.move(6, 'x', 'y', 'z');

//        HanoiTower hanoiTower1 = new HanoiTower();
//        System.out.println("n = 3 下的移动路径 非递归");
//        hanoiTower1.moveUsingStack(3, 'x', 'y', 'z');
    }
}
