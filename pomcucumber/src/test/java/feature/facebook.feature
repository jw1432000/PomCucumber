Feature: Facebook Login Feature Number1

Scenario Outline: Free Login Number11

Given user enters the "<username>" on login page.
When user enters "<password>" on login page.
And user clicks on the login button.
Then close the browser
Examples:
|username|password|
|acd@gmail.com|1234|
|dfde@gmail.com|567|