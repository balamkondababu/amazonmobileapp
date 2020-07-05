Feature: Validate search functionality in amazon android app

  Background: user login into amazon app

    Given Launch the Amazon app
    Then I am on the amazon app sign in Page
    When I click on already a customer sign in button
    Then I enter "username"
    And I click on continue button
    Then I enter "password"
    And I click on Login button

  Scenario: search for particular product and verify product Information
    Given I am on the amazon app homepage
    When I search for a "product"
    Then  I see search results for a product displayed
    And I verify search results count displayed
    When I select random "brand" product from search results
    Then I verify product information in product page
    And I click on "Add to Cart"
    And navigate to the Cart menu
    And I click on "proceed to checkout"
    Then I verify product information in checkout page
    And I compare product information between product page and checkout page
    And I close the app



