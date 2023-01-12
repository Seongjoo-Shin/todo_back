package myself.study.web;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myself.study.model.TodoDto;
import myself.study.service.TodoService;

@Slf4j
@RequestMapping("/test")
@RestController
@RequiredArgsConstructor
public class TodoController {

	private final TodoService service;

	@GetMapping("/get")
	public ResponseEntity<Object> getData() throws ExecutionException, InterruptedException{
		List<TodoDto> list = service.getData();
		for(var dto : list) {
			log.info("data : {}", dto);
		}
		return ResponseEntity.ok().body(list);
	}

	@PostMapping("/insert")
	public ResponseEntity<Object> insertData(TodoDto dto) {
		int result = service.insertData(dto);
		log.info("result : {}", result);
		return ResponseEntity.ok().build();
	}

}
