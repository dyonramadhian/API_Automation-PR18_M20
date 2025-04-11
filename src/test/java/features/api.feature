Feature: Test Automation Rest API

  @api
  Scenario: Test get list data normal
    Given Prepare URL valid for "GET_lIST_USERS"
    When hit API get list users
    Then Verification status code should be 200
    Then Verification response body get list users
    Then Verification response json with JSONSchema "get_list_users_normal.json"

@api
Scenario: Test create new user normal
  Given Prepare URL valid for "CREATE_NEW_USER"
  When hit API post create new user
  Then Verification status code should be 201
  Then Verification response body create new user
  Then Verification response json with JSONSchema "post_create_new_user_normal.json"

  @api
  Scenario:Test delete user normal
    Given Prepare URL valid for "CREATE_NEW_USER"
    When hit API post create new user
    Then Verification status code should be 201
    Then Verification response body create new user
    And hit API delete user
    Then Verification status code should be 204

  @api
  Scenario:Test update user normal
    Given Prepare URL valid for "CREATE_NEW_USER"
    When hit API post create new user
    Then Verification status code should be 201
    Then Verification response body create new user
    And hit API update user
    Then Verification status code should be 200
    Then Verification response body update user







