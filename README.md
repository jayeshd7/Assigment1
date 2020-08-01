# How to run the Test #

**Prerequisite**
1. Java environment 
2. Maven 


**Note: Configure web-driver path and test email address.**
	

- Configure webdriver.
   
    Used WebDriverManager


	
Project is ready to run. Execute following commands and enjoy the automatic web-driver test.
- Go to project path in terminal.
- Run `mvn clean`
- Run `mvn compile`
- Run `mvn test`

You can run testng.xml individually to run Test case
- Run PositiveTestng.xml
- Run NegativeTestng.xml

You can find the test result in `E2EUserJourney\target\surefire-reports\index.html`.

Note -
Some time Test case failed when we run parallel both positive and negative test cases that's why i made two individual testng.xml
that's why I put positivetestng.xml under maven surefire plugin.

Both TC are perfectly running fine.