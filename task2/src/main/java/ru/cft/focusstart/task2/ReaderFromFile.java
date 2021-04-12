package ru.cft.focusstart.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class ReaderFromFile {
    private static final Logger log = LoggerFactory.getLogger(ReaderFromFile.class.getName());
    private final String fileName;
    private String figureType;
    private ArrayList<Double> parameters = new ArrayList<>();

    public ReaderFromFile(String fileName) {
        this.fileName = fileName;
        log.info("Создали экземпляр класса: {}", ReaderFromFile.class.getName());
    }

    public ModelFigureTypeWithParameters getFigureTypeWithParameters() throws IOException, NumberFormatException {
        String string = readLinesFromFile();
        if (string != null) {
            String[] strings = string.split(" ");
            for (String string1 : strings) {
                parameters.add(Double.parseDouble(string1));
            }
        }
        return new ModelFigureTypeWithParameters(figureType, parameters);
    }

    private String readLinesFromFile() throws IOException {
        String string;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            figureType = reader.readLine().toUpperCase(Locale.ROOT);
            string = reader.readLine();
        }
        return string;
    }
}