package ru.cft.focusstart.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Map;

public class DataOutputFormat {
    private static final Logger log = LoggerFactory.getLogger(DataOutputFormat.class.getName());
    private static final int COUNT_OF_SYMBOLS_AFTER_DECIMAL_POINT = 2;
    private static final int COUNT_OF_ZEROS_AFTER_DECIMAL_POINT = 0;
    private static final String LINE_SEPARATOR_AFTER_PARAMETER = " ";
    private static final String LINE_SEPARATOR_BEFORE_PARAMETER = ": ";
    private static final String NAME_PARAMETER_TYPE_FIGURE = "Тип фигуры";
    private final Map<String, Double> parametersFigure;
    private final Map<String, String> parameterUnits;
    private final String figureType;


    public DataOutputFormat(String figureType, Map<String, Double> parametersFigure,
                            Map<String, String> parameterUnits) {
        this.figureType = figureType;
        this.parametersFigure = parametersFigure;
        this.parameterUnits = parameterUnits;
        log.info("Создали экземпляр класса: {}", DataOutputFormat.class.getName());
    }

    public ArrayList<String> forPrint() {
        StringBuilder builder = new StringBuilder();
        ArrayList<String> stringForPrint = new ArrayList<>();
        stringForPrint.add(NAME_PARAMETER_TYPE_FIGURE + LINE_SEPARATOR_BEFORE_PARAMETER + figureType);
        for (String string : parametersFigure.keySet()) {
            builder.setLength(0);
            builder.append(string);
            builder.append(": ");
            builder.append(convertToString(parametersFigure.get(string)));
            builder.append(" ");
            builder.append(parameterUnits.get(string));
            stringForPrint.add(builder.toString());
        }
        return stringForPrint;
    }

    private String convertToString(double parameter) {
        if (parameter % 1 == 0) {
            return String.format("%." + COUNT_OF_ZEROS_AFTER_DECIMAL_POINT + "f", parameter);
        } else {
            return String.format("%." + COUNT_OF_SYMBOLS_AFTER_DECIMAL_POINT + "f", parameter);
        }
    }
}
