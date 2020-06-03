package com.kunyao.algorithm.algorithm_01;

/**
 * @ClassName: MaxSumRec
 * @Author: kunyao
 * @Description: 最大子序列和问题的求解
 * @Date: 2020/6/3 11:00
 * @Version: 1.0
 */
public class MaxSumRec {


    private static int maxSumRec(int[] a, int left, int right){

        //Base case
        if(left == right){
            if(a[left] > 0){
                return a[left];
            }else{
                return 0;
            }
        }


        int center = ( left + right ) / 2;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxRightSum = maxSumRec(a, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += a[i];
            if(leftBorderSum > maxLeftBorderSum){
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += a[i];
            if(rightBorderSum > maxRightBorderSum){
                maxRightBorderSum = rightBorderSum;
            }
        }

        return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
    }

    private static int max3(int maxLeftSum, int maxRightSum, int i) {
        return 0;
    }
}
