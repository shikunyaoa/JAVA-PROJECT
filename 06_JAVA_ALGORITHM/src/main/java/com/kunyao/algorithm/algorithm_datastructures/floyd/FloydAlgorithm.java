package com.kunyao.algorithm.algorithm_datastructures.floyd;

import java.util.Arrays;

/**
 * @ClassName: FloydAlgorithm
 * @Author: kunyao
 * @Description: 最短路径问题 -各个顶点到其他顶点的 == 弗洛伊德算法
 * @Date: 2020/6/30 21:58
 * @Version: 1.0
 */
public class FloydAlgorithm {


    public static void main(String[] args) {


    }
}


class Graph{

    //存放顶点的数组
    private char[] vertex;
    //保存从各个顶点到其他顶点的距离
    private int[][] dis;
    //保存到达目标顶点的前驱节点
    private int[][] pre;

    /**
     *
     * @param length 大小
     * @param matrix 邻接矩阵
     * @param vertex 顶点数组
     */
    public Graph(int length, int[][] matrix, char[] vertex){
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[length][length];

        //对pre数组进行初始化
        for (int i = 0; i < length ; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    //弗洛伊德算法
    public void floyd(){
        int len = 0; //变量保存距离
        //对中间顶点进行遍历
        for (int k = 0; k < dis.length ; k++) {
            //从j顶点开始出发
            for (int i = 0; i < dis.length; i++) {
                //k就是要到达的顶点
                for (int j = 0; j < dis.length ; j++) {
                    //从出发顶点i到中间顶点k,到达j顶点的距离
                    len = dis[i][k] + dis[k][j];
                    if(len < dis[i][j]){ //如果len小于i,j直连的距离
                        dis[i][j] = len; //更新距离
                        pre[i][j] = pre[k][j]; //更新前驱节点
                    }
                }
            }
        }
    }
}