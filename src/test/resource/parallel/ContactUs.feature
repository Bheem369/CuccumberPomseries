Feature: Contact US Feature

Scenario Outline: Contact Us scenario with different set of data
Given user navigate to contactus page
When user fills the given form name with sheetname "<SheetName>" and rownumber <RowNumber>
And user clicks on send button
And clicks ok on alert popup button
Then it shows a successful message "Success! Your details have been submitted successfully."

Examples:
|SheetName||RowNumber|
|contactus||0|
|contactus||1|
