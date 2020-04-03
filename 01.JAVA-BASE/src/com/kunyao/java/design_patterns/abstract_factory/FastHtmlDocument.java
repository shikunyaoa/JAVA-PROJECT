package com.kunyao.java.design_patterns.abstract_factory;

import java.io.IOException;

/**
 * @ClassName: FastHtmlDocument
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/3 13:59
 * @Version: 1.0
 */
public class FastHtmlDocument implements HtmlDocument {

    @Override
    public String toHtml() {
        return null;
    }

    @Override
    public void save(String path) throws IOException {

    }
}
