package com.kunyao.java.design_patterns.abstract_factory;

/**
 * 抽象工厂模式和工厂方法不太一样，它要解决的问题比较复杂，\
 * 不但工厂是抽象的，产品是抽象的，而且有多个产品需要创建，
 * 因此，这个抽象工厂会对应到多个实际工厂，每个实际工厂负责创建多个实际产品
 */
public interface AbstractFactory {

    HtmlDocument createHtml(String md);

    WordDocument createWord(String md);
}
