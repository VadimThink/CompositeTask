package edu.epam.compositetask.reader;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.CharArrayWriter;
import java.io.FileReader;
import java.io.IOException;

public class FileTextReader implements TextReader{
    private static final Logger LOGGER = LogManager.getLogger(FileTextReader.class);

    public String read(String filePath) throws TextReaderException {
        LOGGER.info("Reading text from " + filePath + " file...");
        FileReader fileReader = null;
        CharArrayWriter charArray = new CharArrayWriter();
        try {
            fileReader = new FileReader(filePath);//используется такой престарелый приём чтобы читать все символы, в том числе и \t \n
            char[] charBuffer = new char[1024 * 4];
            int currentCharsAmount;
            while (fileReader.ready()) {
                currentCharsAmount = fileReader.read(charBuffer);
                charArray.write(charBuffer, 0, currentCharsAmount);
            }
        } catch (IOException e) {
            throw new TextReaderException("Something wrong with file text reading.", e);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
        LOGGER.info("Text has been read!");
        return charArray.toString();
    }
}
