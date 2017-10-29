Feature: Cart

  @ui @wpageobject
  Scenario: Should see an empty cart if no items are added
		Given John is viewing the Etsy landing page
		When he views the cart
		Then the cart should be empty
		
		