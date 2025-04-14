package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ApiPage;

public class ApiStep {
ApiPage apiPage;

public ApiStep() {
    this.apiPage = new ApiPage();
}

    @Given("Prepare URL valid for {string}")
    public void prepareUrlFor(String url) {
        apiPage.prepareUrlFor(url);
    }

    @When("hit API get list users")
    public void hitApiGetListUsers() {
        apiPage.hitApiGetListUsers();
    }

    @Then("Verification status code should be {int}")
    public void verificationStatusCodeShouldBe(int status_code) {
        apiPage.verificationStatusCodeShouldBe(status_code);
    }

    @Then("Verification response body get list users")
    public void verificationMessageShouldBeSuccess() {
        apiPage.verificationMessageShouldBeSuccess();
    }

    @Then("Verification response json with JSONSchema {string}")
    public void verificationResponseJsonWithJSONSchema(String filename) {
        apiPage.verificationResponseJsonWithJSONSchema(filename);
    }

//Scenario 2
    @When("hit API post create new user")
    public void hitApiPostCreateNewUser() {
        apiPage.hitApiPostCreateNewUser();
    }

    @Then("Verification response body create new user")
    public void verificationResponseBodyCreateNewUser() {
        apiPage.verificationResponseBodyCreateUser();
    }

//Scenario 3
    @And("hit API delete user")
    public void hitAPIDeleteUser() {
    apiPage.hitApiDeleteUser();
    }

//Scenario 4
    @And("hit API update user")
    public void hitAPIUpdateUser() {
    apiPage.hitApiUpdateUser();
    }

    @Then("Verification response body update user")
    public void verificationResponseBodyUpdateUser() {
    apiPage.validationResponseBodyUpdateUser();
    }

//    @Then("Verification data list should be not null")
//    public void verificationDataListShouldBeNotNull() {
//        System.out.println("Step ke-6");
//    }

}
