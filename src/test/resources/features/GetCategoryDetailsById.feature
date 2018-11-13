Feature: Get Category Details By Id

  As a tmsandbox api client
  I want to retrieve category details by Id
  So that I can determine any categories state

  Scenario: Get a Categorie's Details with a Given Id

    Given I am on version "v1" of the tmsandbox API
    When I get Category details by Id 6327
    Then I get a response code of 200
    And the response contains a "CategoryId" field with the "Integer" value of "6327"
    And the response contains a "Name" field with the "String" value of "Carbon credits"
    And the response contains a "CanRelist" field with the "Boolean" value of "true"
    And the response contains a list of "Promotions"
    And one of the Promotion elements contains a "Name" field with a value of "Gallery"
    And this same Promotion element also contains a "Description" field with a value of "2x larger image"
