package com.kunyao.java.design_patterns.abstract_factory;

/**
 * @ClassName: FastFactory
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/3 14:01
 * @Version: 1.0
 */
public class FastFactory implements AbstractFactory {

    @Override
    public HtmlDocument createHtml(String md) {
        return new FastHtmlDocument();
    }

    @Override
    public WordDocument createWord(String md) {
        return new FastWordDocument();
    }
}
