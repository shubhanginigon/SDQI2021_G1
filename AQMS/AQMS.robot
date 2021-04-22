*** Settings ***
Library  Selenium2Library

*** Variables ***
${expect}  LocationMind
${url}  http://localhost:8080/admin/login
${Browser}  chrome
${delay}  1

*** Test Cases ***
1. Open Website
    Open Browser  ${url}  ${Browser}  options=add_experimental_option("excludeSwitches", ["enable-logging"])
    Maximize Browser Window
    Set Selenium Speed   0.3
2. Input username and password
   Input Text  name=username  Younten
   Input Text  name=password  1234
3. Login
   Click Button  name=submit
4. Check page info
   Click Link    xpath=(//a[@href="#"])[2]
   ${result}  Get Text  xpath=(//div)[8]
   Log To Console  ${result}
   Should Contain  ${result}  ${expect} 

5. close Browser
   Close Browser

