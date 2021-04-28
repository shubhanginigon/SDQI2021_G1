*** Settings ***
Library  Selenium2Library

*** Variables ***
${expect}  LocationMind
${url}  http://localhost:8080
${Browser}  chrome
${delay}  1

*** Test Cases ***
1. Open Website
    Open Browser  ${url}  ${Browser}  options=add_experimental_option("excludeSwitches", ["enable-logging"])
    Maximize Browser Window
    Set Selenium Speed   0.5

2. Click on login link
   Click Link  //a[contains(text(),'Login')]

3. Input username and password
   Input Text  name=username  admin 
   Input Text  name=password  admin

4. Login
   Click Button  name=submit

5. Check page info
   Click Link  //a[contains(text(),'Sensors')]

6. Start and Stop service
   Click Button  name=Stop
   Click Button  name=Start
   Click Link  //a[contains(text(),'Map View')]

7. Logout
   Click Link  //a[contains(text(),'Logout')]

8. close Browser
   Close Browser


