package com.kunyao.algorithm.algorithm_datastructures.horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @ClassName: HorseChessBoard
 * @Author: kunyao
 * @Description: 马踏棋盘问题
 * @Date: 2020/7/1 19:37
 * @Version: 1.0
 */
public class HorseChessBoard {

    private static int X; //棋盘的列数
    private static int Y; //棋盘的行数
    private static boolean[] visited; //标记各个点是否被访问
    private static boolean finished; //标记是否棋盘所有的位置都被访问

    public static void main(String[] args) {

    }


    /**
     * 完成骑士周游问题的算法
     * @param chessboard 棋盘
     * @param row 马当前位置的行
     * @param column 马当前位置的列
     * @param step  是第几步
     */
    public static void traversalChessboard(int[][] chessboard, int row, int column, int step){
        chessboard[row][column] = step;
        visited[row * X + column] = true; //标记该位置已经被访问
        ArrayList<Point> ps = next(new Point(column, row));
        //对ps进行排序
        sort(ps);
        //遍历ps
        while (!ps.isEmpty()) {
            Point p1 = ps.remove(0);
            //判断是否被访问过
            if(!visited[p1.y * X + p1.x]){
                traversalChessboard(chessboard, p1.y, p1.x, step + 1);
            }
        }

        //判断马是否完成了任务
        if(step < X * Y && !finished){
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        }else{
            finished = true;
        }
    }


    /**
     * 对当前这一步的所有下一步的选择位置进行非递减排序
     * @param ps
     */
    public static void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>(){
            @Override
            public int compare(Point o1, Point o2) {
                //获取o1的下一步的所有位置个数
                int size = next(o1).size();
                int size1 = next(o2).size();
                if(size < size1){
                    return -1;
                }else if(size == size1){
                    return 0;
                }else{
                    return 1;
                }

            }
        });
    }
    /**
     * 根据当前位置，计算马还能走哪些位置，并放入一个集合中，最多有8个位置
     * @param curPoint
     * @return
     */
    public static ArrayList<Point> next(Point curPoint){

        //创建一个ArrayList
        ArrayList<Point> ps = new ArrayList<>();
        //创建一个point
        Point p1 = new Point();
        //表示马可以走5即当前点左上的位置
        if((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0){
            ps.add(new Point(p1));
        }

        //判断马可以走6的位置
        if((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0){
            ps.add(new Point(p1));
        }
        //判断马可以走7的位置
        if((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0){
            ps.add(new Point(p1));
        }
        //判断马可以走0的位置
        if((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0){
            ps.add(new Point(p1));
        }
        //判断马可以走1的位置
        if((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y){
            ps.add(new Point(p1));
        }
        //判断马可以走2的位置
        if((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y){
            ps.add(new Point(p1));
        }
        //判断马可以走3的位置
        if((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y){
            ps.add(new Point(p1));
        }
        //判断马可以走4的位置
        if((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y){
            ps.add(new Point(p1));
        }

        return ps;
    }
}
