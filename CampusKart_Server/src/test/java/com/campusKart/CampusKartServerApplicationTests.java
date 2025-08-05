// File: src/test/java/com/campusKart/CampusKartServerApplicationTests.java

package com.campusKart;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CampusKartServerApplicationTests {

	@BeforeAll
	static void loadEnv() {
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		System.setProperty("CLOUDINARY_NAME", dotenv.get("CLOUDINARY_NAME"));
		System.setProperty("CLOUDINARY_KEY", dotenv.get("CLOUDINARY_KEY"));
		System.setProperty("CLOUDINARY_SECRET", dotenv.get("CLOUDINARY_SECRET"));
	}

	@Test
	void contextLoads() {
		// test whether context loads
	}
}
