package com.kunyao.java.design_patterns.command;

/**
 * @ClassName: CopyCommand
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/7 13:35
 * @Version: 1.0
 */
public class CopyCommand implements Command {
    // 持有执行者对象:
    private TextEditor receiver;

    public CopyCommand(TextEditor receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.copy();
    }
}