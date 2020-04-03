package com.kunyao.java.design_patterns.abstract_factory;

import java.io.IOException;

public interface HtmlDocument {
    String toHtml();

    void save(String path) throws IOException;
}
