package com.kunyao.java.design_patterns.command;

/**
 * @ClassName: TextEditor
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/7 13:36
 * @Version: 1.0
 */
public class TextEditor {
    private StringBuilder buffer = new StringBuilder();

    public void copy() {

    }

    public void paste() {
        String text = getFromClipBoard();
        add(text);
    }

    private String getFromClipBoard() {
        return "";
    }

    public void add(String s) {
        buffer.append(s);
    }

    public void delete() {
        if (buffer.length() > 0) {
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }

    public String getState() {
        return buffer.toString();
    }
}