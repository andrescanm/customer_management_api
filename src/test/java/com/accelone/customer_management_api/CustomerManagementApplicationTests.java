package com.accelone.customer_management_api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@ActiveProfiles("test")
class CustomerManagementApplicationTests {

	@Test
	void contextLoads() {
		assertDoesNotThrow(() -> {});
	}

	@Test
	void main() {
		assertDoesNotThrow(() -> CustomerManagementApplication.main(new String[]{}));
	}
}
