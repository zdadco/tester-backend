package ru.zdadco.tester.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    private Integer id;
    private Integer red;
    private Integer green;
    private Integer blue;
}
