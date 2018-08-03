package com.infore.platform.core.common.utils.pdf;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.util.regex.Pattern;

public class LibreOffice2Pdf {

    private final Logger logger = LoggerFactory.getLogger(LibreOffice2Pdf.class);


    @Value("${libre.office.dir:}")
    private String libreOfficeDir;
    @Value("${libre.office.port:8100}")
    private Integer convertPort;

    /**
     * 打开libreOffice服务的地址
     *
     * @return string
     */
    private String getLibreOfficeHome() {
        boolean r = StringUtils.isBlank(libreOfficeDir);
        if (!r) {
            return libreOfficeDir;
        }
        String osName = System.getProperty("os.name");
        if (Pattern.matches("Windows.*", osName)) {
            //获取windows系统下libreoffice主程序的位置
            return "D:\\software\\LibreOffice";
        } else /*if (Pattern.matches("Linux.*", osName))*/ {
            //获取linux系统下libreoffice主程序的位置
            return "/opt/libreoffice6.0/";
        }
    }


    public boolean libreOffice2PDF(String inputPath, String outputPath) {
        try {
            // 获取当前系统安装libreoffice的路径
            String libreOfficeHome = getLibreOfficeHome();
            logger.info("libre office home:{}", libreOfficeHome);
            String cmd = "sh " + libreOfficeHome + "/program/soffice  --headless  --convert-to pdf:writer_pdf_Export " + inputPath + " --outdir " + outputPath;
            logger.info("Shell is : {}", cmd);

            Process ps = Runtime.getRuntime().exec(cmd);

            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String result = sb.toString();
            logger.info("Convert to pdf result:{}", result);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 转换libreoffice支持的文件为pdf
     *
     * @param inputPath  文件地址
     * @param outputPath 输出文件地址
     */
    public boolean libreOffice2PDF2(String inputPath, String outputPath) {

        logger.info("Libre office file 2 pdf input path:{}, out puth:{}", inputPath, outputPath);

        long startTime = System.currentTimeMillis();
        // 根据文件转换成文件流
        File inputFilePath = new File(inputPath);
        File outputFilePath = new File(outputPath);

        // 获取当前系统安装libreoffice的路径
        String libreOfficeHome = getLibreOfficeHome();
        logger.info("libre office home:{}", libreOfficeHome);

        // 如果是txt格式先对其进行转码
		/*if (fileName.substring(fileName.lastIndexOf(".")).equalsIgnoreCase(".txt")) {  
            inputFilePath = TXTHandler(inputFilePath);  
        } */

        DefaultOfficeManagerConfiguration configuration = new DefaultOfficeManagerConfiguration();
        // 设置libreOffice的安装目录
        configuration.setOfficeHome(new File(libreOfficeHome));
        // 端口号  
        configuration.setPortNumber(convertPort);
        // 设置任务执行超时为10分钟  
        configuration.setTaskExecutionTimeout((long) 1000 * 60);
        // 设置任务队列超时为24小时  
        configuration.setTaskQueueTimeout(1000 * 60 * 60 * 24L);

        OfficeManager officeManager = configuration.buildOfficeManager();
        officeManager.start();
        OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
        converter.getFormatRegistry();
        try {
            converter.convert(inputFilePath, outputFilePath);
            long endTime = System.currentTimeMillis();
            logger.info("Convert {} to pdf user：{}s.", inputPath, (endTime - startTime) / 1000);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Convert {} to pdf unsuccessfully.");
            return false;
        } finally {
            logger.info("Convert stop.");
            officeManager.stop();
        }
    }


    /**
     * 转换txt文件编码的方法
     *
     * @param file 文件file
     * @return 转换编码后的文件
     */
    public static File TXTHandler(File file) {
        //或GBK  
        String code = "gb2312";
        byte[] head = new byte[3];
        try {
            InputStream inputStream = new FileInputStream(file);
            inputStream.read(head);
            if (head[0] == -1 && head[1] == -2) {
                code = "UTF-16";
            } else if (head[0] == -2 && head[1] == -1) {
                code = "Unicode";
            } else if (head[0] == -17 && head[1] == -69 && head[2] == -65) {
                code = "UTF-8";
            }
            inputStream.close();

            if ("UTF-8".equals(code)) {
                return file;
            }
            String str = FileUtils.readFileToString(file, code);
            FileUtils.writeStringToFile(file, str, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }
}
