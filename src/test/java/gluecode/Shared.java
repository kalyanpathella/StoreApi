package gluecode;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Shared
{
	public RequestSpecification request;
	public Response response;
	public Scenario se;
	@Before
	public void before(Scenario s)
	{
		se=s;
		SimpleDateFormat sFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); // date format of
		Date dtDate = new Date();
		s.log("Hi,"+s.getName()+" is going to run "+sFormat.format(dtDate));
		
	}
	@After
	public void after(Scenario s)
	{
		se=s;
		s.log(s.getName()+" is "+s.getStatus().name());
	}

}
