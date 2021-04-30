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

2. Check the visualization content
   ${webelement}=  Get WebElement  viz1619640384500
   ${tableauPlaceholder}=  Call Method  ${webelement}  get_attribute  tableauPlaceholder

3. close Browser
   Close Browser