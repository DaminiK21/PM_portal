Feature: Patient dashboard 
Scenario Outline: Patient dashboard operations 
	Given user should be landing Page 
	When User enter username as "<username>" and Password as "<password>" and Click on Sign In button 
	And User select Group from Groups Dashbaord screen 
	And User clicks on Add Patient Button 
	Then Add Patient popup should be opened 
	When user enter Firstname as "<fname>" lastname as "<lname>" MRN number as "<mrn>"
	And Select Date of Birth
	And Gender as "<gender>" Race as "<race>" Ethnicity as "<ethnicity>" Vital Status as "<VitalStatus>"  and Attending Physician as "<Physician>"
	And Click on "Add Patient" Button 
	Then Application Should display sucessfull message
	
	
	#Search Added Patient With Patient id
	
	
	When user click on Search icon
	And user enter valid Patient id as "<mrn>"
	And user click on Search icon
	Then Application should display Patient details on Patient dashboard Screen
	
	
	
	#filter Patient Functionality
	
	 
	When Clear the Search text box
	And user click on Search icon
	And user Clicks on Filter icon
	Then Application should Open search filter section with Cancel,Reset and Apply filter buttons
	
	#cancek Link Functionality
	
	When user clicks on Cancel link
	Then application should close the Filter section
	
	#Reset Button Functionality
	
	When User enter Patient name as "<fname>"and  "<lname>" and Patient Id as "<mrn>"
	And click on Reset Button
	Then application should reset all search fields
	
	#Apply Filter Button Functionality

	When user Clicks on Filter icon
	And User enter Patient name as "<fname>"and  "<lname>" and Patient Id as "<mrn>"
	And click on Apply filter button
	Then Application should display Patient details on Patient dashboard Screen
	
	
	#Delete Patient functionality
	
	When user Clicks on Filter icon
	And user click on Search icon
	And user enter valid Patient id as "<mrn>"
	And user click on Search icon
	And click on delete Action taking button
	Then Application should Display Confirmation message
	When user click on go back button
	Then Application should display Patient details on Patient dashboard Screen
	When click on delete Action taking button
	And Select Remove Patient button
	Then Remove Patient Sucessfull message should be display
	And Then signout successfully
	And Close the browser Sucessfully
	
	
	
	
	
	
	Examples: 
		|username|password|fname|lname|mrn|dob|gender|race|ethnicity|VitalStatus|Physician|
		|jckdoe46@gmail.com|Password@123|Current Medication|TestAccount|CM-00005|22|Female|Native Hawaiian or Other Pacific Islander|Yes|Alive|Jack|
		
	