**Amazon Android App Automation Using Cucumber, Appium, Java and Maven**

Project Structure
--------------
	Project-Name
		|
		|_cucumber-reports
		|	|_Screenshots
		|_logs
		|_src/main/java
		|	|_Pages
		|	|_Utilities
		|_src/test/java
		|	|_StepDefinitions
		|_TestRunner.java
		|_src/test/resources
		|	|_features
		|	|_testdata
		|	|_extent-config.xml
		|	|_log4j2.properties
		|	|_Amazon_shopping.apk
		
cucumber-reports: All extent reports will be stored here. if scenario failed screenshot will be attached to the report


screenshots: failed screenshots will be stored here with scenario name


logs: Amazon.log file stores all logs using log4j2


pages: each java created for each page for elements and methods to perform on the particular page


stepdefinitions: step definitions for each page will be here and Hooks class here to start and end execution based on hooks


utilities: BaseDriver class to setup capabilities.
           DataLoader class to read data from json files.
           Log class for print logs on console and file using log4j2 properties.
           Reusable methods contains mobile gestures and wait conditions which are used in this project.
         
resources/features : contains feature files


resources/testdata : contains data in json files for login and search

extent-config.xml : to customize the extent report

log4j2.properties : configuration file to store logs in console and file

src/java/TestRunner : TestRunner file contains step definitions path, feature file path. we can execute tests using this file.


     
           
		
