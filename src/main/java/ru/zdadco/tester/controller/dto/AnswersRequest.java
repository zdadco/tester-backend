package ru.zdadco.tester.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswersRequest {
    private String email;
    private Boolean shareAnswers;
    private List<Integer> answers;
}
