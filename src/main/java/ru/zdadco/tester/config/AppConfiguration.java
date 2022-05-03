package ru.zdadco.tester.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.zdadco.tester.model.Answer;
import ru.zdadco.tester.model.Test;

import java.util.List;
import java.util.Map;

@Configuration
public class AppConfiguration {

    @Bean
    public Map<Integer, Test> tests() {
        List<String> questions = List.of(
                "Какой цвет лучше всего описывает ваше обычное настроение?",
                "С каким цветом вы ассоциируете себя?",
                "Какой ваш любимый цвет?"
        );
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
