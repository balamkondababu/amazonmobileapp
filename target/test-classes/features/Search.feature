Feature: Search and Verify Product

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
    Then I click on "Add to Cart"



