package myself.study.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.annotation.PostConstruct;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myself.study.mapper.TestDao;
import myself.study.model.TestDto;
import myself.study.service.TestService;

@Slf4j
@Configuration
@Service("TestService")
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

	private final TestDao dao;

	@Override
	public List<TestDto> getData() throws ExecutionException, InterruptedException {
		return dao.getData();
	}

}
