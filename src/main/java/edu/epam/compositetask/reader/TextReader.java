package edu.epam.compositetask.reader;

public interface TextReader {
    String read(String filePath) throws TextReaderException;
}
