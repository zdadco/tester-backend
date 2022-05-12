package ru.zdadco.tester.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import ru.zdadco.tester.model.Answer;
import ru.zdadco.tester.model.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class AppConfiguration {

    private final ResourceLoader resourceLoader;

    @Bean
    public Map<Integer, Test> tests() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:tests/1");
        List<String> questions = Files.readAllLines(resource.getFile().toPath());

        List<Answer> answers = List.of(
                new Answer(1, 255,0,0),
                new Answer(2, 255,165,0),
                new Answer(3, 255,255,0),
                new Answer(4, 0,255,0),
                new Answer(5, 23,118,149),
                new Answer(6, 0,0,255),
                new Answer(7, 128,0,128)
        );

        Test test = new Test(1, questions, answers);

        return Map.of(test.getId(), test);
    }

}
