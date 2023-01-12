package myself.study.web;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myself.study.model.TestDto;
import myself.study.service.TestService;

@Slf4j
@RequestMapping("/test")
@RestController
@RequiredArgsConstructor
public class TestController {

	private final TestService service;

	@GetMapping("/get")
	public ResponseEntity<Object> getData() throws ExecutionException, InterruptedException{
		List<TestDto> list = service.getData();
		log.info("@@@@ data -> {}", list);
		return ResponseEntity.ok().body(list);
	}

}
