package gluecode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import utilities.PropertiesFileUtility;

public class ProductsStep_Def 
{
	Shared shared;
	public ProductsStep_Def(Shared shared)
	{
		this.shared=shared;
	}
	@Given("define Http request using service path {string}")
	public void define_http_request_using_service_path(String servicePath)throws Exception 
	{
		shared.request=RestAssured.given();
		shared.request.baseUri(PropertiesFileUtility.getValuesFromPropertiesFile("uri"));
		shared.request.basePath(servicePath);
	    
	}

	@When("submit HTTP request via get method")
	public void submit_http_request_via_get_method() 
	{
		shared.response=shared.request.get();
	}

	@Then("verify the status code is {int}")
	public void verify_the_status_code_is(Integer expectedStatus) 
	{
		Assert.assertEquals(shared.response.statusCode(), expectedStatus);
	}

	@Then("verify the content type is {string}")
	public void verify_the_content_type_is(String expectedContent) 
	{
	    Assert.assertEquals(shared.response.getContentType(), expectedContent);
	}

	@Then("verify the response body contains expected AllProducts jsonArray {string}")
	public void verify_the_response_body_contains_expected_AllProducts_jsonArray(String expectedBody)throws Exception 
	{
	    String jsonToStrigString=new String(Files.readAllBytes(Paths.get(expectedBody)));
	    JSONArray expeJsonArray=new JSONArray(jsonToStrigString);
	    JSONArray actualJsonArray=new JSONArray(shared.response.then().extract().body().asString());
	    JSONAssert.assertEquals("Get response: ", expeJsonArray, actualJsonArray,JSONCompareMode.LENIENT);
	    		
	    
	}
	@Then("verify the response body contains expected singleProduct jsonObject {string}")
	public void verify_the_response_body_contains_expected_singleProduct_jsonObject(String expectedBody)throws Exception
	{
		String jsonToStrigString=new String(Files.readAllBytes(Paths.get(expectedBody)));
		JSONObject expeJsonObject=new JSONObject(jsonToStrigString);
		JSONObject actualJsonObject=new JSONObject(shared.response.then().extract().body().asString());
		JSONAssert.assertEquals("Get Response: ", expeJsonObject, actualJsonObject,JSONCompareMode.LENIENT);
	}
	@Given("define Http request using service path {string} and query parameter {string} and vaue {string}")
	public void define_Http_request_using_service_path_products_and_query_parameter_and_vaue(String path,String query,String queryValue) throws Exception
	{
		shared.request=RestAssured.given();
		shared.request.baseUri(PropertiesFileUtility.getValuesFromPropertiesFile("uri"));
		shared.request.basePath(path);
		shared.request.queryParam(query, queryValue);
		
	}
	@Then("verify the response body contains expected limit reslut jsonArray {string}")
	public void verify_the_response_body_contains_expected_limit_reslut_jsonArray(String jsonfile) throws IOException
	{
		String jsonToStrigString=new String(Files.readAllBytes(Paths.get(jsonfile)));
	    JSONArray expeJsonArray=new JSONArray(jsonToStrigString);
	    JSONArray actualJsonArray=new JSONArray(shared.response.then().extract().body().asString());
	    JSONAssert.assertEquals("Get response: ", expeJsonArray, actualJsonArray,JSONCompareMode.LENIENT);
	}
	@Then("verify the response body contains expected sort result jsonArray {string}")
	public void verify_the_response_body_contains_expected_sort_result_jsonArray(String jsonFile) throws IOException
	{
		String jsonToStrigString=new String(Files.readAllBytes(Paths.get(jsonFile)));
	    JSONArray expeJsonArray=new JSONArray(jsonToStrigString);
	    JSONArray actualJsonArray=new JSONArray(shared.response.then().extract().body().asString());
	    JSONAssert.assertEquals("Get response: ", expeJsonArray, actualJsonArray,JSONCompareMode.LENIENT);
	}
    @Then("verify the response body contains expected catrgories jsonArray {string}")
    public void verify_the_response_body_contains_expected_catrgories_jsonArray(String jsonFile) throws IOException
	{
		String jsonToStrigString=new String(Files.readAllBytes(Paths.get(jsonFile)));
	    JSONArray expeJsonArray=new JSONArray(jsonToStrigString);
	    JSONArray actualJsonArray=new JSONArray(shared.response.then().extract().body().asString());
	    JSONAssert.assertEquals("Get response: ", expeJsonArray, actualJsonArray,JSONCompareMode.LENIENT);
	}
    @Then("verify the response body contains expected catrgories jewelery jsonArray {string}")
    public void verify_the_response_body_contains_expected_catrgories_jewelery_jsonArray(String jsonFile) throws IOException
    {
    	String jsonToStrigString=new String(Files.readAllBytes(Paths.get(jsonFile)));
	    JSONArray expeJsonArray=new JSONArray(jsonToStrigString);
	    JSONArray actualJsonArray=new JSONArray(shared.response.then().extract().body().asString());
	    JSONAssert.assertEquals("Get response: ", expeJsonArray, actualJsonArray,JSONCompareMode.LENIENT);
    }
    @Given("take payload as jsonfile {string}")
    public void take_payload_as_jsonfile(String palyoad)
    {
    	shared.request.body(palyoad);
    }
    @When("submit HTTP request via post method")
    public void submit_HTTP_request_via_post_method()
    {
    	shared.response=shared.request.post();
    }
    @Then("verify the response body contains expected add new user json object {string}")
    public void verify_the_response_body_contains_expected_add_new_user_json_object(String expectedbody)throws Exception
    {
    	String jsonToStrigString=new String(Files.readAllBytes(Paths.get(expectedbody)));
		JSONObject expeJsonObject=new JSONObject(jsonToStrigString);
		JSONObject actualJsonObject=new JSONObject(shared.response.then().extract().body().asString());
		JSONAssert.assertEquals("Get Response: ", expeJsonObject, actualJsonObject,JSONCompareMode.LENIENT);
    }
}
