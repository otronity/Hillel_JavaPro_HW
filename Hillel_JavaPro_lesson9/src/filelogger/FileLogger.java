package filelogger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {

    public void debug(FileLoggerConfiguration logger, String message) {
        if (logger.getLevel().equals("DEBUG")) {
            String m = formmessage(logger, message);
            try {
                LogToFile(logger.getFilePath() + logger.getFileName(), m);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void info(FileLoggerConfiguration logger, String message) {
        if (logger.getLevel().equals("DEBUG") || logger.getLevel().equals("INFO")) {
            String m = formmessage(logger, message);
            try {
                LogToFile(logger.getFilePath() + logger.getFileName(), m);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
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

    public void LogToFile(String file, String message) throws FileNotFoundException {

        if (file != null) {
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
        } else {
            throw new FileNotFoundException("Файл " + file + " не знайдено");
        }
    }

    public String getDateTimeNow() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss");
        String formatDateNow = now.format(formatter);

        return formatDateNow;
    }

}
