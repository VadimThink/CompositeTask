package edu.epam.compositetask.parser.impl;

import edu.epam.compositetask.model.TextComponent;
import edu.epam.compositetask.model.TextComposite;
import edu.epam.compositetask.parser.AbstractParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TextParser extends AbstractParser {
    private static final Logger LOGGER = LogManager.getLogger(TextParser.class);
    private static final String PARAGRAPH_SPLIT_REGEX = "[^\n]+\n?";

    public TextParser(AbstractParser nextParser) {
        super(nextParser);
    }

    @Override
    public TextComponent parse(String text) {
        TextComposite textComposite = parseComposite(text, PARAGRAPH_SPLIT_REGEX);
        LOGGER.info("Parsed text: " + textComposite);
        return textComposite;
    }
}
