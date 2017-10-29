# Work done
1. Modified code for existing scenarios to work for current Etsy UI, plus some refactoring (e.g. extracting hardcoded value into a constant, splitting page objects).
2. Updated dependencies in build.gradle.
3. Enabled implicit/explicit wait propeties in serenity.properties.
4. Splitted feature files into UI and API subdirectories and set a runner for each category.
5. Implemented the two wip scenarios.
6. Added a UI scenario to verify cart is empty.
7. Added 3 API scnarios using the Serenity wrapper for Rest Assured, 1 checking that an id cookie is returned if not sent with the request and 2 sending an invalid/no API key to an Etsy openapi endpoint (for a valid API key developer registration is required https://www.etsy.com/developers/documentation).
8. Investigated parallel execution and batch strategy:   
	Configured Serenity properties for batch execution but it did not work when executing the tests. After online research, I found that the batch feature is not supported for Cucumber https://github.com/serenity-bdd/serenity-core/issues/580, however there might be a way to do it through JUnit.  
	Most tools found online for parallel execution favour use of Maven, e.g. https://github.com/temyers/cucumber-jvm-parallel-plugin. I tried setting the maxParallelForks property in Gradle and pass --max-workers as a command line argument, to achieve parallel test execution as described here https://docs.gradle.org/3.0/userguide/userguide_single.html?_ga=2.26036030.226462245.1509283785-1721683086.1509283785#sec:test_execution, which still resulted in sequential execution.  
	It seems that the combination of Gradle, Serenity, JUnit, Cucumber does not have a straightforward solution to achieve parallelism. My approach to this is to take a step back and gain more in-depth knowledge of these tools, in order to understand how they are integrated and to then build a solution.

## Running tests

To run all tests, run the command below:

`$ gradle clean test aggregate`

To pass the environment-specific location of the driver binary, add this argument (example for Chrome):

`$ -Dwebdriver.chrome.driver=/path/to/driver`

To run scenarios tagged as pageobject OR screenplay on Chrome: 

`$ gradle clean test aggregate -Dwebdriver.driver=chrome -Dwebdriver.chrome.driver=/path/to/driver -Dcucumber.options="--tags @pageobject,@screenplay"` 

To run scenarios tagged as ui AND NOT wip on Safari: 
`$ gradle clean test aggregate -Dwebdriver.driver=safari -Dwebdriver.base.url=http://abc.com -Dcucumber.options="--tags @ui --tags ~@wip"`

## Reporting

View the report at target/site/serenity/index.html


