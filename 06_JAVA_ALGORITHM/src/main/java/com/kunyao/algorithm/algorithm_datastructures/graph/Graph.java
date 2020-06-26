package com.kunyao.algorithm.algorithm_datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName: Graph
 * @Author: kunyao
 * @Description: 图的基本
 * @Date: 2020/6/25 22:34
 * @Version: 1.0
 */
public class Graph {

    //存储顶点集合
    private ArrayList<String> vertexList;

    //存储图对应的邻接矩阵
    private int[][] edges;

    //表示边的数目
    private int numOfEdges;

    //定义数组boolean[],记录某个节点是否被访问
    private boolean[] isVisited = new boolean[5];

    public static void main(String[] args) {


    }


    public Graph(int n) {
        this.vertexList = new ArrayList<>(n);
        this.edges = new int[n][n];
        numOfEdges = 0;
    }

    /**
     * 得到一个邻接节点的下标
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size() ; i++) {
            if(edges[index][i] > 0){
                return i;
            }
        }

        return -1;
    }

    /**
     * 根据前一个邻接节点的下标来获取下一个邻接节点
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1, int v2){
        for(int j = v2 + 1; j < vertexList.size(); j++ ){
            if(edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }


    /**
     * 深度优先遍历算法（DFS)
     * @param
     */
    public void dfs(boolean[] isVisited, int i){

        //首先访问该节点
        System.out.println(getValueByIndex(i) + "->");
        //将节点设置为已经访问
        isVisited[i] = true;
        //获取第一个邻接节点
        int w = getFirstNeighbor(i);
        while(w != -1){
            //没有被访问
            if(!isVisited[w]){
                //递归访问邻接节点
                dfs(isVisited, w);
            }
            //如果节点已经被访问
            w = getNextNeighbor(i, w);
        }
    }

    /**
     * 对dfs进行一个重载，并进行dfs
     */
    public void dfs(){
        //遍历所有的节点，进行dfs
        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]){
                dfs(isVisited, i);
            }
        }    
    }


    /**
     *  对一个节点进行广度优先算法
     */
    private void bfs(boolean[] isVisited, int i){

        //表示队列头结点的下标
        int u;
        //邻节点w
        int w;
        //队列，记录节点访问的顺序
        LinkedList queue = new LinkedList();

        //访问节点，输出节点信息
        System.out.println(getValueByIndex(i) + "=>");
        //标记为已访问
        isVisited[i] = true;
        //将节点加入到队列
        queue.addLast(i);

        while(!queue.isEmpty()){

            //取出队列的头结点下标
            u = (int) queue.getFirst();
            //得到第一个节点的邻节点
            w = getFirstNeighbor(u);

            while(w != -1){
                //是否访问过
                if(!isVisited[w]){
                    System.out.println(getValueByIndex(w) + "=>");

                    //标记为已访问
                    isVisited[w] = true;
                    //入队
                    queue.addLast(w);
                }
                //以u为前驱节点，找到w的下一个邻节点
                w = getNextNeighbor(u, w);
            }
        }
    }

    /**
     * 遍历所有的节点，都进行广度优先搜索
     * @param
     */
    public void bfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]){
                bfs(isVisited, i);
            }
        }
    }

    //插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /**
     *
     * @param v1 表示点的下标即第几个顶点
     * @param v2 表示第二个顶点对应的下标
     * @param weight
     */
    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public int getNumOfEdges(){
        return numOfEdges;
    }

    public int getNumOfVertex(){
        return vertexList.size();
    }

    public String getValueByIndex(int i){
        return vertexList.get(i);
    }


    /**
     * 获取权值
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    public void show(){
       for(int[] link : edges){
           System.out.println(Arrays.toString(link));
       }
    }
}
