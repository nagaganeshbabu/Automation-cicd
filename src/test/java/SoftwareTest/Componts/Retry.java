package SoftwareTest.Componts;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    int count = 0;
    int maxTry = 1; // Number of times to retry a failed test

    @Override
    public boolean retry(ITestResult result) {
        if (count < maxTry) {
            count++;
            return true; // Tells TestNG to run the test again
        }
        return false;
    }
}