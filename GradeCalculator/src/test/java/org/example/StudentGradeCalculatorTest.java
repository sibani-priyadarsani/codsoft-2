package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class StudentGradeCalculatorTest {
    @InjectMocks @Spy StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void calculateStudentMarks() {
        String separator = System.getProperty("line.separator");
        String userInput = "2"+separator+"60"+separator+"70";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        String grade = studentGradeCalculator.calculateStudentMarks();
        Assert.assertNotNull(grade);
        Assert.assertEquals("C",grade);
    }

    @Test
    public void calculateStudentMarks_A() {
        String separator = System.getProperty("line.separator");
        String userInput = "2"+separator+"80"+separator+"85";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        String grade = studentGradeCalculator.calculateStudentMarks();
        Assert.assertNotNull(grade);
        Assert.assertEquals("A",grade);
    }
}