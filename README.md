# Integration Engineer Coding Challenge

#Environment Setup:
-Java:
Install latest Java JDK in your system. 
Once installed, configure the path to bin in the environment variables of your system. 
Run javac and java commands to check if everything has been setup properly.
Check your java version using java --version command.
-Maven:
Download the maven zip file from the official site and configure the PATH variable.
Run mvn -v command to check the version.
-Eclipse:
Download and install the latest Eclipse software.

#Source code:
Get the source code of the repository using its zip file or with git clone command using git bash.
Import the project into eclipse as an existing maven project using 'import' option.
Right click on the project and select as Run as maven build option. Input 'clean install' command in the goal text field. This cleans the project, downloads required dependency jars and generates a runnable jar.

#Running the project:
Select APIConsumer.java file in the package 'com.mend.projects.demo' and run it as Java Application.
For running the unit test  select APIConsumerTest.java  which is in the package 'com.mend.projects.demo.tests' and run it as JUnit test.

#Input: 
The REST URL has been configured in the properties file to make an API request and there is no need to pass external inputs.

#Output: 
Output will be the converted JSON data of the senates.

#Partial Output generated from the console:
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
