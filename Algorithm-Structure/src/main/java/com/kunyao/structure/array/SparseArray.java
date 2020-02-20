package com.kunyao.structure.array;

/**
 * @ClassName: SparseArray
 * @Author: kunyao
 * @Description:  稀疏数组：当一个数组都是0或者同一个数的时候，可以通过稀疏数组压缩，然后保存到文件中
 *                1. 稀疏数组的第一行记录被压缩数组的维度和有效数字
 *                2. 然后依次记录有效数字的坐标和有效值
 * @Date: 2020/2/19 20:46
 * @Version: 1.0
 */
public class SparseArray {

    public static void main(String[] args) {

        //创建原始数组
        int arrays[][] = new int[11][11];
        arrays[1][2] = 1;
        arrays[2][3] = 2;

        System.out.println("原始数组为:");
        for (int[] array: arrays
             ) {
            for (int item: array
                 ) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }


        int count = 0;
        for (int i = 0; i < 11 ; i++) {
            for (int j = 0; j < 11 ; j++) {
                if(arrays[i][j] != 0){
                    count++;
                }
            }
        }
        //创建稀释数组
        int array3[][] = new int[count+1][3];
        //将被压缩数组的行，列，有效数字的个数记录到稀释数组的第一行
        array3[0][0] = 11;
        array3[0][1] = 11;
        array3[0][2] = count;

        //接下来分别将每个有效数字的坐标和值设置到稀疏数组中
        int state = 0;
        for (int i = 0; i < 11 ; i++) {
            for (int j = 0; j < 11 ; j++) {
                if(arrays[i][j] != 0){
                    state++;
                    array3[state][0] = i;
                    array3[state][1] = j;
                    array3[state][2] = arrays[i][j];
                }
            }
        }

        System.out.println("稀释数组为:");
        for (int i = 0; i < array3.length ; i++) {
            System.out.printf("%d\t %d\t %d\t\n", array3[i][0], array3[i][1], array3[i][2]);
        }
    }
}

/**
 * 在IDEA2019.3中的输出结果为:
 * =====================================
 * 原始数组为:
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	1	0	0	0	0	0	0	0	0
 * 0	0	0	2	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 稀释数组为:
 * 11	 11	 2
 * 1	 2	 1
 * 2	 3	 2
 * =====================================
 * 结论:使用稀疏数组保存数据极大的节省了存储空间
 */