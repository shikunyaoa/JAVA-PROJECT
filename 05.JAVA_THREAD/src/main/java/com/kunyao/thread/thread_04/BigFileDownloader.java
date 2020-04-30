package com.kunyao.thread.thread_04;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @ClassName: BigFileDownloader
 * @Author: kunyao
 * @Description: 使用多线程下载大文件
 * @Date: 2020/4/30 22:12
 * @Version: 1.0
 */
public class BigFileDownloader {


    protected final URL requestURL;
    protected  final long fileSize;


    protected final Storage storage;
    protected final AtomicBoolean taskCanceled = new AtomicBoolean(false);

    public BigFileDownloader(String requestURL) throws Exception {
        this.requestURL = new URL(requestURL);

        fileSize = retieveFileSize(requestURL);
        String fileName = requestURL.substring(requestURL.lastIndexOf("/") + 1);
        storage = new Storage(fileSize, fileName);
    }

    /**
     * 下载指定文件
     * @param taskCount 任务个数
     * @param reportInterval 下载进度报告周期
     */
    public void download(int taskCount, long reportInterval){

        long chunkSizePerThread = fileSize / taskCount;

        //下载数据段的起始字节
        long lowerBound = 0;
        //下载数据段的结束字节
        long upperBound = 0;
        DownloadTask dt;
        for (int i = taskCount - 1; i >= 0 ; i--) {
            lowerBound = i * chunkSizePerThread;
            if( i == taskCount - 1){
                upperBound = fileSize;
            }else{
                upperBound = lowerBound + chunkSizePerThread - 1;
            }
            dt = new DownloadTask(lowerBound, upperBound, requestURL, storage, taskCanceled);
            dispatchWork(dt, i);
        }

        reportProgress(reportInterval);
        doCleanup();
    }

    private void reportProgress(long reportInterval) {
    }

    protected void doCleanup(){

    }

    protected void dispatchWork(final  DownloadTask dt, int workerIndex){
        //创建下载线程
        Thread workerThread = new Thread(new Runnable() {
            public void run() {
                try {
                    dt.run();
                } catch (Exception e) {
                    e.printStackTrace();
                    //取消整个文件的下载
                    cannelDownlaod();
                }
            }
        });
        workerThread.setName("downloader=" + workerIndex);
        workerThread.start();
    }

    private static void cannelDownlaod(){

    }

    private static  long retieveFileSize(String requestURL){
        return 1;
    }




}

class DownloadTask implements Runnable{

    private long a;
    private long b;
    private URL c;
    private Storage d;
    private AtomicBoolean e;

    public DownloadTask(long a, long b, URL c, Storage d, AtomicBoolean e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }

    public void run() {

    }
}

class Storage{

    public long fileSize;

    public String fileName;

    public Storage(long fileSize, String fileName) {
        this.fileSize = fileSize;
        this.fileName = fileName;
    }
}