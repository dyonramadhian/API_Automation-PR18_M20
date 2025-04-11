package pages;

import helper.Endpoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;


public class ApiPage {

    String setURL, global_id;
    Response res;

    public void prepareUrlFor(String url) {
        switch (url) {
            case "GET_lIST_USERS":
                setURL = Endpoint.GET_lIST_USERS;
                break;
            case "CREATE_NEW_USER":
                setURL = Endpoint.CREATE_NEW_USERS;
                break;
            case "DELETE_USER":
                setURL = Endpoint.DELETE_USERS;
                break;
            default:
                System.out.println("input right url");
        }
    }

    public void hitApiGetListUsers(){
        res = getListUsers(setURL);
    }

    public void verificationStatusCodeShouldBe(int status_code) {
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void verificationMessageShouldBeSuccess() {
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female", "male");
        assertThat(status.get(0)).isIn("active", "inactive");
    }

    public void verificationResponseJsonWithJSONSchema(String filename) {
        File JSONFile = Utility.getJSOnSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

//Scenario 2
    public void hitApiPostCreateNewUser() {
        res = postCreateUser(setURL);
    }
    public void verificationResponseBodyCreateUser(){
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");

        global_id = Integer.toString(id);
    }

//Scenario 3 ("DELETE USER")
    public void hitApiDeleteUser() {
        res = deleteUser(setURL, global_id);
    }

//Scenario 4 ("UPDATE USER")
    public void hitApiUpdateUser() {
        res = updateUser(setURL, global_id);
    }

    public void validationResponseBodyUpdateUser(){
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");
    }
}

//        System.out.println(res.getBody().asString());

