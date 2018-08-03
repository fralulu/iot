package com.infore.platform.core.common.utils.file;

import com.infore.platform.core.common.utils.uuid.UUIDGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUploadUtils {

    protected final Logger logger = LoggerFactory.getLogger(FileUploadUtils.class);

    /**
     * 单个文件上传 文件保存路径为realPath + storePath
     *
     * @param file      文件
     * @param realPath  文件绝对路径 如： D:/nginx/html
     * @param storePath 文件相对路径 file/img
     * @return 文件相对路径 storePath + fileName
     * @throws IOException io异常
     */
    public Map<String, Object> uploadFile(MultipartFile file, String realPath, String storePath) throws IOException {
        MultipartFile[] multipartFiles = new MultipartFile[]{file};
        List<Map<String, Object>> paths = uploadFile(multipartFiles, realPath, storePath);
        return paths.isEmpty() ? null : paths.get(0);
    }

    public List<Map<String, Object>> uploadFile(MultipartFile[] files, String realPath, String storePath) throws IOException {
        if (files == null || realPath == null && storePath == null) {
            return null;
        }
        List<Map<String, Object>> pathList = new ArrayList<>();
        UUIDGenerator uuidGenerator = new UUIDGenerator();
        for (MultipartFile file : files) {
            String originalFileName = file.getOriginalFilename();
            //得到存储到本地的文件名
            String localFileName = uuidGenerator.get32V4() + getFileSuffix(originalFileName);
            //新建本地文件
            String dirPath = realPath + "/" + storePath;
            File localFile = new File(dirPath, localFileName);//创建目录
            File fileDir = new File(dirPath);
            if (!fileDir.isDirectory()) {// 如果目录不存在，则创建目录
                fileDir.mkdirs();
            }

            //写文件到本地
            file.transferTo(localFile);
            Map<String, Object> map = new HashMap<>();
            String fileName = file.getOriginalFilename();
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            map.put("FILE_NAME", fileName);
            map.put("FILE_PATH", storePath + "/" + localFileName);
            map.put("FILE_SIZE", file.getSize());
            map.put("FILE_TYPE", fileType.toLowerCase());
            pathList.add(map);
        }
        return pathList;
    }

    /**
     * 获取文件后缀
     *
     * @param originalFileName 原始文件名称
     * @return 文件后缀
     */
    private static String getFileSuffix(String originalFileName) {
        int dot = originalFileName.lastIndexOf('.');
        if ((dot > -1) && (dot < originalFileName.length())) {
            return originalFileName.substring(dot);
        }
        return originalFileName;
    }


    /**
     * 文件下载
     *
     * @param filePath 文件路径
     * @param fileName 文件名称
     * @param request  req
     * @param response resp
     */
    public void download(String filePath, String fileName, HttpServletRequest request, HttpServletResponse response) {
        try {
            File file = new File(filePath);
            // 设置文件MIME类型
            response.setContentType(getMIMEType(file));
            String userAgent = request.getHeader("User-Agent");
            byte[] bytes = userAgent.contains("MSIE") ? fileName.getBytes() : fileName.getBytes("UTF-8");
            fileName = new String(bytes, "ISO-8859-1");
            response.setHeader(
                    "Content-Disposition",
                    String.format("attachment; filename=\"%s\"", fileName));
            // 读取文件
            InputStream ins = new FileInputStream(filePath);
            // 放到缓冲流里面
            BufferedInputStream bins = new BufferedInputStream(ins);
            // 获取文件输出IO流
            OutputStream outs = response.getOutputStream();//获取文件输出IO流
            BufferedOutputStream bouts = new BufferedOutputStream(outs);
            // 写文件
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            // 开始向网络传输文件流
            while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {
                bouts.write(buffer, 0, bytesRead);
            }
            bouts.flush();// 这里一定要调用flush()方法
            ins.close();
            bins.close();
            outs.close();
            bouts.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据输入流下载文件
     *
     * @param is       输入流
     * @param fileName 文件名
     * @param request  req
     * @param response resp
     * @throws Exception ex
     */
    public void download(InputStream is, String fileName, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        BufferedInputStream bins = null;
        ServletOutputStream outs = null;
        BufferedOutputStream bouts = null;
        try {
            String userAgent = request.getHeader("User-Agent");
            byte[] bytes = userAgent.contains("MSIE") ? fileName.getBytes() : fileName.getBytes("UTF-8");
            fileName = new String(bytes, "ISO-8859-1");
            response.setHeader("Content-Disposition",
                    String.format("attachment; filename=\"%s\"", fileName));
            bins = new BufferedInputStream(is);
            outs = response.getOutputStream();
            bouts = new BufferedOutputStream(outs);
            byte[] buffer = new byte[8192];

            int bytesRead1;
            while ((bytesRead1 = bins.read(buffer, 0, 8192)) != -1) {
                bouts.write(buffer, 0, bytesRead1);
            }

        } catch (Exception e) {
            logger.error("文件下载失败：{}", e);
            throw new IOException("文件下载失败。");
        } finally {
            if (bouts != null) {
                bouts.flush();
            }
            if (bins != null) {
                bins.close();
            }
            if (outs != null) {
                outs.close();
            }
            if (bouts != null) {
                bouts.close();
            }
        }
    }


    /**
     * 根据文件后缀名获得对应的MIME类型。
     *
     * @param file 文件
     */
    public String getMIMEType(File file) {
        String type = "*/*";
        String fName = file.getName();
        // 获取后缀名前的分隔符"."在fName中的位置。
        int dotIndex = fName.lastIndexOf(".");
        if (dotIndex < 0) {
            return type;
        }
        /* 获取文件的后缀名 */
        String end = fName.substring(dotIndex, fName.length()).toLowerCase();
        if ("".equals(end)) {
            return type;
        }
        // 在MIME和文件类型的匹配表中找到对应的MIME类型。
        for (String[] mime : MIME_MapTable) {
            if (end.equals(mime[0])) {
                type = mime[1];
            }
        }
        return type;
    }

    private final String[][] MIME_MapTable = {
            // {后缀名， MIME类型}
            {".doc", "application/msword"},
            {".docx",
                    "application/vnd.openxmlformats-officedocument.wordprocessingml.document"},
            {".xls", "application/vnd.ms-excel"},
            {".xlsx",
                    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"},
            {".pdf", "application/pdf"},
            {".ppt", "application/vnd.ms-powerpoint"},
            {".pptx",
                    "application/vnd.openxmlformats-officedocument.presentationml.presentation"},
            {".txt", "text/plain"}, {".wps", "application/vnd.ms-works"},
            {"", "*/*"}
    };

}