package ru.zdadco.tester.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    private Integer id;
    private List<String> questions;
    private List<Answer> answers;
}
