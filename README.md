# Integration Engineer Coding Challenge

## Environment Setup:
-Java:
Install latest Java JDK in your system. <br>
Once installed, configure the path to bin in the environment variables of your system. <br>
Run javac and java commands to check if everything has been setup properly.<br>
Check your java version using java --version command.<br>
-Maven:<br>
Download the maven zip file from the official site and configure the PATH variable.<br>
Run mvn -v command to check the version.<br>
-Eclipse:<br>
Download and install the latest Eclipse software.<br>

## Source code:
Get the source code of the repository using its zip file or with git clone command using git bash.<br>
Import the project into eclipse as an existing maven project using 'import' option.<br>
Right click on the project and select as Run as maven build option. Input 'clean install' command in the goal text field. This cleans the project, downloads required dependency jars and generates a runnable jar.<br>

## Running the project:
Select APIConsumer.java file in the package 'com.mend.projects.demo' and run it as Java Application.<br>
For running the unit test  select APIConsumerTest.java  which is in the package 'com.mend.projects.demo.tests' and run it as JUnit test.<br>

## Input: 
The REST URL has been configured in the properties file to make an API request and there is no need to pass external inputs.<br>

## Output: 
Output will be the converted JSON data of the senates.<br>

## Partial Output generated from the console:
```json
{"members": [
    {
        "firstName": "Tammy",
        "lastName": "Baldwin",
        "address": {
            "city": "Washington DC",
            "street": "709 HART SENATE OFFICE BUILDING",
            "state": "WI",
            "postal": "20510"
        },
        "chartId": "B001230",
        "mobile": "(202) 224-5653",
        "fullName": "Tammy Baldwin"
    },....
   }
```
