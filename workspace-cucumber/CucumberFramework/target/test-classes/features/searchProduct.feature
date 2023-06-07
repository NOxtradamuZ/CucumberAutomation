Feature: Search and place the order for the products

  Scenario: Search experience for product in both Ecommerce pages
    Given user is on Greencart landing page
		When user searches with shortname "Tom"
		And user extracts the actual name of the product
		And user access to the offers page
		And user searches with the extracted product name
		Then user checks if the product exists
