package myself.study.service.impl;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myself.study.mapper.TodoDao;
import myself.study.model.TodoDto;
import myself.study.service.TodoService;

@Slf4j
@Configuration
@Service("TodoService")
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

	private final TodoDao dao;

	@Override
	public List<TodoDto> getData() throws ExecutionException, InterruptedException {
		return dao.getData();
	}

	@Override
	public int insertData(TodoDto dto) {
		return dao.insertData(dto);
	}
}
