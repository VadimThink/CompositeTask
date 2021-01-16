package edu.epam.compositetask.parser.impl;

import edu.epam.compositetask.model.TextComponent;
import edu.epam.compositetask.model.TextLeaf;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WordParserTest {
    private final static String WORD_DATA = "Word";
    private final static TextLeaf WORD_LEAF = TextLeaf.createWord(WORD_DATA);
    private final static String EXPRESSION_DATA = "[3 2 +]";
    private final static TextLeaf EXPRESSION_LEAF = TextLeaf.createExpression(EXPRESSION_DATA);

    private final WordParser wordParser = new WordParser();

    @Test
    public void testParseShouldReturnWordLeafWhenDataIsWord() {
        //given
        TextComponent textComponent;
        TextLeaf actualLeaf;
        //when
        textComponent = wordParser.parse(WORD_DATA);
        actualLeaf = ((TextLeaf)textComponent);
        //then
        Assert.assertEquals(WORD_LEAF, actualLeaf);
    }

    @Test
    public void testParseShouldReturnExpressionLeafWhenDataIsExpression() {
        //given
        TextComponent textComponent;
        TextLeaf actualLeaf;
        //when
        textComponent = wordParser.parse(EXPRESSION_DATA);
        actualLeaf = ((TextLeaf)textComponent);
        //then
        Assert.assertEquals(EXPRESSION_LEAF, actualLeaf);
    }
}