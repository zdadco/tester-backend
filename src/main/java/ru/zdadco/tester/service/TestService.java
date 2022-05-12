package ru.zdadco.tester.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.zdadco.tester.model.Test;

import javax.mail.MessagingException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TestService {

    private final StatisticService statisticService;
    private final ResultBuilderService<File> resultBuilderService;
    private final MailService mailService;

    private final Map<Integer, Test> tests;

    public Test findTestById(Integer testId) {
        if (!tests.containsKey(testId)) throw new RuntimeException("Test with id '" + testId + "' not fount");
        return tests.get(testId);
    }

    public void saveAnswersById(Integer testId, String email, List<Integer> answers, Boolean shareAnswers) {
        Test test = findTestById(testId);

        try {
            File resultFile = resultBuilderService.buildResult(test, answers);
            mailService.sendResult(email, resultFile);
        } catch (IOException | MessagingException e) {
            throw new RuntimeException(e);
        }

        if (shareAnswers) {
            statisticService.saveStatistic(test, answers);
        }
    }

}
