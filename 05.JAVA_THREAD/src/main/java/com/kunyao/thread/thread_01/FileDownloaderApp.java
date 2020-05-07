package com.kunyao.thread.thread_01;

import java.io.FileOutputStream;

/**
 * @ClassName: FileDownloaderApp
 * @Author: kunyao
 * @Description: 使用多线程下载文件
 * @Date: 2020/5/7 17:15
 * @Version: 1.0
 */
public class FileDownloaderApp {

    static Thread fileDownloadThread = null;

    public static void main(String[] args) {

        for (String url: args
             ) {
            fileDownloadThread = new Thread(new FileDownloadThread(url));
            fileDownloadThread.start();
        }
    }

    static class FileDownloadThread implements Runnable{

        private final String requestUrl;

        public FileDownloadThread(String url) {
            this.requestUrl = url;
        }

        @Override
        public void run() {

            try {
                String fileName = requestUrl.substring(requestUrl.lastIndexOf('/') + 1);
                downloadFile(requestUrl, new FileOutputStream(fileName), 1024);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void downloadFile(String requestUrl, FileOutputStream fileOutputStream, int i) {
        }
    }

}
