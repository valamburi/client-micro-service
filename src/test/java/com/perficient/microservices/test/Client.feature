Feature: Test User API

  Background:
    * url baseUrl

  Scenario: Manage new client
    Given path '/client'
    And request { name: 'John' }
    When method post
    Then status 201
    And match response == {id: '#number', nickName: 'John'}