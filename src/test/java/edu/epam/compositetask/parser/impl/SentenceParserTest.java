package edu.epam.compositetask.parser.impl;

import edu.epam.compositetask.model.TextComponent;
import edu.epam.compositetask.model.TextComposite;
import edu.epam.compositetask.model.TextLeaf;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

public class SentenceParserTest {
    private static final String FIRST_WORD_STRING = "Hi";
    private static final String SECOND_WORD_STRING = "user!";
    private static final String VALID_TEXT = FIRST_WORD_STRING + " " + SECOND_WORD_STRING;
    private static final TextComponent FIRST_WORD = TextLeaf.createWord(FIRST_WORD_STRING);
    private static final TextComponent SECOND_WORD = TextLeaf.createWord(SECOND_WORD_STRING);
    private static final List<TextComponent> WORDS = Arrays.asList(FIRST_WORD, SECOND_WORD);
    private static final TextComponent EXPECTED_COMPONENT = new TextComposite();

    @BeforeClass
    public static void initializeComponent() {
        ((TextComposite)EXPECTED_COMPONENT).addChildren(WORDS);
    }

    @Test
    public void testParseShouldReturnCorrectCorrectComponentWhenTextIsValid() {
        //given
        WordParser wordParser = Mockito.mock(WordParser.class);
        SentenceParser sentenceParser = new SentenceParser(wordParser);
        when(wordParser.parse(FIRST_WORD_STRING)).thenReturn(FIRST_WORD);
        when(wordParser.parse(SECOND_WORD_STRING)).thenReturn(SECOND_WORD);
        //when
        TextComponent actualComponent = sentenceParser.parse(VALID_TEXT);
        //then
        Assert.assertEquals(EXPECTED_COMPONENT, actualComponent);
    }
}