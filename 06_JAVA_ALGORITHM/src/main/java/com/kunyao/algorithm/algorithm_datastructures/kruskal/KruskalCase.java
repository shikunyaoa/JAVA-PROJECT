package com.kunyao.algorithm.algorithm_datastructures.kruskal;

/**
 * @ClassName: KruskalCase
 * @Author: kunyao
 * @Description: 公交站问题 - 克鲁斯卡尔算法，最小生成树算法
 * @Date: 2020/6/29 19:31
 * @Version: 1.0
 */
public class KruskalCase {


    //边的个数
    private int edgeNum;
    //顶点数组
    private char[] vertexs;
    //邻接矩阵
    private int[][] matrix;
    //使用INF表示两个顶点不能连通
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {

    }

    public KruskalCase(char[] vertexs, int[][] matrix){

        //初始化顶点数和边的个数
        int vlen = vertexs.length;

        //初始化顶点，复制拷贝的方式
        this.vertexs = new char[vlen];
        for (int i = 0; i < vertexs.length ; i++) {
            this.vertexs[i] = vertexs[i];
        }


        //初始化边，使用的是复制拷贝的方式
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen ; i++) {
            for (int j = 0; j < vlen ; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }

        //统计边
        for (int i = 0; i < vlen ; i++) {
            for (int j = i + 1; j < vlen ; j++) {
                if(this.matrix[i][j] != INF){
                    edgeNum++;
                }
            }
        }
    }

    /**
     * 对边进行排序处理
     * @param edges
     */
    private void sortEdges(EData[] edges){
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i ; j++) {
                if(edges[j].weight > edges[j+1].weight){
                    EData temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }


    /**
     *
     * @param ch 顶点的值
     * @return  返回ch顶点对应的下标，如果找不到，返回-1
     */
    private int getPosition(char ch){
        for (int i = 0; i < vertexs.length ; i++) {
           if(vertexs[i] == ch){
               return i;
           }
        }
        return -1;
    }


    /**
     * 获取图中边，放到EData[]数组中
     * @return
     */
    private EData[] getEdges(){
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length ; j++) {
                if(matrix[i][j] != INF){
                    edges[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }


    /**
     * 获取下标为i的顶点的终点
     * @param ends 就是记录了各个顶点对应的终点是哪个
     * @param i 表示传入的顶点对应的下标
     * @return  返回的是下标为i的这个顶点对应的终点的下标
     */
    private int getEnd(int[] ends, int i ){
        while(ends[i] != 0){
            i = ends[i];
        }
        return i;
    }


    public void kruskal(){
        int index = 0; //表示最后结果数组的索引
        //用于保存已有最小生成树中的每个顶点在最小生成树中的顶点
        int[] ends = new int[edgeNum];
        //创建结果数组，保存最后的最小生成树
        EData[] rets = new EData[edgeNum];

        //获取图中所有边的集合
        EData[] edges = getEdges();

        //按照边的权值大小进行排序
        sortEdges(edges);


        //遍历edges数组，将边添加到最小生成树中，判断要加入的边是否形成了回路，如果没有，就加入，否则不能加入
        for (int i = 0; i < edgeNum ; i++) {
            //获取第一条边的起点
            int p1 = getPosition(edges[i].start);
            //获取第一条边的顶点
            int p2 = getPosition(edges[i].end);

            //获取p1这个顶点在最小生成树中的终点
            int m = getEnd(ends, p1);
            //获取p2这个顶点在最小生成树中的终点
            int n = getEnd(ends, p2);

            //是否构成回路
            if(m != n){
                //设置m在最小生成树中的终点
                ends[m] = n;
                //将一条边加入到数组中
                rets[index++] = edges[i];
            }
        }
    }
}



//创建一个EData,它的对象实例就是一条边
class EData{

    //边的一个点
    char start;
    //边的另外一个点
    char end;
    //边的权值
    int weight;


    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }


}