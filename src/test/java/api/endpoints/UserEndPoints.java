package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
//	Create User method

    public static Response createUser(User payload)
    {
        Response response =
                given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(payload)

                .when()
                    .post(Routes.CREATE_USER);

        return response;
    }
    
//    Get User method 
    
    public static Response readUser(String UserName)
    {
        Response response =
                given()
                	.pathParam("username", UserName)

                .when()
                    .get(Routes.GET_USER);

        return response;
    }
	
//	Update User method

    public static Response updateUser(String UserName, User payload)
    {
        Response response =
                given()
                	.pathParam("username", UserName)
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(payload)

                .when()
                    .put(Routes.UPDATE_USER);

        return response;
    }

//  Delete User method 
    
  public static Response deleteUser(String UserName)
  {
      Response response =
              given()
              	.pathParam("username", UserName)

              .when()
                  .delete(Routes.DELETE_USER);

      return response;
  }
}
