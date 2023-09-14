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
		var todo =  new Todo("acordar", "se não acordar da morto", true, 1);

		webTestClient.post().uri("/todos").bodyValue(todo).exchange().expectStatus().isOk()
			.expectBody().jsonPath("$").isArray()
			.jsonPath("$.length()").isEqualTo(1)
			.jsonPath("$[0].name").isEqualTo(todo.getName())
			.jsonPath("$[0].description").isEqualTo(todo.getDescription())
			.jsonPath("$[0].priority").isEqualTo(todo.getPriority())
			.jsonPath("$[0].finish").isEqualTo(todo.isFinish());
	}
	
	@Test
	void createTodoFailure() {
		var invalidTodo =  new Todo("acordar", "se não acordar da morto", true, 1);

		webTestClient.post()
			.uri("/todos")
			.bodyValue(invalidTodo)
			.exchange()
			.expectStatus().isBadRequest(); 
	}

}
