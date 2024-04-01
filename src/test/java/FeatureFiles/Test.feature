Feature: Test the Adding product into cart and verify the Subtotal

  Scenario Outline: Adding a “Monitor” and "Laptop" Items in Cart and verifying sub total
    Given User is logged into Amazon Shopping website
    And User enters "<ProductName>" into Searchbox
    And User Presses Enter button from keyboard
    And User selects first item from the search result list
    And User adds the item into the cart by clicking on Add to Cart button
    And User opens Cart from the top-left of the website
    And User verifies the price is identical to the product page
    And User verifies that the sub total is identical to the product page

    Examples: 
      | ProductName |
      | Monitor     |
      | Laptop      |



  @2items
  Scenario: Adding two items in Cart and verifying sub total
    Given User is logged into Amazon Shopping website
    And user search for Headphones in the Website
    And User Presses Enter button from keyboard
    And User selects first item from the search result list
    And User adds the item into the cart by clicking on Add to Cart button
    And user search for Keyboard in the Website
    And User Presses Enter button from keyboard
    And User selects first item from the search result list
    And User switches to the new tab
    And User adds the item into the cart by clicking on Add to Cart button
    And User opens Cart from the top-left of the website
    And User verifies the cart and subtotal prices
   
