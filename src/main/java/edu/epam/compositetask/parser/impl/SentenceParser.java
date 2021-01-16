package edu.epam.compositetask.parser.impl;

import edu.epam.compositetask.model.TextComponent;
import edu.epam.compositetask.model.TextComposite;
import edu.epam.compositetask.parser.AbstractParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SentenceParser extends AbstractParser {
    private static final Logger LOGGER = LogManager.getLogger(TextParser.class);
    private static final String LEAF_PATTERN = "\\[[^]\\[]*]|[^ \\[\\]]+\n?"; //matches words and expressions in one time

    public SentenceParser(AbstractParser nextParser) {
        super(nextParser);
    }

    @Override
    public TextComponent parse(String text) {
        TextComposite sentenceComposite = parseComposite(text, LEAF_PATTERN);
        LOGGER.info("Parsed sentence: " + sentenceComposite);
        return sentenceComposite;
    }
}
