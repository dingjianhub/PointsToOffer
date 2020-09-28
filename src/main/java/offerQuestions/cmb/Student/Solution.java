package offerQuestions.cmb.Student;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 现在需要对学生的学号进行分配
 * 按照学生报道的顺序分配学生的学号
 * 如果学号为偶数，那么分配到 A 班级
 * 如果学号为奇数，分配到 B 班级
 *
 * 请你将 【  】 内的代码补全
 *
 * */

class ClassA implements Runnable {
    private final Solution solution;

    public ClassA(Solution solution) {
        this.solution = solution;
    }

    @Override
    public void run() {
        while (Solution.count < this.solution.stuCount) { // 【 1 】
            try {
                this.solution.assignClassA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ClassB implements Runnable {
    private final Solution solution;

    public ClassB(Solution solution) {
        this.solution = solution;
    }

    @Override
    public void run() {
        while (Solution.count < this.solution.stuCount) { // 【 2 】
            try {
                this.solution.assignClassB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Solution {
    public static int count = 0;
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition assignClassA = reentrantLock.newCondition();
    Condition assignClassB = reentrantLock.newCondition();

    public int stuCount; // 学生的总的人数

    public Solution(int stuCount) {
        this.stuCount = stuCount;
    }

    private int sNO = 1; // 表示学生从 1 开始排序

    public void assignClassA() throws InterruptedException {
        reentrantLock.lock();
        try {
            if (sNO % 2 != 0) { // 【 3 】
                return; // 【 4 】
            }
            count++; // 【 5 】
            System.out.println(sNO + " 分配到了 A 班级");
            sNO++;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void assignClassB() throws InterruptedException {
        reentrantLock.lock();
        try {
            if (sNO % 2 == 0) { // 【 6 】
                return; // 【 7 】
            }
            count++;
            System.out.println(sNO + " 被分配到了 B 班级");
            sNO++; // 【 8 】
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(20);
        new Thread(new ClassA(solution)).start();
        new Thread(new ClassB(solution)).start();
    }
}
