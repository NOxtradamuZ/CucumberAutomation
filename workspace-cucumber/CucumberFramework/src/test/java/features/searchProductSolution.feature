	Feature: Search and place the order for the products

	@OffersPage
  Scenario Outline: Check the solution for searching a product
    Given useris on Greencart landing page
		When user searched with shortname <Name> and extracted the actual name of product
		Then user searched for <Name> shortname in offers page
		And validate product name in offers page matches with Landing page
		
	Examples:
	| Name |
	| Tom  |
	| Beet |
