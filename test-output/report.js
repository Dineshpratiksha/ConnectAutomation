$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Cesta_Project/features/Sample.feature");
formatter.feature({
  "name": "Sample feature file",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Sample Rahul Shetty",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Enter the Url",
  "keyword": "Given "
});
formatter.match({
  "location": "gluecode.Sample.enter_the_Url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter User Name",
  "keyword": "And "
});
formatter.match({
  "location": "gluecode.Sample.enter_User_Name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter Password",
  "keyword": "And "
});
formatter.match({
  "location": "gluecode.Sample.enter_Password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Login Button",
  "keyword": "When "
});
formatter.match({
  "location": "gluecode.Sample.click_on_Login_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify Home Page",
  "keyword": "Then "
});
formatter.match({
  "location": "gluecode.Sample.verify_Home_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});