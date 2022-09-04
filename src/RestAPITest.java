import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RestAPITest {
    @Test
    public void getByIdTest() {
        when().
                get("https://jsonplaceholder.typicode.com/posts/1").
        then().
                statusCode(200);
    }

    @Test
    public void NewPostTest() {
        String body = " \"userId\": 1,\n" +
                      " \"title\": \"test\",\n" +
                      " \"body\": \"test\"";
        given().
                body(body).
        when().
                post("https://jsonplaceholder.typicode.com/posts").
        then().
                statusCode(201);
    }

    @Test
    public void FilterByUserTest() {
        given().
                queryParam("userId", "1").
        when().
                get("https://jsonplaceholder.typicode.com/posts").
        then().statusCode(200);
    }

    @Test
    public void DeleteByIdTest() {
         when().
                delete("https://jsonplaceholder.typicode.com/posts/1").
         then().
                statusCode(200);
    }
    @Test
    public void CheckValueTest() {
        Response response = get("https://jsonplaceholder.typicode.com/posts/2");
        String title = response.path("title");
        Assert.assertEquals(title, "qui est esse");
    }
}