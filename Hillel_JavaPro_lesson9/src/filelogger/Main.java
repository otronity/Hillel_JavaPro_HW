package filelogger;

public class Main {

    public static void main(String[] args) {

        FileLoggerConfiguration fileLogConfig = new FileLoggerConfiguration();
        fileLogConfig.load();
        FileLogger logger = new FileLogger(fileLogConfig);

        logger.debug("пишем DEBUG");
        logger.info("пишем INFO");
        logger.debug("ще раз пишем DEBUG");

        logger.debug("і ще раз пишем DEBUG");
        logger.info("ще раз пишем INFO");

    }

}
