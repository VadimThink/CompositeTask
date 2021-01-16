package edu.epam.compositetask.parser.impl;

import edu.epam.compositetask.parser.AbstractParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ParserChainBuilder {
    private static final Logger LOGGER = LogManager.getLogger(TextParser.class);

    public AbstractParser buildParser() {
        LOGGER.info("Creating parser for text...");
        WordParser wordParser = new WordParser();
        SentenceParser sentenceParser = new SentenceParser(wordParser);
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        LOGGER.info("Parser was created!");
        return new TextParser(paragraphParser);
    }
}