package step_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import data_models.PromotionModel;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import java.util.List;

public class CategoryStepDefinitions {

    private RequestSpecification request;
    private ValidatableResponse response;
    private List<PromotionModel> promotions;
    private PromotionModel promotion;

    @Before
    public void before(Scenario scenario) {
        request = RestAssured.with();
    }

    @Given("^I am on version \"([^\"]*)\" of the tmsandbox API$")
    public void i_am_on_version_of_the_tmsandbox_API(String version) throws Exception {

        String BASE_URI = "https://api.tmsandbox.co.nz/" +
                version;

        request.baseUri(BASE_URI)
                .log().method()
                .log().uri()
                .log().params()
                .log().headers();
    }

    @When("^I get Category details by Id (\\d+)$")
    public void i_get_Category_details_by_Id(int id) throws Exception {

        response = request.given()
                .pathParam("categoryId", id)
                .param("catalogue", false)
                .when()
                .get("Categories/{categoryId}/Details.json").then()
                .log().all();
    }

    @Then("^I get a response code of (\\d+)$")
    public void i_get_a_response_code_of(int statusCode) throws Exception {

        response.statusCode(statusCode);
    }

    @Then("^the response contains a \"([^\"]*)\" field with the \"([^\"]*)\" value of \"([^\"]*)\"$")
    public void the_response_contains_a_field_with_the_value_of(String field, String type, String value) throws Exception {

        Object actual = response.extract().jsonPath().get(field);
        String actualTypeName = actual.getClass().getName();
        Assert.assertTrue(actualTypeName.contains(type));
        Assert.assertEquals(value, actual.toString());
    }

    @Then("^the response contains a list of \"([^\"]*)\"$")
    public void the_response_contains_elements(String elements) throws Exception {

        promotions = response.extract().jsonPath().getList(elements, PromotionModel.class);
        Assert.assertTrue(promotions.size() > 0);
    }

    @Then("^one of the Promotion elements contains a \"([^\"]*)\" field with a value of \"([^\"]*)\"$")
    public void one_of_the_elements_contains_a_field_with_the_value_of(String field, final String value) throws Exception {

        switch (field) {
            case "Id":
                //ToDo: Add logic to test the Id field of Promotions
                break;
            case "Name":
                if (promotions.stream().anyMatch(o -> o.getName().equals(value)))
                    promotion = promotions.stream().filter(o -> o.getName().equals(value)).findFirst().get();
                break;
        }

        Assert.assertNotNull(promotion);
    }

    @Then("^this same Promotion element also contains a \"([^\"]*)\" field with a value of \"([^\"]*)\"$")
    public void this_same_element_also_contains_a_field_with_the_value_of(String field, String value) throws Exception {

        switch (field) {
            case "Id":
                //ToDo: Add logic to test the Id field of Promotions
                break;
            case "Name":
                //ToDo: Add logic to test the Name field of Promotions
                break;
            case "Description":
                Assert.assertEquals(value, promotion.getDescription());
                break;
        }
    }
}
