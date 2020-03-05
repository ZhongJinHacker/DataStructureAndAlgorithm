package recursion;

/**
 * @author gradyjiang
 * @title: Queue8 八皇后问题
 * 所有的皇后不可以在一条直线或斜线上
 *
 * @projectName datastructure-and-algorithm
 * @description: TODO
 * @date 2020/2/29
 */

/**
 * 八皇后问题，是一个古老而著名的问题，是回溯算法的典型案例。该问题是国际西洋棋棋手马克斯·贝瑟尔于
 * 1848 年提出:在 8×8 格的国际象棋上摆放八个皇后，使其不能互相攻击，即:任意两个皇后都不能处于同一行、 同一列或同一斜线上
 * ，问有多少种摆法(92)。
 */
public class Queue8 {

    private final int queueCount = 8;

    public int resolveCount() {
        // 每一个index 表示所在的行，value 表示所在的列
        int [] plan = new int [8];
        return makePlans(plan, 0);
    }

    private int makePlans(int [] plan, int index) {
        // 但index等于8时，说明数组已经满了，找到了一种放法
        if (index == 8) {
            //printPlan(plan);
            return 1;
        }
        int count = 0;
        for (int i = 0; i < 8; i++) {
            plan[index] = i;
            if (judge(plan, index)) {
                // 这一层ok，试探下一层
                count += makePlans(plan, index + 1);
            }
        }
        return count;
    }

    /**
     * 检查新加入的位置是否合规
     * @param plan
     * @param index
     * @return
     */
    private boolean judge(int [] plan, int index) {
        for (int i = 0; i < index; i++) {
             // 首先不可能在一条直线上
             // 不在一列上plan[i] == plan[index]
             // 不在一条斜线上,两点的列差和行差不想等
            if (plan[i] == plan[index] || Math.abs(index - i) == Math.abs(plan[index] - plan[i])) {
                return false;
            }
        }
        return true;
    }

    private void printPlan(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
