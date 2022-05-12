package ru.zdadco.tester.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import ru.zdadco.tester.model.Answer;
import ru.zdadco.tester.model.Test;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelFileResultBuilderService implements ResultBuilderService<File> {

    @Override
    public File buildResult(Test test, List<Integer> answers) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Результаты");

            int row = 0;
            int cell = 0;
            Row header = sheet.createRow(row++);

            Cell headerCell = header.createCell(cell++);
            headerCell.setCellValue("Вопрос");

            for (Answer answer : test.getAnswers()) {
                headerCell = header.createCell(cell++);

                XSSFCellStyle headerStyle = workbook.createCellStyle();
                headerStyle.setFillForegroundColor(new XSSFColor(new Color(answer.getRed(), answer.getGreen(), answer.getBlue()), null));
                headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                headerCell.setCellStyle(headerStyle);
            }

            List<String> questions = test.getQuestions();
            for (int i = 0; i < questions.size(); i++) {
                String question = questions.get(i);
                Row questionRow = sheet.createRow(row++);
                Cell questionCell = questionRow.createCell(0);
                questionCell.setCellValue(question);

                Cell answerCell = questionRow.createCell(answers.get(i));
                answerCell.setCellValue("X");
            }

            File file = new File("result.xlsx");
            workbook.write(new FileOutputStream(file));
            return file;
        }
    }

}
