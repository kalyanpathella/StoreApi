Feature: verify the product details

Scenario: Featch all products details using service path products
Given define Http request using service path "products"
When submit HTTP request via get method
Then verify the status code is 200
And verify the content type is "application/json; charset=utf-8"
And verify the response body contains expected AllProducts jsonArray "src\test\resources\TestDataFiles\AllProducts.json"
 

 Scenario: Featch single product details using service path products
Given define Http request using service path "products/1"
When submit HTTP request via get method
Then verify the status code is 200
And verify the content type is "application/json; charset=utf-8"
And verify the response body contains expected singleProduct jsonObject "src\test\resources\TestDataFiles\singleProduct.json"

Scenario: Featch  peoducts details giving limit result
Given define Http request using service path "products" and query parameter "limit" and vaue "5"
When submit HTTP request via get method
Then verify the status code is 200
And verify the content type is "application/json; charset=utf-8"
And verify the response body contains expected limit reslut jsonArray "src\test\resources\TestDataFiles\limitResult.json"


Scenario: Featch  peoducts details giving sort result
Given define Http request using service path "products" and query parameter "sort" and vaue "desc"
When submit HTTP request via get method
Then verify the status code is 200
And verify the content type is "application/json; charset=utf-8"
And verify the response body contains expected sort result jsonArray "src\test\resources\TestDataFiles\sortResult.json"


Scenario: Featch All categories details
Given define Http request using service path "products/categories"
When submit HTTP request via get method
Then verify the status code is 200
And verify the content type is "application/json; charset=utf-8"
And verify the response body contains expected catrgories jsonArray "src\test\resources\TestDataFiles\AllCategories.json"


Scenario: Featch specific categories details
Given define Http request using service path "products/category/jewelery"
When submit HTTP request via get method
Then verify the status code is 200
And verify the content type is "application/json; charset=utf-8"
And verify the response body contains expected catrgories jewelery jsonArray "src\test\resources\TestDataFiles\jewelery.json"


Scenario: Add new Product
Given define Http request using service path "products"
And take payload as jsonfile "src\test\resources\TestDataFiles\AddNewPalyoad.json"
When submit HTTP request via post method
Then verify the status code is 200
And verify the content type is "application/json; charset=utf-8"
#And verify the response body contains expected add new user json object "src\test\resources\TestDataFiles\newproduct.json"









