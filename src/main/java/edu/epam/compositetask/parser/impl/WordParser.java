package edu.epam.compositetask.parser.impl;

import edu.epam.compositetask.model.TextComponent;
import edu.epam.compositetask.model.TextLeaf;
import edu.epam.compositetask.parser.AbstractParser;

public class WordParser extends AbstractParser {

    public WordParser() {
        super(null); //last parser
    }

    @Override
    public TextComponent parse(String text) {
        TextLeaf textLeaf;
        char firstSymbol = text.charAt(0);
        int lastSymbolIndex = text.length() - 1;
        char lastSymbol = text.charAt(lastSymbolIndex);
        if (firstSymbol == '[' && lastSymbol == ']') {
            textLeaf = TextLeaf.createExpression(text);
        } else {
            textLeaf = TextLeaf.createWord(text);
        }
        return textLeaf;
    }
}
