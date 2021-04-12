package ru.cft.focusstart.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class.getName());

    public static void main(String[] args) {
        log.info("Программа стартовала");
        ParserCommandLineArguments parser = new ParserCommandLineArguments(args);
        ReaderFromFile reader = new ReaderFromFile(parser.getInputFileName());
        try {
            ModelFigureTypeWithParameters x = reader.getFigureTypeWithParameters();
            FiguresFactory factory = new FiguresFactory(x.getParameters());
            Figures figure = factory.createFigures(x.getFigureType());
            DataOutputFormat format = new DataOutputFormat(figure.getTypeFigure(), figure.getOutputParameters(),
                    figure.getUnitsOfMeasure());
            if (parser.getOutputFileName() != null) {
                writeParametersToFile(format.forPrint(), parser.getOutputFileName());

            } else {
                printParametersToConsole(format.forPrint());
            }
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } catch (NumberFormatException e) {
            log.error(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage(), e);
        }
        log.info("Программа завершилась");
    }

    private static void writeParametersToFile(ArrayList<String> stringsForWrite, String outputFileName) {
        try (FileWriter writer = new FileWriter(outputFileName, false)) {
            for (String string : stringsForWrite) {
                writer.write(string);
                writer.write(System.lineSeparator());
            }
            log.info("Вывели параметры фигуры в файл: {}", outputFileName);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    private static void printParametersToConsole(ArrayList<String> stringsForPrint) {
        for (String string : stringsForPrint) {
            System.out.println(string);
        }
        log.info("Вывели параметры фигуры в консоль");
    }
}
