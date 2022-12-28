package ua.hillel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class FileLoggerConfiguration {

    String filePath;
    String fileFormat;
    String fileName;
    String level;
    int fileMaxSize;
    String template;

    static String filePrefix;
    final static String urlConfig= ".\\src\\main\\java\\ua\\hillel\\resouces\\config.properties";

    static int numfile = 1;

    public FileLoggerConfiguration() {
    }

    public void load() {
        try (InputStream input = new FileInputStream(urlConfig)) {

            Properties prop = new Properties();
            prop.load(input);

            this.filePath = prop.getProperty("FilePath", ".\\");
            this.level = prop.getProperty("Level", "INFO");
            this.fileMaxSize = Integer.parseInt(prop.getProperty("MaxSize", "100"));
            this.template = prop.getProperty("template", "%s | %s | Message: %s");
            filePrefix = prop.getProperty("FileName", "log") + "_";
            this.fileFormat = prop.getProperty("FileFormat", ".txt");
            this.fileName = filePrefix + getDateTimeNow() + "_" + numfile + fileFormat;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getFileName() {
        File fileLog = new File(filePath + fileName);
        try {
            if (!fileLog.createNewFile()) {
                if (getFileSize() > fileMaxSize) {
                    numfile ++;
                    fileName = filePrefix + getDateTimeNow() + "_" + numfile + fileFormat;
                    File fileLognew = new File(filePath + fileName);
                    if (fileLognew.createNewFile()) {
                        System.out.println("Create new File " + fileName);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    public long getFileSize() {
        Path p = Paths.get(filePath + fileName);
        long bytes = 0;
        try {
            bytes = Files.size(p);
            System.out.println("Розмір файла " + fileName + " = " + bytes + " bytes");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    public String getDateTimeNow() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy_hh;mm;ss");
        return now.format(formatter);
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getFileMaxSize() {
        return fileMaxSize;
    }

    public void setFileMaxSize(int fileMaxSize) {
        this.fileMaxSize = fileMaxSize;
    }

    public String getTemplate() {
        return template;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}