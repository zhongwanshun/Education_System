package com.bjtu.edu.util;

import com.bjtu.edu.dto.FileHolder;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @project: mvc
 * @description: 文件处理工具类
 * @author: wanShun
 * @create: 2022/11/30
 */
public class FileUtil {
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();


    public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile){
        File newFile = new File(cFile.getOriginalFilename());
        try {
            cFile.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile;
    }


    public static String generateNewFile(FileHolder fileHolder, String targetAddr){
        String realFileName = getRandomFileName();
        String extension = getFileExtension(fileHolder.getFileName());
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;

        try {
            //获取fileHolder中的上传文件的输入流
            InputStream is = fileHolder.getFile();
            //创建一个文件输入流
            FileOutputStream fos = new FileOutputStream(com.bjtu.edu.util.PathUtil.getFileBasePath() + relativeAddr);
            //创建一个缓冲区
            byte[] buffer = new byte[1024];
            //判断输入流中的数据是否已经读完的标识
            int length = 0;
            //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
            while((length = is.read(buffer))>0){
                //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                fos.write(buffer, 0, length);
            }
            //关闭输入流
            is.close();
            //关闭输出流
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 返回图片相对路径地址
        return relativeAddr;
    }


    public static String getRandomFileName() {
        //获取随机的五位数
        int ranNum = r.nextInt(89999)+10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr+ranNum;
    }


    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }



    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = com.bjtu.edu.util.PathUtil.getFileBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    /**
     * @author: wanShun
     * @description: storePath是文件的路径还是目录的路径，
     * 如果storePath是文件路径则删除该文件，
     * 如果storePath是目录路径则删除该目录下的所有文件
     * @createTime: 2022/12/1
     * @param storePath
     * @return void
     */
    public static void deleteFileOrPath(String storePath){
        //获取全路径，路径有可能是目录路径，有可能是文件路径
        File fileOrPath = new File(com.bjtu.edu.util.PathUtil.getFileBasePath() + storePath);
        if (fileOrPath.exists()){
            if (fileOrPath.isDirectory()){
                File[] files = fileOrPath.listFiles();
                for (File file : files) {
                    file.delete();
                }
            }
            fileOrPath.delete();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        // 创建文件流
        File file = new File("C:/Users/MECHREV/Desktop/实习简历.pdf");
        InputStream is = new FileInputStream(file);
        FileHolder fileHolder = new FileHolder(file.getName(),is);
        String dest = PathUtil.getHomeworkFilePath(1L);
        String newAddr = FileUtil.generateNewFile(fileHolder,dest);
        System.out.println(newAddr);
    }
}
