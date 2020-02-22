package sparearray;

/**
 * 稀疏数组
 * 用稀疏数组保存数据，可以压缩数据的大小
 */
public class SpareArray {

    /**
     * 构建初始数据
     * @return
     */
    private static int[][] createInitData() {
        int[][] dataArr = new int[10][10];
        dataArr[2][3] = 1;
        dataArr[3][4] = 2;
        dataArr[4][5] = 1;
        dataArr[9][9] = 2;
        return dataArr;
    }

    /**
     * 打印二维数组
     * @param dataArr
     */
    private static void printTwoDimensionalArray(int[][] dataArr) {
        for (int[] row : dataArr) {
            for (int item : row) {
                System.out.print(String.format("%d\t",item));
            }
            System.out.println();
        }
    }

    /**
     * 寻找不为0的数据的数量
     * @param dataArr
     * @return
     */
    private static int getInvalidDataCount(int[][] dataArr) {
        int count = 0;
        for (int[] row : dataArr) {
            for (int item : row) {
                if(item != 0){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 创建稀疏数组
     * 第一行统计二维数组行列数量及有几个有效数字
     * 之后的行记录有效数字的位置及值
     * @param dataArr 原始数组
     * @param count 有效数据个数
     * @return
     */
    private static int[][] generateSpareArray(int[][] dataArr, int count) {
        int[][] spareArr = new int[count+1][3];
        // 疏松数组第一行赋值
        spareArr[0][0] = dataArr.length;
        spareArr[0][1] = dataArr[0].length;
        spareArr[0][2] = count;

        int index = 1;
        for (int row = 0; row < dataArr.length; row++) {
            for (int column = 0; column < dataArr[row].length; column++) {
                if (dataArr[row][column] != 0) {
                    spareArr[index][0] = row;
                    spareArr[index][1] = column;
                    spareArr[index][2] = dataArr[row][column];
                    index++;
                }
            }
        }
        return spareArr;
    }


    public static void main(String[] args) {
        int[][] dataArr = createInitData();
        System.out.println(" ===== 遍历原始数据 =====");
        printTwoDimensionalArray(dataArr);

        // 统计有几个有效数据
        int count = getInvalidDataCount(dataArr);
        int[][] spareArr = generateSpareArray(dataArr, count);

        System.out.println(" ===== 遍历稀疏数组 =====");
        printTwoDimensionalArray(spareArr);

        System.out.println(" ===== 遍历还原后的数据 =====");
        int[][] restoreData = new int[spareArr[0][0]][spareArr[0][1]];
        for (int i = 1; i < spareArr.length; i++) {
            restoreData[spareArr[i][0]][spareArr[i][1]] = spareArr[i][2];
        }
        printTwoDimensionalArray(restoreData);
    }
}
