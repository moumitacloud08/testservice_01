package com.example.testservice;

import com.example.testservice.service.NameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

	@Autowired
	private MockMvc mockmvc;

	@MockBean
	private NameService nameService;

	@Test
	public void shouldSayHello() throws Exception {
		when(nameService.getName()).thenReturn("Test");
		MvcResult mvcResult = mockmvc.perform(MockMvcRequestBuilders.get("/")).andReturn();

		assertEquals("Hello Test", mvcResult.getResponse().getContentAsString());
	}

}
