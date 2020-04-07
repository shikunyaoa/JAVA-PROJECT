package com.kunyao.java.design_patterns.command;

/**
 * @ClassName: Main
 * @Author: kunyao
 * @Description: 命令模式（Command）是指，把请求封装成一个命令，然后执行该命令。
 * 通过封装Command对象，命令模式可以保存已执行的命令，从而支持撤销、重做等操作。
 * @Date: 2020/4/7 13:38
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {

        TextEditor editor = new TextEditor();
        editor.add("Command pattern in text editor.\n");
// 执行一个CopyCommand:
        Command copy = new CopyCommand(editor);
        copy.execute();
        editor.add("----\n");
// 执行一个PasteCommand:
        Command paste = new PasteCommand(editor);
        paste.execute();
        System.out.println(editor.getState());
    }
}
