# kerry-harris-code-sample-assurity

**To build:** 
> mvn clean install

**Note:** you might get a build failure with a complaint about not being able to use lambdas with language level 1.5. Don't worry about it. Ensure that you are using Language Level 8 in: File -> Project Structure -> Project (and Module) and then build the project using: Build -> Build Project

**To Run:**
 - Run tests within IntelliJ IDE:
  - Right click on the file 'GetCategoryDetailsById.feature'
  - Select 'Run Feature: GetCategoryDetailsById'
  
**Note:** when you run this test, the last step fails (this is intentional!) This is because although the description field does contain the text "2x larger image" this is not an exact match for the text in this field. Additionally, when you check the JSON response the 2 is actually part of the Unicode character (\u000a2x) which looks like a bug in this API.




