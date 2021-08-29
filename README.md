## Selenium Test Automation Framework <br/>
This is my first test automation project based on Selenium-WebDriver with Java.<br/>
I have been learning how to build the project from Mr. Tan Le, Mr. Quan Doan, Mr. Anh Le for SATT program 2021 at LogiGear Da Nang.<br/>
I am still developing package of automated tests of [railway website](http://www.railway2.somee.com/Page/HomePage.cshtml).<br/>
The package of tests contains:<br/>
* book ticket tests
* cancel ticktet tests
* change password tests
* FAQ tests
* forgot password tests
* home tests 
* login tests
* logout tests
* register tests
* ticket price tests
* time table tests<br/>
### Project Structure<br/>
Here is a brief summary of main directories and it's content<br/>
* **page_objects** - there are locators that help the WebDriver object find web elements I want to interact with, methods to perform on each page of the website
* **tests** - there are sets of tests for main functionalities of the website
* **helpers** - this directory contains files for configuration, generating data, Wait function, calculating the number of days.
* **common** - there are many constants, functions to avoid repeating code. 
