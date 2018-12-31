This is a demo project for all login scenario using simple, gmail, facebook , twitter, linkedin and others. This project contain all positive and negative scenarios.
I have created different classes containing all the positive and dnegative scenarios using @Test annotaion
This project contains use of Extent report in HTML format
Screenshot of failed test cases will be shown in HTML report infront of each test as well
I have intensly failed few test cases for negative scenarios, just to demonstrate how to add failed screenshot in HTML report
This project Cntains Retry logic and Annotation transform, to retry executing those test cases that are failed in single run, but for this we need to cchange count in Retry class code 
    private static int maxTry = 0; //Run the failed test 0 times
    you can change this number as per the requirement
Plesae execute all test cases using xml suit only 
If need to run particular test class then please comment the one line after @Test as written in coommennted lines under each class
I have implemented data provider that reads data from excel sheet (.csv file) but not used in this project just to show data which I have used in all tests
