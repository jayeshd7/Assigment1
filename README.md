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

Output related to tags and there answer I put on console it self.

tags Name = .deb, answer count = 0 </br>
tags Name = .layerdiagram, answer count = 1 </br>
tags Name = .ctf, answer count = 1 </br>
tags Name = .inf, answer count = 2
tags Name = .loc, answer count = 4
tags Name = .ico, answer count = 26
tags Name = .emf, answer count = 55
tags Name = .aspxauth, answer count = 58
tags Name = .d.ts, answer count = 84
tags Name = .lib, answer count = 116
tags Name = .a, answer count = 123
tags Name = .app, answer count = 135
tags Name = .doc, answer count = 136
tags Name = .class-file, answer count = 256
tags Name = .htpasswd, answer count = 496
tags Name = .bash-profile, answer count = 511
tags Name = .htaccess, answer count = 68376