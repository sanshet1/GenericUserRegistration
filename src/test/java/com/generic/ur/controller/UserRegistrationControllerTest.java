package com.generic.ur.controller;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

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
	
		
	UserAddressDTO userAddressHome= new UserAddressDTO("H","Kumar Paradise","Near Gold Gym","Magarpatta Road","Near Gold Gym","Pune","Pune","MH","India","411036");
	UserAddressDTO userAddressOffice= new UserAddressDTO("O","Capgemini","Tower3, Cybercity","Magarpatta Road","Near Gold Gym","Pune","Pune","MH","India","411036");
		
	UserDTO mockUserDTO = new UserDTO("Santosh","Rachppa","Shetkar","Shetkar","ABCDEF",Arrays.asList(userAddressHome, userAddressOffice));	

	
	@Test
	public void getUser() throws Exception{
		Mockito.when(
				userRegistrationService.getUser(Mockito.anyString())).thenReturn(mockUserDTO);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/shetkar").accept(	MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();	
		
		System.out.println(result.getResponse().getContentAsString());
		String expected = "{\"userFirstName\":\"Santosh\",\"userMiddleName\":\"Rachppa\",\"userLastName\":\"Shetkar\",\"userId\":\"Shetkar\",\"password\":\"ABCDEF\",\"UserAddressDTO\":[{\"type\":\"H\",\"flatNumber\":\"Kumar Paradise\",\"buildingName\":\"Near Gold Gym\",\"streetName\":\"Magarpatta Road\",\"landMark\":\"Near Gold Gym\",\"city\":\"Pune\",\"district\":\"Pune\",\"state\":\"MH\",\"country\":\"India\",\"zipCode\":\"411036\"},{\"type\":\"O\",\"flatNumber\":\"Capgemini\",\"buildingName\":\"Tower3, Cybercity\",\"streetName\":\"Magarpatta Road\",\"landMark\":\"Near Gold Gym\",\"city\":\"Pune\",\"district\":\"Pune\",\"state\":\"MH\",\"country\":\"India\",\"zipCode\":\"411036\"}]}";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);

	}
	
	@Test
	public void createUser() throws Exception {
	
		
		ResponseEntity<String> mockFeedback=new ResponseEntity<String>("Shetkar", HttpStatus.CREATED);
		
		Mockito.when(
				userRegistrationService.createUser(
						Mockito.any(UserDTO.class))).thenReturn(mockFeedback);

		String  request = "{\"userFirstName\":\"Santosh\",\"userMiddleName\":\"Rachppa\",\"userLastName\":\"Shetkar\",\"userId\":\"Shetkar\",\"password\":\"ABCDEF\",\"UserAddressDTO\":[{\"type\":\"H\",\"flatNumber\":\"Kumar Paradise\",\"buildingName\":\"Near Gold Gym\",\"streetName\":\"Magarpatta Road\",\"landMark\":\"Near Gold Gym\",\"city\":\"Pune\",\"district\":\"Pune\",\"state\":\"MH\",\"country\":\"India\",\"zipCode\":\"411036\"},{\"type\":\"O\",\"flatNumber\":\"Capgemini\",\"buildingName\":\"Tower3, Cybercity\",\"streetName\":\"Magarpatta Road\",\"landMark\":\"Near Gold Gym\",\"city\":\"Pune\",\"district\":\"Pune\",\"state\":\"MH\",\"country\":\"India\",\"zipCode\":\"411036\"}]}";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/user")
				.accept(MediaType.APPLICATION_JSON).content(request)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		}
}
