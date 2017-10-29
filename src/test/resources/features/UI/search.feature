Feature: Sample

  @ui @pageobject
  Scenario: Should be able to search for a product from the input box
    Given John is viewing the Etsy landing page
    When he searches for a product from the input box
    Then the result should be displayed

  @ui @screenplay
  Scenario: Should be able to search for a product from the input box (screenplay)
    Given John is viewing the Etsy landing page (screenplay)
    When he searches for a product from the input box (screenplay)
    Then the result should be displayed (screenplay)


  @ui @pageobject
  Scenario: Should be able to search for a product from the drop-down menu
      Given John is viewing the Etsy landing page
      When he searches for 'Stuffed Animals' under 'Toys & Entertainment' from the dropdown
      Then the page for 'Stuffed Animals & Plushies' should be displayed

  @ui @wpageobject
  Scenario: Should be able to search for a product from the icons
		Given John is viewing the Etsy landing page
		When he searches for a product from an icon
		Then the product from the icon should be displayed
