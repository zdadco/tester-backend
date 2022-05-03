package ru.zdadco.tester;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.zdadco.tester.service.ExcelFileResultBuilderService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

@SpringBootTest
class TesterBackendApplicationTests {

	@Autowired
	ExcelFileResultBuilderService resultBuilderService;
	@Autowired
	Map<Integer, ru.zdadco.tester.model.Test> tests;

	@Test
	void contextLoads() {
	}

	@Test
	void tryBuildResultFile() throws IOException {
		ru.zdadco.tester.model.Test test = tests.get(1);
		File file = resultBuilderService.buildResult(test, List.of(5));
		Files.write(file.toPath(), new FileInputStream(file).readAllBytes());
	}
}
