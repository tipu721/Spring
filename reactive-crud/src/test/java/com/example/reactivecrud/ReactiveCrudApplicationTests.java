package com.example.reactivecrud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class ReactiveCrudApplicationTests {

	@Test
	void contextLoads() {

		Flux<String> source = Flux.just(
						"John", "Monica", "Mark", "Cloe", "Frank",
						"Casper", "Olivia", "Emily", "Cate")
				.filter(name -> name.length() == 4)
				.map(String::toUpperCase);

		StepVerifier
				.create(source)
				.expectNext("JOHN")
				.expectNextMatches(name -> name.startsWith("MA"))
				.expectNext("CLOE", "CATE")
				.expectComplete()
				.verify();
	}

}
