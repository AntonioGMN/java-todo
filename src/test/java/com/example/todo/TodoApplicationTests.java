package com.example.todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.todo.entity.Todo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TodoApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void createTodoSuccess() {
		var todo =  new Todo("acordarasf", "se não asdf da morto", true, 1);

		webTestClient.post().uri("/todos").bodyValue(todo).exchange().expectStatus().isOk()
			.expectBody().jsonPath("$").isArray()
			.jsonPath("$[0].name").isEqualTo(todo.getName())
			.jsonPath("$[0].description").isEqualTo(todo.getDescription())
			.jsonPath("$[0].priority").isEqualTo(todo.getPriority())
			.jsonPath("$[0].fisish").isEqualTo(todo.isFinish());
	}
	
	@Test
	void createTodoFailure() {
		var invalidTodo =  new Todo("", "", false, 0);

		webTestClient.post().uri("/todos").bodyValue(invalidTodo).exchange()
			.expectStatus().isBadRequest();
	}

}
