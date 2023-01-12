package myself.study.service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import myself.study.model.TestDto;

public interface TestService {

	List<TestDto> getData() throws ExecutionException, InterruptedException;

}
