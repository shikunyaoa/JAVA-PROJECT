package com.kunyao.java.design_patterns.decorator;

/**
 * @ClassName: BoldDecorator
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/3 15:06
 * @Version: 1.0
 */
public class BoldDecorator extends NodeDecorator {
    public BoldDecorator(TextNode target) {
        super(target);
    }

    @Override
    public String getText() {
        return "<b>" + target.getText() + "</b>";
    }
}