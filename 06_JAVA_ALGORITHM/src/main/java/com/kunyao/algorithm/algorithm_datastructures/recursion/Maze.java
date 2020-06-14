package com.kunyao.algorithm.algorithm_datastructures.recursion;

/**
 * @ClassName: Maze
 * @Author: kunyao
 * @Description: 迷宫回溯问题
 * @Date: 2020/6/13 15:14
 * @Version: 1.0
 */
public class Maze {

    public static void main(String[] args) {

        //先创建一个迷宫

        int[][] map = new int[8][7];

        //1:表示墙

        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("输出地图：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay(map, 1, 1);

        System.out.println("输出新的地图：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


    //使用递归回溯来给小球找路

    /**
     *
     * @param map
     * @param i
     * @param j
     * 1. i和j表示开始出发的坐标
     * 2. 小球到map[6][5]的位置，则说明通路找到
     * 3. 0.表示该点还没有走过 1.表示墙 2.表示通路可以走 3.表示该点已经走过，但是不通
     * 4. 策略： 下-》右-》上-》左 , 如果该点走不通再回溯
     * @return
     */
    public static boolean setWay(int[][] map, int i, int j ){

        if(map[6][5] == 2){
            return true;
        }else{
            //如果这个点还没有走过
            if(map[i][j] == 0){
                //假定该点可以走过
                map[i][j] = 2;
                //向下走
                if(setWay(map, i + 1, j)){
                    return true;
                }else if(setWay(map, i, j + 1)){
                    return true;
                }else if(setWay(map,  i - 1, j )){
                    return true;
                }else if(setWay(map, i, j - 1)){
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }
            }else{
                return false;
            }
        }

    }
}
