package edu.epam.compositetask.parser.impl;

import edu.epam.compositetask.model.TextComponent;
import edu.epam.compositetask.model.TextComposite;
import edu.epam.compositetask.model.TextLeaf;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class TextParserTest {
    private static final String PARAGRAPH_TEXT = "Hi, user! Hi, user!";
    private static final String VALID_TEXT = PARAGRAPH_TEXT + "\n" + PARAGRAPH_TEXT;
    private static final TextComponent PARAGRAPH = TextLeaf.createWord(PARAGRAPH_TEXT);
    private static final List<TextComponent> PARAGRAPHS = Arrays.asList(PARAGRAPH, PARAGRAPH);
    private static final TextComponent EXPECTED_COMPONENT = new TextComposite();

    @BeforeClass
    public static void initializeComponent() {
        ((TextComposite)EXPECTED_COMPONENT).addChildren(PARAGRAPHS);
    }

    @Test
    public void testParseShouldReturnCorrectComponentWhenTextIsValid() {
        //given
        ParagraphParser paragraphParser = Mockito.mock(ParagraphParser.class);
        TextParser textParser = new TextParser(paragraphParser);
        when(textParser.parse(PARAGRAPH_TEXT)).thenReturn(PARAGRAPH);
        when(textParser.parse(PARAGRAPH_TEXT + "\n")).thenReturn(PARAGRAPH);
        //when
        TextComponent actualComponent = textParser.parse(VALID_TEXT);
        //then
        Assert.assertEquals(EXPECTED_COMPONENT, actualComponent);
    }
}