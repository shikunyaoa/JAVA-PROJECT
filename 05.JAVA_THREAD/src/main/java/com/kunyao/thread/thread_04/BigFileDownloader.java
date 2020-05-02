package com.kunyao.thread.thread_04;

import java.io.*;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName: BigFileDownloader
 * @Author: kunyao
 * @Description: 使用多线程下载大文件 ---------基于数据的分割
 * @Date: 2020/4/30 22:12
 * @Version: 1.0
 */
public class BigFileDownloader {


    protected final URL requestURL;
    protected final long fileSize;
    protected final DownloadBuffer storage;
    protected final AtomicBoolean taskCanceled = new AtomicBoolean(false);

    public BigFileDownloader(String requestURL) throws Exception {
        this.requestURL = new URL(requestURL);
        fileSize = retieveFileSize(requestURL);
        String fileName = requestURL.substring(requestURL.lastIndexOf("/") + 1);
        storage = new DownloadBuffer(0, 0, 0, null,null);
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
            @Override
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

    private final long lowerBound;
    private final long upperBound;
    private URL requestURL;
    private DownloadBuffer xbuf;
    private AtomicBoolean cancelFlag;

    public DownloadTask(long lowerBound, long upperBound, URL requestURL, DownloadBuffer xbuf, AtomicBoolean cancelFlag) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.requestURL = requestURL;
        this.xbuf = xbuf;
        this.cancelFlag = cancelFlag;
    }

    //对指定的URL发起HTTP分段下载请求
    private static InputStream issueRequest(URL requestURL, long lowerBound, long upperBound){

        return null;
    }


    @Override
    public void run() {
        if(cancelFlag.get()){
            return;
        }

        ReadableByteChannel channel = null;

        try {
            channel = Channels.newChannel(issueRequest(requestURL, lowerBound, upperBound));
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (!cancelFlag.get() && channel.read(buf) > 0){
                xbuf.write(buf);
                buf.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}

class DownloadBuffer implements Cloneable{

    /**
     * 当前Buffer中缓冲的数据相对于整个存储文件的位置偏移
     */
    private long globalOffset;
    private long upperBound;
    private int offset = 0;
    public final ByteBuffer byteBuf;
    private final Storage storage;


    public DownloadBuffer(long globalOffset, long upperBound, int offset, ByteBuffer byteBuf, Storage storage) {
        this.globalOffset = globalOffset;
        this.upperBound = upperBound;
        this.offset = offset;
        this.byteBuf = byteBuf;
        this.storage = storage;
    }

    public void write(ByteBuffer buf) throws IOException {
        int length = buf.position();
        final int capacity = byteBuf.capacity();

        //当前缓冲区已满，或者剩余容量不够容纳新数据
        if( (offset + length) > capacity || length == capacity){
            //将缓冲区中的数据写入文件
            flush();
        }
        byteBuf.position(offset);
        buf.flip();
        byteBuf.put(buf);
        offset += length;
    }

    public void flush() throws IOException {
        int length;
        byteBuf.flip();
        length = storage.store(globalOffset, byteBuf);
        byteBuf.clear();
        globalOffset += length;
        offset = 0;
    }

    public void close() throws IOException {
        if(globalOffset < upperBound){
            flush();
        }
    }

}

class Storage implements Closeable, AutoCloseable {

    private final RandomAccessFile storeFile;
    private final FileChannel storeChannel;
    protected final AtomicLong totalWrites = new AtomicLong(0);

    public Storage(long fileSize, String fileShortName) throws Exception {
        String fullFileName = System.getProperty("java.io.tmpdir") + "/" + fileShortName;
        String localFileName;
        localFileName = createStoreFile(fileSize, fullFileName);
        storeFile = new RandomAccessFile(localFileName, "rw");
        storeChannel = storeFile.getChannel();
    }

    private String createStoreFile(long fileSize, String fullFileName) throws Exception {
        File file = new File(fullFileName);
        RandomAccessFile raf;
        raf = new RandomAccessFile(file, "rw");

        try {
            raf.setLength(fileSize);
        } finally {
        }
        return fullFileName;
    }

    /**
     * 将data中指定的数据写入文件
     * @throws IOException
     */
    public int store(long offset, ByteBuffer byteBuf) throws IOException {
        int length;
        storeChannel.write(byteBuf, offset);
        length = byteBuf.limit();
        totalWrites.addAndGet(length);
        return length;
    }

    public long getTotalWrites(){
        return totalWrites.get();
    }



    @Override
    public void close() throws IOException {

    }
}