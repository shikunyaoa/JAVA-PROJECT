package com.kunyao.java.network;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName: SocketTest
 * @Author: kunyao
 * @Description: 网络连接测试
 * @Date: 2020/4/23 22:03
 * @Version: 1.0
 */
public class SocketTest {


    public static void main(String[] args) throws IOException {

        try(Socket s = new Socket("time-a.nist.gov", 13)){
            Scanner in = new Scanner(s.getInputStream(), "UTF-8");
            while(in.hasNextLine()){
                String line = in.nextLine();
                System.out.println(line);
            }
        }
    }
}
