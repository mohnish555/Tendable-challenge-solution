# Test Automation Project for Tendable Website

This project contains automated tests written in Java using Selenium WebDriver and TestNG framework to test the functionalities of the Tendable website.

## Setup Instructions

1. Clone this repository to your local machine.
2. Ensure you have Java installed.
3. Ensure you have Maven installed.
4. Install Chrome browser.
5. Download ChromeDriver compatible with your Chrome browser version.
6. Set the path to ChromeDriver in your system environment variables/ Webdriver manager can be used
7. Open a terminal/command prompt and navigate to the project directory.
8. Run the following command to execute the tests:

   Test Strategy
   
Top Level Menus Verification:
Navigates to the Tendable website and verifies the functionality of top-level menus like Home, Our Story, Our Solution, and Why Tendable? by clicking on each menu item and checking the URL.

Demo Button Presence Verification:
Navigates to the Tendable website and verifies the presence and usability of the "Request A Demo" button by checking if it is displayed and enabled.

Error Message Functionality Verification:
Navigates to the Tendable contact us page, submits the form with incomplete information, and verifies whether the error message appears as expected.

Each test method covers different aspects of the Tendable website's functionality to ensure its correctness and reliability.
