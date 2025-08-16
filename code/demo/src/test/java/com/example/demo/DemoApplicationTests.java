import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
package com.example.demo;
@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}

@Disabled("Disabled during bootstrap; enable later when DB test config is ready")
class DemoApplicationTests {
  @Test
  void noop() { }
}

