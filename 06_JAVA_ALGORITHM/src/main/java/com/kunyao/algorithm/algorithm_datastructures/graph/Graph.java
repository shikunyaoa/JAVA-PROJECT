package com.kunyao.algorithm.algorithm_datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;

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


    public static void main(String[] args) {

    }


    public Graph(int n) {
        this.vertexList = new ArrayList<>(n);
        this.edges = new int[n][n];
        numOfEdges = 0;
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
