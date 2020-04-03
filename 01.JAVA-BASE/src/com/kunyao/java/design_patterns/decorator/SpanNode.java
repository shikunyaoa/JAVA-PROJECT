package com.kunyao.java.design_patterns.decorator;

/**
 * @ClassName: SpanNode
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/3 15:05
 * @Version: 1.0
 */
public class SpanNode implements TextNode {
    private String text;

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return "<span>" + text + "</span>";
    }
}