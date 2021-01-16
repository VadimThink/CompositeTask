package edu.epam.compositetask.parser.impl;

import edu.epam.compositetask.model.TextComponent;
import edu.epam.compositetask.model.TextComposite;
import edu.epam.compositetask.parser.AbstractParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ParagraphParser extends AbstractParser {
    private static final Logger LOGGER = LogManager.getLogger(TextParser.class);
    private static final String SENTENCE_PATTERN = "[^!?.]+[!?.](\\.{2})?([^\\n\\w]*\\n)?";

    public ParagraphParser(AbstractParser nextParser) {
        super(nextParser);
    }

    @Override
    public TextComponent parse(String text) {
        TextComposite paragraphComposite = parseComposite(text, SENTENCE_PATTERN);
        LOGGER.info("Parsed paragraph: " + paragraphComposite);
        return paragraphComposite;
    }
}
