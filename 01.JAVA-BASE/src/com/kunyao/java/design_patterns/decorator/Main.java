package com.kunyao.java.design_patterns.decorator;

/**
 * @ClassName: Main
 * @Author: kunyao
 * @Description:Decorator模式有什么好处？它实际上把核心功能和附加功能给分开了,
 * 需要提供目标对象，实现同一个方法，对目标对象的进行调用从而实现功能增强
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
