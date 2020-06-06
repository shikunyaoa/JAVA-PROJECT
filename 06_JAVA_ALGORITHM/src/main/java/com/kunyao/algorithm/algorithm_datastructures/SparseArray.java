package com.kunyao.algorithm.algorithm_datastructures;

/**
 * @ClassName: SparseArray
 * @Author: kunyao
 * @Description: 稀疏数组
 * @Date: 2020/6/6 17:43
 * @Version: 1.0
 */
public class SparseArray {

    public static void main(String[] args) {

        //创建一个原始的二维数组11 * 11
        //0：表示没有棋子 1 表示黑子 2表示篮子

        int charArr[][] = new int[11][11];
        charArr[1][2] = 1;
        charArr[2][3] = 2;

        for (int[] row: charArr
             ) {
            for (int item: row
                 ) {
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }



        int sum = 0;
        for (int i = 0; i < charArr.length ; i++) {
            for (int j = 0; j < charArr[i].length ; j++) {
                if(charArr[i][j] != 0){
                    sum++;
                }
            }
        }


        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        int count = 0;
        for (int i = 0; i < charArr.length ; i++) {
            for (int j = 0; j < charArr[i].length ; j++) {
                if(charArr[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = charArr[i][j];
                }
            }
        }

        for (int i = 0; i < sparseArr.length ; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
    }
}
