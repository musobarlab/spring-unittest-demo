package com.wuriyanto.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.wuriyanto.demo.entity.RegisterRequest;
import com.wuriyanto.demo.entity.User;
import com.wuriyanto.demo.repository.UserRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = Application.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
// @AutoConfigureTestDatabase
class UserControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private UserRepository userRepository;

	@AfterEach
	public void cleanup() {
		userRepository.deleteAll();
	}

	@Test
	public void registerShouldReturnNewUserEqualToDemo() throws Exception {
		RegisterRequest registerRequest = new RegisterRequest("demo", "demo@yahoo.com");
		mvc.perform(
			MockMvcRequestBuilders.post("/users")
			.contentType(MediaType.APPLICATION_JSON)
			.content(JsonUtil.toJson(registerRequest)));

		String expected = "demo";

		User actualUser = userRepository.findByEmail("demo@yahoo.com");
		
		Assertions.assertEquals(expected, actualUser.getFullName());
	}

}
