package com.kunyao.algorithm.algorithm_datastructures.dijkstra;

import javafx.scene.control.Alert;

import java.util.Arrays;

/**
 * @ClassName: DijkstraAlgorithm
 * @Author: kunyao
 * @Description: 最短路径问题 - 迪杰斯特拉算法
 * @Date: 2020/6/30 20:07
 * @Version: 1.0
 */
public class DijkstraAlgorithm {

    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535; //表示不能连接
        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};

        //创建Graph对象
        Graph graph = new Graph(vertex, matrix);
        graph.show();
    }
}


class Graph{

    //顶点数组
    private char[] vertex;
    //邻接矩阵
    private int[][] matrix;

    private  VisitedVertex vv;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }


    public void show(){
        for (int i = 0; i < matrix.length ; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }


    /**
     * 迪杰斯特拉算法
     * @param index 出发顶点对应的下标
     */
    public void dijkstra(int index){
       vv = new VisitedVertex(vertex.length, index);
       //更新index下标顶点到周围顶点的距离和周围顶点的前驱节点
       update(index);

        for (int i = 1; i < vertex.length; i++) {
            index = vv.updateArr();
            update(index);
        }
    }


    /**
     * 更新index下标顶点到周围顶点的距离和周围顶点的前驱节点
     * @param index
     */
    private void update(int index){
        int len = 0;
        for (int i = 0; i < matrix[i].length ; i++) {

            len = vv.getDis(index) + matrix[index][i];
            if(!vv.in(index) && len < vv.getDis(i)){
                vv.updateDis(index, len);
                vv.updatePre(i, index);
            }
        }
    }
}


//已访问顶点集合
class VisitedVertex{

    //记录各个顶点是否访问过，1表示访问过，0表示为访问
    public int[] already_arr;

    //每个下标对应的值为前一个顶点下标
    public int[] pre_visited;

    //记录出发顶点到其他顶点的距离
    public int[] dis;


    /**
     *
     * @param length 顶点的个数
     * @param index 出发顶点对应的下标
     */
    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        this.pre_visited =  new int[length];
        this.dis =  new int[length];

        //初始化dis
        Arrays.fill(dis, 65535);
        already_arr[index] = 1; //设置出发顶点被访问过
        this.dis[index] = 0; //设置出发顶点的访问距离为0
    }


    /**
     * 判断index顶点是否被访问过
     * @param index
     * @return 如果访问过就返回true
     */
    public boolean in(int index){
        return already_arr[index] == 1;
    }


    /**
     * 更新出发顶点到index顶点的距离
     * @param index
     * @param len
     */
    public void updateDis(int index, int len){
        dis[index] = len;
    }


    /**
     * 更新顶点的前驱为index的节点
     * @param pre
     * @param index
     */
    public void updatePre(int pre, int index){
        pre_visited[pre] = index;
    }


    /**
     * 返回出发顶点到index这个顶点的距离
     * @param index
     * @return
     */
    public int getDis(int index){
        return dis[index];
    }


    //继续选择并返回新的访问节点
    public int updateArr(){
        int min = 65535, index = 0;
        for (int i = 0; i < already_arr.length ; i++) {
            if(already_arr[i] == 0 && dis[i] < min){
                min = dis[i];
                index = i;
            }
        }
        //更新index这个顶点被访问过
        already_arr[index] = 1;
        return index;
    }

}