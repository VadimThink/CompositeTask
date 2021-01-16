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

public class ParagraphParserTest {
    private static final String SENTENCE_STRING = "Hi, user!";
    private static final String VALID_TEXT = SENTENCE_STRING + SENTENCE_STRING;
    private static final TextComponent SENTENCE = TextLeaf.createWord(SENTENCE_STRING);
    private static final List<TextComponent> SENTENCES = Arrays.asList(SENTENCE, SENTENCE);
    private static final TextComponent EXPECTED_COMPONENT = new TextComposite();

    @BeforeClass
    public static void initializeComponent() {
        ((TextComposite)EXPECTED_COMPONENT).addChildren(SENTENCES);
    }

    @Test
    public void testParseShouldReturnCorrectCorrectComponentWhenTextIsValid() {
        //given
        SentenceParser sentenceParser = Mockito.mock(SentenceParser.class);
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        when(sentenceParser.parse(SENTENCE_STRING)).thenReturn(SENTENCE);
        //when
        TextComponent actualComponent = paragraphParser.parse(VALID_TEXT);
        //then
        Assert.assertEquals(EXPECTED_COMPONENT, actualComponent);
    }
}