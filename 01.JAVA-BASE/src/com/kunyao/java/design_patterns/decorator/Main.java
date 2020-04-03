package com.kunyao.java.design_patterns.decorator;

/**
 * @ClassName: Main
 * @Author: kunyao
 * @Description:Decorator模式有什么好处？它实际上把核心功能和附加功能给分开了
 * @Date: 2020/4/3 15:08
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {

        TextNode textNode = new SpanNode();
        TextNode textNode1 = new BoldDecorator(textNode);
        System.out.println(textNode.getText());
        System.out.println(textNode1.getText());

        /**
         * <span>null</span>
         * <b><span>null</span></b>
         */
    }
}
