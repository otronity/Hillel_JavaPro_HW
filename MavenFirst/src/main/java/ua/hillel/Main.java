package ua.hillel;

import mathlib.MathLib;

public class Main {

    public static void main(String[] args) {

        FileLoggerConfiguration fileLogConfig = new FileLoggerConfiguration();
        fileLogConfig.load();
        FileLogger logger = new FileLogger(fileLogConfig);

        MathLib mathLib = new MathLib();

        logger.info("INFO: max = " + mathLib.max(3, 6));
        int a = -4;
        logger.info("INFO: abs(" + a + ") = " + mathLib.abs(a));

    }

}
