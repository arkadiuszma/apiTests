import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class BasicAuthorizationTest {
    @Test
    public void CorrectAuthorizationTest(){
        given().
                auth().basic("postman","password").
        when().
                get("https://postman-echo.com/digest-auth").
        then().
                log().body().statusCode(200);
    }
    @Test
    public void IncorrectAuthorizationTest(){
        given().
                auth().basic("postman1","password1").
        when().
                get("https://postman-echo.com/digest-auth").
        then().
                log().body().statusCode(401);
    }
}
