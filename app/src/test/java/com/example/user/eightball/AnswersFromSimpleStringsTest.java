package com.example.user.eightball;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by user on 17/08/2016.
 */
public class AnswersFromSimpleStringsTest {

    Answers answers;
    ArrayList<String> options;

    @Before
    public void before(){
        options = new ArrayList<String>();
        options.add("One");
        options.add("Two");
        options.add("Three");
        answers = new AnswersFromSimpleStrings(options);
    }

    @Test
    public void getAnswersTest(){
        assertNotNull(answers.getAnswers());
    }

    @Test
    public void getAnswersTest2(){
        Answers answers = new AnswersFromSimpleStrings();
        assertEquals(2, answers.getLength());
    }


    @Test
    public void getLengthTest(){
       assertEquals(3, answers.getLength());
    }

    @Test
    public void getAnswerAtIndexTest(){
        assertNotNull(answers.getAnswerAtIndex(0));
    }

    @Test
    public void getAnswerTest(){
        assertNotNull(answers.getAnswer());
    }
}
