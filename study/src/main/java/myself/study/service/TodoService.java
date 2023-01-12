package myself.study.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import myself.study.model.TodoDto;

public interface TodoService {

	List<TodoDto> getData() throws ExecutionException, InterruptedException;

	int insertData(TodoDto dto);

}
