# How to run the Test #

**Prerequisite**
1. Java environment 
2. Maven 


- Configure webdriver.
   
    Used WebDriverManager dependency inside pom.xml


	
Project is ready to run. Execute following commands and enjoy the automatic web-driver test.
- Go to project path in terminal.
- Run `mvn clean`
- Run `mvn compile`
- Run `mvn test`

You can run testng.xml individually to run Test case
- Run testng.xml


You can find the test result in `E2EUserJourney\target\surefire-reports\index.html`.

**Note** </br>
I put both positive and Negative TC inside a DashboardTest with priority tag 1 or 2 as well
Both TC are perfectly running fine.