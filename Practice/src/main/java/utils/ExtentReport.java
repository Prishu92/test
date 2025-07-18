package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test=new ThreadLocal<>();

    public static void initReport(){
    extent=new ExtentReports();
        ExtentSparkReporter spark=new ExtentSparkReporter("target/ExtentReport.html");
        extent.attachReporter(spark);
    }

    public static void createTest(String name){
        test.set(extent.createTest(name));
    }

    public static void logPass(String message){
        test.get().pass(message);
    }
    public static void logFail(String message) {
        test.get().fail(message);
    }

    public static void flushReport() {
        extent.flush();
    }
}
