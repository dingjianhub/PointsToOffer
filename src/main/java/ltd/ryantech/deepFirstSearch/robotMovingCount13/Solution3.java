package ltd.ryantech.deepFirstSearch.robotMovingCount13;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.deepFirstSearch.robotMovingCount13
 * @description 机器人的运动范围
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * @hard_level Medium
 * @leetcdoe_Tag 深度优先搜索 // https://leetcode-cn.com/tag/depth-first-search/
 * @create 2020/05/08 19:42
 **/

public class Solution3 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0});
        while (queue.size() > 0) {
            int[] x = queue.poll();
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            if (i >= m || j >= n || si + sj > k || visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            res++;
            // BFS 方向为 下 右
            queue.add(new int[]{i + 1, j, (i + 1 % 10) != 0 ? si + 1 : si - 8, sj});
            queue.add(new int[]{i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8});
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().movingCount(3, 4, 2));
    }
}
