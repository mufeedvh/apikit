
package org.mule.module.apikit.rest.resource;

import static com.jayway.restassured.RestAssured.given;

import org.mule.tck.junit4.FunctionalTestCase;
import org.mule.tck.junit4.rule.DynamicPort;
import org.mule.util.IOUtils;

import com.jayway.restassured.RestAssured;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;

public class BaseResourceSwaggerFunctionalTestCase extends FunctionalTestCase
{

    @Rule
    public DynamicPort serverPort = new DynamicPort("serverPort");

    @Override
    protected void doSetUp() throws Exception
    {
        RestAssured.port = serverPort.getNumber();
        super.doSetUp();
    }

    @Override
    protected String getConfigResources()
    {
        return "org/mule/module/apikit/rest/service-config.xml, org/mule/module/apikit/test-flows-config.xml";
    }

    @Test
    public void getHtml() throws Exception
    {
        given().header("Accept", "text/html")
            .expect()
            .response()
            .statusCode(200)
            .contentType("text/html")
            .body(Matchers.hasXPath("//html/body/div[@id='header']/div[@class='swagger-ui-wrap']/a"))
            .when()
            .get("/api");
        given().header("Accept", "text/html")
            .expect()
            .response()
            .statusCode(200)
            .contentType("text/html")
            .body(Matchers.hasXPath("//html/body/div[@id='header']/div[@class='swagger-ui-wrap']/a"))
            .when()
            .get("/api/");
    }

    @Test
    public void getResources() throws Exception
    {
        given().header("Accept", "application/x-javascript")
            .expect()
            .response()
            .statusCode(200)
            .contentType("application/x-javascript")
            .body(
                Matchers.equalTo(IOUtils.getResourceAsString(
                    "org/mule/module/apikit/rest/swagger/lib/swagger.js", this.getClass())))
            .when()
            .get("/api/_swagger/lib/swagger.js");
    }

    @Test
    public void getSwaggerJson() throws Exception
    {
        given().header("Accept", "application/swagger+json")
            .expect()
            .response()
            .statusCode(200)
            .contentType("application/swagger+json")
            .body(
                Matchers.equalTo("{\"apiVersion\":\"1.0\",\"swaggerVersion\":\"1.0\",\"basePath\":\"http://localhost:"
                                 + serverPort.getNumber()
                                 + "/api\",\"apis\":[{\"path\":\"/leagues\",\"description\":\"\"}]}"))
            .when()
            .get("/api");
        given().header("Accept", "application/swagger+json")
            .expect()
            .response()
            .statusCode(200)
            .contentType("application/swagger+json")
            .body(
                Matchers.equalTo("{\"apiVersion\":\"1.0\",\"swaggerVersion\":\"1.0\",\"basePath\":\"http://localhost:"
                                 + serverPort.getNumber()
                                 + "/api\",\"apis\":[{\"path\":\"/leagues\",\"description\":\"\"}]}"))
            .when()
            .get("/api/");
    }

}
