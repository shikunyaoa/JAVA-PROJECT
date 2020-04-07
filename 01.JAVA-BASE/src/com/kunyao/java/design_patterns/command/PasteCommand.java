package com.kunyao.java.design_patterns.command;

/**
 * @ClassName: PasteCommand
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/7 13:37
 * @Version: 1.0
 */
public class PasteCommand implements Command {
    private TextEditor receiver;

    public PasteCommand(TextEditor receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.paste();
    }
}