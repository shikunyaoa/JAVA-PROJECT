package com.kunyao.algorithm.algorithm_datastructures.prim;

import java.lang.reflect.WildcardType;
import java.util.concurrent.ForkJoinPool;

/**
 * @ClassName: PrimAlgorithm
 * @Author: kunyao
 * @Description: 最小生成树 - 普利姆算法
 * @Date: 2020/6/28 21:06
 * @Version: 1.0
 */
public class PrimAlgorithm {


}

//创建最小生成树
class MinTree{


    /**
     * 创建图的邻接矩阵
     * @param graph 图对象
     * @param verxs 图对应的顶点个数
     * @param data 图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph, int verxs, char[] data, int[][] weight){
        int i, j;
        for (i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < verxs ; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }


    //编写prim算法，得到最小生成树

    /**
     *
     * @param graph 图
     * @param v 表示从第几个顶点开始生成
     */
    public void prim(MGraph graph, int v){
        //标记顶点是否访问过
        int[] visited = new int[graph.verxs];

        int h1 = -1;
        int h2 = -1;
        //将最小的权值初始化为一个较大的值
        int minWeight = 10000;

        //最小生成树的边树，是顶点的个数减一，所以k从1开始
        for (int k = 1; k < graph.verxs ; k++) {

            for (int i = 0; i < graph.verxs ; i++) {
                for (int j = 0; j < graph.verxs ; j++) {
                    if(visited[i] == 1 && visited[j] == 0 && graph.weight[i][j]  < minWeight){
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }

            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            //将当前这个节点标记为已经访问
            visited[h2] = 1;
            //将minWeight重新设置为10000
            minWeight = 10000;
        }

    }
}

//创建图
class MGraph{

    //表示图的节点个数
    int verxs;
    //存放节点的数据
    char[] data;
    //存放边，就是邻接矩阵
    int[][] weight;

    public MGraph(int verxs) {
        this.verxs= verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}