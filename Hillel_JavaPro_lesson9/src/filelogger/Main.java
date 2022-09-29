package filelogger;

public class Main {

    public static void main(String[] args) {

        FileLoggerConfiguration fileLogConfig = new FileLoggerConfiguration();
        fileLogConfig.load(".\\src\\resouces\\config.properties");
        FileLogger logger = new FileLogger();

        logger.debug(fileLogConfig, "пишем DEBUG");
        logger.info(fileLogConfig, "пишем INFO");
        logger.debug(fileLogConfig, "ще раз пишем DEBUG");

        try {
            Thread.sleep(60000); //перевірка створюється інщий файл чи ні
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.debug(fileLogConfig, "і ще раз пишем DEBUG");
        logger.info(fileLogConfig, "ще раз пишем INFO");

    }

}
