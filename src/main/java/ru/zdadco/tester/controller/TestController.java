package ru.zdadco.tester.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.zdadco.tester.controller.dto.AnswersRequest;
import ru.zdadco.tester.model.Test;
import ru.zdadco.tester.service.TestService;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/{id}")
    public Test getTestById(@PathVariable Integer id) {
        return testService.findTestById(id);
    }

    @PostMapping("/{id}")
    public void saveAnswersById(@PathVariable Integer id, @RequestBody AnswersRequest request) {
        testService.saveAnswersById(id, request.getEmail(), request.getAnswers(), request.getShareAnswers());
    }

}
