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
    Set Selenium Speed   1.9

2. Click on login link
   Click Link  //a[contains(text(),'Login')]

3. Input username and password
   Input Text  name=username  admin 
   Input Text  name=password  admin

4. Login
   Click Button  name=submit


5. Check the visualization content
   ${webelement}=  Get WebElement  viz1619640384500
   ${tableauPlaceholder}=  Call Method  ${webelement}  get_attribute  tableauPlaceholder

6. Logout
   Click Link  //a[contains(text(),'Logout')]
