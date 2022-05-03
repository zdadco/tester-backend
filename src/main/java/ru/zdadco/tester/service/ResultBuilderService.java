package ru.zdadco.tester.service;

import ru.zdadco.tester.model.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ResultBuilderService<T> {

    T buildResult(Test test, List<Integer> answers) throws IOException;

}
