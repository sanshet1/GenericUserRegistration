package com.generic.ur.controller;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.generic.ur.model.UserAddressDTO;
import com.generic.ur.model.UserDTO;
import com.generic.ur.service.UserRegistrationService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserRegistrationController.class, secure = false)
public class UserRegistrationControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserRegistrationService userRegistrationService;
	
		
	UserAddressDTO userAddressHome= new UserAddressDTO("R","Kumar Paradise","Near Gold Gym","Magarpatta Road","Pune","411036");
	UserAddressDTO userAddressOffice= new UserAddressDTO("P","Kumar Paradise","Near Gold Gym","Magarpatta Road","Pune","411036");
		
	UserDTO mockUserDTO = new UserDTO("Santosh","Rachppa","Shetkar","santos@abc.com","Shetkar","ABCDEF",Arrays.asList(userAddressHome, userAddressOffice));	

	
	@Test
	public void getUser() throws Exception{
		Mockito.when(
				userRegistrationService.getUser(Mockito.anyString())).thenReturn(mockUserDTO);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/shetkar").accept(	MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();	
		
		System.out.println(result.getResponse().getContentAsString());
		String expected = "{\"firstName\":\"Santosh\",\"middleName\":\"Rachppa\",\"lastName\":\"Shetkar\",\"email\":\"santos@abc.com\",\"userId\":\"Shetkar\",\"password\":\"ABCDEF\",\"userAddressDTO\":[{\"type\":\"R\",\"address1\":\"Kumar Paradise\",\"address2\":\"Near Gold Gym\",\"street\":\"Magarpatta Road\",\"city\":\"Pune\",\"pinCode\":\"411036\"},{\"type\":\"P\",\"address1\":\"Kumar Paradise\",\"address2\":\"Near Gold Gym\",\"street\":\"Magarpatta Road\",\"city\":\"Pune\",\"pinCode\":\"411036\"}]}";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);

	}
	
	@Test
	public void createUser() throws Exception {
	
		Map map=new HashMap();
		map.put("Result","Shetkar user is created successfully!");
		
		ResponseEntity<Map> mockFeedback=new ResponseEntity<Map>(map, HttpStatus.CREATED);
		
		Mockito.when(
				userRegistrationService.createUser(
						Mockito.any(UserDTO.class))).thenReturn(mockFeedback);

		String  request = "{\"firstName\":\"Santosh\",\"middleName\":\"Rachppa\",\"lastName\":\"Shetkar\",\"email\":\"santos@abc.com\",\"userId\":\"Shetkar12\",\"password\":\"ABCDEFGH\",\"userAddressDTO\":[{\"type\":\"R\",\"address1\":\"Kumar Paradise\",\"address2\":\"Near Gold Gym\",\"street\":\"Magarpatta Road\",\"city\":\"Pune\",\"pinCode\":\"411036\"},{\"type\":\"P\",\"address1\":\"Kumar Paradise\",\"address2\":\"Near Gold Gym\",\"street\":\"Magarpatta Road\",\"city\":\"Pune\",\"pinCode\":\"411036\"}]}";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/user")
				.accept(MediaType.APPLICATION_JSON).content(request)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		}
}
