package filelogger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {

    FileLoggerConfiguration loggerConfiguration;

    public FileLogger(FileLoggerConfiguration loggerConfiguration) {
        this.loggerConfiguration = loggerConfiguration;
    }

    public void debug(String message) {
        if (loggerConfiguration.getLevel().equals("DEBUG")) {
            String m = formmessage(loggerConfiguration, message);
            try {
                logToFile(loggerConfiguration.getFilePath() + loggerConfiguration.getFileName(), m);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void info(String message) {
        if (loggerConfiguration.getLevel().equals("DEBUG") || loggerConfiguration.getLevel().equals("INFO")) {
            String m = formmessage(loggerConfiguration, message);
            try {
                logToFile(loggerConfiguration.getFilePath() + loggerConfiguration.getFileName(), m);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String formmessage(FileLoggerConfiguration logger, String message) {
        String template = "";
        String lvl = "";
        String dtime = getDateTimeNow();

        if ((logger != null) && (message != null)) {
            template = logger.getTemplate();
            lvl = logger.getLevel();
        }
        return String.format(template, dtime, lvl, message);
    }

    public void logToFile(String file, String message) {
        File fileLog = new File(file);
        FileWriter fw = null;

        try {
            fw = new FileWriter(fileLog, true);
            fw.write(message + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getDateTimeNow() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss");
        return now.format(formatter);
    }

}
