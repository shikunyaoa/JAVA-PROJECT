package com.kunyao.java.exception;

import java.io.IOException;

/**
 * @ClassName: FileFormatException
 * @Author: kunyao
 * @Description: 自定义异常类
 * @Date: 2020/4/20 21:38
 * @Version: 1.0
 */
public class FileFormatException extends IOException {

    public FileFormatException() {
    }

    public FileFormatException(String gripe) {
        super(gripe);
    }
}
