package api.endpoints;


/*
Swagger URI --> https://petstore.swagger.io

Create user (Post)              : https://petstore.swagger.io/v2/user

Get user (Get)                  : https://petstore.swagger.io/v2/user/{username}

Update user (Put)               : https://petstore.swagger.io/v2/user/{username}

Delete user (Delete)            : https://petstore.swagger.io/v2/user/{username}

Login user (Get)                : https://petstore.swagger.io/v2/user/login

Logout user (Get)               : https://petstore.swagger.io/v2/user/logout

Create user with List (Post)    : https://petstore.swagger.io/v2/user/createWithList

Create user with Array (Post)   : https://petstore.swagger.io/v2/user/createWithArray

*/


public class Routes {

	public static String BASE_URL = "https://petstore.swagger.io/v2";
	
	//	User model 
	
	 public static final String CREATE_USER = BASE_URL + "/user";
	 public static final String GET_USER = BASE_URL + "/user/{username}";
	 public static final String UPDATE_USER = BASE_URL + "/user/{username}";
	 public static final String DELETE_USER = BASE_URL + "/user/{username}";
	 
   //	 Store model 
	 
	 public static final String GET_INVENTORY_URL = BASE_URL + "/store/inventory";
	 public static final String PLACE_ORDER_URL = BASE_URL + "/store/order";
	 public static final String GET_ORDER_URL = BASE_URL + "/store/order/{orderId}";
	 public static final String DELETE_ORDER_URL = BASE_URL + "/store/order/{orderId}";
	 
    //	 Pet model 
	 
	 public static final String UPLOAD_IMAGE_URL = BASE_URL + "/pet/{petId}/uploadImage";   
	 public static final String ADD_NEW_PET_URL = BASE_URL + "/pet";					  // Add New Pet
	 public static final String UPDATE_PET_URL = BASE_URL + "/pet";						  // Update Existing Pet 
	 public static final String FIND_PETS_BY_STATUS_URL = BASE_URL + "/pet/findByStatus"; // Find Pets By Status

	
}
