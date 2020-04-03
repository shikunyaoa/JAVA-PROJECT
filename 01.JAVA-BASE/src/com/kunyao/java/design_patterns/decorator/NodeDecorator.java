package com.kunyao.java.design_patterns.decorator;

/**
 * @ClassName: NodeDecorator
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/3 15:06
 * @Version: 1.0
 */
public abstract class NodeDecorator implements TextNode {
    protected final TextNode target;

    protected NodeDecorator(TextNode target) {
        this.target = target;
    }

    @Override
    public void setText(String text) {
        this.target.setText(text);
    }
}