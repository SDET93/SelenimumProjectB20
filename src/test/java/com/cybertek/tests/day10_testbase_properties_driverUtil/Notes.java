package com.cybertek.tests.day10_testbase_properties_driverUtil;

public class Notes {
    /*
    OCT 4th
TODAY'S SCHEDULE
    - Review
    - First warmup task
    - Testbase
    - Properties/Configuration Reader
    - Driver Utils
==============================================
Review:

    -> ALERTS - driver.switchTo().alert()
        -TYPES OF ALERTS
        -HOW DO WE SWITCH TO ALERTS
        -HOW DO WE HANDLE ALERTS (WHAT METHODS ARE USED)
    -> IFRAMES
        -WHAT IS AN IFRAME
        -HOW DO WE HANDLE IFRAME
            - driver.switchTo().frame();
            we can use these 3 to locate an iframe
                - locate as web element
                - using the index number
                - idValue or nameValue
        -HOW DO WE SWITCH BACK TO DEFAULT FRAME?
            - driver.switchTo().defaultContent();
            - driver.switchTo().parentFrame();
    -> WINDOWS
        -> For selenium there is no difference in between a window and a tab.
        -> It treats both of them as just a window.
        -HOW DO WE HANDLE WINDOWS USING SELENIUM?
            -> We use something called WINDOW HANDLE to handle windows in selenium.
        -What is a window handle and where does it come from?
            -> A window handle is uniqueID that is automatically and randomly generated by selenium for each window selenium opens.
            -> A window handle is alphanumerical, and unique to each window
            -> And selenium uses window handles to identify and switchto using window handles.
        -How do we switch to a different window using selenium?
            driver.switchTo().window(WINDOWHANDLE);
        -How do we get the handle of the current window?
            driver..getWindowHandle();
            - .getWindowHandle();
                - This method returns us the current window handle as String
            String currentHandle = driver.getWindowHandle();

        -How to get all of the handles of currently opened window?
            - driver.getWindowHandles();
                - This method returns all of the currently opened windows handles.
                - What is the return type of this method?
                    - Return type of this method is a Set of Strings.
                    Set<String>
        -How do we create the logic to switch to another window?
            - We create a for-each loop to loop through the Set of Strings that is returned by  .getWindowHandles(); method.
            - Then we use driver.switchTo().window(PASS HANDLE HERE);
========================================================
TESTBASE
    - Testbase is a class that will hold the common variables and setup/teardown methods
    - So that we can just extend to TestBase class and not have to re-write or copy/paste the same statements again and again.
    - Repeated statements that we are going to be eliminating:
        - @BeforeMethod, @AfterMethod
        - maximize
        - implicit wait etc.
    - So far we don't have a parent class for our tests.
    - TestBase class will be the parent of all of our tests.
    - TestBase is NOT a Utility class, it is a parent class for our tests so that we can extend to it and get common setups, and variables.
========================================================
P.I.Q.
    Inheritance : TestBase (extended to test base)
    Abstract    : TestBase class is abstract class
    Polymorphism : Used polymorphism with our WebDriver
    Encapsulation : NOT YET.
===================================================
    What is the topic?
    Why are we learning this topic?
        - What problem we are solving?
        - What issue we are addressing?
        - What are we making easy by learning this topic?
    How are we using it?
PROPERTIES

    What is test data?
    - All of the data we pass into the app to test the application, such as username, password, url, and any other information.
    How we have been passing our test data?
        usernameInput.sendKeys("username");
        passwordInput.sendKeys("password");
        loginButton.click();
HARDCODING:
    What is hard coding: is putting the data(test data) itself in the source code (test cases, @Test)
    - Hardcoding is not a good practice because when you want to change a test data, you have to go into the code itself.
    Environments:
        qa1.vyrack.com
        qa2.vyrack.com
        staging1.vtrack.com
        staging2.vtrack.com
        www.vytrack.com
-> Properties are stored in "key" and "value" format
//key=value
        //os.name=Mac OS X
        //user.name=cybertekchicago-1
        // keys has to be exactly the same value when you pass it.
        // otherwise it will not work. so if you are getting 'null' make sure your key is correct
-> We are going to be creating a logic to read data from outside of our source code.
-> This will make it easier for us to run the same tests against different test data.
DATA DRIVEN TESTING:
    -> Running the same test(s) against different test data.
        - you could be changing
            -url
            -username
            -password
    -> If we write the test data in the tests themselves, then we would have to go each an every single of the tests to change all of those values.
    -> Therefore the better practice is to read the test data from an external file so that it is easier to change it from one location.

    What kind of benefits are there to read from external file:
    -> We centralize the test data, which is easier to maintain
        ex: instead of going to 100 different test cases, we switch from 1 file and it is applied to all of our tests.
    -> It is extremely easier to maintain the code compared to previous version(hardcoding test data in the source code)
PROPERTIES FILE
-> Properties type is just another type of file.
-What's special about this file?
    -> Properties file stores information in Key&Value format. (key=value)
        -> VALUES SUCH AS:
            browser, username, password, url etc.
    -> As there are different types of files that are created with different types of extensions such as : .txt , .xls, .doc, .xml .csv, .ppt , .pdf
    How to create a properties type of file?
        fileName       .properties
    <name of the file> <type (extension) of the file>
    testData.properties
    test.properties
    configuration.properties
        -browser type
        -usernames
        -passwords
        -env/urls
===================================
How to read from properties file using JAVA:

    #1 - Create instance of Properties class to read .properties file
        Properties properties = new Properties
    #2 - Use FileInputStream to open the file
        FileInputStream file = new FileInputStream(FILEPATH);
    #3 - Load the 'properties' object with the file I just opened.
        properties.load(file);
    #4 - THen we can use properties object to read the file
        properties.getProperty(key) --> returns the value of the given 'key'

     */
}
