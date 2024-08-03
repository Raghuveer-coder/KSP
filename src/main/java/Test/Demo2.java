package Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class Demo2 {

    @BeforeTest
    public void setupBeforeTest() {
        // Code to set up resources or configurations needed before running tests in this test tag
        System.out.println("Setup before the test suite execution");
    }

    @BeforeMethod
    public void setupBeforeMethod() {
        // Code to set up conditions or data needed before each test method
        System.out.println("Setup before each test method");
    }

    public void ApplicationForm() {
        System.out.println("Form 1 test case passed");
    }

    public void ApplicationEntry() {
        System.out.println("Form 2 test case passed");
    }
}
