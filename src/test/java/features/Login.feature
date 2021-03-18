Feature: Login Functionality 
Scenario Outline: Verify Login Functionality 
	Given user should be landing Page 
	When User enter username as "<username>" and Password as "<password>" and Click on Sign In button 
	Then Group dahbosrd screen should be displayed 
	And Then signout successfully
	And Close the browser Sucessfully
	
	Examples: 
		|username|password|
		|jckdoe46@gmail.com|Password@123|